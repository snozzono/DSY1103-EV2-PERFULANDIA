package com.perfulandia.vendedores.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedoresDTO {
    
    private Integer idVendedor;
    private Integer idUsuario;
    private String nombreCompleto;
    private String rut;
    private Integer Sucursales;



}
