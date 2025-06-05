package com.perfulandia.vendedores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.vendedores.models.Sucursales;
import com.perfulandia.vendedores.models.Vendedores;

public interface VendedoresRepository extends JpaRepository<Vendedores, Integer> {
   
    List<Vendedores> findById(Long id);
}
