package com.perfulandia.vendedores.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.vendedores.models.Sucursales;

public interface SucursalesRepository extends JpaRepository<Sucursales, Integer> {
    Optional<Sucursales> findByNombre(String nombre);
    List<Sucursales> findById(Long id);
    

}
