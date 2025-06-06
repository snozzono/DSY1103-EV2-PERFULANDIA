package com.perfulandia.ventas.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "ventas")
@AllArgsConstructor
@NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Vendedores vendedor;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Integer total;

    @Column(nullable = false)
    private Double descuento;

    @Column(nullable = false)
    private Integer totalFinal;

    @Column(nullable = false)
    private String estado;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CuponesAplicados> cuponesAplicados;

    @OneToMany(mappedBy = "idProducto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> productos; // prodcutos con DetalleVenta
}
