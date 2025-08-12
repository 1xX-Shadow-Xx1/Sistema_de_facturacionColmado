package Administrador;

import java.sql.*;
import javax.swing.*;
import persistencia.ConexionBD;

public class AdministradorEmpleados {

    private static EmpleadoTemporal empleadoTemporal;

    // Paso 1: Guardar datos del empleado (sin correo todavía)
    public static void prepararEmpleadoNuevo(String nombre, String cedula, String telefono, String cargo) {
        empleadoTemporal = new EmpleadoTemporal(nombre, cedula, telefono, cargo);
    }

    // Paso 2: Con los datos del correo, inserta ambos registros en la BD
    public static void agregarEmpleadoConCorreo(String correo, String contrasena, int nivelAcceso) {
        if (empleadoTemporal == null) {
            JOptionPane.showMessageDialog(null, "Primero debe ingresar los datos del empleado.");
            return;
        }

        try {
            Connection conn = ConexionBD.getInstancia().getConexion();

            String sqlCorreo = "INSERT INTO Correo (nombre, contraseña, nivelacceso) VALUES (?, ?, ?)";
            PreparedStatement psCorreo = conn.prepareStatement(sqlCorreo, Statement.RETURN_GENERATED_KEYS);
            psCorreo.setString(1, correo);
            psCorreo.setString(2, contrasena);
            psCorreo.setInt(3, nivelAcceso);
            psCorreo.executeUpdate();

            ResultSet rs = psCorreo.getGeneratedKeys();
            int idCorreo = -1;
            if (rs.next()) idCorreo = rs.getInt(1);

            String sqlEmp = "INSERT INTO Empleado (id_correo, nombre_empleado, cedula_empleado, numero_empleado, cargo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psEmp = conn.prepareStatement(sqlEmp);
            psEmp.setInt(1, idCorreo);
            psEmp.setString(2, empleadoTemporal.nombre);
            psEmp.setString(3, empleadoTemporal.cedula);
            psEmp.setString(4, empleadoTemporal.telefono);
            psEmp.setString(5, empleadoTemporal.cargo);
            psEmp.executeUpdate();

            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
            empleadoTemporal = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar empleado: " + ex.getMessage());
        }
    }

    // Editar empleado y correo
    public static void editarEmpleadoCompleto(
            int idEmpleado, int idCorreo,
            String nombre, String cedula, String telefono, String cargo,
            String correo, String contrasena, int nivelAcceso) {
        try {
            Connection conn = ConexionBD.getInstancia().getConexion();

            String sqlCorreo = "UPDATE Correo SET nombre=?, contraseña=?, nivelacceso=? WHERE id_correo=?";
            PreparedStatement psCorreo = conn.prepareStatement(sqlCorreo);
            psCorreo.setString(1, correo);
            psCorreo.setString(2, contrasena);
            psCorreo.setInt(3, nivelAcceso);
            psCorreo.setInt(4, idCorreo);
            psCorreo.executeUpdate();

            String sqlEmp = "UPDATE Empleado SET nombre_empleado=?, cedula_empleado=?, numero_empleado=?, cargo=? WHERE id_empleado=?";
            PreparedStatement psEmp = conn.prepareStatement(sqlEmp);
            psEmp.setString(1, nombre);
            psEmp.setString(2, cedula);
            psEmp.setString(3, telefono);
            psEmp.setString(4, cargo);
            psEmp.setInt(5, idEmpleado);
            psEmp.executeUpdate();

            JOptionPane.showMessageDialog(null, "Empleado editado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al editar empleado: " + ex.getMessage());
        }
    }

    // Eliminar empleado y, opcionalmente, el correo
    public static void eliminarEmpleado(int idEmpleado) {
        try {
            Connection conn = ConexionBD.getInstancia().getConexion();
            String sqlGetCorreo = "SELECT id_correo FROM Empleado WHERE id_empleado=?";
            PreparedStatement psGet = conn.prepareStatement(sqlGetCorreo);
            psGet.setInt(1, idEmpleado);
            ResultSet rs = psGet.executeQuery();
            int idCorreo = -1;
            if (rs.next()) idCorreo = rs.getInt(1);

            String sqlEmp = "DELETE FROM Empleado WHERE id_empleado=?";
            PreparedStatement psEmp = conn.prepareStatement(sqlEmp);
            psEmp.setInt(1, idEmpleado);
            psEmp.executeUpdate();

            if (idCorreo != -1) {
                String sqlCorreo = "DELETE FROM Correo WHERE id_correo=?";
                PreparedStatement psCorreo = conn.prepareStatement(sqlCorreo);
                psCorreo.setInt(1, idCorreo);
                psCorreo.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + ex.getMessage());
        }
    }

    // Llena la JTable con los empleados y correo/nivel de acceso
    public static void poblarTablaEmpleados(javax.swing.JTable tabla) {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Empleado");
        modelo.addColumn("Cedula");
        modelo.addColumn("Número de teléfono");
        modelo.addColumn("Cargo");
        modelo.addColumn("Usuario");
        modelo.addColumn("Nivel de acceso");
        modelo.addColumn("ID Correo"); // Oculto

        String[] datos = new String[8];

        try {
            Statement st = ConexionBD.getInstancia().getConexion().createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT E.id_empleado, E.nombre_empleado, E.cedula_empleado, E.numero_empleado, E.cargo, C.nombre AS usuario, C.nivelacceso, C.id_correo " +
                "FROM Empleado E JOIN Correo C ON E.id_correo = C.id_correo"
            );
            while (rs.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(7).setMinWidth(0);
            tabla.getColumnModel().getColumn(7).setMaxWidth(0);
            tabla.getColumnModel().getColumn(7).setWidth(0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problema al llenar la tabla de empleados.");
        }
    }

    // Utilidad: obtener IDs de la fila seleccionada
    public static int[] obtenerIDsSeleccionados(javax.swing.JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila == -1) return null;
        int idEmpleado = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
        int idCorreo = Integer.parseInt(tabla.getValueAt(fila, 7).toString());
        return new int[]{idEmpleado, idCorreo};
    }
}