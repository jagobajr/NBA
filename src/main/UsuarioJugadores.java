package main;

public class UsuarioJugadores {

	private int id_usuarios;
	private int id_jugador;
	private int PuntosTotales;
	
	
	public UsuarioJugadores(int id_usuarios, int id_jugador, int puntosTotales) {
		super();
		this.id_usuarios = id_usuarios;
		this.id_jugador = id_jugador;
		PuntosTotales = puntosTotales;
	}
	
	public UsuarioJugadores() {
		super();
		this.id_usuarios=0;
		this.id_jugador=0;
		PuntosTotales = 0;
	}

	public int getId_usuarios() {
		return id_usuarios;
	}

	public void setId_usuarios(int id_usuarios) {
		this.id_usuarios = id_usuarios;
	}

	public int getId_jugador() {
		return id_jugador;
	}

	public void setId_jugador(int id_jugador) {
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
