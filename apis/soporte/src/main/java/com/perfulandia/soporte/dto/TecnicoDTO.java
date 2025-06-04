package com.perfulandia.soporte.dto;

import java.sql.Date;

import lombok.*;

@Data
@RequiredArgsConstructor
public class TecnicoDTO {
    
    private Integer id;
    private Date fechaIngreso;
    private Boolean activo;
    private String nombreCompleto;
    private String cargo;
    private Integer usuarioId; // ID del usuario asociado al técnico
}
