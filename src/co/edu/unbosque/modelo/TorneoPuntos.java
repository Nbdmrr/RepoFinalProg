package co.edu.unbosque.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase que representa un torneo por puntos en el sistema, heredando de Torneo.
 * Gestiona la participación de jugadores, generación de cronogramas y desarrollo del torneo.
 */
public class TorneoPuntos extends Torneo {
    
    /** Matriz que almacena el cronograma de enfrentamientos */
    private String[][] cronograma;
    
    /** Arreglo de fechas para cada fase del torneo */
    private LocalDate[] fechas;
    
    /** Jugador ganador del torneo */
    private Jugador ganadorTorneo;

    /**
     * Constructor de la clase TorneoPuntos.
     * @param nombre Nombre del torneo.
     * @param limiteParticipantes Número máximo de participantes.
     * @param tipo Tipo de torneo.
     * @param juego Juego asociado al torneo.
     */
    public TorneoPuntos(String nombre, int limiteParticipantes, String tipo, String juego) {
        super(nombre, limiteParticipantes, tipo, juego);
    }

    /**
     * Añade un jugador al torneo si cumple con los requisitos.
     * @param j1 Jugador a añadir.
     */
    public void añadirJugador(Jugador j1) {
        if(participantes.size() < limiteParticipantes) {
            if (j1.getPuntos() == 0) {
                participantes.add(j1);
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    "El usuario ya está registrado en un torneo por puntos", 
                    "Advertencia", 
                    JOptionPane.WARNING_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                null, 
                "Torneo lleno", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    /**
     * Genera el cronograma de enfrentamientos para el torneo por puntos.
     */
    public void generarCronogramaPorPuntos() {
        actualizarEstadisticaTorneosJugados();
        int n = participantes.size();
        int totalFases = n - 1;
        setCronograma(new String[totalFases][]);
        setFechas(new LocalDate[totalFases]);
        fase = 0;
        LocalDate fechaInicial = LocalDate.now().plusDays(1);

        for (int i = 0; i < totalFases; i++) {
            int cantidadDuelo = n - i - 1;
            getCronograma()[i] = new String[cantidadDuelo];
            getFechas()[i] = fechaInicial.plusDays(i);
            String jugadorA = participantes.get(i).getUsuario();

            for (int j = i + 1, k = 0; j < n; j++, k++) {
                String jugadorB = participantes.get(j).getUsuario();
                getCronograma()[i][k] = "Fase " + (i + 1) + " (" + getFechas()[i] + "): " + jugadorA + " vs " + jugadorB;
            }
        }
    }

    /**
     * Avanza a la siguiente fase del torneo por puntos.
     */
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

            ganador.sumarPartidaGanada();
            jugadorActual.sumarPartidaJugada();
            oponente.sumarPartidaJugada();
            ganador.setPuntos(ganador.getPuntos() + 1);

            System.out.println(jugadorActual.getUsuario() + " vs " + oponente.getUsuario() + " -> Ganador: " + ganador.getUsuario());
        }

        fase++;

        if (fase >= participantes.size()) {
            int maxPuntos = participantes.stream().mapToInt(Jugador::getPuntos).max().orElse(0);
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

                for (Jugador j : participantes) {
                    j.setPuntos(0);
                }
            } else {
                System.out.println("Hay un empate. Iniciando ronda de desempate entre:");
                for (Jugador j : empatados) {
                    System.out.println("- " + j.getUsuario());
                }
                desempatar(empatados);
            }
        }
    }

    /**
     * Realiza el proceso de desempate entre jugadores con igual puntuación.
     * @param empatados Lista de jugadores empatados.
     */
    private void desempatar(List<Jugador> empatados) {
        List<Jugador> nuevosEmpatados = new ArrayList<>(empatados);

        while (nuevosEmpatados.size() > 1) {
            System.out.println("Ronda de desempate...");

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

        for (Jugador j : participantes) {
            j.setPuntos(0);
        }
    }

    // Métodos getter y setter

    /**
     * Obtiene el ganador del torneo.
     * @return Jugador ganador.
     */
    public Jugador getGanadorTorneo() {
        return ganadorTorneo;
    }

    /**
     * Establece el ganador del torneo.
     * @param ganadorTorneo Jugador ganador.
     */
    public void setGanadorTorneo(Jugador ganadorTorneo) {
        this.ganadorTorneo = ganadorTorneo;
    }

    /**
     * Obtiene las fechas programadas para el torneo.
     * @return Arreglo de fechas.
     */
    public LocalDate[] getFechas() {
        return fechas;
    }

    /**
     * Establece las fechas del torneo.
     * @param fechas Arreglo de fechas.
     */
    public void setFechas(LocalDate[] fechas) {
        this.fechas = fechas;
    }

    /**
     * Obtiene el cronograma de enfrentamientos.
     * @return Matriz con el cronograma.
     */
    public String[][] getCronograma() {
        return cronograma;
    }

    /**
     * Establece el cronograma de enfrentamientos.
     * @param cronograma Matriz con el cronograma.
     */
    public void setCronograma(String[][] cronograma) {
        this.cronograma = cronograma;
    }
}