package com.example.Auth.services;

import com.example.Auth.models.Persona;
import com.example.Auth.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    public Persona buscarPorId(Integer id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }
}
