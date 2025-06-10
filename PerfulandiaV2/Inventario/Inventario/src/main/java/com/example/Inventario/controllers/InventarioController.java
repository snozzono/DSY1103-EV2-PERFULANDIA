package com.example.Inventario.controllers;

import com.example.Inventario.models.Inventario;
import com.example.Inventario.models.MovimientoInventario;
import com.example.Inventario.services.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService service;

    @GetMapping("/producto/{id}")
    public ResponseEntity<?> getStockByProducto(@PathVariable Integer id) {
        return service.obtenerPorProducto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/ajuste")
    public ResponseEntity<Inventario> ajustar(@RequestBody Map<String, Object> data) {
        Integer idProducto = (Integer) data.get("idProducto");
        Integer nuevoStock = (Integer) data.get("nuevoStock");
        return ResponseEntity.ok(service.ajustarStock(idProducto, nuevoStock));
    }

    @PostMapping("/movimiento")
    public ResponseEntity<MovimientoInventario> movimiento(@RequestBody MovimientoInventario mov) {
        return ResponseEntity.ok(service.registrarMovimiento(mov));
    }

    @PostMapping
    public ResponseEntity<Object> crear(@RequestBody Inventario inventario) {
    return ResponseEntity.ok(service.crearInventario(inventario));
}

}