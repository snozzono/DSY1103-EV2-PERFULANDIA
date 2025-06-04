package com.perfulandia.gateway.jwt.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.perfulandia.gateway.jwt.dto.AuthResponse;
import com.perfulandia.gateway.jwt.dto.LoginRequest;
import com.perfulandia.gateway.jwt.models.Usuario;
import com.perfulandia.gateway.jwt.repositories.UsuarioRepository;
import com.perfulandia.gateway.jwt.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow();

        String token = jwtUtil.generateToken(usuario.getUsername(), usuario.getPassword());
        return new AuthResponse(token, usuario.getUsername(), usuario.getPassword());
    }
}
