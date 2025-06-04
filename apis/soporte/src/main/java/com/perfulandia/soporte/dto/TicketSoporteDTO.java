package com.perfulandia.soporte.dto;

import java.sql.Date;

import lombok.*;

@Data
@RequiredArgsConstructor
public class TicketSoporteDTO {

    private Integer id;
    private String asunto;
    private String mensaje;
    private String estado;
    private Date fechaCreacion;
    private Date fechaResolucion;
    private Integer clienteId;
    private Integer tecnicoId;

}