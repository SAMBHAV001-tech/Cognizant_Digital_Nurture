# Exercise 3: Register Microservices with Eureka

## Overview
This exercise registers both `Account Service` and `Loan Service` with the Eureka Discovery Server.

## Key Concepts

### 1. Eureka Client
By adding `spring-cloud-starter-netflix-eureka-client` and `@EnableDiscoveryClient`, services automatically register with Eureka at `http://localhost:8761/eureka/`.

### 2. Service Naming
`spring.application.name=account-service` and `spring.application.name=loan-service` define how the microservices appear in Eureka's registry.

## How to Run

1. Build projects:
   ```bash
   mvn clean package
   ```
2. Ensure Eureka Server is running on port 8761.
3. Start Account and Loan Services:
   ```bash
   cd account-service && mvn spring-boot:run
   cd loan-service && mvn spring-boot:run
   ```
4. Check Dashboard: `http://localhost:8761`
