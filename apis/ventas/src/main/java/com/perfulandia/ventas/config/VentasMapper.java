package com.perfulandia.ventas.config;

import org.springframework.stereotype.Component;

import com.perfulandia.ventas.dto.*;
import com.perfulandia.ventas.models.*;

@Component
public class VentasMapper {

    public VentaDTO ventaToDTO(Venta venta) {
        VentaDTO dto = new VentaDTO();
        dto.setIdVenta(venta.getIdVenta());
        dto.setIdCliente((venta.getCliente()).getId().intValue());
        dto.setIdVendedor(venta.getVendedor().getId().intValue());
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
        dto.setIdProducto(detalle.getProducto().getIdProducto().intValue());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        return dto;
    }

    public ProductoDTO productoToDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setIdProducto(producto.getIdProducto().intValue());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio().intValue());
        dto.setIdCategoria(producto.getCategorias().getId());
        dto.setStock(producto.getStock().intValue());
        return dto;

    }
}
