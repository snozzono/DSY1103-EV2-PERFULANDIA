package com.perfulandia.soporte.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.soporte.Models.TicketSoporte;

public interface TicketSoporteRepository extends JpaRepository<TicketSoporte, Integer> {

    List<TicketSoporte> findByClienteId(Integer clienteId);

    
}
