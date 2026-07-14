# Hands-on 3 – JWT Authentication Service

This hands-on demonstrates creating a `/authenticate` endpoint that accepts client Basic Authentication credentials, verifies them against user store, and returns a JSON Web Token (JWT) signed with HMAC-SHA256.

## Concepts
- Basic authentication credentials can be decoded using `Base64.getDecoder()`.
- JSON Web Token (JWT) consists of three parts: header, claims (payload), and signature.
- `io.jsonwebtoken` library is used to build and sign JWTs securely.
