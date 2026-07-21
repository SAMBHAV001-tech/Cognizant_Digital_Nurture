# Exercise 3: API Gateway

## Overview
This exercise demonstrates Spring Cloud Gateway features including dynamic path rewriting, custom request rate limiting, and response caching filters.

## Key Concepts

### 1. Spring Cloud Gateway (Port 8080)
Acts as an API Gateway forwarding `/customer/**` requests to Customer Service (Port 8085) and `/billing/**` requests to Billing Service (Port 8086).

### 2. Path Rewriting
`RewritePath` filter strips gateway prefixes and forwards requests to target backend paths seamlessly.

### 3. Rate Limiting & Response Caching
`RateLimitingFilter` enforces a request quota per client IP address. `CachingFilter` injects standard Cache-Control HTTP headers into all Gateway responses.

## How to Run

1. Build the project using Maven:
   ```bash
   mvn clean package
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Test Gateway endpoints:
   - Customer Route: `GET http://localhost:8080/customer/info`
   - Billing Route: `GET http://localhost:8080/billing/invoice`
