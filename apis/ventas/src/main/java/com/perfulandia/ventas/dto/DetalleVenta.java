package com.perfulandia.ventas.dto;

import com.perfulandia.Clientes.models.Cliente;
import com.perfulandia.productos.models.Producto;

public class DetalleVenta {

    private Integer idDetalleVenta;
    private Cliente cliente;
    private Producto producto; 
    private int cantidad;
    private int precioUnitario;

}
