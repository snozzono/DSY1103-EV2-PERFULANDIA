package com.example.Inventario.services;

import com.example.Inventario.models.Almacen;
import com.example.Inventario.repository.AlmacenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {

    private final AlmacenRepository almacenRepository;

    public AlmacenService(AlmacenRepository almacenRepository) {
        this.almacenRepository = almacenRepository;
    }

    public Almacen save(Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    public List<Almacen> findAll() {
        return almacenRepository.findAll();
    }

    public Optional<Almacen> findById(Long id) {
        return almacenRepository.findById(id);
    }

    public void deleteById(Long id) {
        almacenRepository.deleteById(id);
    }

    public Almacen update(Long id, Almacen almacen) {
        almacen.setId(id);
        return almacenRepository.save(almacen);
    }
}
