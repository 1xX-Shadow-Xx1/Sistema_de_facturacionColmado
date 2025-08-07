package logica.persona;

public class Empleado extends Persona {

    static protected int id_empleado = 0;
    protected String cargo;

    public Empleado() {
        id_empleado++;
    }

    
    
    public Empleado(int id_empleado, String cargo, String nombre, String cedula, int numero) {
       super(nombre, cedula, numero);
        this.id_empleado = id_empleado;
        this.cargo = cargo;
    }

    public Empleado(int id_empleado, String cargo, String nombre, String cedula) {
        super(nombre, cedula);
        this.id_empleado = id_empleado;
        this.cargo = cargo;
    }

    public static int getId_empleado() {
        return id_empleado;
    }

    public static void setId_empleado(int id_empleado) {
        Empleado.id_empleado = id_empleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    

    

    @Override
    public void editarDatos() {
        super.editarDatos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

   

    
}
