package com.perfulandia.soporte.Services;

import org.springframework.stereotype.Service;

import com.perfulandia.soporte.Models.TicketSoporte;
import com.perfulandia.soporte.Repositories.TicketSoporteRepository;
import com.perfulandia.soporte.dto.CrearTicketSoporteRequest;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SoportesService {

    private final TicketSoporteRepository ticketRepository;


  public TicketSoporte crearTicket(CrearTicketSoporteRequest request) {
   
    TicketSoporte ticket = new TicketSoporte();
    ticket.setId(request.getTicketId());
    ticket.setUsuario(request.getAsunto());
    ticket.setSoporte(request.getSoporteId());
    ticket.setMensaje(request.getMensaje());
    ticket.setEstado("Abierto");
    ticket.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
    
    // Aquí se debería guardar el ticket en la base de datos
    // ticketRepository.save(ticket);
    
    return ticket;
  }

}
}
