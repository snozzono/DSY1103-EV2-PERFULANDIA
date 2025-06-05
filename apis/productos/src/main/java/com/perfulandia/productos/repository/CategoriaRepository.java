package com.perfulandia.productos.repository;

import com.perfulandia.productos.models.Categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findById(Integer id);
}
