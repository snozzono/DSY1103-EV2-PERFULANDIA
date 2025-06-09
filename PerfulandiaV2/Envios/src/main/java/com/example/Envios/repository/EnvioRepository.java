package com.example.Envios.repository;

import com.example.Envios.models.Envios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envios, Long> {
}