package com.app.auth_service.payload;



public record RegisterResponse(
        Long id,
        String userName,
        String role
) {
}
