package com.example.Auth.services;

import com.example.Auth.dto.AuthResponse;
import com.example.Auth.dto.LoginRequest;
import com.example.Auth.dto.RegistroRequest;
import com.example.Auth.models.Persona;
import com.example.Auth.models.Usuario;
import com.example.Auth.repository.UsuarioRepository;
import com.example.Auth.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPass()));

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtUtil.generateToken(usuario.getEmail());
        return new AuthResponse(token);
    }

    public String register(RegistroRequest request) {
        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUser());
        usuario.setPassword(passwordEncoder.encode(request.getPass()));

        Persona persona = new Persona();
        persona.setId(request.getIdPersona());
        usuario.setPersona(persona);

        usuarioRepository.save(usuario);
        return "Usuario registrado con éxito";
    }

    public void logout(String token) {
    }
}

