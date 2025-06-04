package com.perfulandia.vendedores.dto;

import lombok.*;
import java.sql.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearVendedorRequest {

    private Integer idUsuario;
    private Integer idSucursal;
    private Date fechaIngreso;
    private boolean activo;

}
