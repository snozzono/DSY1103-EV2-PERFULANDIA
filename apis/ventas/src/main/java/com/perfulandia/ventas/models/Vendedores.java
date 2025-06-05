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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")
    private Sucursales sucursales;

    @OneToMany(mappedBy = "vendedor")
    private List<Venta> ventas;

    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = false)
    private Date fechaIngreso;

    @Column(nullable = false)
    private String nombre;


}
