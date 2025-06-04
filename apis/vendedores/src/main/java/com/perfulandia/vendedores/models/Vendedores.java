package com.perfulandia.vendedores.models;

import com.perfulandia.auth.models.Usuario;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "vendedores")
@AllArgsConstructor
@NoArgsConstructor
public class Vendedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursales sucursal;

    @Column(nullable = false)
    private Date fechaIngreso;

    @Column(nullable = false, unique = true)
    private boolean activo;
}
