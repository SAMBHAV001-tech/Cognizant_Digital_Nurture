# Exercise 1: Account and Loan Microservices

## Overview
This exercise creates two standalone Spring Boot microservices: `Account Service` and `Loan Service`.

## Key Concepts

### 1. Account Service (Port 8085)
Exposes endpoint `GET /accounts/{number}` to query account details by account number.

### 2. Loan Service (Port 8081)
Exposes endpoint `GET /loans/{number}` to query loan details by loan number.

## How to Run

1. Build projects:
   ```bash
   mvn clean package
   ```
2. Run Account Service:
   ```bash
   cd account-service && mvn spring-boot:run
   ```
3. Run Loan Service:
   ```bash
   cd loan-service && mvn spring-boot:run
   ```
4. Test Endpoints:
   - Account Details: `GET http://localhost:8085/accounts/12345678`
   - Loan Details: `GET http://localhost:8081/loans/98765432`
