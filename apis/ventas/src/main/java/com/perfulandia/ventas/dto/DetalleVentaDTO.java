package com.perfulandia.ventas.dto;

import java.sql.Date;

import com.perfulandia.Clientes.models.Cliente;
import com.perfulandia.productos.models.Producto;

import lombok.*;

@Data
public class DetalleVentaDTO {

    private Integer idProducto; 
    private Integer cantidad;
    private Integer precioUnitario;


}
