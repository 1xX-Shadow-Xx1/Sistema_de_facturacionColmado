/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentanaPrincipal;

import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class CerrarSesion {
    
    private VentanaMain ventanaMain;
    
    public CerrarSesion(VentanaMain ventanaMain){
        this.ventanaMain = ventanaMain;
    }


    
    public void CerrarSesionMain(){
        
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de querer salir de la Sesion?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION);
        
        if(confirmacion == JOptionPane.YES_OPTION){
            ventanaMain.ventanalogin.setVisible(true);
            ventanaMain.dispose();
        }
    }
    
}
