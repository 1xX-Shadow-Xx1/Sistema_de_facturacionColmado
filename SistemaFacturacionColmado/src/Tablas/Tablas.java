package Tablas;

import javax.swing.table.DefaultTableModel;
import VentanaPrincipal.VentanaMain;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void TablaDatosClientes(){

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Numero de Telefono");
        modelo.addColumn("Direccion");

        String [] datos = new String[5];
        
        try {

            Statement st = ConexionBD.getInstancia().getConexion().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM vistadatosclientes;");

            while (rs.next()){
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);

            }
            ventanaMain.TablaDatosClientes.setModel(modelo);
        }catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("Problema con la TablaDatosClientes");
        }

                
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
        modelo.addColumn("Cliente");
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
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
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
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero de factura");
        modelo.addColumn("Tipo de pago");
        modelo.addColumn("Total");
        
        String[] datos = new String[3];
        try{
            
            Statement st = ConexionBD.getInstancia().getConexion().createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM vista_facturas_resumen;");
            
            while (rs.next()) {
                for(int i = 0; i < datos.length; i++){
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }
            ventanaMain.TablaHistorialCliente_VentanaHistorialCliente.setModel(modelo);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
}


