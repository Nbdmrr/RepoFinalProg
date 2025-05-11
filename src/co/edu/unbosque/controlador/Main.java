package co.edu.unbosque.controlador;

import java.util.ArrayList;

import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.Torneo;
import co.edu.unbosque.modelo.TorneoEliminacion;
import co.edu.unbosque.modelo.TorneoGrupos;

public class Main {

	public static void main(String[] args) {
		
		Jugador jugador1= new Jugador("pepito1", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","sapo");
		Jugador jugador2= new Jugador("pepito2", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","buho");
		Jugador jugador3= new Jugador("pepito356", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "goku");
		Jugador jugador4= new Jugador("pepito456", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "goku");
		Jugador jugador5= new Jugador("pepito5", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","buho");
		Jugador jugador6= new Jugador("pepito6", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","sapo");
		Jugador jugador7= new Jugador("pepito7", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","perro");
		Jugador jugador8= new Jugador("pepito8", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","perro");
		
		Jugador jugador9= new Jugador("pepito1", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","buho");
		Jugador jugador10= new Jugador("pepito2", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","perro");
		Jugador jugador11= new Jugador("pepito3", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "goku");
		Jugador jugador12= new Jugador("pepito4", "dsdsd", "dasndjs", "shabdjas ", "dasdsa","sapo");
		
		TorneoGrupos torneo= new TorneoGrupos("torneo sapo hp",16,"tipo","juego");
		
		
		
		ArrayList<Jugador> ganadoresauxiliar = new ArrayList<Jugador>();
		
			ganadoresauxiliar.add(jugador1);
			ganadoresauxiliar.add(jugador3);
			ganadoresauxiliar.add(jugador5);
			ganadoresauxiliar.add(jugador8);
			ganadoresauxiliar.add(jugador9);
			ganadoresauxiliar.add(jugador12);
			
		
		torneo.getParticipantes().add(jugador1);
		torneo.getParticipantes().add(jugador2);
		torneo.getParticipantes().add(jugador3);
		torneo.getParticipantes().add(jugador4);
		torneo.getParticipantes().add(jugador5);
		torneo.getParticipantes().add(jugador6);
		torneo.getParticipantes().add(jugador7);
		torneo.getParticipantes().add(jugador8);
		torneo.getParticipantes().add(jugador9);
		torneo.getParticipantes().add(jugador10);
		torneo.getParticipantes().add(jugador11);
		torneo.getParticipantes().add(jugador12);
		
		torneo.organizarEquipos();
		torneo.generarCronograma();
		
		torneo.mostrarCronograma();
		
		
        
        
        
        System.out.println(pepitos.get(0));
		

	}

}
