package com.perfulandia.vendedores.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalesDTO {

    private Integer idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String encargado;

}
