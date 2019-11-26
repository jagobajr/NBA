package JugadoresEquipos;

public class Jugador {
	
	protected String Id;
	protected String Nombre;
	protected String Equipo;
	protected int PuntosJornada;
	protected int PuntosTotales;
	protected String posicion;
	protected int Precio;
	
	public Jugador(String nombre, String posicion, String equipo, int puntosJornada, int puntosTotales, int precio) {
		super();
		Nombre = nombre;
		Equipo = equipo;
		PuntosJornada = puntosJornada;
		PuntosTotales = puntosTotales;
		Precio = precio;
		this.posicion = posicion;
	}
	
	public Jugador() {
		super();
		Nombre = "";
		Equipo = "";
		PuntosJornada = 0;
		PuntosTotales = 0;
		this.posicion = "";
	}

	public String getId() {
		return Nombre;
	}

	public void setId(String id) {
		id = id;
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

	public int getPuntosJornada() {
		return PuntosJornada;
	}

	public void setPuntosJornada(int puntosJornada) {
		PuntosJornada = puntosJornada;
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
		Precio = precio;
	}


	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Jugador [Nombre=" + Nombre + ", posicion=" + posicion + ", Equipo=" + Equipo + ", PuntosJornada=" + PuntosJornada + ", PuntosTotales=" + PuntosTotales + " ,]";
	}
	
	

}
