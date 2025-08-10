package VentanaPrincipal;

import VentanaLogin.Sesion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Botones {

    EstadoBoton[] BtnListaAdmin = new EstadoBoton[5];
    EstadoBoton[] BtnListaEmpleado = new EstadoBoton[4];

    private VentanaMain ventana;
    private MenuEmpleado menuEmpleado;
    
    public Botones(VentanaMain ventana, MenuEmpleado menuEmpleado) {
        this.ventana = ventana;
        this.menuEmpleado = menuEmpleado;
        
        
        BotonesEmpleado();
        BotonesAdmin();
    }
    
    void BotonesEmpleado(){
        for(int i = 0; i < BtnListaEmpleado.length; i++){
            BtnListaEmpleado[i] = new EstadoBoton(false);
        }
        BtnListaEmpleado[0].activo = true;
    }
    void BotonesAdmin(){
        for (int i = 0; i < BtnListaAdmin.length; i++) {
            BtnListaAdmin[i] = new EstadoBoton(false);
        }
        BtnListaAdmin[0].activo = true;
    }

    public void botones(JPanel btn, JLabel Txt, int numBtn, String nameVentana){

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                if (BtnListaAdmin[numBtn].activo == false){
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
                if(BtnListaAdmin[numBtn].activo == false){
                    btn.setBackground(new Color(223,223,223));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(BtnListaAdmin[numBtn].activo == false){
                    btn.setBackground(new Color(232,232,232));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(BtnListaAdmin[numBtn].activo == false){
                    btn.setBackground(new Color(220,220,220));
                    Txt.setForeground(new Color(102,102,102));
                }
            }
        });
    }
    
    public void botonesEmpleados(JPanel btn, JLabel Txt, int numBtn, String nameVentana){
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                if(BtnListaEmpleado[numBtn].activo ==false){
                    ventana.mostrarVentana(nameVentana);
                    menuEmpleado.IluminacionBotonesMenuEmpleado(btn, Txt);
                    if (numBtn == 0){
                        ventana.tablas.TablaDatosClientes();
                    }
                    if (numBtn == 1) {
                        ventana.tablas.TablaGestionProductos();
                    }
                    if (numBtn == 3) {
                        ventana.tablas.TablaClientesHistorial();
                        ventana.tablas.TablaFacturaHistorial();
                    }
                    BotonestadoEmpleado(numBtn);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                
                if(BtnListaEmpleado[numBtn].activo == false){
                    btn.setBackground(new Color(223,223,223));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                if(BtnListaEmpleado[numBtn].activo == false){
                    btn.setBackground(new Color(232,232,232));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);

                if(BtnListaEmpleado[numBtn].activo == false){
                    btn.setBackground(new Color(220,220,220));
                    Txt.setForeground(new Color(102,102,102));
                }
            }
        });
    }

    void Botonestado(int Btn){
        BtnListaAdmin[Btn].activo = true;
        
        
        for(int i = 0; i < BtnListaAdmin.length; i++ ){
            if( i != Btn){
                BtnListaAdmin[i].activo = false;
            }
        }
    }
    void BotonestadoEmpleado(int Btn){
        BtnListaEmpleado[Btn].activo = true;
        
        
        for(int i = 0; i < BtnListaEmpleado.length; i++ ){
            if( i != Btn){
                BtnListaEmpleado[i].activo = false;
            }
        }
    }
}
