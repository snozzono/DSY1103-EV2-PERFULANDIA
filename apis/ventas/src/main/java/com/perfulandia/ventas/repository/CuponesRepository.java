package com.perfulandia.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.ventas.models.Cupones;
import java.util.List;


public interface CuponesRepository extends JpaRepository<Cupones, Integer> {

    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar cupones por código o fecha de expiración
    List<Cupones> findByCodigo(Integer codigo);
    boolean existsByCodigoCupones(Integer codigoCupon);
}
