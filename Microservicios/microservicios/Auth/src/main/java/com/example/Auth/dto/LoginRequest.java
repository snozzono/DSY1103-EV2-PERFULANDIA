package com.example.Auth.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String pass;
}
