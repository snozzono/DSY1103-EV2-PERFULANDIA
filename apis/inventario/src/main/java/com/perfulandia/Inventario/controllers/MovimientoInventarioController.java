package com.perfulandia.Inventario.controllers;

import com.perfulandia.Inventario.models.MovimientoInventario;
import com.perfulandia.Inventario.services.MovimientoInventarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario/movimiento")
public class MovimientoInventarioController {

    private final MovimientoInventarioService service;

    public MovimientoInventarioController(MovimientoInventarioService service) {
        this.service = service;
    }

    @PostMapping
    public MovimientoInventario crear(@RequestBody MovimientoInventario movimiento) {
        return service.save(movimiento);
    }

    @GetMapping
    public List<MovimientoInventario> listar() {
        return service.findAll();
    }
}
