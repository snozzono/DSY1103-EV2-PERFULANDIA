package com.example.Auth.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tokens")
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private boolean expirado;
    private boolean revocado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}