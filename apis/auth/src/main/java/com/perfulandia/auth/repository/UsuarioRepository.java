package com.perfulandia.auth.repository;

import com.perfulandia.auth.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByRolNombre(String nombre);
}
