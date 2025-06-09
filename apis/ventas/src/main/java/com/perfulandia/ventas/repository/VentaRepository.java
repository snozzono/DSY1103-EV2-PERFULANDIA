package com.perfulandia.ventas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.Clientes;
import com.perfulandia.ventas.models.CuponesAplicados;
import com.perfulandia.ventas.models.Venta;


public interface VentaRepository extends JpaRepository<Venta, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar ventas por cliente, fecha, etc.

    Optional<Venta> findByIdVenta(Integer idVenta);
    List<Venta> findByCliente(Clientes cliente);
}
