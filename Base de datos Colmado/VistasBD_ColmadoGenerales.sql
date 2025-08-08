-- VISTAS -- 

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `vistadatospersonales` AS
    SELECT 
		`cliente`.`cedula_cliente` AS `cedula`,
        `cliente`.`nombre_cliente` AS `nombre`,
        `cliente`.`numero_cliente` AS `numero`,
        'Cliente' AS `tipo`
    FROM
        `cliente` 
    UNION ALL SELECT 
		`empleado`.`cedula_empleado` AS `cedula`,
        `empleado`.`nombre_empleado` AS `nombre`,
        `empleado`.`numero_empleado` AS `numero`,
        `empleado`.`cargo` AS `tipo`
    FROM
        `empleado`;


--

CREATE VIEW vistaproductos AS
SELECT 
    id_producto,
    nombre,
    cantidad,
	precio,
    unidad_medida
FROM ProductoColmado;
--

CREATE VIEW vista_registro_ventas AS
SELECT 
    c.cedula_cliente AS cedula,
    f.id_factura AS factura,
    c.nombre_cliente AS nombre,
    f.total AS venta
FROM 
    Factura f
JOIN 
    Cliente c ON f.id_cliente = c.id_cliente;


--

CREATE VIEW vistahistorial_tablaclientes AS
SELECT 
    nombre_cliente,
    cedula_cliente,
    numero_cliente
FROM Cliente;

--


CREATE VIEW vista_facturas_resumen AS
SELECT 
	id_factura AS Factura,
    tipo_pago AS Tipo,
    total AS Total

FROM Factura;

--

CREATE OR REPLACE VIEW vista_empleado_correo_simple AS
SELECT 
    e.id_empleado,
    e.nombre_empleado,
    c.nombre AS correo,
    c.contraseña
FROM Empleado e
JOIN Correo c ON e.id_correo = c.id_correo;




