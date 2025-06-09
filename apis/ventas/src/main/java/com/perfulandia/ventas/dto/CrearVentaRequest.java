package com.perfulandia.ventas.dto;

import java.sql.Date;
import java.util.List;

import com.perfulandia.Clientes.models.Cliente;
import com.perfulandia.productos.Dtos.ProductoDTO;
import com.perfulandia.vendedores.models.*;
import com.perfulandia.Clientes.models.Cliente;

import lombok.Data;

@Data
public class CrearVentaRequest {

    private Integer idCliente;
    private Integer idVendedor;
    private Date fecha;
    private Double descuento;
    private String estado;
    private Integer total;
    private Integer totalFinal;
}
