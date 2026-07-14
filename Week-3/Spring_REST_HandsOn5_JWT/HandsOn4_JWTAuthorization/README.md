# Hands-on 4 – JWT Authorization Filter

This hands-on demonstrates creating a custom filter `JwtAuthorizationFilter` that extends `BasicAuthenticationFilter` to validate Bearer tokens in incoming request headers and automatically log the authenticated user into Spring's Security context.

## Concepts
- `BasicAuthenticationFilter` is extended to inspect headers on every request.
- Bearer tokens are retrieved from `Authorization` header and parsed.
- Validation checks if signature is valid and claims match roles.
- `SecurityContextHolder` maintains the authenticated state.
