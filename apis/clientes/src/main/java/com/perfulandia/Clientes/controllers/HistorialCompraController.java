package com.perfulandia.Clientes.controllers;

import com.perfulandia.Clientes.models.HistorialCompra;
import com.perfulandia.Clientes.services.HistorialCompraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialCompraController {

    private final HistorialCompraService historialCompraService;

    public HistorialCompraController(HistorialCompraService historialCompraService) {
        this.historialCompraService = historialCompraService;
    }

    @PostMapping
    public HistorialCompra crear(@RequestBody HistorialCompra historial) {
        return historialCompraService.save(historial);
    }

    @GetMapping
    public List<HistorialCompra> listar() {
        return historialCompraService.findAll();
    }

    @GetMapping("/{id}")
    public HistorialCompra obtener(@PathVariable Long id) {
        return historialCompraService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public HistorialCompra actualizar(@PathVariable Long id, @RequestBody HistorialCompra historial) {
        return historialCompraService.update(id, historial);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        historialCompraService.deleteById(id);
    }
}
