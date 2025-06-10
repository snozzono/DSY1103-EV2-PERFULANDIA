package com.perfulandia.ventas.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "cupones")
@Data
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private int descuento;

    @Column(name = "fecha_expiracion")
    private LocalDate fechaExpiracion;
}
