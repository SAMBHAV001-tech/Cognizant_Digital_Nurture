package com.cognizant.paymentservice.controller;

import com.cognizant.paymentservice.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/process")
    public ResponseEntity<String> process(@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
        String response = paymentService.processPayment(fail);
        return ResponseEntity.ok(response);
    }
}
