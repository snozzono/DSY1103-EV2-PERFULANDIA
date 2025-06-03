package com.perfulandia.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar ventas por cliente, fecha, etc.

    List<Venta> findByClienteId(Integer clienteId);
    List<Venta> findByCodigoCupon(Integer codigoCupon);
}
