package com.perfulandia.vendedores.services;

import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import lombok.*;

import com.perfulandia.vendedores.config.MapperVendedores;
import com.perfulandia.vendedores.dto.*;
import com.perfulandia.vendedores.models.*;

import java.util.*;

import com.perfulandia.vendedores.repositories.*;

@Service
@RequiredArgsConstructor
public class VendedoresService {

    private final VendedoresRepository vendedoresRepository;
    private final MapperVendedores mapperVendedores;

    public Vendedores crearVendedor(CrearVendedorRequest request) {
        Vendedores vendedor = new Vendedores();
        vendedor.setUsuario(mapperVendedores.getUsuarioRepository().findById(request.getIdUsuario().longValue())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + request.getIdUsuario())));
        vendedor.setSucursal(mapperVendedores.getSucursalRepository().findById(request.getIdSucursal())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con ID: " + request.getIdSucursal())));
        vendedor.setFechaIngreso(request.getFechaIngreso());
        vendedor.setActivo(request.isActivo());
        return vendedoresRepository.save(vendedor);
    }

    public Vendedores obtenerVendedorPorId(Integer id) {
        return vendedoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado con ID: " + id));
    }

    public Vendedores actualizarVendedor(Integer id, Vendedores vendedor) {
        Vendedores vendedorExistente = obtenerVendedorPorId(id);
        vendedorExistente.setUsuario(vendedor.getUsuario());
        vendedorExistente.setSucursal(vendedor.getSucursal());
        vendedorExistente.setFechaIngreso(vendedor.getFechaIngreso());
        vendedorExistente.setActivo(vendedor.isActivo());
        return vendedoresRepository.save(vendedorExistente);
    }

    public List<Vendedores> obtenerVendedoresPorSucursal(Integer idSucursal) {
        return vendedoresRepository.findBySucursalId(idSucursal);
    }
}