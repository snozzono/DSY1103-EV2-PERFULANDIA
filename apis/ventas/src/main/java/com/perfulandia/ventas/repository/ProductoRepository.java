package com.perfulandia.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
