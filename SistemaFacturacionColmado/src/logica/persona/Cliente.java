package logica.persona;

public class Cliente extends Persona {
    
    static protected int id_cliente = 0;
    protected String metodo_pago;

    
   
    
  

    
    public Cliente(int id_cliente, String metodo_pago, String nombre, String cedula, int numero) {
        super(nombre, cedula, numero);
        this.id_cliente = id_cliente;
        this.metodo_pago = metodo_pago;
    }

    public Cliente(int id_cliente, String metodo_pago, String nombre, String cedula) {
        super(nombre, cedula);
        this.id_cliente = id_cliente;
        this.metodo_pago = metodo_pago;
        this.id_cliente++;

    }

    public static int getId_cliente() {
        return id_cliente;
    }

    public static void setId_cliente(int id_cliente) {
        Cliente.id_cliente = id_cliente;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
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
