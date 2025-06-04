package com.example.Inventario.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventario")
@Data
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "producto_id")
    private Long productoId;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;

}