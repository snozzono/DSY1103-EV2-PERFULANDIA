package com.example.Envios.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipos_envio")
@Data
public class TipoEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
}