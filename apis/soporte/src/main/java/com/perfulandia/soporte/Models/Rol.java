package com.perfulandia.soporte.Models;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name = "soporteRoles")
@Data
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;
}