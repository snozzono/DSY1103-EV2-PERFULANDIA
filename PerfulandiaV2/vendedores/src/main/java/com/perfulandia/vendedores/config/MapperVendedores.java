package com.perfulandia.vendedores.config;

import org.springframework.stereotype.Component;

import com.perfulandia.vendedores.dto.SucursalesDTO;
import com.perfulandia.vendedores.dto.VendedoresDTO;
import com.perfulandia.vendedores.models.Sucursales;
import com.perfulandia.vendedores.models.Vendedores;
import com.perfulandia.vendedores.repositories.SucursalesRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
public class MapperVendedores {

    private final SucursalesRepository sucursalRepository;

    // Aquí puedes agregar métodos de mapeo entre entidades y DTOs si es necesario
    // Por ejemplo, para convertir un objeto Vendedores a un objeto VendedoresDTO

    // Ejemplo de método de mapeo (puedes ajustar según tus necesidades)
    
    public static VendedoresDTO toDTO(Vendedores vendedor) {
        if (vendedor == null) {
            return null;
        }
        VendedoresDTO dto = new VendedoresDTO();
        dto.setIdVendedor(vendedor.getId());
        dto.setIdUsuario(vendedor.getUsuario().intValue());
        dto.setSucursales(vendedor.getSucursal().getId());

        return dto;
    }

    public static SucursalesDTO toSucursalDTO(Sucursales sucursal) {
        if (sucursal == null) {
            return null;
        }
        SucursalesDTO dto = new SucursalesDTO();
        dto.setIdSucursal(sucursal.getId());
        dto.setNombre(sucursal.getNombre());
        dto.setDireccion(sucursal.getDireccion());
        dto.setTelefono(sucursal.getTelefono());
        dto.setEncargado(sucursal.getEncargado());
        return dto;
    }
    
}
