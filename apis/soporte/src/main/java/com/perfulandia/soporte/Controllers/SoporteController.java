package com.perfulandia.soporte.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

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
    
    private final SoporteService soporteService;

    @PostMapping("/soporte/tickets")
    public ResponseEntity<TicketSoporteDTO> crearTicket(@RequestBody TicketSoporteDTO ticketSoporteDTO) {
        //TODO: process POST request
        
        return ticketSoporteDTO;
    }
        
    @GetMapping("/soporte/tickets/cliente/{id}")
    public ResponseEntity<List<TicketSoporteDTO>> obtenerTicketsPorCliente(@PathVariable Integer id) {
        List<TicketSoporteDTO> tickets = soporteService.obtenerTicketsPorCliente(id);
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("soporte/tickets/{id}/estado")
    public String comoVaElTicket(@PathVariable Integer id) {
        //TODO: process PUT request
        
        return entity;
    }
}
