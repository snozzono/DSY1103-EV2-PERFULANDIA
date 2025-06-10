package com.perfulandia.vendedores.services;

import com.perfulandia.vendedores.dto.VendedoresDTO;
import com.perfulandia.vendedores.models.Sucursales;
import com.perfulandia.vendedores.models.Vendedores;
import com.perfulandia.vendedores.repositories.SucursalesRepository;
import com.perfulandia.vendedores.repositories.VendedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendedoresService {

    @Autowired
    private VendedoresRepository repository;

    @Autowired
    private SucursalesRepository sucursalesRepository;

    public VendedoresDTO guardar(VendedoresDTO dto) {
        Vendedores vendedor = toEntity(dto);
        Vendedores saved = repository.save(vendedor);
        return toDTO(saved);
    }

    public List<VendedoresDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<VendedoresDTO> listarPorSucursal(Integer idSucursal) {
    return repository.findBySucursalId(idSucursal)
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public Optional<VendedoresDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO);
    }

    public Optional<VendedoresDTO> actualizar(Integer id, VendedoresDTO dto) {
        return repository.findById(id).map(v -> {
            v.setNombreCompleto(dto.getNombreCompleto());
            v.setRut(dto.getRut());
            v.setUsuario(dto.getIdUsuario());

            Sucursales sucursal = sucursalesRepository.findById(dto.getSucursales())
                    .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

            v.setSucursal(sucursal);
            return toDTO(repository.save(v));
        });
    }

    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;

        
    }

    // Métodos auxiliares
    private VendedoresDTO toDTO(Vendedores v) {
        VendedoresDTO dto = new VendedoresDTO();
        dto.setIdVendedor(v.getId());
        dto.setIdUsuario(v.getUsuario());
        dto.setNombreCompleto(v.getNombreCompleto());
        dto.setRut(v.getRut());
        dto.setSucursales(v.getSucursal() != null ? v.getSucursal().getId() : null);
        return dto;
    }

    private Vendedores toEntity(VendedoresDTO dto) {
        Vendedores v = new Vendedores();
        v.setId(dto.getIdVendedor());
        v.setUsuario(dto.getIdUsuario());
        v.setNombreCompleto(dto.getNombreCompleto());
        v.setRut(dto.getRut());

            Sucursales sucursal = sucursalesRepository.findById(dto.getSucursales())
                    .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con ID"));
            v.setSucursal(sucursal);
        return v;

        
    }
}
