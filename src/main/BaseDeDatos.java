package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BaseDeDatos 
{

	private static Connection connection = null;
	private static Statement statement = null;
	

	// Inicializa una BD SQLITE y devuelve una conexion con ella. Debe llamarse a este 
	// metodo antes que ningun otro, y debe devolver no null para poder seguir trabajando con la BD.
	// @param nombreBD	Nombre de fichero de la base de datos
	// @return	Conexion con la base de datos indicada. Si hay algun error, se devuelve null
	 
	public static Connection initBD() {
		try {
		    Class.forName("org.sqlite.JDBC");

		    connection = DriverManager.getConnection("jdbc:sqlite:BaseDeDatos.db" );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexion!! No se ha podido conectar con ", "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexion!! No se ha podido conectar con " );
			return null;
		}
	}
	
	// Devuelve la conexion si ha sido establecida previamente (#initBD()).
	 // @return	Conexion con la BD, null si no se ha establecido correctamente.
	 
	public static Connection getConnection() {
		return connection;
	}
	
	
	public static Statement getStatement() {
		return statement;
	}
	public static Connection initUsuario() {
		try {
		    Class.forName("org.sqlite.JDBC");

		    connection = DriverManager.getConnection("jdbc:sqlite:usuarios.db" );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexion!! No se ha podido conectar con ", "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error de conexion!! No se ha podido conectar con " );
			return null;
		}
	}
	
	// Devuelve la conexion si ha sido establecida previamente (#initBD()).
	 // @return	Conexion con la BD, null si no se ha establecido correctamente.
	 
	
	//Cierra la conexion con la Base de Datos
	 
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//public static void crearTablaUsuarios() {
	//if (statement==null) return;//para que alguien no nos llame antes de initBD
	//try {
//			statement.executeUpdate("create table usuarios " + "(numIdentificador int, id string, contrase�a string, dinero double" +")");
	//} catch (SQLException e) {
		// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
		// e.printStackTrace();  
//	}
	//}
	
	
    public static void crearTablaUsuarioJugadores(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table UsuarioJugadores " + "(idUsuario string, idJugador string" +")");
		}catch(SQLException e){
			
		}
		
		
		
	}
	
	
    public static void crearTablaBasesSalidos(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table basesSalidos " + "(id int, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
		}catch(SQLException e){
			
		}
		
		
	}
    public static void crearTablaEscoltasSalidos(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table escoltasSalidos " + "(id int, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
		}catch(SQLException e){
			
		}
		
		
	}
    public static void crearTablaAlerosSalidos(){
 	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table alerosSalidos " + "(id int, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		
	}
	
	
}
    public static void crearTablaAlapivotSalidos(){
	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table alapivotSalidos " + "(id int, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		
	}
	
	
}
	
    public static void crearTablaPivotSalidos(){
	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table pivotSalidos " + "(id string, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		
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