package com.perfulandia.vendedores.models;

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
    @Column(name = "id_vendedor")
    private Integer id;

    @Column(name = "id_usuario")
    private Integer usuario;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    private String rut;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursales sucursal;

    
    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
    }

    public Sucursales getSucursal() {
        return this.sucursal;
    }
}
