package co.edu.unbosque.modelo;

public class Administrador extends Usuario{
	
	private String cargo;
	
	
	public Administrador(String usuario, String contraseña, String nacionalidad, String correo,String cargo) {
	super(usuario,contraseña,nacionalidad,correo);
     tipo = "Administrador";
     this.setCargo(cargo);
	
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
