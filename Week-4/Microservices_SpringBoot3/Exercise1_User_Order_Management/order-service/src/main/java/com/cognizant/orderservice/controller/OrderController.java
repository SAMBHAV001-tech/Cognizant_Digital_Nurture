package com.cognizant.orderservice.controller;

import com.cognizant.orderservice.dto.OrderResponseDTO;
import com.cognizant.orderservice.dto.UserDTO;
import com.cognizant.orderservice.entity.Order;
import com.cognizant.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public OrderController(OrderRepository orderRepository, WebClient.Builder webClientBuilder, @Value("${user.service.url}") String userServiceUrl) {
        this.orderRepository = orderRepository;
        this.webClient = webClientBuilder.baseUrl(userServiceUrl).build();
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderWithUser(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        UserDTO user = webClient.get()
                .uri("/users/" + order.getUserId())
                .retrieve()
                .bodyToMono(UserDTO.class)
                .block();

        OrderResponseDTO responseDTO = new OrderResponseDTO(order.getId(), order.getProduct(), order.getPrice(), user);
        return ResponseEntity.ok(responseDTO);
    }
}
