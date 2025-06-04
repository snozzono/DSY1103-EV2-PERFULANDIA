package com.perfulandia.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perfulandia.ventas.models.CuponesAplicados;

public interface CuponesAplicadosRepository extends JpaRepository<CuponesAplicados, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar cupones aplicados por venta o cupon
    
}
