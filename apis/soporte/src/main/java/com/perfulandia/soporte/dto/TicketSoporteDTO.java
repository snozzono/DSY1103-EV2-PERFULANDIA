package com.perfulandia.soporte.dto;

import lombok.*;

@Data
@RequiredArgsConstructor
public class TicketSoporteDTO {

    private Integer id;
    private Integer clienteId;
    private Integer tipoSoporteId;
    private String mensaje;
    private String estado;
}
