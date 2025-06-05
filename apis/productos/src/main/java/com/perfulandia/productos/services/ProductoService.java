package com.perfulandia.productos.services;

import com.perfulandia.productos.models.Producto;
import com.perfulandia.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }

    public Producto update(Integer id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }
}