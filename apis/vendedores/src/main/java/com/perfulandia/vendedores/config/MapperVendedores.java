package com.perfulandia.vendedores.config;

import org.springframework.stereotype.Component;

import com.perfulandia.vendedores.dto.*;
import com.perfulandia.vendedores.models.*;
import com.perfulandia.vendedores.repositories.*;

import lombok.*;

@Data
@RequiredArgsConstructor
@Component
public class MapperVendedores {

    private final UsuarioRepository usuarioRepository;  
    private final SucursalesRepository sucursalRepository;
    private final VendedoresRepository vendedoresRepository;

    public Vendedores mapToVendedor(CrearVendedorRequest request) {
        Vendedores vendedor = new Vendedores();
        vendedor.setFechaIngreso(request.getFechaIngreso());
        vendedor.setActivo(request.isActivo());

        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(request.getPassword());
        usuario.setEmail(request.getEmail());
        vendedor.setUsuario(usuario);

        Sucursales sucursal = new Sucursales();
        sucursal.setNombre(request.getNombreSucursal());
        sucursal.setDireccion(request.getDireccion());
        sucursal.setTelefono(request.getTelefono());
        sucursal.setEncargado(request.getEncargado());
        sucursalRepository.save(sucursal);
        vendedor.setSucursal(sucursal);

        return vendedor;
    }

    public CrearVendedorRequest mapToCrearVendedorRequest(Vendedores vendedor) {
        CrearVendedorRequest request = new CrearVendedorRequest();
        request.setFechaIngreso(vendedor.getFechaIngreso());
        request.setActivo(vendedor.isActivo());
        request.setUsername(vendedor.getUsuario().getUsername());
        request.setPassword(vendedor.getUsuario().getPassword());
        request.setEmail(vendedor.getUsuario().getEmail());
        request.setNombreSucursal(vendedor.getSucursal().getNombre());
        request.setDireccion(vendedor.getSucursal().getDireccion());
        request.setTelefono(vendedor.getSucursal().getTelefono());
        request.setEncargado(vendedor.getSucursal().getEncargado());
        return request;
    }

    public Vendedores mapearCrearVendedorRequestAVendedores(CrearVendedorRequest request) {
        return mapToVendedor(request);
    }
    public CrearVendedorRequest mapearVendedoresACrearVendedorRequest(Vendedores vendedor) {
        return mapToCrearVendedorRequest(vendedor);
    }
    public Vendedores mapearActualizarVendedorAVendedores(Vendedores vendedor, CrearVendedorRequest request) {
        vendedor.setFechaIngreso(request.getFechaIngreso());
        vendedor.setActivo(request.isActivo());

        Usuario usuario = vendedor.getUsuario();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(request.getPassword());
        usuario.setEmail(request.getEmail());
        vendedor.setUsuario(usuario);

        Sucursales sucursal = vendedor.getSucursal();
        sucursal.setNombre(request.getNombreSucursal());
        sucursal.setDireccion(request.getDireccion());
        sucursal.setTelefono(request.getTelefono());
        sucursal.setEncargado(request.getEncargado());
        vendedor.setSucursal(sucursalRepository.save(sucursal));

        return vendedor;
    }
    public CrearVendedorRequest mapearActualizarVendedorACrearVendedorRequest(Vendedores vendedor) {
        CrearVendedorRequest request = new CrearVendedorRequest();
        request.setFechaIngreso(vendedor.getFechaIngreso());
        request.setActivo(vendedor.isActivo());
        request.setUsername(vendedor.getUsuario().getUsername());
        request.setPassword(vendedor.getUsuario().getPassword());
        request.setEmail(vendedor.getUsuario().getEmail());
        request.setNombreSucursal(vendedor.getSucursal().getNombre());
        request.setDireccion(vendedor.getSucursal().getDireccion());
        request.setTelefono(vendedor.getSucursal().getTelefono());
        request.setEncargado(vendedor.getSucursal().getEncargado());
        return request;
    }
    public Vendedores mapearVendedoresACrearVendedor(CrearVendedorRequest request) {
        return mapToVendedor(request);
    }
    public CrearVendedorRequest mapearCrearVendedorAVendedores(Vendedores vendedor) {
        return mapToCrearVendedorRequest(vendedor);
}
    public Vendedores mapearVendedoresACrearVendedorRequest(CrearVendedorRequest request) {
        return mapToVendedor(request);
    }
    public CrearVendedorRequest mapearCrearVendedorRequestAVendedores(Vendedores vendedor) {
        return mapToCrearVendedorRequest(vendedor);
    }
}