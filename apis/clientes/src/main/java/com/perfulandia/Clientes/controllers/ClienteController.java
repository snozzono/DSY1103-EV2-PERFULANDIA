package com.perfulandia.Clientes.controllers;

import com.perfulandia.Clientes.models.Cliente;
import com.perfulandia.Clientes.services.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable Long id) {
        return clienteService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    @GetMapping("/preferencias")
    public String obtenerPreferencias() {
        return "Preferencias del cliente (ejemplo)";
    }
}