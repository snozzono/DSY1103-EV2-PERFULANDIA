package com.perfulandia.vendedores.services;

import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import lombok.*;

import com.perfulandia.vendedores.config.MapperVendedores;
import com.perfulandia.vendedores.dto.*;
import com.perfulandia.vendedores.models.*;
import com.perfulandia.vendedores.repositories.*;

import java.util.*;


@Service
@RequiredArgsConstructor
public class VendedoresService {

    private final VendedoresRepository vendedoresRepository;
    private final MapperVendedores mapperVendedores;
    private final UsuarioRepository usuarioRepository;
    private final SucursalesRepository sucursalesRepository;

    public Vendedores crearVendedor(CrearVendedorRequest request) {
        Vendedores vendedor = mapperVendedores.mapearCrearVendedorRequestAVendedores(request);
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

    public List<Vendedores> obtenerVendedoresPorSucursal(Long idSucursal) {

        List<Sucursales> sucursales = sucursalesRepository.findById(idSucursal);
        if (sucursales == null || sucursales.isEmpty()) {
            throw new RuntimeException("Sucursal no encontrada con ID: " + idSucursal);
        }
        return sucursales.get(0).getVendedores();

        
    }
}