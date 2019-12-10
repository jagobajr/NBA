package JugadoresEquipos;

public class Jugador {
	
	protected String Nombre;
	protected String Equipo;
	protected int Puntos;
	protected String posicion;
	protected int Precio;
	
	public Jugador(String nombre, String posicion, String equipo, int puntos, int precio) {
		super();
		Nombre = nombre;
		Equipo = equipo;
		Puntos = puntos;
		Precio = precio;
		this.posicion = posicion;
	}
	
	public Jugador() {
		super();
		Nombre = "";
		Equipo = "";
		Puntos = 0;
		this.posicion = "";
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

	public int getPuntos() {
		return Puntos;
	}

	public void setPuntos(int puntos) {
		Puntos = puntos;
	}
	
	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Puntos = precio;
	}


	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Jugador [Nombre=" + Nombre + ", posicion=" + posicion + ", Equipo=" + Equipo + ", Puntos=" + Puntos + ", ]";
	}
	
	
	
}