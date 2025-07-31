package logica.persona;

public class Empleado extends Persona {

    protected int id_empleado;
    protected String cargo;

    public Empleado(int id_empleado, String cargo, String nombre, int cedula, int numero) {
        super(nombre, cedula, numero);
        this.id_empleado = id_empleado;
        this.cargo = cargo;
    }

    public Empleado(int id_empleado, String cargo, String nombre, int cedula) {
        super(nombre, cedula);
        this.id_empleado = id_empleado;
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
