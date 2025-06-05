package com.perfulandia.auth.services;

import com.perfulandia.auth.models.Usuario;
import com.perfulandia.auth.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthUsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public AuthUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> findByRol(String rol) {
        return usuarioRepository.findByRolNombre(rol);
    }
}