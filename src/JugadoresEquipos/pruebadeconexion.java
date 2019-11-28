package JugadoresEquipos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JugadoresEquipos.BaseDeDatos;

public class pruebadeconexion {
	
	

	public static void main(String[] args) {
		BaseDeDatos.initBD("jdbc:sqlite:data/NBA.db");
		Statement stmt=BaseDeDatos.getStatement();

		try {
		
			ResultSet rs = stmt.executeQuery("SELECT * FROM Jugadores");

			while(rs.next()) {
			String nombre = rs.getString("Nombre");
			String Posicion = rs.getString("Posicion");
			String Equipo = rs.getString("Equipo");
			String PuntosJornada = rs.getString("PuntosJornada");
			String Precio = rs.getString("Precio");

			System.out.println("Nombre: " + nombre + " Posicion: " + Posicion + " Equipo: " + Equipo + " PuntosJornada: " + PuntosJornada + " Precio: " + Precio); 
			}
			

			//ya no queremos usarla mas

			BaseDeDatos.close();

			}catch(SQLException e) {
			System.out.println("No se ha podido cargar la BD");
			}
	}

}
