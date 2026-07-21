# Exercise 1: Edge Services for Routing and Filtering

## Overview
This project demonstrates how to set up an API Gateway using Spring Cloud Gateway to handle routing and request filtering across microservices.

## Key Concepts

### 1. API Gateway
An API Gateway acts as the single entry point for all client requests in a microservices architecture. It simplifies client interaction by abstracting internal service locations.

### 2. Spring Cloud Gateway
Spring Cloud Gateway provides an efficient way to route requests based on predicates (like URL paths) and apply filters to modify requests or responses.

### 3. Global Filters
Global filters run on all requests handled by the gateway. In this exercise, `LoggingFilter` implements `GlobalFilter` and `Ordered` to log request details (URI, HTTP Method) before forwarding and log the response HTTP status code after execution.

## How to Run

1. Build the project using Maven:
   ```bash
   mvn clean package
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Test routed endpoints:
   - Gateway Route: `http://localhost:8081/api/hello`
