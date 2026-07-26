# Exercise 2: Verifying Interactions with Mockito

This exercise demonstrates verifying that mock method interactions occur as expected during unit testing.

## Core Concepts Implemented

### 1. Interaction Verification with verify()
Verifies that a mock method was called with expected arguments:
```java
verify(notificationService).sendNotification("user102", "Important Update");
```

### 2. Invocation Count Verification (times, never)
Validates call frequencies:
```java
verify(notificationService, times(1)).sendEmail(...);
verify(notificationService, never()).sendNotification(...);
```

## Running Tests
Run the tests using Maven CLI:
```bash
mvn test
```
