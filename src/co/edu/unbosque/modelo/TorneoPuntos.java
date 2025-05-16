package co.edu.unbosque.modelo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;


public class TorneoPuntos extends Torneo{
	 
	 private String[][] cronograma;
	    private LocalDate[] fechas;
	    private Jugador ganadorTorneo;
	
	 
	 
	public TorneoPuntos(String nombre, int limiteParticipantes, String tipo, String juego) {
		super(nombre,limiteParticipantes,tipo,juego);
	}
	
	public void añadirJugador(Jugador j1) {
		if(participantes.size()<limiteParticipantes) {
			if (j1.getPuntos()==0) {
		participantes.add(j1);}
			
		else if (j1.getPuntos()!=0) {
			
			JOptionPane.showMessageDialog(
				    null, 
				    "El usuario ya está registrado en un torneo por puntos", 
				    "Advertencia", 
				    JOptionPane.WARNING_MESSAGE
				);
		}
			}
		else{JOptionPane.showMessageDialog(
			    null, 
			    "Torneo lleno", 
			    "Advertencia", 
			    JOptionPane.WARNING_MESSAGE
			);
		}
	}
	

	
	
	public void generarCronogramaPorPuntos() {
	    actualizarEstadisticaTorneosJugados();

	    int n = participantes.size();
	    int totalFases = n - 1; // Porque el último ya peleó con todos antes

	    setCronograma(new String[totalFases][]);
	    setFechas(new LocalDate[totalFases]);
	    fase = 0;

	    LocalDate fechaInicial = LocalDate.now().plusDays(1);

	    for (int i = 0; i < totalFases; i++) {
	        int cantidadDuelo = n - i - 1; // jugador i vs (i+1) hasta n-1
	        getCronograma()[i] = new String[cantidadDuelo];
	        getFechas()[i] = fechaInicial.plusDays(i);

	        String jugadorA = participantes.get(i).getUsuario();

	        for (int j = i + 1, k = 0; j < n; j++, k++) {
	            String jugadorB = participantes.get(j).getUsuario();
	            getCronograma()[i][k] = "Fase " + (i + 1) + " (" + getFechas()[i] + "): " + jugadorA + " vs " + jugadorB;
	        }
	    }
	}
	public void avanzarFasePorPuntos() {
	    if (fase >= participantes.size()) {
	        System.out.println("El torneo ya ha finalizado.");
	        return;
	    }

	    Jugador jugadorActual = participantes.get(fase);

	    System.out.println("Fase " + (fase + 1) + ": " + jugadorActual.getUsuario() + " vs todos los demás");

	    for (int i = 0; i < participantes.size(); i++) {
	        if (i == fase) continue;

	        Jugador oponente = participantes.get(i);
	        Jugador ganador = Math.random() < 0.5 ? jugadorActual : oponente;

	        // Estadísticas
	        ganador.sumarPartidaGanada();
	        jugadorActual.sumarPartidaJugada();
	        oponente.sumarPartidaJugada();

	        ganador.setPuntos(ganador.getPuntos() + 1);

	        System.out.println(jugadorActual.getUsuario() + " vs " + oponente.getUsuario() + " -> Ganador: " + ganador.getUsuario());
	    }

	    fase++;

	    // Si ya todos han jugado (última fase completada)
	    if (fase >= participantes.size()) {
	        // Buscar el mayor puntaje
	        int maxPuntos = participantes.stream().mapToInt(Jugador::getPuntos).max().orElse(0);

	        // Buscar todos los jugadores con ese puntaje
	        List<Jugador> empatados = new ArrayList<>();
	        for (Jugador j : participantes) {
	            if (j.getPuntos() == maxPuntos) {
	                empatados.add(j);
	            }
	        }

	        if (empatados.size() == 1) {
	            setGanadorTorneo(empatados.get(0));
	            getGanadorTorneo().sumarTorneoGanado();
	            System.out.println("¡El torneo ha finalizado! Ganador: " + getGanadorTorneo().getUsuario());
	            estado = "Terminado";

	            // Reiniciar puntos de todos los jugadores
	            for (Jugador j : participantes) {
	                j.setPuntos(0);
	            }
	        } else {
	            // Desempate
	            System.out.println("Hay un empate. Iniciando ronda de desempate entre:");
	            for (Jugador j : empatados) {
	                System.out.println("- " + j.getUsuario());
	            }
	            desempatar(empatados);
	        }
	    }
	}

	private void desempatar(List<Jugador> empatados) {
	    List<Jugador> nuevosEmpatados = new ArrayList<>(empatados);

	    while (nuevosEmpatados.size() > 1) {
	        System.out.println("Ronda de desempate...");

	        // Reiniciar puntos antes de desempate
	        for (Jugador j : nuevosEmpatados) {
	            j.setPuntos(0);
	        }

	        for (int i = 0; i < nuevosEmpatados.size(); i++) {
	            Jugador jugadorActual = nuevosEmpatados.get(i);
	            for (int j = 0; j < nuevosEmpatados.size(); j++) {
	                if (i == j) continue;
	                Jugador oponente = nuevosEmpatados.get(j);
	                Jugador ganador = Math.random() < 0.5 ? jugadorActual : oponente;

	                ganador.setPuntos(ganador.getPuntos() + 1);
	            }
	        }

	        int maxPuntos = nuevosEmpatados.stream().mapToInt(Jugador::getPuntos).max().orElse(0);
	        nuevosEmpatados = nuevosEmpatados.stream().filter(j -> j.getPuntos() == maxPuntos).toList();
	    }

	    setGanadorTorneo(nuevosEmpatados.get(0));
	    getGanadorTorneo().sumarTorneoGanado();
	    System.out.println("¡El torneo ha finalizado! Ganador tras desempate: " + getGanadorTorneo().getUsuario());
	    estado = "Terminado";

	    // Reiniciar puntos
	    for (Jugador j : participantes) {
	        j.setPuntos(0);
	    }
	}

	public Jugador getGanadorTorneo() {
		return ganadorTorneo;
	}

	public void setGanadorTorneo(Jugador ganadorTorneo) {
		this.ganadorTorneo = ganadorTorneo;
	}

	public LocalDate[] getFechas() {
		return fechas;
	}

	public void setFechas(LocalDate[] fechas) {
		this.fechas = fechas;
	}

	public String[][] getCronograma() {
		return cronograma;
	}

	public void setCronograma(String[][] cronograma) {
		this.cronograma = cronograma;
	}



	
		
		
	
	 
	    	
	    
    
	

	
	
	
	
}
