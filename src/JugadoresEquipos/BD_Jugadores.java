package JugadoresEquipos;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class BD_Jugadores {
	
	private static Connection connection = null;
	private static Statement statement = null;

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

	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}

	
	/** Crea una tabla de catálogo multimedia en una base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaUsuarios() {
	if (statement==null) return;//para que alguien no nos llame antes de initBD
	try {
			statement.executeUpdate("create table usuarios " + "(numIdentificador int, id string, contraseña string, dinero double" +")");
	} catch (SQLException e) {
		// Si hay excepción es que la tabla ya existía (lo cual es correcto)
		// e.printStackTrace();  
	}
	}
	public static void crearTablaUsuarioJugadores(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table UsuarioJugadores " + "(idUsuario string, idJugador string" +")");
		}catch(SQLException e){
			
		}
		
		
		
	}
	
public static void crearTablaPorterosSalidos(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table porterosSalidos " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
		}catch(SQLException e){
			
		}
		
		
	}
public static void crearTablaDefensasSalidos(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table defensasSalidos " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
		}catch(SQLException e){
			
		}
		
		
	}
public static void crearTablaMediosSalidos(){
	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table mediosSalidos " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		
	}
	
	
}
public static void crearTablaDelanterosSalidos(){
	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table delanterosSalidos " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		
	}
	
	
}
	
	
	
	/** Cierra la conexión con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void crearTablaJugadores() 
	{
		if (statement==null) return;//para que alguien no nos llame antes de initBD
		try {
				statement.executeUpdate("create table jugadores " + "(id string, nombre string, equipo string, posicion string, edad int, puntosJornada int, puntosTotales int" +")");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
		}
	
//	public static void crearTablaPuntosJornada(){
//		
//		if(statement==null) return;
//		try{
//			
//			statement.executeUpdate("create table puntosjornada " + "(idJugador string, numJornada int, PuntosJornada1 int" +")");
//		}catch(SQLException e){
//			
//		}
//		
//		
//	}
public static void crearTablaMercadoDeFichajes(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table mercadoDeFichajes " + "(idJugador string, nombre string, precio int, puntosTotales int" +")");
		}catch(SQLException e){
			
		}
		
		
	}
public static void crearTablaClasificacion(){
	if(statement==null) return;
	
	try{
		statement.executeUpdate("create table clasificacion"+ "(Posicion string,idJugador string, PuntosJornada string,  PuntosTotales string"+")");
	}catch(SQLException e){
		
		
		
	}
	
	
}
	
	
	
		
	}