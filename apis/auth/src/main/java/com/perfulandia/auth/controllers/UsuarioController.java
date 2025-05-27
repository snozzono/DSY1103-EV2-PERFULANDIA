package com.perfulandia.auth.controllers;

import com.perfulandia.auth.models.Usuario;
import com.perfulandia.auth.services.UsuarioService;
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