package com.perfulandia.soporte.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "soporteDireccion")
@Table(name = "direcciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String numero;
    private String comuna;
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
