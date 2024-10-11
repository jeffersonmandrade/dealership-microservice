package com.app.auth_service.service;

import com.app.auth_service.model.Role;
import com.app.auth_service.model.User;
import com.app.auth_service.payload.LoginRequest;
import com.app.auth_service.payload.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User registerUser(RegisterRequest registerRequest) {
      var user =  User.builder()
                .username(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .password(passwordEncoder.encode(registerRequest.password()))
                .email(registerRequest.email())
                .role(Role.USER)
                .build();
        return userService.createUser(user);
    }

    public String authenticate(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(loginRequest.login(), loginRequest.password());
        Authentication authenticate = authenticationManager.authenticate(userAuth);
        var  userAuthenticated = (User) authenticate.getPrincipal();
        List<String> roles = getRoles(authenticate.getAuthorities());
        return jwtService.generateToken(userAuthenticated, roles);
    }

    public List<String> getRoles(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream().map(GrantedAuthority::getAuthority).toList();
    }

}
