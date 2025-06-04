package com.example.Envios.controllers;

import com.example.Envios.models.TarifaEnvio;
import com.example.Envios.services.TarifaEnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifas-envio")
public class TarifaEnvioController {
    private final TarifaEnvioService tarifaEnvioService;

    public TarifaEnvioController(TarifaEnvioService tarifaEnvioService) {
        this.tarifaEnvioService = tarifaEnvioService;
    }

    @PostMapping
    public TarifaEnvio crear(@RequestBody TarifaEnvio tarifa) {
        return tarifaEnvioService.save(tarifa);
    }

    @GetMapping
    public List<TarifaEnvio> listar() {
        return tarifaEnvioService.findAll();
    }

    @GetMapping("/{id}")
    public TarifaEnvio obtener(@PathVariable Long id) {
        return tarifaEnvioService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public TarifaEnvio actualizar(@PathVariable Long id, @RequestBody TarifaEnvio tarifa) {
        return tarifaEnvioService.update(id, tarifa);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tarifaEnvioService.delete(id);
    }
}
