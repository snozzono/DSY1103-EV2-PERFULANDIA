-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema perfulandia
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `perfulandia` ;

-- -----------------------------------------------------
-- Schema perfulandia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `perfulandia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `perfulandia` ;

-- -----------------------------------------------------
-- Table `perfulandia`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(100) NULL,
  `rol` VARCHAR(45) NOT NULL COMMENT 'Roles: admin, vendedor, cliente, tecnico',
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
COMMENT = 'Tabla de usuarios del sistema';

-- -----------------------------------------------------
-- Table `perfulandia`.`sucursales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`sucursales` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`sucursales` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `direccion` TEXT NOT NULL,
  `telefono` VARCHAR(20) NULL,
  `encargado` VARCHAR(100) NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Sucursales de la empresa';

-- -----------------------------------------------------
-- Table `perfulandia`.`vendedores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`vendedores` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`vendedores` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT NOT NULL,
  `sucursal_id` BIGINT NOT NULL,
  `fecha_ingreso` DATE NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_vendedores_usuarios_idx` (`usuario_id` ASC),
  INDEX `fk_vendedores_sucursales_idx` (`sucursal_id` ASC),
  CONSTRAINT `fk_vendedores_usuarios`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `perfulandia`.`usuarios` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_vendedores_sucursales`
    FOREIGN KEY (`sucursal_id`)
    REFERENCES `perfulandia`.`sucursales` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Vendedores asociados a sucursales';

-- -----------------------------------------------------
-- Table `perfulandia`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`clientes` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`clientes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT NOT NULL,
  `nombre_completo` VARCHAR(100) NULL,
  `rut` VARCHAR(12) NULL,
  `telefono` VARCHAR(15) NULL,
  `direccion` TEXT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_clientes_usuarios_idx` (`usuario_id` ASC),
  UNIQUE INDEX `rut_UNIQUE` (`rut` ASC),
  CONSTRAINT `fk_clientes_usuarios`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `perfulandia`.`usuarios` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Clientes del sistema';

-- -----------------------------------------------------
-- Table `perfulandia`.`categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`categorias` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`categorias` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `descripcion` TEXT NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Categorías de productos';

-- -----------------------------------------------------
-- Table `perfulandia`.`marcas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`marcas` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`marcas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `descripcion` TEXT NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Marcas de productos';

-- -----------------------------------------------------
-- Table `perfulandia`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`productos` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`productos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `descripcion` TEXT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `stock` INT NULL DEFAULT 0,
  `categoria_id` BIGINT NOT NULL,
  `marca_id` BIGINT NOT NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_productos_categorias_idx` (`categoria_id` ASC),
  INDEX `fk_productos_marcas_idx` (`marca_id` ASC),
  CONSTRAINT `fk_productos_categorias`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `perfulandia`.`categorias` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_productos_marcas`
    FOREIGN KEY (`marca_id`)
    REFERENCES `perfulandia`.`marcas` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Catálogo de productos';

-- -----------------------------------------------------
-- Table `perfulandia`.`cupones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`cupones` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`cupones` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(20) NOT NULL,
  `descuento` DECIMAL(5,2) NOT NULL,
  `valido_hasta` DATE NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `usos_maximos` INT NULL DEFAULT 1,
  `usos_actuales` INT NULL DEFAULT 0,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC))
ENGINE = InnoDB
COMMENT = 'Cupones de descuento';

