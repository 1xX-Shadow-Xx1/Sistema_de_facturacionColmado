/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanaEditarProductos;


import VentanaPrincipal.VentanaMain;
import java.awt.Color;
import java.awt.Window;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import logica.producto.ProductoColmado;
import persistencia.ConexionBD;
/**
 *
 * @author kevin
 */
public class VentanaEditarProductos extends JFrame{
    
    private int idProducto;
    private VentanaMain ventanaMain;
    private JTable TablaMostrarProductos_VentanaGestionProductos;
   
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaEditarProductos.class.getName());

    /**
     * Creates new form VentanaEditarProductos
     */
    public VentanaEditarProductos() {
        initComponents();
    }

    public VentanaEditarProductos(int id, String nombre, int cantidad, double precio, String unidad, VentanaMain ventanaMain, JTable tablaProductos) {
        this.idProducto = idProducto;
        this.ventanaMain = ventanaMain;
        this.TablaMostrarProductos_VentanaGestionProductos = tablaProductos;
        initComponents();

        
        EditarNombreProductoBarra.setText(nombre);
        EditarCantidadBarra.setText(String.valueOf(cantidad));
        EditarPrecioBarra.setText(String.valueOf(precio));
        EditarUnidadMedidaItems.setSelectedItem(unidad);

        this.idProducto = (id);
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VentanaEmergenteEditarProductos = new javax.swing.JPanel();
        EditarNombreProductoBarra = new javax.swing.JTextField();
        EditarNombreProductoTxt = new javax.swing.JLabel();
        EditarCantidadTxt = new javax.swing.JLabel();
        EditarCantidadBarra = new javax.swing.JTextField();
        EditarPrecioTxt = new javax.swing.JLabel();
        EditarPrecioBarra = new javax.swing.JTextField();
        EditarUnidadMedidaTxt = new javax.swing.JLabel();
        EditarUnidadMedidaItems = new javax.swing.JComboBox<>();
        BotonVentanaEditar = new javax.swing.JPanel();
        VentanaBotonEditarTxt = new javax.swing.JLabel();
        TituloEditarProductos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(450, 550));

        EditarNombreProductoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarNombreProductoBarraActionPerformed(evt);
            }
        });

        EditarNombreProductoTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EditarNombreProductoTxt.setText("Nombre del Producto");

        EditarCantidadTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EditarCantidadTxt.setText("Cantidad");

        EditarPrecioTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EditarPrecioTxt.setText("Precio");

        EditarUnidadMedidaTxt.setText("Unidad de Medida");

        EditarUnidadMedidaItems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Onza" }));

        BotonVentanaEditar.setBackground(new java.awt.Color(220, 220, 220));
        BotonVentanaEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonVentanaEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonVentanaEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonVentanaEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonVentanaEditarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonVentanaEditarMousePressed(evt);
            }
        });

        VentanaBotonEditarTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VentanaBotonEditarTxt.setText("Editar");
        VentanaBotonEditarTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VentanaBotonEditarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentanaBotonEditarTxtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BotonVentanaEditarLayout = new javax.swing.GroupLayout(BotonVentanaEditar);
        BotonVentanaEditar.setLayout(BotonVentanaEditarLayout);
        BotonVentanaEditarLayout.setHorizontalGroup(
            BotonVentanaEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaBotonEditarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
        );
        BotonVentanaEditarLayout.setVerticalGroup(
            BotonVentanaEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaBotonEditarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        TituloEditarProductos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TituloEditarProductos.setText("Editar Productos");

        javax.swing.GroupLayout VentanaEmergenteEditarProductosLayout = new javax.swing.GroupLayout(VentanaEmergenteEditarProductos);
        VentanaEmergenteEditarProductos.setLayout(VentanaEmergenteEditarProductosLayout);
        VentanaEmergenteEditarProductosLayout.setHorizontalGroup(
            VentanaEmergenteEditarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaEmergenteEditarProductosLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(VentanaEmergenteEditarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloEditarProductos)
                    .addComponent(EditarNombreProductoTxt)
                    .addComponent(EditarNombreProductoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarCantidadTxt)
                    .addComponent(EditarCantidadBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarPrecioTxt)
                    .addComponent(EditarPrecioBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarUnidadMedidaTxt)
                    .addComponent(EditarUnidadMedidaItems, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(VentanaEmergenteEditarProductosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(BotonVentanaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        VentanaEmergenteEditarProductosLayout.setVerticalGroup(
            VentanaEmergenteEditarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaEmergenteEditarProductosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(TituloEditarProductos)
                .addGap(97, 97, 97)
                .addComponent(EditarNombreProductoTxt)
                .addGap(6, 6, 6)
                .addComponent(EditarNombreProductoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditarCantidadTxt)
                .addGap(6, 6, 6)
                .addComponent(EditarCantidadBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditarPrecioTxt)
                .addGap(6, 6, 6)
                .addComponent(EditarPrecioBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditarUnidadMedidaTxt)
                .addGap(6, 6, 6)
                .addComponent(EditarUnidadMedidaItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(BotonVentanaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaEmergenteEditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VentanaEmergenteEditarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditarNombreProductoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarNombreProductoBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarNombreProductoBarraActionPerformed

    private void BotonVentanaEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonVentanaEditarMouseEntered
        BotonVentanaEditar.setBackground(new Color(231,231,231));
    }//GEN-LAST:event_BotonVentanaEditarMouseEntered

    private void BotonVentanaEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonVentanaEditarMouseExited
        BotonVentanaEditar.setBackground(new Color(220,220,220));
    }//GEN-LAST:event_BotonVentanaEditarMouseExited

    private void BotonVentanaEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonVentanaEditarMousePressed
        BotonVentanaEditar.setBackground(new Color(210,210,210));
    }//GEN-LAST:event_BotonVentanaEditarMousePressed

    private void BotonVentanaEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonVentanaEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonVentanaEditarMouseClicked

    private void VentanaBotonEditarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentanaBotonEditarTxtMouseClicked
        
        String nuevoNombre = EditarNombreProductoBarra.getText().trim();
        String nuevaCantidad = (EditarCantidadBarra.getText().trim());
        String nuevoPrecio = (EditarPrecioBarra.getText().trim());
        String nuevaUnidadMedida = (String) EditarUnidadMedidaItems.getSelectedItem();

        if (nuevoNombre.isEmpty() || nuevaCantidad.isEmpty() || nuevoPrecio.isEmpty() || nuevaUnidadMedida == null) {
            JOptionPane.showMessageDialog(null, "¡Los campos no pueden estar vacíos!");
        return;
        } 
        
        int NuevaCantidad = Integer.valueOf(nuevaCantidad);
        double NuevoPrecio = Double.valueOf(nuevoPrecio);
        
        
        try {
                
                Statement st = ConexionBD.getInstancia().getConexion().createStatement();
                
                st.executeUpdate("UPDATE ProductoColmado SET "
               + "nombre = '" + nuevoNombre + "', "
               + "cantidad = " + NuevaCantidad + ", "
               + "precio = " + NuevoPrecio + ", "
               + "unidad_medida = '" + nuevaUnidadMedida + "' "
               + "WHERE id_producto = " + idProducto);
                
                ventanaMain.MostrarTablas("vistaproductos", TablaMostrarProductos_VentanaGestionProductos);
                
                JOptionPane.showMessageDialog(null, "Producto editado Exitosamente");

                Window ventana = SwingUtilities.getWindowAncestor(VentanaEmergenteEditarProductos);
                if (ventana != null) {
                    ventana.dispose();
                }

        } catch ( SQLException ex) {
            ex.printStackTrace();    
        }    
    }//GEN-LAST:event_VentanaBotonEditarTxtMouseClicked
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonVentanaEditar;
    private javax.swing.JTextField EditarCantidadBarra;
    private javax.swing.JLabel EditarCantidadTxt;
    private javax.swing.JTextField EditarNombreProductoBarra;
    private javax.swing.JLabel EditarNombreProductoTxt;
    private javax.swing.JTextField EditarPrecioBarra;
    private javax.swing.JLabel EditarPrecioTxt;
    private javax.swing.JComboBox<String> EditarUnidadMedidaItems;
    private javax.swing.JLabel EditarUnidadMedidaTxt;
    private javax.swing.JLabel TituloEditarProductos;
    private javax.swing.JLabel VentanaBotonEditarTxt;
    public javax.swing.JPanel VentanaEmergenteEditarProductos;
    // End of variables declaration//GEN-END:variables
}
