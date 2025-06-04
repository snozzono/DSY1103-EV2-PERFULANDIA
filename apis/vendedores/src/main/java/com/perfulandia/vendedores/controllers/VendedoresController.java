package com.perfulandia.vendedores.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.vendedores.dto.CrearVendedorRequest;
import com.perfulandia.vendedores.models.Vendedores;
import com.perfulandia.vendedores.services.VendedoresService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/vendedores")
@RequiredArgsConstructor
public class VendedoresController {
    
    private final VendedoresService vendedoresService;

    @PostMapping("/")
    public ResponseEntity<Vendedores> crearVendedor(@RequestBody CrearVendedorRequest request) {
        Vendedores vendedor = vendedoresService.crearVendedor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedores> getById(@PathVariable Integer id) {
        Vendedores vendedor = vendedoresService.obtenerVendedorPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(vendedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedores> actualizarVendedor(@PathVariable Integer id, @RequestBody Vendedores vendedor) {
        Vendedores vendedorActualizado = vendedoresService.actualizarVendedor(id, vendedor);
        return ResponseEntity.status(HttpStatus.OK).body(vendedorActualizado);
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<Vendedores>> getVendorsBySucursal(@PathVariable Integer id) {
        List<Vendedores> vendedores = vendedoresService.obtenerVendedoresPorSucursal(id);
        return ResponseEntity.status(HttpStatus.OK).body(vendedores);
    }


}
