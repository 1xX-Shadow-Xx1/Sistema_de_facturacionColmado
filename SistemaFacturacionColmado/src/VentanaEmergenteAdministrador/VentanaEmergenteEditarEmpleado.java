package VentanaEmergenteAdministrador;

import administrador.AdministradorEmpleados;

public class VentanaEmergenteEditarEmpleado extends javax.swing.JFrame {

    private javax.swing.JTable tablaReferencia; // referencia a la tabla principal

    // Constructor recibe la tabla principal para obtener los ids
    public VentanaEmergenteEditarEmpleado(javax.swing.JTable tablaPrincipal) {
        this.tablaReferencia = tablaPrincipal;
        initComponents();

        BotonGuardarEditacionEmpleado_VentanaEmergente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int[] ids = AdministradorEmpleados.obtenerIDsSeleccionados(tablaReferencia);
                if (ids != null) {
                    AdministradorEmpleados.editarEmpleadoCompleto(
                        ids[0], // idEmpleado
                        ids[1], // idCorreo
                        BarraEditarNombreEmpleado_VentanaEmergente.getText(),
                        BarraEditarCedulaEmpleado_VentanaEmergente.getText(),
                        BarraEditarTelefonoEmpleado_VentanaEmergente.getText(),
                        BoxEditarCargoEmpleado_VentanaEmergente.getSelectedItem().toString(),
                        BarraEditarUsuarioEmpleado_VentanaEmergente.getText(),
                        new String(BarraEditarContraseñaEmpleado_VentanaEmergente.getPassword()),
                        BoxEditarNivelAccesoEmpleado_VentanaEmergente.getSelectedIndex() + 1
                    );
                    setVisible(false);
                }
            }
        });
    }

    // ... (resto del código generado por NetBeans)
}