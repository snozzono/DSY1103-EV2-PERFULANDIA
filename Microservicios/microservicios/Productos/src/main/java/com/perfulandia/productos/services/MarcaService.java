package com.perfulandia.productos.services;

import com.perfulandia.productos.models.Marca;
import com.perfulandia.productos.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> findById(Long id) {
        return marcaRepository.findById(id);
    }

    public void deleteById(Long id) {
        marcaRepository.deleteById(id);
    }
}