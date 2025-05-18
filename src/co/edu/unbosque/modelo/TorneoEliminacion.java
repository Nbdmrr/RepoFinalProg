package co.edu.unbosque.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa un torneo por eliminación directa. 
 * Los jugadores se enfrentan entre sí y el perdedor queda eliminado hasta que queda un solo ganador.
 */
public class TorneoEliminacion extends Torneo {

    private String[][] cronograma;
    private LocalDate[] fechas;
    private ArrayList<Jugador> ganadores;
    private HashMap<Jugador, Boolean> eliminados;
    private Jugador ganadorTorneo;

    /**
     * Constructor para inicializar un torneo por eliminación.
     * 
     * @param nombre Nombre del torneo.
     * @param limiteparticipantes Número máximo de participantes.
     * @param tipo Tipo de torneo.
     * @param juego Juego del torneo.
     */
    public TorneoEliminacion(String nombre, int limiteparticipantes, String tipo, String juego) {
        super(nombre, limiteparticipantes, tipo, juego);
        ganadores = new ArrayList<>();
        eliminados = new HashMap<>();
        ganadorTorneo = null;
    }

    /**
     * Genera el cronograma del torneo en fases eliminatorias.
     */
    public void generarCronograma() {
        actualizarEstadisticaTorneosJugados();
        int fases = 0;
        int participantesRestantes = limiteParticipantes;

        while (participantesRestantes > 1) {
            if (participantesRestantes % 2 == 0) {
                participantesRestantes = participantesRestantes / 2;
                fases++;
            }
        }

        cronograma = new String[fases][];
        fechas = new LocalDate[fases];
        fase = 0;

        LocalDate fechaInicial = LocalDate.now().plusDays(1);
        int partidas = participantes.size() / 2;

        cronograma[0] = new String[partidas];
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

    /**
     * Actualiza el cronograma para la siguiente fase usando los ganadores actuales.
     * 
     * @param ganadores Lista de jugadores que ganaron la fase actual.
     */
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

    /**
     * Simula los partidos de la fase actual y avanza a la siguiente fase.
     * Elige un ganador al azar por cada enfrentamiento.
     */
    public void avanzarFase() {
        if (fase >= cronograma.length) {
            estado = "terminado";
            return;
        }

        Random random = new Random();
        ArrayList<Jugador> ganadoresFaseActual = new ArrayList<>();

        for (int i = 0; i < participantes.size() - 1; i += 2) {
            Jugador jugador1 = participantes.get(i);
            Jugador jugador2 = participantes.get(i + 1);

            jugador1.sumarPartidaJugada();
            jugador2.sumarPartidaJugada();

            Jugador ganador = random.nextBoolean() ? jugador1 : jugador2;
            Jugador perdedor = (ganador == jugador1) ? jugador2 : jugador1;

            ganador.sumarPartidaGanada();
            eliminados.put(perdedor, false);

            ganadoresFaseActual.add(ganador);

            System.out.println("Duelo: " + jugador1.getUsuario() + " vs " + jugador2.getUsuario() +
                               " -> Ganador: " + ganador.getUsuario());
        }

        this.ganadores = ganadoresFaseActual;
        actualizarCronograma(ganadoresFaseActual);

        if (ganadoresFaseActual.size() == 1) {
            this.ganadorTorneo = ganadoresFaseActual.get(0);
            ganadorTorneo.sumarTorneoGanado();
            System.out.println("¡El torneo ha finalizado! Ganador: " + ganadorTorneo.getUsuario());
        } else {
            this.participantes = ganadoresFaseActual;
        }
    }

    /**
     * Muestra el cronograma del torneo en consola.
     */
    public void mostrarCronograma() {
        for (int i = 0; i < getCronograma().length; i++) {
            for (String partido : getCronograma()[i]) {
                System.out.println(partido);
            }
        }
    }

    /**
     * Obtiene el mapa de jugadores eliminados.
     * 
     * @return Mapa con jugadores y su estado de eliminación.
     */
    public HashMap<Jugador, Boolean> getEliminados() {
        return eliminados;
    }

    /**
     * Obtiene el jugador ganador del torneo.
     * 
     * @return Ganador del torneo.
     */
    public Jugador getGanadorTorneo() {
        return ganadorTorneo;
    }

    /**
     * Establece el jugador ganador del torneo.
     * 
     * @param ganadorTorneo Jugador ganador.
     */
    public void setGanadorTorneo(Jugador ganadorTorneo) {
        this.ganadorTorneo = ganadorTorneo;
    }

    /**
     * Obtiene la lista de ganadores de la fase actual.
     * 
     * @return Lista de ganadores.
     */
    public ArrayList<Jugador> getGanadores() {
        return ganadores;
    }

    /**
     * Establece la lista de ganadores de la fase actual.
     * 
     * @param ganadores Lista de ganadores.
     */
    public void setGanadores(ArrayList<Jugador> ganadores) {
        this.ganadores = ganadores;
    }

    /**
     * Obtiene el arreglo de fechas del cronograma.
     * 
     * @return Arreglo de fechas.
     */
    public LocalDate[] getFechas() {
        return fechas;
    }

    /**
     * Establece el arreglo de fechas del cronograma.
     * 
     * @param fechas Arreglo de fechas.
     */
    public void setFechas(LocalDate[] fechas) {
        this.fechas = fechas;
    }

    /**
     * Obtiene el cronograma del torneo.
     * 
     * @return Matriz con los partidos programados.
     */
    public String[][] getCronograma() {
        return cronograma;
    }

    /**
     * Establece el cronograma del torneo.
     * 
     * @param cronograma Matriz con partidos programados.
     */
    public void setCronograma(String[][] cronograma) {
        this.cronograma = cronograma;
    }
} 

