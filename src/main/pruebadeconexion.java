package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.BaseDeDatos;

public class pruebadeconexion {
	
	//commit
	
	public static void main(String[] args) throws SQLException {
		
		

		try(Statement st= BaseDeDatos.initBD().createStatement();) {
		
			ResultSet rs = st.executeQuery("SELECT * FROM Jugadores");

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
		
		try(Statement st= BaseDeDatos.initBD().createStatement();) {
			
			ResultSet rs = st.executeQuery("SELECT * FROM Usuarios");

			while(rs.next()) {
			String nombre = rs.getString("Usuario");
			String password = rs.getString("Password");
			String correo = rs.getString("Correo");
			String dinero = rs.getString("Dinero");

			System.out.println("Usuario: " + nombre + " Password: " + password + " Correo: " + correo + " Dinero: " + dinero ); 
			}
			

			//ya no queremos usarla mas

			BaseDeDatos.close();

			}catch(SQLException e) {
			System.out.println("No se ha podido cargar la BD");
			}
	}

}
