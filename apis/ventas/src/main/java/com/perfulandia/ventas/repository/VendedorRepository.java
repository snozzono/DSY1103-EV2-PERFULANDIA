package com.perfulandia.ventas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.Vendedores;

public interface VendedorRepository extends JpaRepository<Vendedores,Integer>{
    
    Optional<Vendedores> findById(Long id);
}