-- -----------------------------------------------------
-- Table `perfulandia`.`ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`ventas` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`ventas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cliente_id` BIGINT NOT NULL,
  `vendedor_id` BIGINT NOT NULL,
  `fecha` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `total` DECIMAL(10,2) NOT NULL,
  `descuento` DECIMAL(10,2) NULL DEFAULT 0.00,
  `total_final` DECIMAL(10,2) NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'pendiente',
  `cupon_id` BIGINT NULL,
  `notas` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ventas_clientes_idx` (`cliente_id` ASC),
  INDEX `fk_ventas_vendedores_idx` (`vendedor_id` ASC),
  INDEX `fk_ventas_cupones_idx` (`cupon_id` ASC),
  CONSTRAINT `fk_ventas_clientes`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `perfulandia`.`clientes` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ventas_vendedores`
    FOREIGN KEY (`vendedor_id`)
    REFERENCES `perfulandia`.`vendedores` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ventas_cupones`
    FOREIGN KEY (`cupon_id`)
    REFERENCES `perfulandia`.`cupones` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Registro de ventas';

-- -----------------------------------------------------
-- Table `perfulandia`.`detalle_venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`detalle_venta` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`detalle_venta` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `venta_id` BIGINT NOT NULL,
  `producto_id` BIGINT NOT NULL,
  `cantidad` INT NOT NULL,
  `precio_unitario` DECIMAL(10,2) NOT NULL,
  `subtotal` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_detalle_venta_ventas_idx` (`venta_id` ASC),
  INDEX `fk_detalle_venta_productos_idx` (`producto_id` ASC),
  CONSTRAINT `fk_detalle_venta_ventas`
    FOREIGN KEY (`venta_id`)
    REFERENCES `perfulandia`.`ventas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_detalle_venta_productos`
    FOREIGN KEY (`producto_id`)
    REFERENCES `perfulandia`.`productos` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Detalle de productos por venta';

-- -----------------------------------------------------
-- Table `perfulandia`.`transportistas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`transportistas` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`transportistas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(20) NULL,
  `email` VARCHAR(100) NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Empresas transportistas';

-- -----------------------------------------------------
-- Table `perfulandia`.`estados_envio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`estados_envio` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`estados_envio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `descripcion` TEXT NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Estados posibles de envío';

-- -----------------------------------------------------
-- Table `perfulandia`.`envios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`envios` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`envios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `venta_id` BIGINT NOT NULL,
  `direccion_envio` TEXT NOT NULL,
  `estado_envio_id` INT NOT NULL,
  `transportista_id` INT NOT NULL,
  `fecha_envio` DATE NULL,
  `fecha_entrega` DATE NULL,
  `tracking` VARCHAR(100) NULL,
  `costo_envio` DECIMAL(8,2) NULL DEFAULT 0.00,
  `notas` TEXT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_envios_ventas_idx` (`venta_id` ASC),
  INDEX `fk_envios_estados_envio_idx` (`estado_envio_id` ASC),
  INDEX `fk_envios_transportistas_idx` (`transportista_id` ASC),
  UNIQUE INDEX `venta_id_UNIQUE` (`venta_id` ASC),
  CONSTRAINT `fk_envios_ventas`
    FOREIGN KEY (`venta_id`)
    REFERENCES `perfulandia`.`ventas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_envios_estados_envio`
    FOREIGN KEY (`estado_envio_id`)
    REFERENCES `perfulandia`.`estados_envio` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_envios_transportistas`
    FOREIGN KEY (`transportista_id`)
    REFERENCES `perfulandia`.`transportistas` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Información de envíos';

-- -----------------------------------------------------
-- Table `perfulandia`.`almacenes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`almacenes` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`almacenes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `direccion` VARCHAR(255) NULL,
  `ubicacion` VARCHAR(255) NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Almacenes de productos';

