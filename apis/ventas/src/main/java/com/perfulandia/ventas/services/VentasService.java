package com.perfulandia.ventas.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.perfulandia.vendedores.config.MapperVendedores;
import com.perfulandia.ventas.config.VentasMapper;
import com.perfulandia.ventas.dto.*;
import com.perfulandia.ventas.models.*;
import com.perfulandia.ventas.repository.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentasService {

   private final VentasMapper ventaMapper;
   private final VendedorRepository vendedorRepository;
   private final ClienteRepository clienteRepository;

   private final VentaRepository ventaRepository;
   private final CuponesRepository cuponesRepository;
   private final ProductoRepository productosRepository;
   private final CuponesAplicadosRepository cuponesAplicadosRepository;

public Venta crearVenta(@RequestBody CrearVentaRequest req) {
   // Validar entrada
   if (req == null) {
      throw new RuntimeException("La solicitud de venta es nula");
   }

   // Mapear request a entidad Venta usando el mapper
   Venta venta = ventaMapper.crearVentaRequestToVenta(req);

   // Asignar cliente
   Clientes cliente = clienteRepository.findById(req.getIdCliente())
      .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + req.getIdCliente()));
   venta.setCliente(cliente);

   // Asignar vendedor
   Vendedores vendedor = vendedorRepository.findById(req.getIdVendedor())
      .orElseThrow(() -> new RuntimeException("Vendedor no encontrado: " + req.getIdVendedor()));
   venta.setVendedor(vendedor);

   // Asignar fecha actual y total
   venta.setFecha(new Date(System.currentTimeMillis()));
   venta.setDescuento(req.getDescuento());
   venta.setEstado(req.getEstado());
   venta.setTotal(req.getTotal());
   venta.setTotalFinal(req.getTotalFinal());

   // Guardar y retornar la venta
   return ventaRepository.save(venta);
}

   public Venta buscarVentaPorId(Integer id) {
      return ventaRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
   }

   public List<Venta> buscarVentasPorCliente(Integer clienteId) {
      Clientes cliente = clienteRepository.findById(clienteId)
         .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + clienteId));
      return ventaRepository.findByCliente(cliente);
   }

   public Cupones validarCupones(Cupones cupon) {
   if (cuponesRepository.existsByCodigo((cupon.getCodigo()))) {
      throw new RuntimeException("El cupón ya existe con el código: " + cupon.getCodigo());
   }
   return cuponesRepository.save(cupon);

}

}