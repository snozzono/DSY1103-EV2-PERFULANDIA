package com.perfulandia.soporte.Models;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "soporte")
public class TicketSoporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer id;

    @Column(name = "tipo_ticket")
    private String tipoTicket;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_resolucion")
    private Date fechaResolucion;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "tecnico_id")
    private Integer tecnicoId;
}
