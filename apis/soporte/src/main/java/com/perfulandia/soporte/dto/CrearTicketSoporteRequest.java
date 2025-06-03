package com.perfulandia.soporte.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CrearTicketSoporteRequest {
    
    private Integer ticketId;
    private Integer soporteId;
    private Integer clienteId;
    private String asunto;
    private String mensaje;
    private String estado;
    private Date fechaCreacion;
    private Date fechaResolucion;
   
}
