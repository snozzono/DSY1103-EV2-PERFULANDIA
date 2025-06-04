package com.perfulandia.soporte.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.perfulandia.soporte.Config.SoporteMapper;
import com.perfulandia.soporte.Models.TicketSoporte;
import com.perfulandia.soporte.Repositories.TecnicosRepository;
import com.perfulandia.soporte.Repositories.TicketSoporteRepository;
import com.perfulandia.soporte.dto.*;
import com.perfulandia.Clientes.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SoportesService {

    private final TicketSoporteRepository ticketRepository;
    private final TecnicosRepository tecnicoRepository;
    private final ClienteRepository clienteRepository;
    private final SoporteMapper soporteMapper;

  public TicketSoporte crearTicket(CrearTicketSoporteRequest request) {
    TicketSoporte ticket = new TicketSoporte();
    ticket.setAsunto(request.getAsunto());
    ticket.setMensaje(request.getMensaje());
    ticket.setEstado(request.getEstado());
    ticket.setFechaCreacion(request.getFechaCreacion());
    ticket.setFechaResolucion(request.getFechaResolucion());
    ticket
    .setCliente(clienteRepository
      .findById(request.getClienteId()
      .longValue())
      .orElseThrow(()
        -> new RuntimeException("Cliente no encontrado")));
    ticket
    .setTecnico(tecnicoRepository
    .findById(request
    .getTecnicoId())
    .orElseThrow(() -> new RuntimeException("Técnico no encontrado")));
    return ticketRepository.save(ticket);
  }

  public List<TicketSoporteDTO> obtenerTicketsPorCliente(Integer clienteId) {
    return ticketRepository.findByClienteId(clienteId)
      .stream()
      .map(soporteMapper::toDto)
      .toList();
  }

  public TicketSoporteDTO actualizarTicket(Integer id, TicketSoporteDTO ticketSoporteDTO) {
    TicketSoporte ticket = ticketRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
    ticket.setEstado(ticketSoporteDTO.getEstado());
    ticket.setFechaResolucion(ticketSoporteDTO.getFechaResolucion());
    TicketSoporte updatedTicket = ticketRepository.save(ticket);
    return soporteMapper.toDto(updatedTicket);
}


}