package logica.factura;

public class Venta extends Factura {
    
    protected int id_venta;
    protected String estado;
        
    /*protected
    protected
    protected
    protected
    */

    public Venta(int id_venta, int id_factura, int fecha, double total) {
        super(id_factura, fecha, total);
        this.id_venta = id_venta;
    }

    
   
    
    public void calcularTotal(){
}        

   
    
}
