package com.perfulandia.vendedores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.perfulandia.vendedores.models.Usuario;

import java.util.List;
import java.util.Optional;

@Repository("VendedoresUsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Optional<Usuario> findById(Integer id);
    List<Usuario> findById(Integer id);
    List<Usuario> findByUsername(String username);
    
}
