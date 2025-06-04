package com.perfulandia.ventas.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.perfulandia.ventas.config.VentasMapper;
import com.perfulandia.ventas.dto.CrearVentaRequest;
import com.perfulandia.ventas.dto.CuponesDTO;
import com.perfulandia.ventas.dto.VentaDTO;
import com.perfulandia.ventas.models.Cupones;
import com.perfulandia.ventas.models.Venta;
import com.perfulandia.ventas.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentasService {

   private final VentasMapper ventaMapper;
   private final VentaRepository ventaRepository;
   private final CuponesRepository cuponesRepository;

public Venta crearVenta(CrearVentaRequest req) {
   Venta venta = new Venta();
   venta.setCliente(req.getCliente());
   venta.setVendedor(req.getVendedor());
   venta.setFecha(req.getFecha());
   venta.setTotal(req.getTotal());
   venta.setDescuento(req.getDescuento());
   venta.setTotalFinal(req.getTotalFinal());
   venta.setEstado(req.getEstado());
   venta.setCuponesAplicados(req.getCodigoCupon());
   venta.setProductos(req.getProductos());
   return venta;
   }

   public VentaDTO buscarVentaPorId(Integer id) {
      Venta venta = ventaRepository.findById(id)
      .orElseThrow(()->new RuntimeException("Usuario no encontrado con ID: " + id));

      return ventaMapper.ventaToDTO(venta);
   }

   public List<VentaDTO> buscarVentasPorCliente(Integer clienteId) {
      List<Venta> ventas = ventaRepository.findByClienteId(clienteId);
      if (ventas.isEmpty()) {
         throw new RuntimeException("No se encontraron ventas para el cliente con ID: " + clienteId);
      }
      return ventas.stream()
                   .map(ventaMapper::ventaToDTO)
                   .toList();
   }

   public CuponesDTO validarCupones(Cupones cupon) {
   if (cuponesRepository.existsByCodigoCupones(cupon.getCodigo())) {
      throw new RuntimeException("El cupón ya existe con el código: " + cupon.getCodigo());
   }
   Cupones nuevoCupon = cuponesRepository.save(cupon);
   return ventaMapper.cuponesToDTO(nuevoCupon);
}

}


