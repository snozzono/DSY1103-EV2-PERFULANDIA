package com.perfulandia.ventas.dto;

import java.sql.Date;
import java.util.List;

import com.perfulandia.ventas.models.CuponesAplicados;

import lombok.Data;

@Data
public class CuponesDTO {

    private Integer codigo;
    private Double descuento;
    private List<String> productos; // lista de productos a los que aplica el cupón
    private Date fechaExpiracion;
}
