package com.perfulandia.ventas.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cupones")
public class Cupones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCupon;

    @Column(nullable = false, unique = true)
    private Integer codigo;

    @Column(nullable = false)
    private Double descuento;

    @Column(nullable = false)
    private Date fechaExpiracion;

    @OneToMany(mappedBy = "cupon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CuponesAplicados> cuponesAplicados;

}
