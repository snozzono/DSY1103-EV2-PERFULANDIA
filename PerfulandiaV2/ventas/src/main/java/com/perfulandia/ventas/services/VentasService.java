package com.perfulandia.ventas.services;

import com.perfulandia.ventas.models.*;
import com.perfulandia.ventas.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class VentasService {

    private final VentaRepository ventaRepo;
    private final CuponRepository cuponRepo;

    public Venta crearVenta(Venta venta) {
        return ventaRepo.save(venta);
    }

    public Optional<Venta> getVentaPorId(Integer id) {
        return ventaRepo.findById(id);
    }

    public List<Venta> getVentasPorCliente(Integer clienteId) {
        return ventaRepo.findByIdCliente(clienteId);
    }

    public Cupon validarCupon(Cupon cupon) {
        if (cuponRepo.existsByCodigo(cupon.getCodigo())) {
            throw new RuntimeException("El cupon ya existe.");
        }
        return cuponRepo.save(cupon);
    }
}