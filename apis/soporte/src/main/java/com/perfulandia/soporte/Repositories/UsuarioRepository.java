package com.perfulandia.soporte.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.soporte.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    
}
