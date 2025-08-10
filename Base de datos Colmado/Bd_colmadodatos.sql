
USE  colmadodatosgenerales;

-- Tabla Cliente actualizada
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre_cliente VARCHAR(100),
    cedula_cliente VARCHAR(14) UNIQUE,
    numero_cliente VARCHAR(20),
    tipo_pago VARCHAR(50)
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
    id_factura INT,
    id_producto INT,
    cantidad INT,
    PRIMARY KEY (id_factura, id_producto),
    FOREIGN KEY (id_factura) REFERENCES Factura(id_factura),
    FOREIGN KEY (id_producto) REFERENCES ProductoColmado(id_producto)
);



select nombre, contraseña from Correo ;
select * from Correo ;
select * from empleado;
SELECT * FROM ProductoColmado;



-- Consultas rapidas
SELECT * FROM vistadatospersonales;
SELECT * FROM vistaproductos;
SELECT * FROM vista_registro_ventas;
SELECT * FROM vistahistorial_tablaclientes;
SELECT * FROM vista_facturas_resumen;

SELECT * FROM vista_empleado_correo_simple;

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

/*ALTER TABLE Empleado
ADD COLUMN id_correo INT;

ALTER TABLE correo
ADD COLUMN nombre VARCHAR(100);

ALTER TABLE Empleado
ADD CONSTRAINT fk_empleado_correo
FOREIGN KEY (id_correo) REFERENCES correo(id_correo); */
