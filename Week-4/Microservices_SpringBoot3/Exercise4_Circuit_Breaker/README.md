# Exercise 4: Circuit Breaker using Resilience4j

## Overview
This exercise demonstrates fault tolerance in Spring Boot microservices using Resilience4j `@CircuitBreaker` and fallback methods.

## Key Concepts

### 1. Payment Service (Port 8087)
Processes third-party payment gateway requests.

### 2. Circuit Breaker (`@CircuitBreaker`)
Monitors service calls for failures. When a third-party service fails or exceeds failure thresholds, the circuit breaker opens and immediately routes calls to the designated fallback method `paymentFallback`.

### 3. Fallback Method
`paymentFallback` logs the exception details and returns a standard graceful response to the client without throwing raw internal errors.

## How to Run

1. Build the project using Maven:
   ```bash
   mvn clean package
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Test endpoints:
   - Normal Execution: `GET http://localhost:8087/payment/process`
   - Trigger Circuit Breaker Fallback: `GET http://localhost:8087/payment/process?fail=true`
