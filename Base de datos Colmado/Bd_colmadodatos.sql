
USE colmadodatosgenerales;

CREATE TABLE Persona (
    cedula VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(100),
    numero INT
);

CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY,
    cedula VARCHAR(12) UNIQUE,
    tipo_pago VARCHAR(50),
    FOREIGN KEY (cedula) REFERENCES Persona(cedula)
);

CREATE TABLE Empleado (
    id_empleado INT PRIMARY KEY,
    cedula VARCHAR(12) UNIQUE,
    cargo VARCHAR(50),
    FOREIGN KEY (cedula) REFERENCES Persona(cedula)
);

CREATE TABLE ProductoColmado (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio DOUBLE,
    cantidad INT,
    unidad_medida VARCHAR(50)
);

CREATE TABLE Factura (
    id_factura INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    tipo_pago VARCHAR(50) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    impuesto DECIMAL(10,2) NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    id_cliente INT NOT NULL,
    id_empleado INT NOT NULL,
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


SELECT * FROM ProductoColmado;

-- Consultas rapidas
SELECT * FROM vistaproductos;
SELECT * FROM vistadatospersonales;
SELECT * FROM vistahistorialcliente_tablafacturas;
SELECT * FROM vistahistorial_tablaclientes;
SELECT * FROM vista_factura_completa;
