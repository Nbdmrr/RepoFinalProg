package co.edu.unbosque.modelo;

import java.util.ArrayList;

public class Torneo {
	
	
	protected ArrayList<Jugador> participantes;
	protected String tipo;
	protected String nombre;
	protected int limiteParticipantes;
	private int cantidadEliminados;
	protected String juego;
	protected int fase;
	protected String estado;
	
	
	
	
	 public Torneo(String nombre, int limiteParticipantes, String tipo, String juego) {
		 participantes = new ArrayList<Jugador>();
		 this.fase = 1;
		 this.nombre= nombre;
		 this.limiteParticipantes=limiteParticipantes;
		 this.tipo=tipo;
		 this.setJuego(juego);
		 this.setEstado("preparando");
		 setCantidadEliminados(0);
		 
		 
		
	}


	


	public int getLimiteParticipantes() {
		return limiteParticipantes;
	}


	public void setLimiteParticipantes(int limiteParticipantes) {
		this.limiteParticipantes = limiteParticipantes;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public ArrayList<Jugador> getParticipantes() {
		return participantes;
	}


	public void setParticipantes(ArrayList<Jugador> participantes) {
		this.participantes = participantes;
	}
	@Override
	
	public String toString() {
		
		
		return"Nombre del torneo: "+ nombre;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getFase() {
		return fase;
	}


	public void setFase(int fase) {
		this.fase = fase;
	}


	public String getJuego() {
		return juego;
	}


	public void setJuego(String juego) {
		this.juego = juego;
	}


	





	public int getCantidadEliminados() {
		return cantidadEliminados;
	}





	public void setCantidadEliminados(int cantidadEliminados) {
		this.cantidadEliminados = cantidadEliminados;
	}

}
