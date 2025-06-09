package com.perfulandia.ventas.models;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;

@Entity(name = "VentasVendedores")
@Data
@Table(name = "vendedores")
@NoArgsConstructor
@AllArgsConstructor
public class Vendedores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private Integer vendedorId;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursales;
    //, referencedColumnName = "id_sucursal"

    @Column(name = "nombre_completo", nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String rut;

    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = true)
    private Date fechaIngreso;



}
