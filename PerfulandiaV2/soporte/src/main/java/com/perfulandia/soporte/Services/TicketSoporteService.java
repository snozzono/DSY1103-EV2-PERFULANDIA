package com.perfulandia.soporte.Services;

import com.perfulandia.soporte.Models.TicketSoporte;
import com.perfulandia.soporte.Repositories.TicketSoporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketSoporteService {

    private final TicketSoporteRepository repository;

    public TicketSoporte crearTicket(TicketSoporte ticket) {
        ticket.setFechaCreacion(new java.sql.Date(new Date().getTime()));
        ticket.setEstado("Abierto");
        return repository.save(ticket);
    }

    public List<TicketSoporte> obtenerPorCliente(Integer idCliente) {
        return repository.findByIdUsuario(idCliente);
    }

    public TicketSoporte actualizarEstado(Integer id, String nuevoEstado) {
        TicketSoporte ticket = repository.findById(id).orElseThrow();
        ticket.setEstado(nuevoEstado);
        if (nuevoEstado.equalsIgnoreCase("Resuelto")) {
            ticket.setFechaResolucion(new java.sql.Date(new Date().getTime()));
        }
        return repository.save(ticket);
    }
}
