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


public class JugadoresAzar extends UsuarioJugadores {


	
	
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
		            Logger.getLogger(initBD.class.getName()).log(Level.SEVERE, null, ex);
		        }
		      return con;  
		    } 
	}
	

	
	
	public ArrayList<Jugador> getjugadores() throws Exception{
		
	ArrayList<Jugador> jugadores= new ArrayList<Jugador>();	
	
	
	try (Statement stmt=con.createStatement()){
		ResultSet rs= stmt.executeQuery("SELECT Nombre, Posicion, Equipo, Puntos, Precio from Jugadores");
		
		while(rs.next()) {
			Jugador Jugador= new Jugador();
			Jugador.setNombre(rs.getString("Nombre"));
			Jugador.setPosicion(rs.getString("Posicion"));
			Jugador.setEquipo(rs.getString("Equipo"));
			Jugador.setPuntosJornada(rs.getInt("Puntos"));
			Jugador.setPrecio(rs.getInt("Precio"));
			jugadores.add(Jugador);
			
		}
	}catch (SQLException e) {
		throw new Exception("Error obteniendo los jugadores",e);
	}
	return jugadores;
	}
	
	
	public static void main(String[]args){
		// obtener los cinco numeros al azar
		 int[] arAzar = new int[5];
		 int i =0;
		 boolean bolRepetido = false;
		ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
		do {
			arAzar[i] = (int) (Math.random()*jugadores.size());
			for(int j=0; j<=i; j++) {
				if(arAzar[i-1] == arAzar[j]) {
					bolRepetido = true;
					break;
				}
			}
			if(!bolRepetido) {
				i++;
			}
			
			bolRepetido = false;
		}while(i<5);
		
		// obtener los cinco jugadores 
		
			UsuarioJugadores usuJugador = new UsuarioJugadores();
		
		for (int h=0; h<5; h++){
			usuJugador.setId_jugador(arAzar[h]);

			//usuJugador.setId_usuarios

			usuJugador.setId_usuarios(usuJugador.getId_usuarios());
 // of https://github.com/jagobajr/NBA.git
			//usuJugador.setId_usuarios(id_usuarios);
			//falta id usuario que hay que crearlo con la funcion dameUltimoRegistro 
			// inserta registro en bd 
			//hay crear el nueva intancia el usuJugadores
		}
				
		
		System.out.println(jugadores.size());
	}

}

