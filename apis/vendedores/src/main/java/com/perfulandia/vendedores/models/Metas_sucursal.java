package com.perfulandia.vendedores.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "metas_sucursal")
@AllArgsConstructor
@NoArgsConstructor
public class Metas_sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursales sucursal;

    @Column(nullable = false)
    private Integer mes;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Double monto_meta;

    @Column(nullable = false)
    private String observacion; 
}
