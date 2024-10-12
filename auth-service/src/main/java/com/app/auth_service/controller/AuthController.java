package com.app.auth_service.controller;

import com.app.auth_service.model.User;
import com.app.auth_service.payload.LoginRequest;
import com.app.auth_service.payload.RegisterRequest;
import com.app.auth_service.payload.RegisterResponse;
import com.app.auth_service.payload.ResponsePayload;
import com.app.auth_service.service.AuthService;
import com.app.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(new ResponsePayload(authService.authenticate(loginRequest)));
    }

    @PostMapping("/register-user")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        var createdUser = authService.registerUser(registerRequest);
        var responseUser = new RegisterResponse(
                createdUser.getId(),
                createdUser.getUsername(),
                createdUser.getRole().toString()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }


}
