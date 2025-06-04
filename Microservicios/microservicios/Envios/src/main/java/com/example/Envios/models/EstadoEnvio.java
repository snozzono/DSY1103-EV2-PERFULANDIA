package com.example.Envios.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estados_envio")
@Data
public class EstadoEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;
}