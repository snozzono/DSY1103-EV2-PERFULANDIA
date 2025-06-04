package com.perfulandia.productos.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import com.perfulandia.productos.models.*;

@Data
@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

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
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marcas; // Relación con la entidad marcas, si es necesario

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = true)
    private Categoria categorias; // Relación con la entidad categorias, si es necesario
}
