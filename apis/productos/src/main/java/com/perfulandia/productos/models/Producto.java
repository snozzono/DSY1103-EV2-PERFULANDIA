package com.perfulandia.productos.models;

import java.math.BigDecimal;
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
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer precio;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marcas; // Relación con la entidad marcas, si es necesario

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = true)
    private Categorias categorias; // Relación con la entidad categorias, si es necesario
}
