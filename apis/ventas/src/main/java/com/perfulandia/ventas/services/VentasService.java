package com.perfulandia.ventas.services;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.perfulandia.ventas.dto.VentaDTO;
import com.perfulandia.ventas.models.Venta;
import com.perfulandia.ventas.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentasService {

    private final DetalleVentaRepository detalleVentaRepository;
    private final VentaRepository ventaRepository;

    public List<VentaDTO> obtenerTodasLasVentas() {
        return ventaRepository.findAll().stream()
                .map(venta -> new VentaDTO(
                        venta.getIdVenta(),
                        venta.getCliente(),
                        venta.getVendedor(),
                        venta.getFecha(),
                        venta.getTotal(),
                        venta.getDescuento(),
                        venta.getTotalFinal(),
                        venta.getEstado()))
                .toList();
    }
    public VentaDTO obtenerVentaPorId(Integer idVenta) {
        return ventaRepository.findById(idVenta)
                .map(venta -> new VentaDTO(
                        venta.getIdVenta(),
                        venta.getCliente(),
                        venta.getVendedor(),
                        venta.getFecha(),
                        venta.getTotal(),
                        venta.getDescuento(),
                        venta.getTotalFinal(),
                        venta.getEstado()))
                .orElse(null);
    }
    public VentaDTO crearVenta(VentaDTO ventaDTO) {
        // Aquí deberías convertir el DTO a la entidad Venta y guardarla
        // Por simplicidad, asumimos que la conversión es directa
        Venta venta = new Venta();
        venta.setCliente(ventaDTO.getCliente());
        venta.setVendedor(ventaDTO.getVendedor());
        venta.setFecha(ventaDTO.getFecha());
        venta.setTotal(ventaDTO.getTotal());
        venta.setDescuento(ventaDTO.getDescuento());
        venta.setTotalFinal(ventaDTO.getTotalFinal());
        venta.setEstado(ventaDTO.getEstado());

        Venta nuevaVenta = ventaRepository.save(venta);
        return new VentaDTO(
                nuevaVenta.getIdVenta(),
                nuevaVenta.getCliente(),
                nuevaVenta.getVendedor(),
                nuevaVenta.getFecha(),
                nuevaVenta.getTotal(),
                nuevaVenta.getDescuento(),
                nuevaVenta.getTotalFinal(),
                nuevaVenta.getEstado());
    }
    public VentaDTO actualizarVenta(Integer idVenta, VentaDTO ventaDTO) {
        return ventaRepository.findById(idVenta)
                .map(venta -> {
                    venta.setCliente(ventaDTO.getCliente());
                    venta.setVendedor(ventaDTO.getVendedor());
                    venta.setFecha(ventaDTO.getFecha());
                    venta.setTotal(ventaDTO.getTotal());
                    venta.setDescuento(ventaDTO.getDescuento());
                    venta.setTotalFinal(ventaDTO.getTotalFinal());
                    venta.setEstado(ventaDTO.getEstado());

                    Venta ventaActualizada = ventaRepository.save(venta);
                    return new VentaDTO(
                            ventaActualizada.getIdVenta(),
                            ventaActualizada.getCliente(),
                            ventaActualizada.getVendedor(),
                            ventaActualizada.getFecha(),
                            ventaActualizada.getTotal(),
                            ventaActualizada.getDescuento(),
                            ventaActualizada.getTotalFinal(),
                            ventaActualizada.getEstado());
                })
                .orElse(null);
    }
    public void eliminarVenta(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }
    public List<VentaDTO> buscarVentasPorCliente(Integer idCliente) {
        return ventaRepository.findAll().stream()
                .filter(venta -> venta.getCliente().getId().equals(idCliente))
                .map(venta -> new VentaDTO(
                        venta.getIdVenta(),
                        venta.getCliente(),
                        venta.getVendedor(),
                        venta.getFecha(),
                        venta.getTotal(),
                        venta.getDescuento(),
                        venta.getTotalFinal(),
                        venta.getEstado()))
                .toList();
    }
    public List<VentaDTO> buscarVentasPorVendedor(Integer idVendedor) {
        return ventaRepository.findAll().stream()
                .filter(venta -> venta.getVendedor().getId().equals(idVendedor))
                .map(venta -> new VentaDTO(
                        venta.getIdVenta(),
                        venta.getCliente(),
                        venta.getVendedor(),
                        venta.getFecha(),
                        venta.getTotal(),
                        venta.getDescuento(),
                        venta.getTotalFinal(),
                        venta.getEstado()))
                .toList();
    }
    public List<VentaDTO> buscarVentasPorFecha(Date fechaInicio, Date fechaFin) {
        return ventaRepository.findAll().stream()
                .filter(venta -> !venta.getFecha().before(fechaInicio) && !venta.getFecha().after(fechaFin))
                .map(venta -> new VentaDTO(
                        venta.getIdVenta(),
                        venta.getCliente(),
                        venta.getVendedor(),
                        venta.getFecha(),
                        venta.getTotal(),
                        venta.getDescuento(),
                        venta.getTotalFinal(),
                        venta.getEstado()))
                .toList();
    }

    public void eliminarVentaPorId(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }

}
