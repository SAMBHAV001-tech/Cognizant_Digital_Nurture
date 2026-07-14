# Hands-on 2 – Read JSON using @RequestBody

This hands-on demonstrates reading a JSON request payload using Spring's `@RequestBody` annotation and automatically deserializing it into a Java object.

## Concepts
- `@RequestBody` binds the HTTP request body to a method parameter.
- The `HttpMessageConverter` (Jackson by default) handles JSON deserialization/serialization.
