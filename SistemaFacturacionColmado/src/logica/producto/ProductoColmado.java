
package logica.producto;

public class ProductoColmado implements Producto {
    
    static protected int id_producto = 0;
    protected String nombre;
    protected double precio;
    protected int cantidad;
    protected String unidad_medida;

    public ProductoColmado() {
        ++id_producto;
    }

    
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    
    
    
    @Override
    public void agregarProducto() {
        
      
    }

    @Override
    public void editarProducto() {

    }

    @Override
    public void mostrarProducto() {

    }

    @Override
    public void eliminarProducto() {

    }
    
   


}
