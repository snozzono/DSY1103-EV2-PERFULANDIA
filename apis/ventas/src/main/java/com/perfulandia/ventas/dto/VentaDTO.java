package com.perfulandia.ventas.dto;

import java.sql.Date;
import java.util.List;

import com.perfulandia.Clientes.models.Cliente;
import com.perfulandia.vendedores.models.Vendedor;
import com.perfulandia.ventas.models.Cupones;
import com.perfulandia.ventas.models.CuponesAplicados;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    private Integer idVenta;
    private Cliente cliente;
    private Vendedor vendedor;
    private Date fecha;
    private Integer total;
    private Double descuento;
    private Integer totalFinal;
    private String estado;
    private List<Integer> cuponesAplicados;

}
