# Exercise 1: Mocking and Stubbing with Mockito & JUnit 5

This exercise demonstrates creating mock objects and stubbing method calls using Mockito with JUnit 5.

## Core Concepts Implemented

### 1. Mock Creation
Mock objects simulate external dependencies without executing actual implementations:
```java
@Mock
private ExternalApi externalApi;
```

### 2. Dependency Injection
Mockito injects mock objects into the target service instance:
```java
@InjectMocks
private MyService myService;
```

### 3. Stubbing Methods
Define return values for specified method calls:
```java
when(externalApi.fetchData("userQuery")).thenReturn("sample data");
```

## Running Tests
Run the tests using Maven CLI:
```bash
mvn test
```
