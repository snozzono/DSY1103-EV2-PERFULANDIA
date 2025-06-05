package com.perfulandia.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.Cupones;
import java.util.List;
import java.util.Optional;


public interface CuponesRepository extends JpaRepository<Cupones, Integer> {

    Optional<Cupones> findById(Long id);
    boolean existsByCodigo(Integer codigo);
    
}
