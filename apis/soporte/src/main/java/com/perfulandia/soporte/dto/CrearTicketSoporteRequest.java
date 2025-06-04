package com.perfulandia.soporte.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CrearTicketSoporteRequest {
    
    private String asunto;
    private String mensaje;
    private String estado;
    private Date fechaCreacion;
    private Date fechaResolucion;
    private Integer clienteId; // ID del cliente asociado al ticket
    private Integer tecnicoId; // ID del técnico asignado al ticket
}
