package com.perfulandia.ventas.dto;

import com.perfulandia.productos.models.Categorias;
import com.perfulandia.productos.models.Marca;

import lombok.Data;

@Data
public class ProductoDTO {
    
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer IdCategoria;
    private Marca marca;
    private Integer stock; // Cantidad disponible en inventario

}
