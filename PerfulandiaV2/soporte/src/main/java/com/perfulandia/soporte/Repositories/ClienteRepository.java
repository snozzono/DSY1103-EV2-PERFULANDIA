package com.perfulandia.soporte.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perfulandia.soporte.Models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
