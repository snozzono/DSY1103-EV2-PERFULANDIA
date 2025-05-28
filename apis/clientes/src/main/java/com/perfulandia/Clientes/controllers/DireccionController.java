package com.perfulandia.Clientes.controllers;

import com.perfulandia.Clientes.models.Direccion;
import com.perfulandia.Clientes.services.DireccionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping
    public Direccion crear(@RequestBody Direccion direccion) {
        return direccionService.save(direccion);
    }

    @GetMapping
    public List<Direccion> listar() {
        return direccionService.findAll();
    }

    @GetMapping("/{id}")
    public Direccion obtener(@PathVariable Long id) {
        return direccionService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Direccion actualizar(@PathVariable Long id, @RequestBody Direccion direccion) {
        return direccionService.update(id, direccion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        direccionService.deleteById(id);
    }
}
