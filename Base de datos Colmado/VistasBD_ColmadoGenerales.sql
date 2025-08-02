/*Vista de la tabla productoSQL*/
CREATE VIEW vistaproductos AS
SELECT 
id_producto AS id, 
nombre AS Producto, 
cantidad AS Cantidad, 
precio AS Precio, 
unidad_medida AS medida
FROM ProductoColmado;




/* vistadatospersonales */
CREATE VIEW vistadatospersonales AS
SELECT 
    p.cedula,
    p.nombre,
    p.numero AS Telefono,
    'Cliente' AS Tipo 
FROM Cliente c
JOIN Persona p ON c.cedula = p.cedula

UNION ALL

SELECT 
    p.cedula AS Cedula,
    p.nombre AS Nombre,
    p.numero,
    'Empleado' AS Cargo
FROM Empleado e
JOIN Persona p ON e.cedula = p.cedula;


/* vistahistorialcliente_tablafacturas */
CREATE OR REPLACE VIEW vistahistorialcliente_tablafacturas AS
SELECT 
    p.cedula AS Cedula,
    f.id_factura AS Factura,
    p.nombre AS Cliente,
    f.total AS Total
FROM Factura f
JOIN Cliente c ON f.id_cliente = c.id_cliente
JOIN Persona p ON c.cedula = p.cedula;


/* vistahistorial_tablaclientes */
CREATE OR REPLACE VIEW vistahistorial_tablaclientes AS
SELECT 
    p.cedula AS Cedula,
    p.nombre AS Nombre,
    p.numero AS Telefono
FROM Persona p;


/* vistaregistro_ventas */
CREATE OR REPLACE VIEW vista_factura_completa AS
SELECT 
    F.id_factura,
    F.fecha,
    F.tipo_pago,
    F.subtotal,
    F.impuesto,
    F.total,
    
    C.id_cliente,
    PC.nombre AS Nombre_Cliente,
    PC.cedula AS Cedula_Cliente,
    PC.numero AS Telefono_Cliente,
    
    E.id_empleado,
    PE.nombre AS Nombre_Empleado,
    PE.cedula AS Cedula_Empleado,
    E.cargo AS Cargo

FROM Factura F
JOIN Cliente C ON F.id_cliente = C.id_cliente
JOIN Persona PC ON C.cedula = PC.cedula

JOIN Empleado E ON F.id_empleado = E.id_empleado
JOIN Persona PE ON E.cedula = PE.cedula;

-- Vista registro de ventas
CREATE VIEW VistaRegistro_Ventas AS
SELECT 
    id_factura AS Factura,
    tipo_pago AS Pago,
    total AS Total
FROM 
    Factura;




