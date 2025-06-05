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
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer codigo;

    @Column(nullable = false)
    private Double descuento;

    @Column(nullable = true)
    private Date validoHasta;

    @Column(nullable = false)
    private Date fechaExpiracion;

}
