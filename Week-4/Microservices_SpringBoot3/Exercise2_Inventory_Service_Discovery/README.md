# Exercise 2: Inventory Management with Service Discovery

## Overview
This project demonstrates microservice discovery and registration using Spring Cloud Netflix Eureka Server with `Product Service` and `Inventory Service`.

## Key Concepts

### 1. Eureka Server (Port 8761)
Acts as the central registry where microservices register themselves dynamically upon startup.

### 2. Product Service (Port 8083) & Inventory Service (Port 8084)
Microservices configured as Eureka clients (`@EnableDiscoveryClient`) that auto-register with Eureka Server and enable service-to-service discovery by application name.

## How to Run

1. Build the projects:
   ```bash
   mvn clean package
   ```
2. Start Eureka Server:
   ```bash
   cd eureka-server && mvn spring-boot:run
   ```
3. Start Product and Inventory Services:
   ```bash
   cd product-service && mvn spring-boot:run
   cd inventory-service && mvn spring-boot:run
   ```
4. Access Eureka Dashboard:
   - Dashboard URL: `http://localhost:8761`
