package co.edu.unbosque.modelo;

public class Usuario {
	
	protected String usuario;
	protected String contraseña;
	protected String nacionalidad;
	protected String tipo;
	protected String correo;
	
	public Usuario(String usuario,String contraseña, String nacionalidad, String correo) {
		
		this.setContraseña(contraseña);
		this.setUsuario(usuario);
		this.setNacionalidad(nacionalidad);
		this.setCorreo(correo);
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
