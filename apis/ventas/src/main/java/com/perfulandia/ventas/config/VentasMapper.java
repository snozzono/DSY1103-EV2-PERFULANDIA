package com.perfulandia.ventas.config;

import java.util.List;

import org.springframework.stereotype.Component;

import com.perfulandia.ventas.dto.*;
import com.perfulandia.ventas.models.*;
import com.perfulandia.ventas.repository.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
public class VentasMapper {

    private final VendedorRepository vendedorRepository;

    private final CuponesAplicadosRepository cuponesAplicadosRepository = null;
    private final ProductoRepository productoRepository = null;
    private final VentaRepository ventaRepository = null;
    private final ClienteRepository clienteRepository = null;

    VentasMapper(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public VentaDTO ventaToDTO(Venta venta) {
        VentaDTO dto = new VentaDTO();
        dto.setIdVenta(venta.getIdVenta());
        dto.setIdCliente((venta.getCliente()).getId().intValue());
        dto.setIdVendedor(venta.getVendedor().getVendedorId().intValue());
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());
        dto.setDescuento(venta.getDescuento());
        dto.setTotalFinal(venta.getTotalFinal());
        dto.setEstado(venta.getEstado());
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

    public Venta dtoToVenta(VentaDTO dto) {
        Venta venta = new Venta();
        venta.setIdVenta(dto.getIdVenta());
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());
        venta.setDescuento(dto.getDescuento());
        venta.setTotalFinal(dto.getTotalFinal());
        venta.setEstado(dto.getEstado());
        return venta;
    }

    public Venta crearVentaRequestToVenta(CrearVentaRequest request) {
        
        Venta venta = new Venta();
        venta.setCliente(clienteRepository.findById(request.getIdCliente()).get());
        venta.setDescuento(request.getDescuento());
        venta.setEstado(request.getEstado());
        venta.setFecha(request.getFecha());
        venta.setVendedor(vendedorRepository.findById(request.getIdVendedor()).get());
        venta.setTotal(request.getTotal());
        venta.setTotalFinal(request.getTotalFinal());

        return venta;
    }
}
