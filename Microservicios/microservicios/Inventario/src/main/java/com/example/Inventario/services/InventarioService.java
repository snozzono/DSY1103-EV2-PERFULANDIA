package com.example.Inventario.services;

import com.example.Inventario.models.Inventario;
import com.example.Inventario.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public Inventario save(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> findById(Long id) {
        return inventarioRepository.findById(id);
    }

    public void deleteById(Long id) {
        inventarioRepository.deleteById(id);
    }

    public Inventario update(Long id, Inventario inventario) {
        inventario.setId(id);
        return inventarioRepository.save(inventario);
    }
}