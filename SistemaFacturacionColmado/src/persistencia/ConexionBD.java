
package persistencia;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static ConexionBD instancia;

    private Connection conexion;

    private final String URL = "jdbc:mysql://localhost:3306/colmadodatosgenerales"; 
    private final String USUARIO = "root";
    private final String CLAVE = "mysql123456"; 

    private ConexionBD() {
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conectado a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

   
}

