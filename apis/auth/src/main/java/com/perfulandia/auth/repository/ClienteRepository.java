package com.perfulandia.auth.repository;

import com.perfulandia.auth.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}