
package logica.factura;

import java.util.ArrayList;
import java.util.List;
import logica.producto.ProductoColmado;

public class Factura implements Facturable {
    
    protected int id_factura;
    protected int fecha;
    //protected Object Cliente;
    protected double total;
    List<ProductoColmado> nombres_productos = new ArrayList<>(); 

    public Factura(int id_factura, int fecha, double total) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.total = total;
    }

    
    
    @Override
    public void generarFactura() {

    }

            
}
