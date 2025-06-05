package com.perfulandia.vendedores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDTO {
    
    private Integer idUsuario;
    private String username;
    private String email;
    private String password;
}
