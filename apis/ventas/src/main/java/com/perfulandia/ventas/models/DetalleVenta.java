package com.perfulandia.ventas.models;

import com.perfulandia.Clientes.models.Cliente;
import com.perfulandia.productos.models.Producto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "DetalleVenta")
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Integer precioUnitario;
}
