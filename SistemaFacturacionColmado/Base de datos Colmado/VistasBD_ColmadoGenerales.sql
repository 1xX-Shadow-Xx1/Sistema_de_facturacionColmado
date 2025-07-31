
/* vistadatospersonales */
CREATE VIEW vistadatospersonales AS
SELECT 
    p.cedula,
    p.nombre,
    p.numero AS telefono,
    'Cliente' AS tipo
FROM Cliente c
JOIN Persona p ON c.cedula = p.cedula

UNION ALL

SELECT 
    p.cedula,
    p.nombre,
    p.numero AS telefono,
    'Empleado' AS tipo
FROM Empleado e
JOIN Persona p ON e.cedula = p.cedula;


/* vistahistorialcliente_tablafacturas */
CREATE OR REPLACE VIEW vistahistorialcliente_tablafacturas AS
SELECT 
    p.cedula,
    f.id_factura,
    c.tipo_pago,
    f.total
FROM Factura f
JOIN Cliente c ON f.id_cliente = c.id_cliente
JOIN Persona p ON c.cedula = p.cedula;


/* vistahistorial_tablaclientes */
CREATE OR REPLACE VIEW vistahistorial_tablaclientes AS
SELECT 
    p.cedula,
    p.nombre,
    p.numero AS telefono
FROM Persona p;


/* vistaregistro_ventas */
CREATE OR REPLACE VIEW vistaregistro_ventas AS
SELECT 
    f.id_factura AS numero_factura,
    p.nombre AS cliente,
    v.total AS total_venta
FROM Venta v
JOIN Factura f ON v.id_factura = f.id_factura
JOIN Cliente c ON v.id_cliente = c.id_cliente
JOIN Persona p ON c.cedula = p.cedula;
