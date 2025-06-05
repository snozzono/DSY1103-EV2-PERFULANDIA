package com.perfulandia.soporte.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "soporteHistorialCompras")
@Table(name = "historial_compras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;
    private Integer cantidad;
    private LocalDate fechaCompra;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
