# Hands-on 2 – In-Memory Authentication and Role-Based Authorization

This hands-on demonstrates setting up users in-memory with passwords encoded using `BCryptPasswordEncoder` and restricting specific resources using Spring Security roles.

## Concepts
- `InMemoryUserDetailsManager` allows defining standard username/password combinations.
- `BCryptPasswordEncoder` hashes passwords securely.
- Role-based matching (e.g. `.hasRole("USER")`) blocks users with other roles (like `ADMIN`) from accessing endpoints.
