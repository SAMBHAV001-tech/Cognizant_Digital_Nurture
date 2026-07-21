# Exercise 2: API Gateway Load Balancing

## Overview
This exercise demonstrates API Gateway client-side load balancing using Spring Cloud Gateway and Spring Cloud LoadBalancer with a custom `RandomLoadBalancer` strategy.

## Key Concepts

### 1. Load Balancing
Load balancing distributes incoming network traffic across multiple backend service instances to ensure high availability and prevent any single server from becoming a bottleneck.

### 2. Spring Cloud LoadBalancer
Spring Cloud LoadBalancer is a reactive client-side load balancer component provided by Spring Cloud. It dynamically resolves service URIs starting with `lb://<service-name>`.

### 3. Custom RandomLoadBalancer Configuration
Using `@LoadBalancerClient`, we configure `RandomLoadBalancer` as the load balancing policy to select a backend instance randomly from the available list of static instances.

## How to Run

1. Build the project using Maven:
   ```bash
   mvn clean package
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Send requests to the gateway endpoint:
   - URL: `http://localhost:8080/backend/test`
   - Observe that successive requests receive responses alternating/randomizing between Instance 1 (Port 8082) and Instance 2 (Port 8083).
