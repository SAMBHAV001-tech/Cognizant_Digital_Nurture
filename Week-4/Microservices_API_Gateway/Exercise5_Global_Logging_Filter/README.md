# Exercise 5: Global Logging Filter

## Overview
This exercise creates a custom `LogFilter` implementing `GlobalFilter` and `Ordered` inside Spring Cloud API Gateway.

## Key Concepts

### 1. GlobalFilter
Intercepts every HTTP request routed through the API Gateway, logging request method, URI, and response status codes.

### 2. Request Tracing
Provides centralized request and response logging for all microservices in the system.

## How to Run

1. Build project:
   ```bash
   mvn clean package
   ```
2. Run Gateway:
   ```bash
   mvn spring-boot:run
   ```
3. Send requests to `http://localhost:8080/greet` or `http://localhost:8080/accounts/123` and observe log messages printed in the console.
