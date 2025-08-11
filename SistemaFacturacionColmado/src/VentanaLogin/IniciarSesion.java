/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import persistencia.ConexionBD;

/**
 *
 * @author kevin
 */
public class IniciarSesion {

    private VentanaLogin vn;

    public IniciarSesion(VentanaLogin ventana) {
        this.vn = ventana;
    }
    
    public void Login() {

        String correo = "Ramona@gmail.com";  //vn.getCorreoText();
        String password = "Admin123"; //vn.getPasswordText();
        int id_empleadologin = -1;

        if (correo.equals("Ingrese su correo electronico") || password.equals("••••••••••••••••")) {
            JOptionPane.showMessageDialog(null, "ingresa contraseña y correo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (correo == "" || password == "") {
            JOptionPane.showMessageDialog(null, "ingresa contraseña y correo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Statement st = ConexionBD.getInstancia().getConexion().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM vista_empleado_correo_simple ;");


            boolean loginExitoso = false;


            while (rs.next()) {
                String Correo = rs.getString("correo");
                String Password = rs.getString("contraseña");
                String nombreEmpleado = rs.getString("nombre_empleado");
                int nivelAcceso = Integer.valueOf(rs.getString("nivelacceso"));
                id_empleadologin = Integer.valueOf(rs.getString("id_empleado"));
                


                if (correo.equals(Correo) && password.equals(Password)) {
                    loginExitoso = true;
                    System.out.println("Login correcto. ID Empleado: " + rs.getInt("id_empleado"));
                    System.out.println("acceso: " + rs.getInt("nivelacceso"));
                    Sesion.idEmpleado = id_empleadologin;
                    Sesion.Empleado = nombreEmpleado;
                    Sesion.nivelAcceso = nivelAcceso;
                    break;
                }
            }
            if (loginExitoso) {

                vn.abrirVentanaPrincipal();
                vn.setVisible(false);
 

            } else {
                JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


