package com.app.auth_service.payload;

public record RegisterRequest(String email, String password, String firstName,String lastName) {
}
