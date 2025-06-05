package com.perfulandia.vendedores.dto;

import lombok.*;
import java.sql.*;

import jakarta.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearVendedorRequest {

    //vendedor
    private Integer idVendedor;
    private Date fechaIngreso;
    private boolean activo;

    //usuario
    private Integer idUsuario;
    private String username;
    private String password;
    private String email;

    //sucursal
    private String nombreSucursal;
    private String direccion;
    private String telefono;
    private String encargado;

}