package com.example.Inventario.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "movimientos_inventario")
@Data
public class MovimientoInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // entra o sale

    private Integer cantidad;

    private String motivo;

    private LocalDateTime fecha = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;
}
