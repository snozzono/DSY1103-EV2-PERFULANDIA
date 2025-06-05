package com.perfulandia.vendedores.dto;

import lombok.*;
import java.sql.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Data
public class VendedoresDTO {
    
    private Integer idVendedor;
    private Integer idUsuario;
    private Integer idSucursal;
    private Date fechaIngreso;
    private boolean activo;


}
