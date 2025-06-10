package com.perfulandia.vendedores.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "sucursales")
@AllArgsConstructor
@NoArgsConstructor
public class Sucursales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = true)
    private String telefono;

    @Column(nullable = true)
    private String encargado;
}
