package co.edu.unbosque.modelo;

import java.util.ArrayList;

/**
 * Clase que representa un administrador, que es un tipo de usuario.
 * Contiene además el cargo que desempeña el administrador.
 */
public class Administrador extends Usuario {
	
	/** Cargo o posición del administrador */
	private String cargo;
	
	/**
	 * Constructor de la clase Administrador.
	 * 
	 * @param usuario Nombre de usuario
	 * @param contraseña Contraseña del usuario
	 * @param nacionalidad Nacionalidad del administrador
	 * @param correo Correo electrónico del administrador
	 * @param cargo Cargo o posición que desempeña
	 */
	public Administrador(String usuario, String contraseña, String nacionalidad, String correo, String cargo) {
		super(usuario, contraseña, nacionalidad, correo);
		tipo = "Administrador";
		this.setCargo(cargo);
	}

	/**
	 * Obtiene el cargo del administrador.
	 * 
	 * @return cargo del administrador
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Establece el cargo del administrador.
	 * 
	 * @param cargo cargo a asignar al administrador
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

	

}
