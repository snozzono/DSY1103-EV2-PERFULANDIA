package com.perfulandia.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.Clientes;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Clientes, Integer>{
    Optional<Clientes> findById(Integer id);
}
