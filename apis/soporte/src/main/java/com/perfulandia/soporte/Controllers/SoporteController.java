package com.perfulandia.soporte.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.soporte.Models.TicketSoporte;
import com.perfulandia.soporte.Services.SoportesService;
import com.perfulandia.soporte.dto.CrearTicketSoporteRequest;
import com.perfulandia.soporte.dto.TicketSoporteDTO;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SoporteController {
    
    private final SoportesService soporteService;

    @PostMapping("/soporte/tickets")
    public ResponseEntity<TicketSoporte> crearTicket(@RequestBody CrearTicketSoporteRequest request) {
        TicketSoporte ticketSoporte = soporteService.crearTicket(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketSoporte);
    }
        
    @GetMapping("/soporte/tickets/cliente/{id}")
    public List<TicketSoporteDTO> obtenerTicketsPorIdCliente(@PathVariable Integer id) {
        return soporteService.obtenerTicketsPorCliente(id);
    }

    @PutMapping("soporte/tickets/{id}/estado")
    public ResponseEntity<TicketSoporteDTO> actualizarTicket(@PathVariable Integer id, @RequestBody TicketSoporteDTO ticketSoporteDTO) {
        soporteService.actualizarTicket(id, ticketSoporteDTO);
        return ResponseEntity.ok(ticketSoporteDTO);
    }

}
