package co.edu.unbosque.modelo;

import java.util.ArrayList;
import java.util.Random;


public class TorneoPuntos extends Torneo{
	 private int indiceActual = 0;
	 
	public TorneoPuntos(String nombre, int limiteParticipantes, String tipo, String juego) {
		super(nombre,limiteParticipantes,tipo,juego);
	}
	
	public void añadirJugador(Jugador j1) {
		if(participantes.size()<limiteParticipantes) {
		participantes.add(j1);}
		else{System.out.println("Torneo Lleno");
		}
	}
	
	
	public void iniciarRonda() {
	    if (indiceActual >= participantes.size()) {
	        System.out.println("Todos los jugadores ya tuvieron su ronda.");
	        return;
	    }
	    Jugador actual = participantes.get(indiceActual);
	    for (int j = indiceActual + 1; j < participantes.size(); j++) {
	        iniciarDuelo(actual, participantes.get(j)); 
	    }
	    listaPorPuntos(participantes);
	    indiceActual++;
	}
	
		
		
	public void iniciarDuelo(Jugador peleador1, Jugador peleador2){
		if (Math.random() < 0.5) {
		  peleador1.setPuntos(peleador1.getPuntos()+1);;
		} else {
			peleador2.setPuntos(peleador2.getPuntos()+1);
		}
		
	}
	
	public void listaPorPuntos(ArrayList<Jugador> jugadoresDespuesDeRonda) {
	    for (int i = 0; i < jugadoresDespuesDeRonda.size() - 1; i++) {
	        for (int j = i + 1; j < jugadoresDespuesDeRonda.size(); j++) {
	            Jugador jugador1 = jugadoresDespuesDeRonda.get(i);
	            Jugador jugador2 = jugadoresDespuesDeRonda.get(j);
	            
	            if (jugador1.getPuntos() < jugador2.getPuntos()) {
	                jugadoresDespuesDeRonda.set(i, jugador2);
	                jugadoresDespuesDeRonda.set(j, jugador1);
	            }
	        }
	    }
	    for (int i = 0; i < jugadoresDespuesDeRonda.size(); i++) {
	        System.out.println("Jugador en posicion " + (i + 1) + ": " + jugadoresDespuesDeRonda.get(i).getUsuario()
	                           + " - Puntos: " + jugadoresDespuesDeRonda.get(i).getPuntos());
	        "hola"
	    }
	}
	

	
	
	
	
}
