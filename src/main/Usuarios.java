package main;

public class Usuarios {
	private String idUsuario;
	private String usuario;
	private String password;
	private String correo;
	private int dinero;
	private String idTipo;
	
	
	
	
	public Usuarios(String idUsuario, String usuario, String password, String correo, int dinero, String idTipo) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.dinero = dinero;
		this.idTipo = idTipo;
	}
	
	public Usuarios() {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.dinero = dinero;
		this.idTipo = idTipo;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(String idUsuario) {
		this.idTipo = idUsuario;
	}
}
