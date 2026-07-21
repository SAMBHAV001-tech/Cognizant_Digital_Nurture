package com.cognizant.resilience.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class FallbackController {

    @GetMapping("/slow")
    public Mono<String> slowEndpoint(@RequestParam(value = "fail", defaultValue = "false") boolean fail) {
        if (fail) {
            return Mono.error(new RuntimeException("Simulated Failure"));
        }
        return Mono.just("Service Execution Response").delayElement(Duration.ofSeconds(1));
    }

    @GetMapping("/fallback")
    public Mono<String> fallbackEndpoint() {
        return Mono.just("Fallback response: Circuit Breaker triggered or operation timed out.");
    }
}
