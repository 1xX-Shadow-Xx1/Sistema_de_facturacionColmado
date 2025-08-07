package logica.persona;

public abstract class Persona {
    
    protected String nombre;
    protected String cedula;
    protected int numero;

    public Persona() {
       
    }

    
    
    public Persona(String nombre, String cedula, int numero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numero = numero;
    }

    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
   

  
  

 
    
    
    public void mostrarDatos(){
        
    }
    
      public void editarDatos(){
        
    }
    
    
}
