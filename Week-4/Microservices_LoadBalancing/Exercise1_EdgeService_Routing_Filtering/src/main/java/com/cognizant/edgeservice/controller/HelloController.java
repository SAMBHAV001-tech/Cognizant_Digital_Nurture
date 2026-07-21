package com.cognizant.edgeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Edge Service Routing and Filtering Working Successfully!");
    }
}