-- -----------------------------------------------------
-- Table `perfulandia`.`inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`inventario` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`inventario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `producto_id` BIGINT NOT NULL,
  `cantidad` INT NOT NULL DEFAULT 0,
  `almacen_id` BIGINT NOT NULL,
  `stock_minimo` INT NULL DEFAULT 0,
  `stock_maximo` INT NULL DEFAULT 1000,
  `updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_inventario_productos_idx` (`producto_id` ASC),
  INDEX `fk_inventario_almacenes_idx` (`almacen_id` ASC),
  UNIQUE INDEX `producto_almacen_UNIQUE` (`producto_id` ASC, `almacen_id` ASC),
  CONSTRAINT `fk_inventario_productos`
    FOREIGN KEY (`producto_id`)
    REFERENCES `perfulandia`.`productos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_inventario_almacenes`
    FOREIGN KEY (`almacen_id`)
    REFERENCES `perfulandia`.`almacenes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Control de inventario por almacén';

-- -----------------------------------------------------
-- Table `perfulandia`.`movimientos_inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`movimientos_inventario` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`movimientos_inventario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `inventario_id` BIGINT NOT NULL,
  `cantidad` INT NOT NULL,
  `fecha` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `motivo` VARCHAR(255) NULL,
  `tipo` ENUM('entrada', 'salida', 'ajuste', 'transferencia') NOT NULL,
  `usuario_id` BIGINT NULL,
  `documento_referencia` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_movimientos_inventario_inventario_idx` (`inventario_id` ASC),
  INDEX `fk_movimientos_inventario_usuarios_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_movimientos_inventario_inventario`
    FOREIGN KEY (`inventario_id`)
    REFERENCES `perfulandia`.`inventario` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_movimientos_inventario_usuarios`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `perfulandia`.`usuarios` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Historial de movimientos de inventario';

-- -----------------------------------------------------
-- Table `perfulandia`.`tecnicos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`tecnicos` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`tecnicos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` DATE NOT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT 1,
  `nombre_completo` VARCHAR(100) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `especialidad` VARCHAR(100) NULL,
  `usuarios_id` BIGINT NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_tecnicos_usuarios_idx` (`usuarios_id` ASC),
  CONSTRAINT `fk_tecnicos_usuarios`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `perfulandia`.`usuarios` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Técnicos de soporte';

-- -----------------------------------------------------
-- Table `perfulandia`.`ticket_soporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `perfulandia`.`ticket_soporte` ;

CREATE TABLE IF NOT EXISTS `perfulandia`.`ticket_soporte` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `asunto` VARCHAR(100) NULL,
  `mensaje` TEXT NOT NULL,
  `estado` ENUM('abierto', 'en_proceso', 'resuelto', 'cerrado') NOT NULL DEFAULT 'abierto',
  `prioridad` ENUM('baja', 'media', 'alta', 'critica') NULL DEFAULT 'media',
  `fecha_creacion` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_resolucion` TIMESTAMP NULL,
  `clientes_id` BIGINT NOT NULL,
  `tecnicos_id` INT NOT NULL,
  `categoria_ticket` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ticket_soporte_clientes_idx` (`clientes_id` ASC),
  INDEX `fk_ticket_soporte_tecnicos_idx` (`tecnicos_id` ASC),
  CONSTRAINT `fk_ticket_soporte_clientes`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `perfulandia`.`clientes` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ticket_soporte_tecnicos`
    FOREIGN KEY (`tecnicos_id`)
    REFERENCES `perfulandia`.`tecnicos` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Tickets de soporte técnico';

-- -----------------------------------------------------
-- Data for table `perfulandia`.`estados_envio`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfulandia`;
INSERT INTO `perfulandia`.`estados_envio` (`id`, `nombre`, `descripcion`) VALUES (1, 'Pendiente', 'Envío pendiente de procesamiento');
INSERT INTO `perfulandia`.`estados_envio` (`id`, `nombre`, `descripcion`) VALUES (2, 'En Preparación', 'Envío siendo preparado');
INSERT INTO `perfulandia`.`estados_envio` (`id`, `nombre`, `descripcion`) VALUES (3, 'En Tránsito', 'Envío en camino');
INSERT INTO `perfulandia`.`estados_envio` (`id`, `nombre`, `descripcion`) VALUES (4, 'Entregado', 'Envío entregado exitosamente');
INSERT INTO `perfulandia`.`estados_envio` (`id`, `nombre`, `descripcion`) VALUES (5, 'Cancelado', 'Envío cancelado');

COMMIT;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;