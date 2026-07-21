# Exercise 2: Eureka Discovery Server

## Overview
This exercise configures a Spring Cloud Eureka Discovery Server acting as the central service registry for microservices.

## Key Concepts

### 1. Eureka Server (Port 8761)
Provides a service registry where microservices register themselves dynamically.

### 2. Configuration
`eureka.client.register-with-eureka=false` and `eureka.client.fetch-registry=false` prevent the standalone server from trying to register with itself.

## How to Run

1. Build project:
   ```bash
   mvn clean package
   ```
2. Run Eureka Server:
   ```bash
   mvn spring-boot:run
   ```
3. Access Eureka Dashboard:
   - Dashboard URL: `http://localhost:8761`
