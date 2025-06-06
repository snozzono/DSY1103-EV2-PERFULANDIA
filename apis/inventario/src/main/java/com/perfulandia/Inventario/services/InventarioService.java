package com.perfulandia.Inventario.services;


import com.perfulandia.Inventario.models.Inventario;
import com.perfulandia.Inventario.models.MovimientoInventario;
import com.perfulandia.Inventario.repository.InventarioRepository;
import com.perfulandia.Inventario.repository.MovimientoInventarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepo;
    private final MovimientoInventarioRepository movimientoRepo;

    public Optional<Inventario> obtenerPorProducto(Integer idProducto) {
        return inventarioRepo.findByIdProducto(idProducto);
    }

    public Inventario ajustarStock(Integer idProducto, Integer nuevoStock) {
        Inventario inv = inventarioRepo.findByIdProducto(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        inv.setStockDisponible(nuevoStock);
        return inventarioRepo.save(inv);
    }

    public MovimientoInventario registrarMovimiento(MovimientoInventario movimiento) {
        movimiento.setFecha(LocalDateTime.now());
        return movimientoRepo.save(movimiento);
    }

    public Inventario crearInventario(Inventario inventario) {
    return inventarioRepo.save(inventario);
}
}
