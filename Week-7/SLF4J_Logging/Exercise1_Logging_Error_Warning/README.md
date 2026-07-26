# Exercise 1: Logging Error Messages and Warning Levels with SLF4J & Logback

This exercise demonstrates logging `ERROR` and `WARN` severity messages using the SLF4J abstraction API with Logback implementation.

## Core Concepts Implemented

### 1. Logger Initialization
Logger instances are instantiated via `LoggerFactory`:
```java
private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);
```

### 2. Log Levels
- **ERROR**: Logs error events that might still allow the application to continue running.
- **WARN**: Logs potentially harmful situations or warning notices.

```java
logger.error("Database connection failed: Unable to connect to host localhost:5432");
logger.warn("High memory usage warning: Memory utilization reached 88%");
```

## Running the Application
Build and execute the project using Maven:
```bash
mvn compile exec:java
```
