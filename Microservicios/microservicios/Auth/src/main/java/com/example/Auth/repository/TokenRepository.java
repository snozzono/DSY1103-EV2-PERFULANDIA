package com.example.Auth.repository;

import com.example.Auth.models.Token;
import com.example.Auth.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
    void deleteByUsuario(Usuario usuario);
}