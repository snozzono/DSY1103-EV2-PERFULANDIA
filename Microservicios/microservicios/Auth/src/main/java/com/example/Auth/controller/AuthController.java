package com.example.Auth.controller;

import com.example.Auth.dto.LoginRequest;
import com.example.Auth.dto.RegistroRequest;
import com.example.Auth.services.AuthService;
import com.example.Auth.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistroRequest request) {
        return authService.register(request);
    }

    @PostMapping("/logout")
    public String logout() {
        // El cliente debe borrar el token (no hay estado del lado del servidor)
        return "Logout exitoso";
    }
}
