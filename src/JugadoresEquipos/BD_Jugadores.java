package JugadoresEquipos;

import java.sql.*;

public class BD_Jugadores {

	public static void main(String[]args) {
		try {
		Class.forName("org.sqlite.JDBC");


		Connection conn = DriverManager.getConnection("jdbc:sqlite:data/NBA.db");
		Statement stmt = conn.createStatement();
		// conexion abierzta
		// statement creado
		ResultSet rs = stmt.executeQuery("SELECT Nombre, Posicion, Equipo, Puntos, Precio FROM Jugadores");

		while(rs.next()) {
		String nombre = rs.getString("Nombre");
		String Posicion = rs.getString("Posicion");
		String Equipo = rs.getString("Equipo");
		String Puntos = rs.getString("Puntos");
		String Precio = rs.getString("Precio");

		System.out.println("Nombre: " + nombre + " Posicion: " + Posicion + " Equipo: " + Equipo + " Puntos: " + Puntos + " Precio: " + Precio); 
		}
		

		//ya no queremos usarla mas

		stmt.close();
		conn.close();

		}catch(ClassNotFoundException e) {
		System.out.println("No se ha podido cargar el driver");
		}catch(SQLException e) {
		System.out.println("No se ha podido cargar la BD");
		}
		
		


		}
	
	
		}
//+ "Puntos: " + Puntos);
