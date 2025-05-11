package co.edu.unbosque.modelo;

public class Entrenador extends Usuario{
	
	
	private String equipo;
	
	public Entrenador(String ususario,String contraseña, String nacionalidad,String correo,String equipo) {
	
	super(ususario,contraseña,nacionalidad, correo);
	
	this.setEquipo(equipo);
	
	tipo="Entrenador";
	
	}

	public String getEquipo() {
		
		return equipo;
		
	}

	public void setEquipo(String equipo) {
		
		this.equipo = equipo;
	}		

}
