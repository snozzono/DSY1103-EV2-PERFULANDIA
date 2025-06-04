package com.example.Envios.services;

import com.example.Envios.models.TarifaEnvio;
import com.example.Envios.repository.TarifaEnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifaEnvioService {
    private final TarifaEnvioRepository tarifaEnvioRepository;

    public TarifaEnvioService(TarifaEnvioRepository tarifaEnvioRepository) {
        this.tarifaEnvioRepository = tarifaEnvioRepository;
    }

    public TarifaEnvio save(TarifaEnvio tarifa) {
        return tarifaEnvioRepository.save(tarifa);
    }

    public List<TarifaEnvio> findAll() {
        return tarifaEnvioRepository.findAll();
    }

    public Optional<TarifaEnvio> findById(Long id) {
        return tarifaEnvioRepository.findById(id);
    }

    public TarifaEnvio update(Long id, TarifaEnvio tarifa) {
        tarifa.setId(id);
        return tarifaEnvioRepository.save(tarifa);
    }

    public void delete(Long id) {
        tarifaEnvioRepository.deleteById(id);
    }
}