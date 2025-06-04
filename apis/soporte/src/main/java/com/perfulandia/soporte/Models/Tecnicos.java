package com.perfulandia.soporte.Models;

import lombok.*;

import java.sql.Date;

import jakarta.persistence.*;

import com.perfulandia.auth.models.Usuario;

@Entity
@Table(name = "tecnicos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tecnicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fechaIngreso", nullable = false)
    private Date fechaIngreso;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
