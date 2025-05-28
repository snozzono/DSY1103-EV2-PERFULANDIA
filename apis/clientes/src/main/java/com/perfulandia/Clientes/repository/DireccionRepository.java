package com.perfulandia.Clientes.repository;
import com.perfulandia.Clientes.models.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}