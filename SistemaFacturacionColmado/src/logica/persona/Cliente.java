package logica.persona;

public class Cliente extends Persona {
    
    protected int id_cliente;
    protected String metodo_pago;

    public Cliente(int id_cliente, String metodo_pago, String nombre, int cedula, int numero) {
        super(nombre, cedula, numero);
        this.id_cliente = id_cliente;
        this.metodo_pago = metodo_pago;
    }

    public Cliente(int id_cliente, String metodo_pago, String nombre, int cedula) {
        super(nombre, cedula);
        this.id_cliente = id_cliente;
        this.metodo_pago = metodo_pago;
    }

  

    @Override
    public void editarDatos() {
        super.editarDatos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
    public void verHistorialCompra(){
        
    }
    
    
}
