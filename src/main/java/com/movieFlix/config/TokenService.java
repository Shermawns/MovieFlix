package com.movieFlix.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.movieFlix.entity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {

    private String secret = "SKIBIDIFORTNITEBALLS";
    public String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId())
                .withClaim("userEmail", user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("Shermann skibidi")
                .sign(algorithm);
    }
}
