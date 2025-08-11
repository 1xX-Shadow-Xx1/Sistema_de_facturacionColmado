-- Vistas de clientes y direcciones
DROP VIEW IF EXISTS vistadatosclientes;
CREATE VIEW vistadatosclientes AS
SELECT 
    c.id_cliente AS ID,
    c.cedula_cliente AS Cedula,
    c.nombre_cliente AS Nombre,
    c.numero_cliente AS `Numero de Telefono`,
    IFNULL(d.direccion, 'Ninguno') AS Direccion
FROM Cliente c
LEFT JOIN Direcciones d ON d.id_cliente = c.id_cliente;

DROP VIEW IF EXISTS vistahistorial_tablaclientes;
CREATE VIEW vistahistorial_tablaclientes AS
SELECT
    c.cedula_cliente AS Cedula,
    c.nombre_cliente AS Nombre,
    c.numero_cliente AS `Numero de telefono`
FROM Cliente c;


-- Vista combinada de personas (clientes y empleados)
DROP VIEW IF EXISTS vistadatospersonales;
CREATE VIEW vistadatospersonales AS
SELECT 
    c.cedula_cliente AS Cedula,
    c.nombre_cliente AS Nombre,
    c.numero_cliente AS `Numero de Telefono`,
    IFNULL(d.direccion, 'Ninguno') AS Direccion,
    'Cliente' AS Tipo
FROM Cliente c
LEFT JOIN Direcciones d ON d.id_cliente = c.id_cliente

UNION ALL

SELECT 
    e.cedula_empleado AS Cedula,
    e.nombre_empleado AS Nombre,
    e.numero_empleado AS `Numero de Telefono`,
    'Ninguno' AS Direccion,
    e.cargo AS Tipo
FROM Empleado e;


-- Vista de productos
DROP VIEW IF EXISTS vistaproductos;
CREATE VIEW vistaproductos AS
SELECT
    p.id_producto AS ID,
    p.nombre AS Producto,
    p.cantidad AS Cantidad,
    p.precio AS Precio,
    p.unidad_medida AS `Unidad de Medida`
FROM ProductoColmado p;


-- Vista de empleados y sus correos
DROP VIEW IF EXISTS vista_empleado_correo_simple;
CREATE VIEW vista_empleado_correo_simple AS
SELECT 
    e.id_empleado,
    e.nombre_empleado,
    c.nombre AS correo,
    c.contraseña,
    c.nivelacceso
FROM Empleado e
JOIN Correo c ON e.id_correo = c.id_correo;


-- Vista resumen de facturas
DROP VIEW IF EXISTS vista_facturas_resumen;
CREATE OR REPLACE VIEW vista_facturas_resumen AS
SELECT 
    f.id_factura AS `ID Factura`,
    c.cedula_cliente AS Cedula,
    f.tipo_pago AS `Tipo de pago`,
    f.fecha AS Fecha,
    f.impuesto AS Impuesto,
    f.subtotal AS Subtotal,
    f.total AS Total,
    e.nombre_empleado AS empleado
FROM Factura f
JOIN Cliente c ON f.id_cliente = c.id_cliente
JOIN Empleado e ON f.id_empleado = e.id_empleado;


-- Vista detalle de productos en facturas
DROP VIEW IF EXISTS VistaFacturaProductos;
CREATE OR REPLACE VIEW VistaFacturaProductos AS
SELECT 
    fp.id_factura,
    pc.nombre AS nombre_producto,
    fp.cantidad,
    pc.precio AS precio_unidad
FROM Factura_Producto fp
JOIN ProductoColmado pc ON fp.id_producto = pc.id_producto;


-- Vista para registro de ventas (sumario por factura)
DROP VIEW IF EXISTS vista_registro_ventas;
CREATE VIEW vista_registro_ventas AS
SELECT 
    c.nombre_cliente AS Cliente,
    f.id_factura AS `Numero de factura`,
    e.nombre_empleado AS Empleado,
    f.total AS Venta
FROM Factura f
JOIN Cliente c ON f.id_cliente = c.id_cliente
JOIN Empleado e ON f.id_empleado = e.id_empleado;

