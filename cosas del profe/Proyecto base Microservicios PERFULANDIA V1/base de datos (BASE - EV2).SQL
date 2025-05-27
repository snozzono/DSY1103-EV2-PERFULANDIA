-- Insertar roles
INSERT INTO roles (id, nombre) VALUES
(1, 'cliente'),
(2, 'vendedor'),
(3, 'admin');

-- Insertar usuarios
INSERT INTO usuarios (id, username, password, email, enabled, rol_id) VALUES
(1, 'jp.bustos', '*****', 'juan@example.com', 1, 1),
(2, 'mvaldez', '*****', 'maria@example.com', 1, 1),
(3, 'carla.m', '*****', 'carla@example.com', 1, 2),
(4, 'admin1', '*****', 'admin@example.com', 1, 3);

-- Insertar clientes
INSERT INTO clientes (id, usuario_id, nombre_completo, rut, telefono, direccion) VALUES
(1, 1, 'Juan Bustos', '11.111.111-1', '56912345678', 'Av. Chile 123'),
(2, 2, 'Maria Valdez', '22.222.222-2', '56987654321', 'Calle Lago 456');

-- Insertar vendedores
INSERT INTO vendedores (id, usuario_id, sucursal, meta_mensual) VALUES
(1, 3, 'Sucursal Centro', 500000.00);

-- Insertar productos
INSERT INTO productos (id, nombre, descripcion, precio, categoria, marca) VALUES
(1, 'Té Verde', 'Infusión relajante', 2500.00, 'Infusión', 'PerfuTea'),
(2, 'Té Negro', 'Infusión estimulante', 2300.00, 'Infusión', 'PerfuTea');

-- Insertar inventario
INSERT INTO inventario (id, producto_id, cantidad, ubicacion) VALUES
(1, 1, 100, 'Bodega Central'),
(2, 2, 80, 'Bodega Sur');

-- Insertar ventas
INSERT INTO ventas (id, cliente_id, vendedor_id, fecha, total) VALUES
(1, 1, 1, '2025-05-24 10:00:00', 4800.00);

-- Insertar detalle de ventas
INSERT INTO detalle_venta (id, venta_id, producto_id, cantidad, precio_unitario) VALUES
(1, 1, 1, 1, 2500.00),
(2, 1, 2, 1, 2300.00);

-- Insertar cupones
INSERT INTO cupones (id, codigo, descuento, valido_hasta) VALUES
(1, 'MAYO2025', 10.00, '2025-05-31');

-- Insertar tickets de soporte
INSERT INTO tickets_soporte (id, cliente_id, asunto, mensaje, estado, fecha_creacion) VALUES
(1, 1, 'Problema con el envío', 'No he recibido mi pedido aún.', 'abierto', '2025-05-25 14:30:00');
