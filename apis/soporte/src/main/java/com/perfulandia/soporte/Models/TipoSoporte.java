package com.perfulandia.soporte.Models;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "tipo_soporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

}
