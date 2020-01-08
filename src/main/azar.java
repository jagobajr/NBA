package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import main.UsuarioJugadores;

public class azar {
	Statement st=null;
	private ArrayList<Jugador>listaJ;
	
	public azar() {
		
		anyadirJugadoresALista();
		// obtener los cinco numeros al azar
				 int[] arAzar = new int[5];
				 int i =0;
				 boolean bolRepetido = false;
				
				do {
					arAzar[i] = (int) (Math.random()*listaJ.size());
					for(int j=0; j<=i; j++) {
						if(arAzar[i] == arAzar[j]) {
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

					int idJug = usuJugador.getId_jugador();
					

					usuJugador.setId_usuarios(dameUltimoUsuario());
					
					Statement st = BaseDeDatos.getStatement();
					
					String sentencia="INSERT INTO usujugadores values(";
					sentencia = sentencia + idJug + ","+ dameUltimoUsuario()+")";
					
					System.out.println(sentencia);
					try {
						st.executeUpdate(sentencia);
						
					} catch (SQLException e) {
						LogController.log ( Level.SEVERE, "Error al repartir los jugadores " + (new Date()),e);
						e.printStackTrace();
					}
				}
	}
	
	private int dameUltimoUsuario() {
		BaseDeDatos.initBD();
		try {
			Statement st = BaseDeDatos.getStatement();
			ResultSet rs=st.executeQuery("select max(id_usuario) from usuarios");
			
			
			if(rs.getRow()>0) {
				return rs.getInt(1);
			}else {
				return 1;
			}
			
			
			
			
		} catch (SQLException e) {
			LogController.log ( Level.WARNING, "Error al obtener el ultimo usuario " + (new Date()),e);
			e.printStackTrace();
			
		}
		
		
		return 1;
		
	}
	
	


	private void anyadirJugadoresALista() {
		ArrayList<Jugador> listaJ= new ArrayList<Jugador>();
		listaJ.clear();
		BaseDeDatos.initBD();
		try {
			st=BaseDeDatos.getStatement();
			ResultSet rs=st.executeQuery("select * from jugadores");
			
			Jugador jugador=new Jugador();
			while(rs.next())
			{
				
				jugador=new Jugador();
				

				jugador.setNombre(rs.getString(2));
				jugador.setPrecio(rs.getInt(7));
				jugador.setEquipo(rs.getString(4));
				jugador.setId(rs.getString(1));
				jugador.setPuntosJornada(rs.getInt(5));
				jugador.setPuntosTotales(rs.getInt(6));
				jugador.setPosicion(rs.getString(3));
				
				listaJ.add(jugador);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
