package com.perfulandia.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    Optional<Cliente> findById(Integer id);
}
