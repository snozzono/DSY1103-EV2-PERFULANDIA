package com.perfulandia.soporte.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.soporte.Models.TicketSoporte;

import java.util.List;

public interface TicketSoporteRepository extends JpaRepository<TicketSoporte, Integer> {
    List<TicketSoporte> findByIdUsuario(Integer idUsuario);
}