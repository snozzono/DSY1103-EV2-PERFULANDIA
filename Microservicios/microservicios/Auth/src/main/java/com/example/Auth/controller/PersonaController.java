package com.example.Auth.controller;


import com.example.Auth.models.Persona;
import com.example.Auth.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public ResponseEntity<Persona> crear(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.crear(persona));
    }

    @GetMapping
    public ResponseEntity<List<Persona>> listar() {
        return ResponseEntity.ok(personaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(personaService.buscarPorId(id));
    }
}
