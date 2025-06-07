package com.perfulandia.ventas.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Long precio;

    @Column(nullable = false)
    private Long stock;

    @Column(nullable = false)
    private String estado; // Activo, Inactivo, etc.

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = true)
    private Categorias categorias; // Relación con la entidad categorias, si es necesario
}
