package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Jugador 
{
	private String nombre;
	private String id;
	private String equipo;
	private int precio;
	private int puntosJornada;
	private int puntosTotales;
	private String posicion;
	
	public Jugador()
	{
		nombre="";
		equipo="";
		precio=0;
		puntosJornada=0;
		puntosTotales=0;
		posicion="";
	}
	public String getId() {
			return id;
	}
	public void setId(String id) {
			this.id = id;
		
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getPuntosJornada() {
		return puntosJornada;
	}
	public void setPuntosJornada(int puntosJornada) {
		this.puntosJornada = puntosJornada;
	}
	public int getPuntosTotales() {
		return puntosTotales;
	}
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	
	
	
	
	public int testJugadoresEnBaseDatos(ArrayList <Jugador>lista,Statement st){
		
		BaseDeDatos.initBD();
		st=BaseDeDatos.getStatement();
		lista.clear();
		
		try {
			ResultSet rs=st.executeQuery("select * from Jugadores");
			
			Jugador jugador=new Jugador();
			while(rs.next())
			{
				
				jugador=new Jugador();
				
				jugador.setId(rs.getString(1));
				jugador.setNombre(rs.getString(2));
				jugador.setPosicion(rs.getString(3));
				jugador.setEquipo(rs.getString(4));
				jugador.setPuntosJornada(rs.getInt(5));
				jugador.setPuntosTotales(rs.getInt(6));
				jugador.setPrecio(rs.getInt(7));
				
				lista.add(jugador);
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista.size();
	}
	public static void main(String[] args) {
		System.out.println();
	}


}