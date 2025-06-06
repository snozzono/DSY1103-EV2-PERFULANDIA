package com.perfulandia.envios.repository;

import com.perfulandia.envios.models.EstadoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Long> {
}