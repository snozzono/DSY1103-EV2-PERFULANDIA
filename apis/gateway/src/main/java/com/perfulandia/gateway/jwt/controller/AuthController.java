package com.perfulandia.gateway.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.gateway.jwt.dto.AuthResponse;
import com.perfulandia.gateway.jwt.dto.LoginRequest;
import com.perfulandia.gateway.jwt.services.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse postMethodName(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
    
}
