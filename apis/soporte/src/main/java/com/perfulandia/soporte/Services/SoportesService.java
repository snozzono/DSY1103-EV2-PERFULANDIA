package com.perfulandia.soporte.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.perfulandia.soporte.Config.SoporteMapper;
import com.perfulandia.soporte.Models.*;
import com.perfulandia.soporte.Repositories.*;
import com.perfulandia.soporte.dto.*;

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
    
    Cliente cliente = clienteRepository.findById(request.getClienteId().longValue())
      .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    ticket.setCliente(cliente);

    Tecnicos tecnico = tecnicoRepository.findById(request.getTecnicoId())
      .orElseThrow(() -> new RuntimeException("Técnico no encontrado"));
    ticket.setTecnico(tecnico);
    
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