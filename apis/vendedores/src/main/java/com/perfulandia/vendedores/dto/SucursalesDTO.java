package com.perfulandia.vendedores.dto;

import lombok.*;
import java.util.*;
import jakarta.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalesDTO {

    private Integer idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String encargado;

}
