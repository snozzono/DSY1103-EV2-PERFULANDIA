package com.perfulandia.ventas.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.perfulandia.vendedores.config.MapperVendedores;
import com.perfulandia.ventas.config.VentasMapper;
import com.perfulandia.ventas.models.*;
import com.perfulandia.ventas.repository.*;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentasService {

   private final VentasMapper ventaMapper;
   private final VendedorRepository vendedorRepository;
   private final ClienteRepository clienteRepository;

private final VentaRepository ventaRepository;
private final CuponesRepository cuponesRepository;

public Venta crearVenta(Venta req) {
   Cliente cliente = clienteRepository.findById(req.getCliente().getId().intValue())
      .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + req.getCliente().getId()));

   Vendedores vendedor = vendedorRepository.findById(req.getVendedor().getId())
      .orElseThrow(() -> new RuntimeException("Vendedor no encontrado con ID: " + req.getVendedor().getId()));

   Venta venta = new Venta();
   venta.setCliente(cliente);
   venta.setVendedor(vendedor);
   venta.setFecha(new Date(System.currentTimeMillis()));
   venta.setTotal(req.getTotal());

   if (req.getCuponesAplicados() != null && !req.getCuponesAplicados().isEmpty()) {
      for (Object cuponObj : req.getCuponesAplicados()) {
         Long cuponId;
         if (cuponObj instanceof Integer) {
            cuponId = ((Integer) cuponObj).longValue();
         } else if (cuponObj instanceof Long) {
            cuponId = (Long) cuponObj;
         } else {
            throw new RuntimeException("Tipo de ID de cupón no soportado: " + cuponObj);
         }
         Cupones cupon = cuponesRepository.findById(cuponId)
            .orElseThrow(() -> new RuntimeException("Cupón no encontrado con ID: " + cuponId));
         CuponesAplicados cuponAplicado = new CuponesAplicados();
         cuponAplicado.setVenta(venta);
         cuponAplicado.setCupon(cupon);
         venta.getCuponesAplicados().add(cuponAplicado);
      }
   }

   return ventaRepository.save(venta);
}

   public Venta buscarVentaPorId(Integer id) {
      return ventaRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
   }

   public List<Venta> buscarVentasPorCliente(Integer clienteId) {
      Cliente cliente = clienteRepository.findById(clienteId)
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