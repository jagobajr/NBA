package NBA.login;

public class Usuarios {
	private int id;
	private String usuario;
	private String contraseña;
	private String correo;
	private int idTipo;
	
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
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int id) {
		this.idTipo = idTipo;
	}
}
