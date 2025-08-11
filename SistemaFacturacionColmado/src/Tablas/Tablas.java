package Tablas;

import javax.swing.table.DefaultTableModel;
import VentanaPrincipal.VentanaMain;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import persistencia.ConexionBD;

/**
 *
 * @author kevin
 */

public class Tablas{
    
    private VentanaMain ventanaMain; 
    
     public Tablas(VentanaMain ventanaMain) {
        this.ventanaMain = ventanaMain;
    }
    
    
    public void TablaDatosPersonales(){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Numero de Telefono");
        modelo.addColumn("Tipo");
        
        String [] datos = new String[4];
        
        try {
            Statement st = ConexionBD.getInstancia().getConexion().createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM vistadatospersonales;");

            while (rs.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }

            ventanaMain.TablaDatosPersonales.setModel(modelo);


        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void TablaGestionProductos(){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Unidad de Medida");
        
        String[] datos = new String[5];
        try {
            Statement st = ConexionBD.getInstancia().getConexion().createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM vistaproductos;");

            while (rs.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }

            ventanaMain.TablaMostrarProductos_VentanaGestionProductos.setModel(modelo);


        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public void TablaRegistroVentas(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cedula");
        modelo.addColumn("Numero de factura");
        modelo.addColumn("Cliente");
        modelo.addColumn("Venta");
        
        String[] datos = new String[4];
        try {
            Statement st = ConexionBD.getInstancia().getConexion().createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM vista_registro_ventas;");

            while (rs.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }

            ventanaMain.TablaVentanaVentas.setModel(modelo);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void TablaClientesHistorial(){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Cedula");
        modelo.addColumn("Numero de telefono");
        
        String[] datos = new String[3];
        try{
            
            Statement st = ConexionBD.getInstancia().getConexion().createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM vistahistorial_tablaclientes;");
            
            while (rs.next()) {
                for(int i = 0; i < datos.length; i++){
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }
            ventanaMain.TablaClientes_VentanaHistorialCliente.setModel(modelo);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void TablaFacturaHistorial(){
        
        
        
ventanaMain.TablaClientes_VentanaHistorialCliente.getSelectionModel().addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting()) {
        int fila = ventanaMain.TablaClientes_VentanaHistorialCliente.getSelectedRow();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Factura");
        modelo.addColumn("Cedula");
        modelo.addColumn("Tipo de pago");
        modelo.addColumn("Fecha");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Subtotal"); 
        modelo.addColumn("Total");

        // Si no hay fila seleccionada, limpiar tabla facturas y salir
        if (fila == -1) {
            ventanaMain.TablaHistorialCliente_VentanaHistorialCliente.setModel(modelo); // tabla vacía
            return;
        }

        String cedula = ventanaMain.TablaClientes_VentanaHistorialCliente.getValueAt(fila, 1).toString();

        try {
            Statement st = ConexionBD.getInstancia().getConexion().createStatement();

            // Poner la cédula entre comillas simples en la consulta SQL
            String consulta = "SELECT * FROM vista_facturas_resumen WHERE Cedula = '" + cedula + "'";

            ResultSet rs = st.executeQuery(consulta);

            String[] datos = new String[7];
            while (rs.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }

            ventanaMain.TablaHistorialCliente_VentanaHistorialCliente.setModel(modelo);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    });
}
}
    



