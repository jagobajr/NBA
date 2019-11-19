package JugadoresEquipos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class plantilla_conexion {

	public class conexion {

		private Connection con = null;
		    
		 public Connection getConexion() {
		        
		        try{
		            Class.forName("org.sqlite.JDBC");
		            con = (Connection) DriverManager.getConnection("jdbc:sqlite:data/NBA.db");
		            
		        } catch(SQLException e)
		        {
		            System.err.println(e);
		        } catch (ClassNotFoundException ex) {
		            Logger.getLogger(plantilla_conexion.class.getName()).log(Level.SEVERE, null, ex);
		        }
		      return con;  
		    }
		
		 
		 
	}

}
