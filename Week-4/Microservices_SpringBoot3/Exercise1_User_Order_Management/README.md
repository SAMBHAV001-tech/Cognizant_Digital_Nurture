# Exercise 1: User and Order Management System

## Overview
This exercise demonstrates microservice communication between `User Service` and `Order Service` using Spring WebClient and JPA/H2 in-memory databases.

## Key Concepts

### 1. User Service (Port 8081)
Manages user details (`id`, `name`, `email`) using Spring Data JPA and H2 database.

### 2. Order Service (Port 8082)
Manages order details (`id`, `userId`, `product`, `price`). When querying an order, `Order Service` makes a reactive REST call using Spring `WebClient` to `User Service` to fetch user details associated with the order.

## How to Run

1. Build the projects:
   ```bash
   mvn clean package
   ```
2. Start `user-service`:
   ```bash
   cd user-service && mvn spring-boot:run
   ```
3. Start `order-service`:
   ```bash
   cd order-service && mvn spring-boot:run
   ```
4. Test REST APIs:
   - Create User: `POST http://localhost:8081/users`
   - Create Order: `POST http://localhost:8082/orders`
   - Fetch Order with User Details: `GET http://localhost:8082/orders/1`
