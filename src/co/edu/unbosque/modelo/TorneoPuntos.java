package co.edu.unbosque.modelo;


import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class TorneoPuntos extends Torneo{
	 private int indiceActual = 0;
	 private String[][] cronograma;
	    private LocalDate[] fechas;
	
	 
	 
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
	
	
	public void iniciarRonda() {
	    if (indiceActual >= participantes.size()) {
	        System.out.println("Todos los jugadores ya tuvieron su ronda.");
	        return;
	    }
	    
	    if (indiceActual == 0) {
	        fechas = new LocalDate[participantes.size()];
	        fechas[0] = LocalDate.now().plusDays(1);
	        cronograma = new String[participantes.size()][];
	    }
	    
	    int partidosEnRonda = participantes.size() - indiceActual - 1;
	    cronograma[indiceActual] = new String[partidosEnRonda];
	    
	    Jugador actual = participantes.get(indiceActual);
	    int contarPartido = 0;
	    
	    for (int j = indiceActual + 1; j < participantes.size(); j++) {
	        iniciarDuelo(actual, participantes.get(j));
	        
	      
	        if (indiceActual == 0) {
	      
	            cronograma[indiceActual][contarPartido] = "Fase 1 (" + fechas[0] + "): " + actual.getUsuario() + " vs " + participantes.get(j).getUsuario();
	        } else {
	   
	            cronograma[indiceActual][contarPartido] = "Fase " + (indiceActual + 1) + " (" +  fechas[indiceActual] + "): " +  actual.getUsuario() + " vs " + participantes.get(j).getUsuario();
	        }
	        contarPartido++;
	    }
	    if (indiceActual + 1 < participantes.size()) {
	        fechas[indiceActual + 1] = fechas[indiceActual].plusDays(1);
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
	        
	    }
	}

    public void setFechas(LocalDate[] fechas2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFechas'");
    }

    public void setCronograma(String[][] cronograma2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCronograma'");
    }

    public String[][] getCronograma() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCronograma'");
    }

    public LocalDate[] getFechas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFechas'");
    }
	

	
	
	
	
}
