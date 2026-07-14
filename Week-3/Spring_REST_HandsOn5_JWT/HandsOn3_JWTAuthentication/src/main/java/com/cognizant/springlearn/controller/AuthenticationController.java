package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private static final String SECRET = "mysecretkeyshouldbeverylongandsecureandhaveatleast256bitsfortesting";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        LOGGER.info("START authenticate");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            LOGGER.error("Missing or invalid authorization header");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing credentials");
        }

        try {
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] decoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decoded, StandardCharsets.UTF_8);
            String[] values = credentials.split(":", 2);
            String username = values[0];
            String password = values[1];

            LOGGER.debug("Decoded credentials for username: {}", username);

            boolean valid = ("user".equals(username) && "userpass".equals(password))
                    || ("admin".equals(username) && "adminpass".equals(password));

            if (!valid) {
                LOGGER.error("Invalid credentials for user: {}", username);
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
            }

            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                    .signWith(KEY, SignatureAlgorithm.HS256)
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            LOGGER.info("END authenticate");
            return response;
        } catch (Exception e) {
            if (e instanceof ResponseStatusException) {
                throw (ResponseStatusException) e;
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid base64 encoding");
        }
    }
}
