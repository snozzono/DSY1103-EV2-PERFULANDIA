package com.perfulandia.productos.repository;

import com.perfulandia.productos.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
