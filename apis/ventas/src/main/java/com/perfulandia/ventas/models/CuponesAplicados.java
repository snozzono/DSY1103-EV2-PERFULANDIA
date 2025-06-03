package com.perfulandia.ventas.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity 
@Table(name = "cuponesAplicados")
@NoArgsConstructor
@AllArgsConstructor
public class CuponesAplicados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuponAplicado;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta; // Relación con la entidad Venta

    @ManyToOne
    @JoinColumn(name = "cupon_id", nullable = false)
    private Cupones cupon; // Relación con la entidad Cupones

    @Column(nullable = false)
    private Boolean descuentoAplicado; // Descuento aplicado por el cupón

}
