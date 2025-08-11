
	USE  colmadodatosgenerales;

	-- Tabla Cliente actualizada
	CREATE TABLE Cliente (
		id_cliente INT PRIMARY KEY AUTO_INCREMENT,
		nombre_cliente VARCHAR(100),
		cedula_cliente VARCHAR(14) UNIQUE,
		numero_cliente VARCHAR(20),
		tipo_pago VARCHAR(50)
		
	);

	create table Direcciones (
		id_cliente int not null,
		direccion varchar(100),
		foreign key (id_cliente) references Cliente(id_cliente)
	);

	-- relacion correo - empleado
	CREATE TABLE Correo (
		id_correo INT PRIMARY KEY AUTO_INCREMENT,
		nombre VARCHAR(100),
		contraseña VARCHAR(100),
		nivelacceso INT
	);

	-- Tabla Empleado actualizada
	CREATE TABLE Empleado (
		id_empleado INT PRIMARY KEY AUTO_INCREMENT,
		id_correo INT NOT NULL,
		nombre_empleado VARCHAR(100),
		cedula_empleado VARCHAR(14) UNIQUE,
		numero_empleado VARCHAR(20),
		cargo VARCHAR(50),
		FOREIGN KEY (id_correo) REFERENCES Correo(id_correo)
	);

	-- Productos
	CREATE TABLE ProductoColmado (
		id_producto INT PRIMARY KEY AUTO_INCREMENT,
		nombre VARCHAR(100),
		precio DOUBLE,
		cantidad INT,
		unidad_medida VARCHAR(50)
	);

	-- Facturas
	CREATE TABLE Factura (
		id_factura INT PRIMARY KEY AUTO_INCREMENT,
		fecha DATE NOT NULL,
		tipo_pago VARCHAR(50) NOT NULL,
		subtotal DECIMAL(10,2) NOT NULL,
		impuesto VARCHAR(10) NOT NULL,
		total DECIMAL(10,2) NOT NULL,
		id_cliente INT NOT NULL,
		id_empleado INT NOT NULL,
		FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
		FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
	);

	-- Relación Factura - Producto
	CREATE TABLE Factura_Producto (
		id_factura_producto INT AUTO_INCREMENT PRIMARY KEY,
		id_factura INT,
		id_producto INT,
		cantidad INT,
		FOREIGN KEY (id_factura) REFERENCES Factura(id_factura),
		FOREIGN KEY (id_producto) REFERENCES ProductoColmado(id_producto)
	);


	-- Insertar un correo primero
	INSERT INTO correo (nombre, contraseña,nivelacceso) 
	VALUES ('Kevin@gmail.com', 'Admin123',2);

	-- Ahora insertar un empleado con ese id_correo (supongamos que fue 1)
	INSERT INTO Empleado (id_correo, nombre_empleado, cedula_empleado, numero_empleado, cargo) 
	VALUES (1, 'Kevin Liriano Ramirez', '402-9234264-8', '809-123-4567', 'Administrador');



	INSERT INTO correo (nombre, contraseña,nivelacceso) 
	VALUES ('Ramona@gmail.com', 'Admin123',1);

	-- Ahora insertar un empleado con ese id_correo (supongamos que fue 1)
	INSERT INTO Empleado (id_correo, nombre_empleado, cedula_empleado, numero_empleado, cargo) 
	VALUES (2, 'Ramona Liriano Ramirez', '402-9254264-8', '809-133-4567', 'Empleado');

	SELECT * FROM vista_empleado_correo_simple;
	select * from cliente;
    
    SELECT * FROM Factura_Producto;

SELECT nombre_producto, cantidad, precio_unidad 
FROM VistaFacturaProductos 
WHERE id_factura = 1;
SELECT * FROM factura;


-- Insertar clientes
INSERT INTO Cliente (nombre_cliente, cedula_cliente, numero_cliente, tipo_pago) VALUES
('Carlos Díaz', '001-1111111-1', '809-555-1111', 'Contado'),
('Ana Gómez', '002-2222222-2', '809-555-2222', 'Crédito');

-- Insertar productos
INSERT INTO ProductoColmado (nombre, precio, cantidad, unidad_medida) VALUES
('Harina', 30.00, 100, 'Libras'),
('Frijoles', 45.00, 150, 'Libras');

-- Insertar facturas (asumiendo id_cliente=1, id_empleado=1)
INSERT INTO Factura (fecha, tipo_pago, subtotal, impuesto, total, id_cliente, id_empleado) VALUES
('2025-08-11', 'Contado', 150.00, '18%', 177.00, 1, 1),
('2025-08-12', 'Crédito', 90.00, '18%', 106.20, 2, 2);

-- Insertar detalle factura-producto (relación)
INSERT INTO Factura_Producto (id_factura, id_producto, cantidad) VALUES
(1, 1, 3),  -- 3 libras de harina en factura 1
(1, 2, 2),  -- 2 libras de frijoles en factura 1
(2, 2, 2);  -- 2 libras de frijoles en factura 2

SELECT * FROM vista_facturas_resumen WHERE Cedula = '40000000';
	