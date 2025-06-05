package com.perfulandia.productos.Dtos;

import com.perfulandia.productos.models.Categoria;
import com.perfulandia.productos.models.Marca;

import lombok.Data;

@Data
public class ProductoDTO {
    
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Categoria categoria;
    private Marca marca;
    private Integer stock; // Cantidad disponible en inventario

}
