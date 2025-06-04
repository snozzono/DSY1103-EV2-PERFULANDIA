package com.perfulandia.gateway.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/ping")
public class PingController {
    
    @GetMapping("/ping")
    public String ping() {
        return "Api funcionando correctamente";
    }
    
}
