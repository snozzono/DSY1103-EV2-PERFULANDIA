package com.example.Envios.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "envios")
@Data
public class Envios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ventaId;
    private String direccionEnvio;

    @ManyToOne
    @JoinColumn(name = "estado_envio_id")
    private EstadoEnvio estadoEnvio;

    @ManyToOne
    @JoinColumn(name = "transportista_id")
    private Transportista transportista;

    private Date fechaEnvio;
    private Date fechaEntrega;
    private String tracking;
}