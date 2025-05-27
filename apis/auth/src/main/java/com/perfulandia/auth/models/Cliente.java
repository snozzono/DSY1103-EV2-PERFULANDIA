package com.perfulandia.auth.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "nombre_completo")
    private String nombreCompleto;
    private String rut;
    private String telefono;
    private String direccion;
}