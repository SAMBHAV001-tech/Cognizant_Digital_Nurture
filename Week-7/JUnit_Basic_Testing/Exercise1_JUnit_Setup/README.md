# Exercise 1: Setting Up JUnit

This exercise demonstrates setting up JUnit 4.13.2 in a Maven Java project and writing initial unit tests.

## Maven Dependency Configuration
The following dependency is added to `pom.xml`:
```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

## Running Tests
Run the tests using Maven CLI:
```bash
mvn test
```
JUnit executes all `@Test` annotated methods in `src/test/java/`.
