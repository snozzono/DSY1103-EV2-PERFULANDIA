package com.perfulandia.envios.models;

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
    
}
