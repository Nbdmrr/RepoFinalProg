package co.edu.unbosque.controlador;

import java.util.ArrayList;

import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.TorneoEliminacion;
import co.edu.unbosque.modelo.TorneoGrupos;
import co.edu.unbosque.modelo.persistencia.DirectorioJugadoresDAO;
import co.edu.unbosque.modelo.persistencia.DirectorioTorneosDAO;
import co.edu.unbosque.vista.Vista;

public class Main {
	

    public static void main(String[] args) {
    	
    	Controlador controlador = new Controlador();
        DirectorioJugadoresDAO jugadoresDAO = new DirectorioJugadoresDAO("jugadores.bin");
        DirectorioTorneosDAO torneosDAO = new DirectorioTorneosDAO("torneos.bin");
        TorneoGrupos torneo = new TorneoGrupos("Torneo Grupal", 12, "Por Grupos", "Valorant");

     // Crear los 12 jugadores
     Jugador[] equipo1 = {
         new Jugador("Leo", "123", "Colombia", "leo@example.com", "Sniper", "Team A"),
         new Jugador("Ana", "123", "Chile", "ana@example.com", "Mid", "Team A"),
         new Jugador("Carlos", "123", "Perú", "carlos@example.com", "Jungla", "Team A")
     };

     Jugador[] equipo2 = {
         new Jugador("Lucía", "123", "Argentina", "lucia@example.com", "Top", "Team B"),
         new Jugador("Pedro", "123", "México", "pedro@example.com", "Support", "Team B"),
         new Jugador("Sofía", "123", "Uruguay", "sofia@example.com", "ADC", "Team B")
     };

     Jugador[] equipo3 = {
         new Jugador("Juan", "123", "Bolivia", "juan@example.com", "Mid", "Team C"),
         new Jugador("Marta", "123", "Ecuador", "marta@example.com", "Top", "Team C"),
         new Jugador("Nico", "123", "Chile", "nico@example.com", "Jungla", "Team C")
     };

     Jugador[] equipo4 = {
         new Jugador("Laura", "123", "Paraguay", "laura@example.com", "Support", "Team D"),
         new Jugador("Andrés", "123", "Colombia", "andres@example.com", "ADC", "Team D"),
         new Jugador("Valentina", "123", "Perú", "valentina@example.com", "Sniper", "Team D")
     };

     // Agregar jugadores al torneo
     for (Jugador j : equipo1) torneo.getParticipantes().add(j);
     for (Jugador j : equipo2) torneo.getParticipantes().add(j);
     for (Jugador j : equipo3) torneo.getParticipantes().add(j);
     for (Jugador j : equipo4) torneo.getParticipantes().add(j);

     // Asignar equipos al torneo
     torneo.organizarEquipos();

     // Generar cronograma
     torneo.generarCronograma();

     // Mostrar en interfaz
     String[][] cronograma = torneo.getCronograma();
     controlador.getVista().getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(cronograma);

     // Simular semifinales
     torneo.avanzarAFase2();
     torneo.actualizarCronogramaPorGrupos();
     cronograma = torneo.getCronograma();
     controlador.getVista().getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(cronograma);

     // Simular final
     torneo.elegirGanadorFinal();
     cronograma = torneo.getCronograma();
     controlador.getVista().getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(cronograma);

}}