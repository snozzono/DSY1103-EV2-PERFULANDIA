package com.perfulandia.productos.controller;

import com.perfulandia.productos.models.Producto;
import com.perfulandia.productos.services.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return productoService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.update(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.deleteById(id);
    }
}