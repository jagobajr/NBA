package main;

public class Usuarios {
	private String idUsuario;
	private String usuario;
	private String contra;
	private String correo;
	private int dinero;
	private int puntos;
	
	
	
	public Usuarios(String idUsuario, String usuario, String contra, String correo, int dinero, int puntos) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contra = contra;
		this.correo = correo;
		this.dinero = dinero;
		this.puntos = puntos;
	}
	
	public Usuarios() {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contra = contra;
		this.correo = correo;
		this.dinero = dinero;
		this.puntos = puntos;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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
	
	public int getPuntos() {
		return dinero;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	//public static int getUsuarioId() {
       // return idUsuario;
    //}
}
