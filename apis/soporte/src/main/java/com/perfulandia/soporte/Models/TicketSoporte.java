package com.perfulandia.soporte.Models;

import com.perfulandia.Clientes.*;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "ticketSoporte")
@NoArgsConstructor
@AllArgsConstructor
public class TicketSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "ticketSoporte", cascade = CascadeType.ALL)
    private TipoSoporte soporte;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "asunto", nullable = false)
    private String asunto;

    @Column(name = "mensaje", nullable = false)
    private String mensaje;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_resolucion")
    private Date fechaResolucion;
}
