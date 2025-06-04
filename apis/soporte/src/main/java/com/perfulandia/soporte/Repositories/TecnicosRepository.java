package com.perfulandia.soporte.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.soporte.Models.Tecnicos;



public interface TecnicosRepository extends JpaRepository<Tecnicos, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar técnicos por nombre o estado
    // List<Tecnicos> findByNombreCompleto(String nombreCompleto);
    // List<Tecnicos> findByActivo(Boolean activo);
    
}
