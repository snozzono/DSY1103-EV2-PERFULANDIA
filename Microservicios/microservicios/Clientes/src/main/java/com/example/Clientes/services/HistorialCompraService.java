package com.example.Clientes.services;

import com.example.Clientes.models.HistorialCompra;
import com.example.Clientes.repository.HistorialCompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialCompraService {

    private final HistorialCompraRepository historialCompraRepository;

    public HistorialCompraService(HistorialCompraRepository historialCompraRepository) {
        this.historialCompraRepository = historialCompraRepository;
    }

    public HistorialCompra save(HistorialCompra historial) {
        return historialCompraRepository.save(historial);
    }

    public List<HistorialCompra> findAll() {
        return historialCompraRepository.findAll();
    }

    public Optional<HistorialCompra> findById(Long id) {
        return historialCompraRepository.findById(id);
    }

    public HistorialCompra update(Long id, HistorialCompra historial) {
        historial.setId(id);
        return historialCompraRepository.save(historial);
    }

    public void deleteById(Long id) {
        historialCompraRepository.deleteById(id);
    }
}