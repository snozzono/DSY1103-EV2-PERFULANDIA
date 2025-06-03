package com.perfulandia.soporte.Config;

import org.springframework.stereotype.Component;


import com.perfulandia.soporte.dto.*;
import com.perfulandia.soporte.Models.*;

@Component
public class SoporteMapper {
    public TicketSoporteDTO toDto(TicketSoporte ticket) {
        TicketSoporteDTO dto = new TicketSoporteDTO();
        dto.setId(ticket.getId());
        dto.setClienteId(ticket.getUsuario().getId());
        dto.setTipoSoporteId(ticket.getSoporte().getId());
        dto.setMensaje(ticket.getMensaje());
        dto.setEstado(ticket.getEstado());
        return dto;
    }

}
