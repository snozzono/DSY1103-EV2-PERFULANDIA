package com.perfulandia.ventas.controllers;

import com.perfulandia.ventas.models.*;
import com.perfulandia.ventas.services.VentasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VentasController {

    private final VentasService ventaService;

    @PostMapping("/ventas")
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.crearVenta(venta));
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<?> getVenta(@PathVariable Integer id) {
        return ventaService.getVentaPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venta no encontrada"));
    }

    @GetMapping("/ventas/cliente/{clienteId}")
    public ResponseEntity<List<Venta>> getVentasPorCliente(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(ventaService.getVentasPorCliente(clienteId));
    }

    @PostMapping("/cupones/validar")
    public ResponseEntity<Cupon> validarCupon(@RequestBody Cupon cupon) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.validarCupon(cupon));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
   @GetMapping("/ping")
    public ResponseEntity<String> ping() {
    return ResponseEntity.ok("Ventas vivo");
}

}
