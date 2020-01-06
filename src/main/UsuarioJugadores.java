package main;

public class UsuarioJugadores {

	private String id_usuarios;
	private String id_jugador;
	private int PuntosTotales;
	
	
	public UsuarioJugadores(String id_usuarios, String id_jugador, int puntosTotales) {
		super();
		this.id_usuarios = id_usuarios;
		this.id_jugador = id_jugador;
		PuntosTotales = puntosTotales;
	}
	
	public UsuarioJugadores() {
		super();
		this.id_usuarios="";
		this.id_jugador="";
		PuntosTotales = 0;
	}

	public String getId_usuarios() {
		return id_usuarios;
	}

	public void setId_usuarios(String id_usuarios) {
		this.id_usuarios = id_usuarios;
	}

	public String getId_jugador() {
		return id_jugador;
	}

	public void setId_jugador(String id_jugador) {
		this.id_jugador = id_jugador;
	}

	public int getPuntosTotales() {
		return PuntosTotales;
	}

	public void setPuntosTotales(int puntosTotales) {
		PuntosTotales = puntosTotales;
	}
	
	


	

	@Override
	public String toString() {
		return "UsuarioJugadores [id_usuarios=" + id_usuarios + ", id_jugador=" + id_jugador + 
				", Puntos=" + PuntosTotales + ", ]";
	}
	
	
}
