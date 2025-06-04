package com.example.Auth.services;

import com.example.Auth.models.Rol;
import com.example.Auth.repository.RolRepository;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public Rol findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }
}
