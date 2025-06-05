package com.perfulandia.soporte.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "SoporteUusario")
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}