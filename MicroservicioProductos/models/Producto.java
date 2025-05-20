package com.example.MicroservicioProductos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String marca;
    private Integer stock;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;
}