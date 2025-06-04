package com.perfulandia.gateway.jwt.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;

}
