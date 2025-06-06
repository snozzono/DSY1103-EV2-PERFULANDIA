package com.perfulandia.productos.repository;

import com.perfulandia.productos.models.Categorias;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {
    Optional<Categorias> findById(Integer id);
}
