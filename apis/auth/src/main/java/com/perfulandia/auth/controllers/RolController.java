package com.perfulandia.auth.controllers;

import com.perfulandia.auth.models.Rol;
import com.perfulandia.auth.services.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public Rol crear(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @GetMapping
    public List<Rol> listar() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public Rol buscarPorId(@PathVariable Long id) {
        return rolService.findById(id).orElse(null);
    }
}
