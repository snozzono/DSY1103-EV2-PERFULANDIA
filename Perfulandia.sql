
-- SQL normalizado para Perfulandia
-- Versión corregida por ChatGPT

CREATE DATABASE IF NOT EXISTS perfulandia;
USE perfulandia;

-- Roles
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE
);

-- Usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    rol_id BIGINT,
    FOREIGN KEY (rol_id) REFERENCES roles(id)
);

-- Sucursales
CREATE TABLE sucursales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion TEXT NOT NULL,
    telefono VARCHAR(20),
    encargado VARCHAR(100)
);

-- Vendedores
CREATE TABLE vendedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    sucursal_id INT NOT NULL,
    fecha_ingreso DATE,
    activo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (sucursal_id) REFERENCES sucursales(id)
);

-- Clientes
CREATE TABLE clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    nombre_completo VARCHAR(100),
    rut VARCHAR(12),
    telefono VARCHAR(15),
    direccion TEXT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Categorías y marcas
CREATE TABLE categorias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE marcas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255)
);

-- Productos
CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    precio DECIMAL(10,2),
    stock INT,
    categoria_id BIGINT,
    marca_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    FOREIGN KEY (marca_id) REFERENCES marcas(id)
);

-- Ventas
CREATE TABLE ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    vendedor_id INT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2),
    descuento DECIMAL(10,2),
    total_final DECIMAL(10,2),
    estado VARCHAR(50),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (vendedor_id) REFERENCES vendedores(id)
);

-- Detalle de venta
CREATE TABLE detalle_venta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT NOT NULL,
    producto_id BIGINT NOT NULL,
    cantidad INT,
    precio_unitario DECIMAL(10,2),
    FOREIGN KEY (venta_id) REFERENCES ventas(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- Cupones
CREATE TABLE cupones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(30),
    descuento DECIMAL(5,2),
    valido_hasta DATE
);

-- Tabla intermedia cupones aplicados (muchos a muchos)
CREATE TABLE cupones_aplicados (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cupon_id BIGINT NOT NULL,
    venta_id INT NOT NULL,
    FOREIGN KEY (cupon_id) REFERENCES cupones(id),
    FOREIGN KEY (venta_id) REFERENCES ventas(id)
);

-- Transportistas
CREATE TABLE transportistas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    email VARCHAR(100)
);

-- Estados de envío
CREATE TABLE estados_envio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion TEXT
);

-- Envíos
CREATE TABLE envios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT NOT NULL,
    direccion_envio TEXT,
    estado_envio_id INT NOT NULL,
    transportista_id INT NOT NULL,
    fecha_envio DATE,
    fecha_entrega DATE,
    tracking VARCHAR(100),
    FOREIGN KEY (venta_id) REFERENCES ventas(id),
    FOREIGN KEY (estado_envio_id) REFERENCES estados_envio(id),
    FOREIGN KEY (transportista_id) REFERENCES transportistas(id)
);

-- Inventario y movimientos
CREATE TABLE almacenes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    ubicacion VARCHAR(255)
);

CREATE TABLE inventario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    producto_id BIGINT NOT NULL,
    cantidad INT,
    almacen_id BIGINT,
    FOREIGN KEY (producto_id) REFERENCES productos(id),
    FOREIGN KEY (almacen_id) REFERENCES almacenes(id)
);

CREATE TABLE movimientos_inventario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    inventario_id BIGINT NOT NULL,
    cantidad INT,
    fecha DATETIME,
    motivo VARCHAR(255),
    tipo VARCHAR(255),
    FOREIGN KEY (inventario_id) REFERENCES inventario(id)
);

-- Metas por sucursal
CREATE TABLE metas_sucursal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sucursal_id INT NOT NULL,
    mes TINYINT,
    anio SMALLINT,
    monto_meta DECIMAL(10,2),
    observacion TEXT,
    FOREIGN KEY (sucursal_id) REFERENCES sucursales(id)
);

-- Soporte al cliente
CREATE TABLE tipo_soporte (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion TEXT
);

CREATE TABLE ticket_soporte (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    tipo_soporte_id INT NOT NULL,
    asunto VARCHAR(100),
    mensaje TEXT,
    estado VARCHAR(50),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_resolucion TIMESTAMP,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (tipo_soporte_id) REFERENCES tipo_soporte(id)
);
