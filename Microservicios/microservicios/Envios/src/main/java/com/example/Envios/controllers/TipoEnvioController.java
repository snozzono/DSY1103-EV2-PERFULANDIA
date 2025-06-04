package com.example.Envios.controllers;

import com.example.Envios.models.TipoEnvio;
import com.example.Envios.services.TipoEnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-envio")
public class TipoEnvioController {
    private final TipoEnvioService tipoEnvioService;

    public TipoEnvioController(TipoEnvioService tipoEnvioService) {
        this.tipoEnvioService = tipoEnvioService;
    }

    @PostMapping
    public TipoEnvio crear(@RequestBody TipoEnvio tipo) {
        return tipoEnvioService.save(tipo);
    }

    @GetMapping
    public List<TipoEnvio> listar() {
        return tipoEnvioService.findAll();
    }

    @GetMapping("/{id}")
    public TipoEnvio obtener(@PathVariable Long id) {
        return tipoEnvioService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public TipoEnvio actualizar(@PathVariable Long id, @RequestBody TipoEnvio tipo) {
        return tipoEnvioService.update(id, tipo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tipoEnvioService.delete(id);
    }
}