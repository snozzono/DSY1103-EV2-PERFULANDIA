package com.perfulandia.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar detalles de venta por ID de venta o producto

}
