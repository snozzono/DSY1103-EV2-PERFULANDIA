package com.example.controllers;

import com.example.models.Usuario;
import com.example.services.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.findById(id).orElse(null);
    }

    @GetMapping("/rol/{nombre}")
    public List<Usuario> buscarPorRol(@PathVariable String nombre) {
        return usuarioService.findByRol(nombre);
    }
}