package com.perfulandia.vendedores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.vendedores.models.Vendedores;

public interface VendedoresRepository extends JpaRepository<Vendedores, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar vendedores por sucursal o por nombre
    List<Vendedores> findBySucursalId(Integer idSucursal);
    List<Vendedores> findByUsuario(Long usuario);
    
    
}
