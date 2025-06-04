package com.example.Envios.services;

import com.example.Envios.models.Envios;
import com.example.Envios.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {
    private final EnvioRepository envioRepository;

    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public Envios save(Envios envio) {
        return envioRepository.save(envio);
    }

    public List<Envios> findAll() {
        return envioRepository.findAll();
    }

    public Optional<Envios> findById(Long id) {
        return envioRepository.findById(id);
    }

    public Envios update(Long id, Envios envio) {
        envio.setId(id);
        return envioRepository.save(envio);
    }

    public void delete(Long id) {
        envioRepository.deleteById(id);
    }
}
