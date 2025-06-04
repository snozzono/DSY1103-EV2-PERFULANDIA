package com.perfulandia.productos.controller;

import com.perfulandia.productos.models.Marca;
import com.perfulandia.productos.services.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping
    public Marca crear(@RequestBody Marca marca) {
        return marcaService.save(marca);
    }

    @GetMapping
    public List<Marca> listar() {
        return marcaService.findAll();
    }

    @GetMapping("/{id}")
    public Marca buscarPorId(@PathVariable Long id) {
        return marcaService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Marca actualizar(@PathVariable Long id, @RequestBody Marca marca) {
        marca.setId(id);
        return marcaService.save(marca);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        marcaService.deleteById(id);
    }
}