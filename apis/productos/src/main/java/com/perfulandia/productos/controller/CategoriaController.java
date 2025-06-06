
package com.perfulandia.productos.controller;

import com.perfulandia.productos.models.Categorias;
import com.perfulandia.productos.services.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public Categorias crear(@RequestBody Categorias categoria) {
        return categoriaService.save(categoria);
    }

    @GetMapping
    public List<Categorias> listar() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categorias buscarPorId(@PathVariable Integer id) {
        return categoriaService.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Categorias actualizar(@PathVariable Integer id, @RequestBody Categorias categoria) {
        categoria.setId(id);
        return categoriaService.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        categoriaService.deleteById(id);
    }
}
