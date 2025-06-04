package com.perfulandia.soporte.Config;

import org.springframework.stereotype.Component;


import com.perfulandia.soporte.dto.*;
import com.perfulandia.soporte.Models.*;

@Component
public class SoporteMapper {
    public TicketSoporteDTO toDto(TicketSoporte ticket) {
        TicketSoporteDTO dto = new TicketSoporteDTO();
        dto.setId(ticket.getId());
        dto.setAsunto(ticket.getAsunto());
        dto.setMensaje(ticket.getMensaje());
        dto.setEstado(ticket.getEstado());
        dto.setFechaCreacion(ticket.getFechaCreacion());
        dto.setFechaResolucion(ticket.getFechaResolucion());
        dto.setClienteId(ticket.getCliente().getId().intValue());
        dto.setTecnicoId(ticket.getTecnico().getId());
        return dto;
    }

    public TecnicoDTO toDto(Tecnicos tecnico) {
        TecnicoDTO dto = new TecnicoDTO();
        dto.setId(tecnico.getId());
        dto.setFechaIngreso(tecnico.getFechaIngreso());
        dto.setActivo(tecnico.getActivo());
        dto.setNombreCompleto(tecnico.getNombreCompleto());
        dto.setCargo(tecnico.getCargo());
        dto.setUsuarioId(tecnico.getUsuario().getId().intValue());
        return dto;
    }
}
