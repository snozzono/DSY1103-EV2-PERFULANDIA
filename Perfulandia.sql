-- -----------------------------------------------------
-- Schema perfulandia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `perfulandia` DEFAULT CHARACTER SET utf8 ;
USE `perfulandia` ;

-- -----------------------------------------------------
-- Table `roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uniq_nombre` (`nombre`)
);

-- -----------------------------------------------------
-- Table `usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `enabled` TINYINT NULL DEFAULT TRUE,
  `rol_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uniq_username` (`username`),
  INDEX `idx_rol_id` (`rol_id`),
  CONSTRAINT `fk_usuarios_roles`
    FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`)
);

-- -----------------------------------------------------
-- Table `clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT NULL,
  `nombre_completo` VARCHAR(100) NULL DEFAULT NULL,
  `rut` VARCHAR(12) NULL DEFAULT NULL,
  `telefono` VARCHAR(15) NULL DEFAULT NULL,
  `direccion` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_usuario_id` (`usuario_id`),
  CONSTRAINT `fk_clientes_usuarios`
    FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
);

-- -----------------------------------------------------
-- Table `vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendedores` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT NULL,
  `sucursal` VARCHAR(100) NULL DEFAULT NULL,
  `meta_mensual` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_usuario_id_vendedores` (`usuario_id`),
  CONSTRAINT `fk_vendedores_usuarios`
    FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
);

-- -----------------------------------------------------
-- Table `productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `productos` (
  `id` BIGINT NOT NULL,
  `nombre` VARCHAR(1000) NULL,
  `descripcion` TEXT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `categoria` VARCHAR(50) NULL,
  `marca` VARCHAR(50) NULL,
  PRIMARY KEY (`id`)
);

-- -----------------------------------------------------
-- Table `inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `producto_id` BIGINT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `ubicacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_producto_id` (`producto_id`),
  CONSTRAINT `fk_inventario_productos`
    FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`)
);

-- -----------------------------------------------------
-- Table `ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ventas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cliente_id` BIGINT NULL,
  `vendedor_id` BIGINT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_cliente_id` (`cliente_id`),
  INDEX `idx_vendedor_id` (`vendedor_id`),
  CONSTRAINT `fk_ventas_clientes`
    FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`),
  CONSTRAINT `fk_ventas_vendedores`
    FOREIGN KEY (`vendedor_id`) REFERENCES `vendedores` (`id`)
);

-- -----------------------------------------------------
-- Table `detalle_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `venta_id` BIGINT NULL,
  `producto_id` BIGINT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `precio_unitario` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_venta_id` (`venta_id`),
  INDEX `idx_producto_id` (`producto_id`),
  CONSTRAINT `fk_detalle_venta_ventas`
    FOREIGN KEY (`venta_id`) REFERENCES `ventas` (`id`),
  CONSTRAINT `fk_detalle_venta_productos`
    FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`)
);

-- -----------------------------------------------------
-- Table `cupones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupones` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(30) NULL DEFAULT NULL,
  `descuento` DECIMAL(5,2) NULL DEFAULT NULL,
  `valido_hasta` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- -----------------------------------------------------
-- Table `tickets_soporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets_soporte` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cliente_id` BIGINT NULL,
  `asunto` VARCHAR(100) NULL DEFAULT NULL,
  `mensaje` TEXT NULL DEFAULT NULL,
  `estado` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `idx_cliente_id_soporte` (`cliente_id`),
  CONSTRAINT `fk_tickets_soporte_clientes`
    FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
);
