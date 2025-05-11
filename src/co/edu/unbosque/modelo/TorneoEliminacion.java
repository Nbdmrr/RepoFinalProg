package co.edu.unbosque.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TorneoEliminacion extends Torneo{
	
	
   
	private String[][] cronograma;
    private LocalDate[] fechas;
    private ArrayList<Jugador> ganadores;
    private Jugador ganadorTorneo;
    
    
	public TorneoEliminacion(String nombre, int limiteparticipantes,String tipo, String juego) {
		
		
		super(nombre,limiteparticipantes,tipo,juego);
		
		
		
	}
	public void generarCronograma() {
		int fases = 0;
		int participantesRestantes = limiteParticipantes;
		while (participantesRestantes > 1) {
		    if (participantesRestantes % 2 == 0) {  // Solo si es par
		        participantesRestantes = participantesRestantes / 2;
		        fases++;
		    } else {
		        	    }
		}
        cronograma=new String[fases][];
        fechas=new LocalDate[fases];
        fase = 0;

        LocalDate fechaInicial = LocalDate.now().plusDays(1);
        int partidas = participantes.size() / 2;

        cronograma[0]= new String[partidas];
        fechas[0] = fechaInicial;

        for (int j = 0; j < partidas; j++) {
            String jugador1 = participantes.get(j * 2).getUsuario();
            String jugador2 = participantes.get(j * 2 + 1).getUsuario();
            getCronograma()[0][j] = "Fase 1 (" + getFechas()[0] + "): " + jugador1 + " vs " + jugador2;
        }

        for (int i = 1; i < fases; i++) {
            partidas /= 2;
            cronograma[i] = new String[partidas];
           fechas[i] = fechaInicial.plusDays(i);

            for (int j = 0; j < partidas; j++) {
                cronograma[i][j] = "Fase " + (i + 1) + " (" + getFechas()[i] + "): Pendiente";
            }
        }
    }

    public void actualizarCronograma(List<Jugador> ganadores) {
        if (fase >= getCronograma().length - 1) {
            System.out.println("El torneo ha finalizado.");
            return;
        }

        int partidos = ganadores.size() / 2;
        int faseSiguiente = fase + 1;

        for (int j = 0; j < partidos; j++) {
            if (cronograma[faseSiguiente][j].contains("Pendiente")) {
                String jugador1 = ganadores.get(j * 2).getUsuario();
                String jugador2 = ganadores.get(j * 2 + 1).getUsuario();
                cronograma[faseSiguiente][j] = "Fase " + (faseSiguiente + 1) + " (" + getFechas()[faseSiguiente] + "): " + jugador1 + " vs " + jugador2;
            }
        }

        fase++;
    }

    public void mostrarCronograma() {
        for (int i = 0; i < getCronograma().length; i++) {
            for (String partido : getCronograma()[i]) {
                System.out.println(partido);
            }
        }
    }
    
	public Jugador getGanadorTorneo() {
		return ganadorTorneo;
	}
	public void setGanadorTorneo(Jugador ganadorTorneo) {
		this.ganadorTorneo = ganadorTorneo;
	}
	public ArrayList<Jugador> getGanadores() {
		return ganadores;
	}
	public void setGanadores(ArrayList<Jugador> ganadores) {
		this.ganadores = ganadores;
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
	    
	    



	
	


