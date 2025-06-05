package com.perfulandia.vendedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.perfulandia.vendedores",
    "com.perfulandia.auth"
})
@EnableJpaRepositories(basePackages = {
    "com.perfulandia.vendedores.repositories",
    "com.perfulandia.auth.repository"
})
@EntityScan(basePackages = {
    "com.perfulandia.vendedores.models",
    "com.perfulandia.auth.models"
})
public class VendedoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendedoresApplication.class, args);
	}

}
