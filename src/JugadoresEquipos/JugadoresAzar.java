package JugadoresEquipos;


import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JugadoresAzar extends Jugador{
	
	
	private Connection con = null;
	public class conexion {

		
		    
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
	

	
	
	public ArrayList<Jugador> getjugadores() throws DBException{
		
	ArrayList<Jugador> jugadores= new ArrayList<Jugador>();	
	
	
	try (Statement stmt=con.createStatement()){
		ResultSet rs= stmt.executeQuery("SELECT Nombre, Posicion, Equipo, Puntos from Jugadores");
		
		while(rs.next()) {
			Jugador Jugador= new Jugador();
			Jugador.setNombre(rs.getString("Nombre"));
			Jugador.setPosicion(rs.getString("Posicion"));
			Jugador.setEquipo(rs.getString("Equipo"));
			Jugador.setPuntos(rs.getInt("Puntos"));
			jugadores.add(Jugador);
			
		}
	}catch (SQLException e) {
		throw new DBException("Error obteniendo los jugadores,e");
	}
	return jugadores;
	}
	
	public static void main(String[]args){
		ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
		
		System.out.println(jugadores);
	}

}

