# Exercise 3: Resilience Patterns

## Overview
This project demonstrates how to implement resilience patterns using Resilience4j integrated with Spring Cloud Gateway.

## Key Concepts

### 1. Resilience Patterns
Resilience patterns help microservices handle failures gracefully and maintain system stability during network delays, service outages, or high latency.

### 2. Circuit Breaker
The Circuit Breaker pattern prevents repeated execution of requests that are likely to fail. When failure rates cross a defined threshold, the circuit opens and redirects requests immediately to a fallback response.

### 3. TimeLimiter
The TimeLimiter pattern sets a upper duration limit for request completion. If the downstream service does not respond within the configured timeout duration (e.g. 2 seconds), the request times out and fallback logic is executed.

## How to Run

1. Build the project using Maven:
   ```bash
   mvn clean package
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Test resilience behavior:
   - Access `http://localhost:8084/slow`
   - Observe that since `/slow` takes 5 seconds and TimeLimiter is set to 2 seconds, the gateway returns the fallback response: `"Fallback response: Circuit Breaker triggered or operation timed out."`
