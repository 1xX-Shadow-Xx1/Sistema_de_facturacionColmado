-- Asegúrate de estar usando tu schema
USE colmadodatosgenerales;

CREATE TABLE Persona (
    cedula INT PRIMARY KEY,
    nombre VARCHAR(100),
    numero INT
);

CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    cedula INT UNIQUE,
    tipo_pago VARCHAR(50),
    FOREIGN KEY (cedula) REFERENCES Persona(cedula)
);

CREATE TABLE Empleado (
    id_empleado INT PRIMARY KEY,
    cedula INT UNIQUE,
    cargo VARCHAR(50),
    FOREIGN KEY (cedula) REFERENCES Persona(cedula)
);

CREATE TABLE ProductoColmado (
    id_producto INT PRIMARY KEY auto_increment,
    nombre VARCHAR(100),
    precio DOUBLE,
    cantidad INT,
    unidad_medida VARCHAR(50)
);

CREATE TABLE Factura (
    id_factura INT PRIMARY KEY,
    fecha DATE,
    total DOUBLE,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Venta (
    id_venta INT PRIMARY KEY,
    id_factura INT UNIQUE,
    id_cliente INT,
    id_empleado INT,
    total DOUBLE,
    FOREIGN KEY (id_factura) REFERENCES Factura(id_factura),
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
);

CREATE TABLE Factura_Producto (
    id_factura INT,
    id_producto INT,
    cantidad INT,
    PRIMARY KEY (id_factura, id_producto),
    FOREIGN KEY (id_factura) REFERENCES Factura(id_factura),
    FOREIGN KEY (id_producto) REFERENCES ProductoColmado(id_producto)
);

CREATE TABLE Venta_Producto (
    id_venta INT,
    id_producto INT,
    cantidad INT,
    PRIMARY KEY (id_venta, id_producto),
    FOREIGN KEY (id_venta) REFERENCES Venta(id_venta),
    FOREIGN KEY (id_producto) REFERENCES ProductoColmado(id_producto)
);


DELETE FROM ProductoColmado;
SELECT * FROM ProductoColmado;
SELECT * FROM vistadatospersonales;
SELECT * FROM vistahistorialcliente_tablafacturas;
SELECT * FROM vistahistorial_tablaclientes;
SELECT * FROM vistaregistro_ventas;vistadatospersonalesvistadatospersonales