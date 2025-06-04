package com.example.Auth.services;

import com.example.Auth.models.Token;
import com.example.Auth.models.Usuario;
import com.example.Auth.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Optional<Token> findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public void deleteByUsuario(Usuario usuario) {
        tokenRepository.deleteByUsuario(usuario);
    }

    public Token save(Token token) {
        return tokenRepository.save(token);
    }
}
