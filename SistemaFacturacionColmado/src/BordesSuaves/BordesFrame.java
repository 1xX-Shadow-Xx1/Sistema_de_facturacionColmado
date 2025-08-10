/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BordesSuaves;

import VentanaLogin.VentanaLogin;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author kevin
 */
public class BordesFrame extends JFrame{
    
    public void bordeFrame(JFrame frame, int ancho, int alto, int redondeoHorizontal, int redondeoVertical){
        
        // Definimos tamaño y posición
        frame.setSize(ancho, alto);
        frame.setLocationRelativeTo(null);
        // Aplicamos el borde redondeado
        frame.setShape(new RoundRectangle2D.Double(0, 0, ancho, alto, redondeoHorizontal, redondeoVertical));
    }

    
}
