package main;

public class Usuarios {
	private int id;
	private String usuario;
	private String contra;
	private String correo;
	private int dinero;
	private int idTipo;
	
	
	
	public Usuarios(int id, String usuario, String contra, String correo, int dinero, int idTipo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contra = contra;
		this.correo = correo;
		this.dinero = dinero;
		this.idTipo = idTipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int id) {
		this.idTipo = id;
	}
}
