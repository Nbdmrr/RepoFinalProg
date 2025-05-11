package co.edu.unbosque.modelo.persistencia;

import java.util.ArrayList;




public class EquipoDTO {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<JugadorDTO> equipo;
	private EntrenadorDTO entrenador1;
	private EntrenadorDTO entrenador2;
	private EntrenadorDTO entrenador3;
	
	
	
	
	
	public EntrenadorDTO getEntrenador3() {
		return entrenador3;
	}
	public void setEntrenador3(EntrenadorDTO entrenador3) {
		this.entrenador3 = entrenador3;
	}
	public EntrenadorDTO getEntrenador2() {
		return entrenador2;
	}
	public void setEntrenador2(EntrenadorDTO entrenador2) {
		this.entrenador2 = entrenador2;
	}
	public EntrenadorDTO getEntrenador1() {
		return entrenador1;
	}
	public void setEntrenador1(EntrenadorDTO entrenador1) {
		this.entrenador1 = entrenador1;
	}
	public ArrayList<JugadorDTO> getEquipo() {
		return equipo;
	}
	public void setEquipo(ArrayList<JugadorDTO> equipo) {
		this.equipo = equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
