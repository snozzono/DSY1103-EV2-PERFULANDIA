package com.perfulandia.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.perfulandia.ventas.models",
							"com.perfulandia.vendedores.models",
							"com.perfulandia.clientes.models",
							"com.perfulandia.vendedores.models",
							"com.perfulandia.productos.models"})
public class ProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosApplication.class, args);
	}

}
