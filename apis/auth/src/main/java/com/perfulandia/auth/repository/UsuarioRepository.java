package com.perfulandia.auth.repository;

import com.perfulandia.auth.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AuthUsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByRolNombre(String nombre);
}
