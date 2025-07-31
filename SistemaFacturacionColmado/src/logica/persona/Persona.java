package logica.persona;

public abstract class Persona {
    
    protected String nombre;
    protected int cedula;
    protected int numero;

    public Persona(String nombre, int cedula, int numero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numero = numero;
    }

    public Persona(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
   

  
  

 
    
    
    public void mostrarDatos(){
        
    }
    
      public void editarDatos(){
        
    }
    
    
}
