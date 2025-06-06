package com.perfulandia.envios.repository;

import com.perfulandia.envios.models.Envios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envios, Long> {
}