package com.perfulandia.vendedores.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.vendedores.models.Sucursales;

public interface SucursalesRepository extends JpaRepository<Sucursales, Integer> {
    List<Sucursales> findByNombre(String nombre);
    @Override
    default Optional<Sucursales> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
