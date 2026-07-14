# Hands-on 4 – Global Exception Handling

This hands-on demonstrates creating a Global Exception Handler using `@ControllerAdvice` to centralize exception management and return standardized JSON error responses to API clients.

## Concepts
- `@ControllerAdvice`: Allows handling exceptions across the whole application globally.
- `ResponseEntityExceptionHandler`: A base class providing default handling for standard Spring MVC exceptions.
- `MethodArgumentNotValidException`: Thrown when validation on an argument annotated with `@Valid` fails.
- `HttpMessageNotReadableException`: Thrown when HTTP request body is malformed or properties cannot be parsed correctly.
