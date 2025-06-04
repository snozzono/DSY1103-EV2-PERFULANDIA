package com.example.Envios.services;

import com.example.Envios.models.TipoEnvio;
import com.example.Envios.repository.TipoEnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEnvioService {
    private final TipoEnvioRepository tipoEnvioRepository;

    public TipoEnvioService(TipoEnvioRepository tipoEnvioRepository) {
        this.tipoEnvioRepository = tipoEnvioRepository;
    }

    public TipoEnvio save(TipoEnvio tipo) {
        return tipoEnvioRepository.save(tipo);
    }

    public List<TipoEnvio> findAll() {
        return tipoEnvioRepository.findAll();
    }

    public Optional<TipoEnvio> findById(Long id) {
        return tipoEnvioRepository.findById(id);
    }

    public TipoEnvio update(Long id, TipoEnvio tipo) {
        tipo.setId(id);
        return tipoEnvioRepository.save(tipo);
    }

    public void delete(Long id) {
        tipoEnvioRepository.deleteById(id);
    }
}