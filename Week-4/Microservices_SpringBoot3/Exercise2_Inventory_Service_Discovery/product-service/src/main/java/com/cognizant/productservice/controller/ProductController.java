package com.cognizant.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Map<String, Object> getProductInfo(@PathVariable String id) {
        return Map.of(
                "productId", id,
                "name", "Laptop Pro",
                "price", 1299.99,
                "service", "product-service"
        );
    }
}
