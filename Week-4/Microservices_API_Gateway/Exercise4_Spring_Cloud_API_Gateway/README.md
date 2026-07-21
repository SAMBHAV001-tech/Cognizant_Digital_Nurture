# Exercise 4: Spring Cloud API Gateway

## Overview
This exercise creates an API Gateway project using Spring Cloud Gateway registered with Eureka Server.

## Key Concepts

### 1. API Gateway (Port 8080)
Acts as a unified routing layer forwarding requests to microservices using `lb://account-service` and `lb://loan-service` URLs.

### 2. Service Discovery Integration
By enabling `@EnableDiscoveryClient` and Eureka Client dependencies, the gateway resolves registered service instances dynamically.

## How to Run

1. Build project:
   ```bash
   mvn clean package
   ```
2. Run API Gateway:
   ```bash
   mvn spring-boot:run
   ```
3. Test Gateway endpoints:
   - Greet Route: `GET http://localhost:8080/greet`
   - Accounts Route: `GET http://localhost:8080/accounts/12345678`
   - Loans Route: `GET http://localhost:8080/loans/98765432`
