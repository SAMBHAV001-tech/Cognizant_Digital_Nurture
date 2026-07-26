# Exercise 4: AAA Pattern, Setup and Teardown

This exercise demonstrates unit testing using the **Arrange-Act-Assert (AAA)** pattern alongside `@Before` (setup) and `@After` (teardown) annotations in JUnit 4.

## Key Concepts Implemented

### 1. Arrange-Act-Assert (AAA) Pattern
- **Arrange**: Set up test data, objects, and preconditions.
- **Act**: Invoke the method under test.
- **Assert**: Verify that the actual result matches expectations.

### 2. Lifecycle Annotations
- `@Before`: Executes before every `@Test` method to set up initial state.
- `@After`: Executes after every `@Test` method to clean up resources.

## Running Tests
Run the tests using Maven CLI:
```bash
mvn test
```
