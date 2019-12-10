package JugadoresEquipos;

public class UsuarioJugadores {

	protected static int id_usuarios;
	protected int id_jugador;
	protected String Nombre;
	protected String Equipo;
	protected int PuntosTotales;
	protected String posicion;
	protected int Precio;
	
	public UsuarioJugadores(int id_usuarios, int id_jugador,String nombre, String posicion, String equipo, int puntosTotales, int precio) {
		super();
		this.id_usuarios = id_usuarios;
		this.id_jugador = id_jugador;
		Nombre = nombre;
		Equipo = equipo;
		PuntosTotales = puntosTotales;
		Precio = precio;
		this.posicion = posicion;
	}
	
	public UsuarioJugadores() {
		super();
		this.id_usuarios=0;
		this.id_jugador=0;
		Nombre = "";
		Equipo = "";
		PuntosTotales = 0;
		this.posicion = "";
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

	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEquipo() {
		return Equipo;
	}

	public void setEquipo(String equipo) {
		Equipo = equipo;
	}

	public int getPuntosTotales() {
		return PuntosTotales;
	}

	public void setPuntosTotales(int puntosTotales) {
		PuntosTotales = puntosTotales;
	}
	
	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		PuntosTotales = precio;
	}


	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "UsuarioJugadores [id_usuarios=" + id_usuarios + ", id_jugador=" + id_jugador + 
				",Nombre=" + Nombre + ", posicion=" + posicion + ", Equipo=" + Equipo + ", Puntos=" + PuntosTotales + ", ]";
	}
	
	
}
