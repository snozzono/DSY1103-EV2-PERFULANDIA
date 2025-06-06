package com.perfulandia.productos.services;

import com.perfulandia.productos.models.Categorias;
import com.perfulandia.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categorias save(Categorias categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categorias> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categorias> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
