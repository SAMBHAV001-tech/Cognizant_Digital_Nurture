package com.cognizant.paymentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public String processPayment(boolean fail) {
        if (fail) {
            throw new RuntimeException("Third-party payment gateway exception.");
        }
        return "Payment processed successfully through third-party gateway.";
    }

    public String paymentFallback(boolean fail, Exception ex) {
        System.err.println("Fallback triggered due to error: " + ex.getMessage());
        return "Fallback response: Payment service is currently experiencing issues. Please try again later.";
    }
}
