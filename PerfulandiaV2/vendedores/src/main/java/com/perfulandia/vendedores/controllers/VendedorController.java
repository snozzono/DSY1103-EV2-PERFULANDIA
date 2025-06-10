package com.perfulandia.vendedores.controllers;

import com.perfulandia.vendedores.dto.VendedoresDTO;
import com.perfulandia.vendedores.services.VendedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    @Autowired
    private VendedoresService service;

    @PostMapping
    public ResponseEntity<VendedoresDTO> crear(@RequestBody VendedoresDTO dto) {
        return ResponseEntity.ok(service.guardar(dto));
    }

    @GetMapping
    public ResponseEntity<List<VendedoresDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedoresDTO> obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedoresDTO> actualizar(@PathVariable Integer id, @RequestBody VendedoresDTO dto) {
        return service.actualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return service.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<VendedoresDTO>> listarPorSucursal(@PathVariable Integer id) {
    return ResponseEntity.ok(service.listarPorSucursal(id));
    }

}
