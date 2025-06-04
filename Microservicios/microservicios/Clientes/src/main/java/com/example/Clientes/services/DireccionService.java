package com.example.Clientes.services;

import com.example.Clientes.models.Direccion;
import com.example.Clientes.repository.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    public Optional<Direccion> findById(Long id) {
        return direccionRepository.findById(id);
    }

    public Direccion update(Long id, Direccion direccion) {
        direccion.setId(id);
        return direccionRepository.save(direccion);
    }

    public void deleteById(Long id) {
        direccionRepository.deleteById(id);
    }
}
    