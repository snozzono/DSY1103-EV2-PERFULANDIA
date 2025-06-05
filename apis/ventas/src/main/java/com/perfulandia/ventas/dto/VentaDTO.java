package com.perfulandia.ventas.dto;

import java.sql.Date;
import java.util.List;

import com.perfulandia.Clientes.models.Cliente;
import com.perfulandia.vendedores.models.Vendedores;
import com.perfulandia.ventas.models.Cupones;
import com.perfulandia.ventas.models.CuponesAplicados;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class VentaDTO {

    private Integer idVenta;
    private Integer idCliente;
    private Integer idVendedor;
    private Date fecha;
    private Integer total;
    private Double descuento;
    private Integer totalFinal;
    private String estado;
    private List<CuponesAplicados> cuponesAplicados;

}
