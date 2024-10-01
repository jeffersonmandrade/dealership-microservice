package com.app.auth_service.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String SECRET_JWT;

    public String generateToken(UserDetails userDetails, List<String> roles) {
        Algorithm algorithm = Algorithm.HMAC512(SECRET_JWT);
     return   JWT.create()
                .withSubject(userDetails.getUsername())
                .withIssuedAt(LocalDateTime.now().toInstant(ZoneOffset.from(ZoneOffset.UTC)))
                .withExpiresAt(LocalDateTime.now().plusDays(3).toInstant(ZoneOffset.from(ZoneOffset.UTC)))
                .withClaim("roles", roles)
                .sign(algorithm);
    }
}


