package com.example.Envios.services;

import com.example.Envios.models.Envios;
import com.example.Envios.repository.EnvioRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnvioService {
    private final EnvioRepository envioRepository;

    public Envios crearEnvio(Envios envio) {
        return envioRepository.save(envio);
    }

    public Envios obtenerPorId(Long id) {
        return envioRepository.findById(id).orElseThrow();
    }

    public Envios actualizarEstado(Long id, String nuevoEstado) {
    Envios envio = envioRepository.findById(id).orElseThrow();
    envio.setEstadoEnvio(nuevoEstado); 
    return envioRepository.save(envio);
}

}
