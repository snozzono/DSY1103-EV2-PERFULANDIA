package com.example.Inventario.controllers;

import com.example.Inventario.models.Almacen;
import com.example.Inventario.services.AlmacenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacenes")
public class AlmacenController {

    private final AlmacenService almacenService;

    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @PostMapping
    public Almacen crear(@RequestBody Almacen almacen) {
        return almacenService.save(almacen);
    }

    @GetMapping
    public List<Almacen> listar() {
        return almacenService.findAll();
    }

    @GetMapping("/{id}")
    public Almacen buscarPorId(@PathVariable Long id) {
        return almacenService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Almacen actualizar(@PathVariable Long id, @RequestBody Almacen almacen) {
        return almacenService.update(id, almacen);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        almacenService.deleteById(id);
    }
}
