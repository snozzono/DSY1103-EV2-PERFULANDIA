package com.example.Inventario.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "almacenes")
@Data
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String ubicacion;
}

