package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;



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
			LogController.log(Level.INFO, "Conectada base de datos ", null );
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
			LogController.log( Level.SEVERE, "Error en conexi�n de base de datos ", e );
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
			LogController.log( Level.SEVERE, "Error en conexi�n de base de datos " , e );
			e.printStackTrace();
		}
	}


	public static void tablaClasificacion(Usuarios usr) {
		PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = initBD();

		String sql =("SELECT Nombre,PuntosTotales from jugadores order by puntosTotales asc");
		System.out.println(sql);
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usr.getUsuario());
			ps.setInt(6, usr.getPuntos());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void crearTablaUsuarioJugadores(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table UsuarioJugadores " + "(idUsuario string, idJugador string" +")");
		}catch(SQLException e){
			LogController.log( Level.SEVERE, "Error al crear tabla " , e );
		}
		
	}
	
	
    public static void crearTablaBasesSalidos(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table basesSalidos " + "(id int, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
		}catch(SQLException e){
			LogController.log( Level.SEVERE, "Error al crear tabla bases salidos " , e );
		}
		
		
	}
    public static void crearTablaEscoltasSalidos(){
		
		if(statement==null) return;
		try{
			
			statement.executeUpdate("create table escoltasSalidos " + "(id int, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
		}catch(SQLException e){
			LogController.log( Level.SEVERE, "Error al crear tabla escoltas salidos" , e );
		}
		
		
	}
    public static void crearTablaAlerosSalidos(){
 	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table alerosSalidos " + "(id int, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		LogController.log( Level.SEVERE, "Error al crear tabla aleros salidos" , e );
		
	}
	
	
}
    public static void crearTablaAlapivotSalidos(){
	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table alapivotSalidos " + "(id int, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		LogController.log( Level.SEVERE, "Error al crear tabla ala-pivots salidos" , e );
		
	}
	
	
}
	
    public static void crearTablaPivotSalidos(){
	
	if(statement==null) return;
	try{
		
		statement.executeUpdate("create table pivotSalidos " + "(id string, nombre string, equipo string, posicion string, precio int, puntosJornada int, puntosTotales int" +")");
	}catch(SQLException e){
		LogController.log( Level.SEVERE, "Error al crear tabla pivots salidos" , e );
		
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