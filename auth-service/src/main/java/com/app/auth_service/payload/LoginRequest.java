package com.app.auth_service.payload;

public record LoginRequest(
        String login,
        String password
){}
