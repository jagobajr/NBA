package JugadoresEquipos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionRegistro {

    private Connection con = null;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("org.sqlite.JDBC");
            con = (Connection) DriverManager.getConnection("jdbc:sqlite:BaseDeDatos.db");
            
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
      return con;  
    }
}
  