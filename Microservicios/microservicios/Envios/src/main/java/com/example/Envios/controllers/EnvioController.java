package com.example.Envios.controllers;

import com.example.Envios.models.Envios;
import com.example.Envios.services.EnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {
    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @PostMapping
    public Envios crear(@RequestBody Envios envio) {
        return envioService.save(envio);
    }

    @GetMapping
    public List<Envios> listar() {
        return envioService.findAll();
    }

    @GetMapping("/{id}")
    public Envios obtener(@PathVariable Long id) {
        return envioService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Envios actualizar(@PathVariable Long id, @RequestBody Envios envio) {
        return envioService.update(id, envio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        envioService.delete(id);
    }
}
