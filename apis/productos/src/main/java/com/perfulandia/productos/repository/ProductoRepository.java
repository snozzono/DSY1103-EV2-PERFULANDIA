package com.perfulandia.productos.repository;

import com.perfulandia.productos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}