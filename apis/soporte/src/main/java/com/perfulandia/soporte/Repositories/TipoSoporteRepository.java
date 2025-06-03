package com.perfulandia.soporte.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.soporte.Models.TipoSoporte;

public interface TipoSoporteRepository extends JpaRepository<TipoSoporte, Integer> {
    // Aquí puedes definir métodos específicos para manejar los tipos de soporte
    // Por ejemplo, si necesitas encontrar un tipo de soporte por su nombre:
    // Optional<TipoSoporte> findByNombre(String nombre);
    
}
