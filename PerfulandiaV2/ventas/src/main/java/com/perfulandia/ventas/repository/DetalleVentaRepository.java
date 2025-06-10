package com.perfulandia.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findByIdVenta(Integer idVenta);
}
