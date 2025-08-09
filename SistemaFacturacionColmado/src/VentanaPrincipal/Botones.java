package VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Botones {

    EstadoBoton[] lista = new EstadoBoton[5];
    private JPanel DatosPersonalesBtn, GestionProductosBtn, FacturacionBtn , RegistroVentasBtn, HistorialClienteBtn;
    private JLabel DatosPersonalesTxt, GestionProductosTxt, FacturacionTxt , RegistroVentasTxt, HistorialClienteTxt;


    private VentanaMain ventana;

    public Botones(VentanaMain ventana) {
        this.ventana = ventana;

        for (int i = 0; i < lista.length; i++) {
            lista[i] = new EstadoBoton(false);
        }
        lista[0].activo = true;
    }

    public void botones(JPanel btn, JLabel Txt, int numBtn, String nameVentana){

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (lista[numBtn].activo == false){
                    ventana.mostrarVentana(nameVentana);
                    ventana.IluminacionBotonesMenu(btn,Txt);
                    if (numBtn == 0){
                        ventana.tablas.TablaDatosPersonales();
                    }
                    if (numBtn == 1) {
                        ventana.tablas.TablaGestionProductos();
                    }
                    if (numBtn == 3) {
                        ventana.tablas.TablaRegistroVentas();
                    }
                    if (numBtn == 4) {
                        ventana.tablas.TablaClientesHistorial();
                        ventana.tablas.TablaFacturaHistorial();
                    }
                    Botonestado(numBtn);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(lista[numBtn].activo == false){
                    btn.setBackground(new Color(223,223,223));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(lista[numBtn].activo == false){
                    btn.setBackground(new Color(232,232,232));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(lista[numBtn].activo == false){
                    btn.setBackground(new Color(220,220,220));
                    Txt.setForeground(new Color(102,102,102));
                }
            }
        });
    }

    void Botonestado(int Btn){

        lista[Btn].activo = true;

        for(int i = 0; i < lista.length; i++ ){
            if( i != Btn){
                lista[i].activo = false;
            }
        }
    }
}
