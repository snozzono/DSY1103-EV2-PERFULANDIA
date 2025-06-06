package com.perfulandia.envios.controllers;

import com.perfulandia.envios.models.Envios;
import com.perfulandia.envios.services.EnvioService;

import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/envios")
public class EnvioController {
    private final EnvioService envioService;

    @PostMapping
    public ResponseEntity<Envios> crear(@RequestBody Envios envio) {
        return ResponseEntity.ok(envioService.crearEnvio(envio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envios> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(envioService.obtenerPorId(id));
    }

   @PutMapping("/{id}/estado")
    public ResponseEntity<Envios> actualizarEstado(
        @PathVariable Long id,
        @RequestBody Map<String, String> data) {
    String estadoId = data.get("estado");
    return ResponseEntity.ok(envioService.actualizarEstado(id, estadoId));
}

}