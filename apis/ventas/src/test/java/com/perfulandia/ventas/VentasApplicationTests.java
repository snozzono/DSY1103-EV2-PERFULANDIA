package com.perfulandia.ventas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.perfulandia.Clientes.repository.ClienteRepository;
import com.perfulandia.productos.repository.ProductoRepository;
import com.perfulandia.vendedores.models.Vendedores;
import com.perfulandia.vendedores.repositories.VendedoresRepository;
import com.perfulandia.ventas.config.VentasMapper;
import com.perfulandia.ventas.controllers.VentasController;
import com.perfulandia.ventas.dto.CrearVentaRequest;
import com.perfulandia.Clientes.models.Cliente;
import com.perfulandia.ventas.models.Cupones;
import com.perfulandia.ventas.models.Venta;
import com.perfulandia.ventas.repository.CuponesAplicadosRepository;
import com.perfulandia.ventas.repository.CuponesRepository;
import com.perfulandia.ventas.repository.VendedorRepository;
import com.perfulandia.ventas.repository.VentaRepository;
import com.perfulandia.ventas.services.VentasService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class VentasApplicationTests {

	@Test
	void contextLoads() {
		//vacio
	}

	
	@Mock
	private VentaRepository ventaRepository;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Mock 
	private ProductoRepository productoRepository;
	
	@Mock
	private VendedoresRepository vendedoresRepository;
	
	@Mock
	private CuponesRepository cuponesRepository;
	
	@Mock
	private VentasService ventasService;

	@Test
	@DisplayName("Test crear venta exitosa")
	void testCrearVenta() {
		// Arrange
		CrearVentaRequest request = new CrearVentaRequest();
		request.setIdCliente(1);
		request.setIdVendedor(1);
		
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		
		Vendedores vendedor = new Vendedores();
		vendedor.setId(1);
		
		when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
		when(vendedoresRepository.findById(anyInt())).thenReturn(Optional.of(vendedor));
		
		// Act
		Venta response = ventasService.crearVenta(request);
		
		// Assert
		assertThat(response).isNotNull();
	}
}
