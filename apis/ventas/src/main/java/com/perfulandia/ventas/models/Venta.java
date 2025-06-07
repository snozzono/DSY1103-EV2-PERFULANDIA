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
    @Column(name = "id_venta")
    private Integer idVenta;

    @OneToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Clientes cliente;
    //, referencedColumnName = "cliente_id"

    @OneToOne
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Vendedores vendedor;
    //, referencedColumnName = "vendedor_id"

    @Column(name = "fecha_venta", nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Double descuento;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Integer total;

    @Column(nullable = false)
    private Integer totalFinal;

}
