package com.perfulandia.ventas.models;

import java.sql.Date;

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

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private int precioUnitario;
}
