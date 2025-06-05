package com.perfulandia.ventas.models;

import lombok.*;
import jakarta.persistence.*;

@Entity(name = "sucursalesVentas")
@Data
@Table(name = "sucursal")
@NoArgsConstructor
@AllArgsConstructor
public class Sucursales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 50)
    private String encargado;

    @Column(nullable = false, length = 20)
    private String telefono;
}
