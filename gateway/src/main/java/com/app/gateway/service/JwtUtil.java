package com.app.gateway.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {
    private static final String SECRET = "secret";
    public String decodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC512(SECRET);
        token = token.replace("Bearer", "").strip();
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getSubject();
    }

}
