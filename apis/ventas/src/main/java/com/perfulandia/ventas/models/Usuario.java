package com.perfulandia.ventas.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "usuarioAuth")
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre_usuario")
    private String username;

    @Column(name = "email")
    private String email;
    
    @Column(name = "contrasena")
    private String password;

    @Column(name = "rol")
    private String rol;

    @Column(name = "estado")
    private String estado;
}