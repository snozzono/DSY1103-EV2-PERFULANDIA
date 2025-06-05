package com.perfulandia.ventas.controllers;

import com.perfulandia.ventas.dto.*;
import com.perfulandia.ventas.dto.VentaDTO;
import com.perfulandia.ventas.models.*;
import com.perfulandia.ventas.services.*;

import lombok.*;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class VentasController {
    
    private final VentasService ventaService;

    @PostMapping("/ventas")
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta request) {
        Venta venta = ventaService.crearVenta(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(venta);
    }

    @GetMapping("/ventas/{id}")
    public ResponseEntity<?> buscarVentaPorId(@PathVariable Integer id) {
           try {
            Venta venta = ventaService.buscarVentaPorId(id);
            return ResponseEntity.ok(venta);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(Map.of("mensaje", ex.getMessage()));
        }
    }

    @GetMapping("/ventas/cliente/{clienteid}")
    public ResponseEntity<?> comprasPorIdCliente(@PathVariable Integer clienteid) {
        try {
           List<Venta> ventas = ventaService.buscarVentasPorCliente(clienteid);
           return ResponseEntity.ok(ventas);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(Map.of("mensaje", ex.getMessage()));
        }
    }

    @PostMapping("/cupones/validar")
    public ResponseEntity<Cupones> validarCupon(@RequestBody Cupones cupon) {
        try {
            Cupones nuevoCupon = ventaService.validarCupones(cupon);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCupon);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(null);
        }
    }


}
