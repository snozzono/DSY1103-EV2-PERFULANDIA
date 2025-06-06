package com.perfulandia.productos.Dtos;

import com.perfulandia.productos.models.Categorias;
import com.perfulandia.productos.models.Marca;

import lombok.Data;

@Data
public class ProductoDTO {
    
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Categorias categoria;
    private Marca marca;
    private Integer stock; // Cantidad disponible en inventario

}
