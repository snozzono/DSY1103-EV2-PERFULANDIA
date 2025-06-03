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

    private Cliente cliente;
    private Vendedor vendedor;
    private Date fecha;
    private Integer total;
    private Double descuento;
    private Integer totalFinal;
    private String estado; // "PENDIENTE", "APROBADA", "RECHAZADA"
    private List<Integer> codigoCupon; // opcional, si se usa un cupón
    private List<String> productos; // lista de productos vendidos
}
