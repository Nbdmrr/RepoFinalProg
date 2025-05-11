package co.edu.unbosque.modelo;

import java.util.ArrayList;

public class Equipo {
	
	private String nombre;
	private ArrayList<Jugador> equipo;
	private Entrenador entrenador1;
	private Entrenador entrenador2;
	private Entrenador entrenador3;
	
	
	public Equipo(String nombre,Entrenador entrenador1) {
		
		this.setNombre(nombre);
		this.setEntrenador1(entrenador1);
		entrenador2 = null;
		entrenador3 = null;
			
	}


	public ArrayList<Jugador> getEquipo() {
		return equipo;
	}


	public void setEquipo(ArrayList<Jugador> equipo) {
		this.equipo = equipo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Entrenador getEntrenador3() {
		return entrenador3;
	}


	public void setEntrenador3(Entrenador entrenador3) {
		this.entrenador3 = entrenador3;
	}


	public Entrenador getEntrenador2() {
		return entrenador2;
	}


	public void setEntrenador2(Entrenador entrenador2) {
		this.entrenador2 = entrenador2;
	}


	public Entrenador getEntrenador1() {
		return entrenador1;
	}


	public void setEntrenador1(Entrenador entrenador1) {
		this.entrenador1 = entrenador1;
	}
	
	

}
