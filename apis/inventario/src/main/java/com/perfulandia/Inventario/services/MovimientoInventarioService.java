package com.perfulandia.Inventario.services;

import com.perfulandia.Inventario.models.MovimientoInventario;
import com.perfulandia.Inventario.repository.MovimientoInventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoInventarioService {

    private final MovimientoInventarioRepository repository;

    public MovimientoInventarioService(MovimientoInventarioRepository repository) {
        this.repository = repository;
    }

    public MovimientoInventario save(MovimientoInventario movimiento) {
        return repository.save(movimiento);
    }

    public List<MovimientoInventario> findAll() {
        return repository.findAll();
    }
}
