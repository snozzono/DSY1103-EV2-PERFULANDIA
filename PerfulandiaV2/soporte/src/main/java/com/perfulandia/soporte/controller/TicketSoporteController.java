package com.perfulandia.soporte.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.perfulandia.soporte.Models.TicketSoporte;
import com.perfulandia.soporte.Services.TicketSoporteService;

import java.util.*;

@RestController
@RequestMapping("/api/soporte/tickets")
@RequiredArgsConstructor
public class TicketSoporteController {

    private final TicketSoporteService service;

    @PostMapping
    public ResponseEntity<TicketSoporte> crear(@RequestBody TicketSoporte ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearTicket(ticket));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<TicketSoporte>> porCliente(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorCliente(id));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<TicketSoporte> actualizar(@PathVariable Integer id, @RequestBody String estado) {
        return ResponseEntity.ok(service.actualizarEstado(id, estado));
    }
}