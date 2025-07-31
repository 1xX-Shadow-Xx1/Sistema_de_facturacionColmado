/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VentanaEditarProductos;

import java.awt.Color;

/**
 *
 * @author kevin
 */
public class VentanaEditarProductos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaEditarProductos.class.getName());

    /**
     * Creates new form VentanaEditarProductos
     */
    public VentanaEditarProductos() {
        initComponents();
    }

    public VentanaEditarProductos(Object id, Object nombre, Object cantidad, Object precio, Object unidad) {
        initComponents();

        
        EditarNombreProductoBarra.setText(nombre.toString());
        EditarCantidadBarra.setText(cantidad.toString());
        EditarPrecioBarra.setText(precio.toString());
        EditarUnidadMedidaItems.setSelectedItem(unidad.toString());
        
        this.idProducto = id.toString(); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        setPreferredSize(new java.awt.Dimension(400, 400));
        setSize(new java.awt.Dimension(400, 400));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EditarNombreProductoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TituloEditarProductos)
                            .addComponent(EditarPrecioTxt)
                            .addComponent(EditarCantidadTxt)
                            .addComponent(EditarNombreProductoTxt)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(EditarPrecioBarra, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EditarCantidadBarra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(EditarUnidadMedidaItems, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EditarUnidadMedidaTxt, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(BotonVentanaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(TituloEditarProductos)
                .addGap(81, 81, 81)
                .addComponent(EditarNombreProductoTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarNombreProductoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditarCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarCantidadBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditarPrecioTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarPrecioBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditarUnidadMedidaTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarUnidadMedidaItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(BotonVentanaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
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
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaEditarProductos().setVisible(true));
    }
    private String idProducto;
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
    // End of variables declaration//GEN-END:variables
}
