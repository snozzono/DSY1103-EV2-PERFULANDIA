package com.example.Auth.dto;

import lombok.Data;

@Data
public class RegistroRequest {
    private String user;
    private String email;
    private String pass;
    private String rol; 

    private Integer idPersona;
}
