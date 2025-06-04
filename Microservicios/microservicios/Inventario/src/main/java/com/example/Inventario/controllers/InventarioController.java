package com.example.Inventario.controllers;

import com.example.Inventario.models.Inventario;
import com.example.Inventario.services.InventarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public Inventario crear(@RequestBody Inventario inventario) {
        return inventarioService.save(inventario);
    }

    @GetMapping
    public List<Inventario> listar() {
        return inventarioService.findAll();
    }

    @GetMapping("/{id}")
    public Inventario buscarPorId(@PathVariable Long id) {
        return inventarioService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Long id, @RequestBody Inventario inventario) {
        return inventarioService.update(id, inventario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inventarioService.deleteById(id);
    }
}