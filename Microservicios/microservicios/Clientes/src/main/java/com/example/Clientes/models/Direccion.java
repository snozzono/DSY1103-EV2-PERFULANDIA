package com.example.Clientes.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "direcciones")
@Data
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
