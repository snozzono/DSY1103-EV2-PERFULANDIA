package com.example.MicroservicioProductos.repository;

import com.example.MicroservicioProductos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}