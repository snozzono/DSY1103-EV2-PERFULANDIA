package com.example.Envios.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transportistas")
@Data
public class Transportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String rut;
}
