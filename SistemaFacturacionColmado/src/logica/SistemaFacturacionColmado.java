
package logica;

import VentanaPrincipal.VentanaMain;
import com.formdev.flatlaf.FlatLightLaf;
import persistencia.ConexionBD;

public class SistemaFacturacionColmado {
 
    public static void main(String[] args) {
        
        ConexionBD c1 = ConexionBD.getInstancia();
        
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> new VentanaMain().setVisible(true));
        
    }
    
}
