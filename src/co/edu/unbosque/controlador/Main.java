package co.edu.unbosque.controlador;

import java.util.ArrayList;

import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.TorneoGrupos;
import co.edu.unbosque.modelo.persistencia.DirectorioJugadoresDAO;
import co.edu.unbosque.modelo.persistencia.DirectorioTorneosDAO;

public class Main {

    public static void main(String[] args) {
        DirectorioJugadoresDAO jugadoresDAO = new DirectorioJugadoresDAO("jugadores.bin");
        DirectorioTorneosDAO torneosDAO = new DirectorioTorneosDAO("torneos.bin");

        Jugador jugador1 = new Jugador("pepito1", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "sapo");
        Jugador jugador2 = new Jugador("pepito2", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "buho");
        Jugador jugador3 = new Jugador("pepito356", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "goku");
        Jugador jugador4 = new Jugador("pepito456", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "goku");
        Jugador jugador5 = new Jugador("pepito5", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "buho");
        Jugador jugador6 = new Jugador("pepito6", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "sapo");
        Jugador jugador7 = new Jugador("pepito7", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "perro");
        Jugador jugador8 = new Jugador("pepito8", "dsdsd", "dasndjs", "shabdjas ", "dasdsa", "perro");

        jugadoresDAO.add(jugador1);
        jugadoresDAO.add(jugador2);
        jugadoresDAO.add(jugador3);
        jugadoresDAO.add(jugador4);
        jugadoresDAO.add(jugador5);
        jugadoresDAO.add(jugador6);
        jugadoresDAO.add(jugador7);
        jugadoresDAO.add(jugador8);

        System.out.println("Jugadores registrados:");
        System.out.println(jugadoresDAO.getAll());

        TorneoGrupos torneo = new TorneoGrupos("Torneo Sapo", 16, "Grupos", "Ajedrez");

        torneo.getParticipantes().add(jugador1);
        torneo.getParticipantes().add(jugador2);
        torneo.getParticipantes().add(jugador3);
        torneo.getParticipantes().add(jugador4);
        torneo.getParticipantes().add(jugador5);
        torneo.getParticipantes().add(jugador6);
        torneo.getParticipantes().add(jugador7);
        torneo.getParticipantes().add(jugador8);

        torneo.organizarEquipos();
        torneo.generarCronograma();

        torneo.mostrarCronograma();

        torneosDAO.add(torneo);

        System.out.println("Torneos registrados:");
        System.out.println(torneosDAO.getAll());
    }
}