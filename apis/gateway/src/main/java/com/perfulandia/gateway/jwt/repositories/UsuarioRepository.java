package com.perfulandia.gateway.jwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.gateway.jwt.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar un usuario por su nombre de usuario:
    Optional<Usuario> findByUsername(String username);
    
    // O para verificar si un usuario existe por su nombre de usuario:
    boolean existsByUsername(String username);
    
    // O para verificar si un usuario existe por su correo electrónico:
    boolean existsByEmail(String email);
    
}
