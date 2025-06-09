package com.perfulandia.vendedores.repositories;

import com.perfulandia.vendedores.models.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalesRepository extends JpaRepository<Sucursales, Integer> {
}
