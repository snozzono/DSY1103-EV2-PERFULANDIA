package com.perfulandia.soporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(
    basePackages = {
        "com.perfulandia.soporte.repositories",
        "com.perfulandia.Clientes.repositories"
    }
)
@EntityScan(basePackages = {
    "com.perfulandia.soporte.Models", 
    "com.perfulandia.Clientes.models"
})
public class SoporteApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoporteApplication.class, args);
    }
}