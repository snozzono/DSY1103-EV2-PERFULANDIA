package com.perfulandia.ventas.config;

import org.springframework.stereotype.Component;

import com.perfulandia.productos.models.*;
import com.perfulandia.productos.Dtos.*;
import com.perfulandia.ventas.dto.*;
import com.perfulandia.ventas.models.*;

@Component
public class VentasMapper {

    public VentaDTO ventaToDTO(Venta venta) {
        VentaDTO dto = new VentaDTO();
        dto.setIdVenta(venta.getIdVenta());
        dto.setCliente(venta.getCliente());
        dto.setVendedor(venta.getVendedor());
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());
        dto.setDescuento(venta.getDescuento());
        dto.setTotalFinal(venta.getTotalFinal());
        dto.setEstado(venta.getEstado());
        dto.setCuponesAplicados(venta.getCuponesAplicados());
        return dto;
    }

    public CuponesDTO cuponesToDTO(Cupones cupon) {
        CuponesDTO dto = new CuponesDTO();
        dto.setCodigo(cupon.getCodigo());
        dto.setDescuento(cupon.getDescuento());
        dto.setFechaExpiracion(cupon.getFechaExpiracion());
        return dto;
    }

    public DetalleVentaDTO detalleVentaToDTO(DetalleVenta detalle) {
        DetalleVentaDTO dto = new DetalleVentaDTO();
        dto.setProducto(detalle.getProducto());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        return dto;
    }

    public ProductoDTO productoToDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setDescripcion(producto.getDescripcion());
        dto.setCategoria(producto.getCategorias());
        dto.setMarca(producto.getMarcas());
        dto.setStock(producto.getStock());
        return dto;
    }
}
