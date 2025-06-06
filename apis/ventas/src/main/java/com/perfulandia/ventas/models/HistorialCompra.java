package com.perfulandia.ventas.models;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity(name = "VentasHistorialCompra")
@Table(name = "historial_compras")
@Data
public class HistorialCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;
    private Integer cantidad;
    private LocalDate fechaCompra;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
