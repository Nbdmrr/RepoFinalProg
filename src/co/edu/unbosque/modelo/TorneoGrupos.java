package co.edu.unbosque.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class TorneoGrupos extends Torneo {

    private Jugador[] equipo1;
    private Jugador[] equipo2;
    private Jugador[] equipo3;
    private Jugador[] equipo4;
    private Jugador[] equipoGanador1;
    private Jugador[] equipoGanador2;
    private Jugador[] equipoGanadorTorneo;

    // Usamos HashMap<Jugador, Boolean> para almacenar los eliminados
    private HashMap<Jugador, Boolean> eliminados;

    private String[][] cronograma;
    private LocalDate[] fechas;

    public TorneoGrupos(String nombre, int limiteParticipantes, String tipo, String juego) {
        super(nombre, limiteParticipantes, tipo, juego);
        setEquipo1(new Jugador[3]);
        setEquipo2(new Jugador[3]);
        setEquipo3(new Jugador[3]);
        setEquipo4(new Jugador[3]);
        setEquipoGanador1(new Jugador[3]);
        setEquipoGanador2(new Jugador[3]);
        setEquipoGanadorTorneo(new Jugador[3]);
        eliminados = new HashMap<>();  // Inicializamos el HashMap para los eliminados
    }

    public void organizarEquipos() {
        List<Jugador[]> grupos = new ArrayList<>();
        List<Jugador> copiaJugadores = new ArrayList<>(this.participantes);

        while (!copiaJugadores.isEmpty()) {
            Jugador primero = copiaJugadores.get(0);
            String equipo = primero.getEquipo();
            Jugador[] grupo = new Jugador[3];
            int indice = 0;
            for (int i = 0; i < copiaJugadores.size() && indice < 3; i++) {
                Jugador actual = copiaJugadores.get(i);
                if (actual.getEquipo().equals(equipo)) {
                    grupo[indice++] = actual;
                }
            }
            for (Jugador j : grupo) {
                copiaJugadores.remove(j);
            }
            grupos.add(grupo);
        }
        setEquipo1(grupos.get(0));
        setEquipo2(grupos.get(1));
        setEquipo3(grupos.get(2));
        setEquipo4(grupos.get(3));
    }

    public boolean agregarJugador(Jugador jugador) {
        String equipo = jugador.getEquipo();
        int cantidadEquipo = 0;

        for (Jugador j : participantes) {
            if (j.getEquipo().equals(equipo)) {
                cantidadEquipo++;
            }
        }

        if (cantidadEquipo >= 3) {
            JOptionPane.showMessageDialog(null, "Equipo completo");
            return false;
        } else {
            participantes.add(jugador);
            JOptionPane.showMessageDialog(null, "Jugador añadido al torneo");
            return true;
        }
    }

    public void avanzarAFase2() {
        int puntosA = 0;
        int puntosB = 0;

        // Primera semifinal: equipo1 vs equipo2
        for (int i = 0; i < 3; i++) {
            Jugador jugadorA = getEquipo1()[i];
            Jugador jugadorB = getEquipo2()[i];

            jugadorA.sumarPartidaJugada();
            jugadorB.sumarPartidaJugada();

            Jugador ganador = Math.random() < 0.5 ? jugadorA : jugadorB;
            ganador.sumarPartidaGanada();

            if (ganador == jugadorA) {
                puntosA++;
            } else {
                puntosB++;
            }
        }

        if (puntosA > puntosB) {
            setEquipoGanador1(getEquipo1());

            for (Jugador perdedor : getEquipo2()) {
                participantes.remove(perdedor);
                // Marcamos al perdedor como eliminado
                eliminados.put(perdedor, false); 
            }

        } else if (puntosB > puntosA) {
            setEquipoGanador1(getEquipo2());

            for (Jugador perdedor : getEquipo1()) {
                participantes.remove(perdedor);
                // Marcamos al perdedor como eliminado
                eliminados.put(perdedor, false); 
            }
        }

        // Segunda semifinal: equipo3 vs equipo4
        puntosA = 0;
        puntosB = 0;

        for (int i = 0; i < 3; i++) {
            Jugador jugadorA = getEquipo3()[i];
            Jugador jugadorB = getEquipo4()[i];

            jugadorA.sumarPartidaJugada();
            jugadorB.sumarPartidaJugada();

            Jugador ganador = Math.random() < 0.5 ? jugadorA : jugadorB;
            ganador.sumarPartidaGanada();

            if (ganador == jugadorA) {
                puntosA++;
            } else {
                puntosB++;
            }
        }

        if (puntosA > puntosB) {
            setEquipoGanador2(getEquipo3());

            for (Jugador perdedor : getEquipo4()) {
                participantes.remove(perdedor);
                // Marcamos al perdedor como eliminado
                eliminados.put(perdedor, false); 
            }

        } else if (puntosB > puntosA) {
            setEquipoGanador2(getEquipo4());

            for (Jugador perdedor : getEquipo3()) {
                participantes.remove(perdedor);
                // Marcamos al perdedor como eliminado
                eliminados.put(perdedor, false); 
            }
        }
        actualizarCronogramaPorGrupos();
    }

    public void elegirGanadorFinal() {
        int puntosA = 0;
        int puntosB = 0;

        for (int i = 0; i < 3; i++) {
            Jugador jugadorA = getEquipoGanador1()[i];
            Jugador jugadorB = getEquipoGanador2()[i];

            jugadorA.sumarPartidaJugada();
            jugadorB.sumarPartidaJugada();

            Jugador ganador = Math.random() < 0.5 ? jugadorA : jugadorB;
            ganador.sumarPartidaGanada();

            if (ganador.equals(jugadorA)) {
                puntosA++;
            } else {
                puntosB++;
            }
        }

        if (puntosA > puntosB) {
            setEquipoGanadorTorneo(equipoGanador1);

            // Sumar torneo ganado a todos los del equipo
            for (Jugador j : equipoGanador1) {
                j.sumarTorneoGanado();
            }

            for (Jugador perdedor : equipoGanador2) {
                participantes.remove(perdedor);
                // Marcamos al perdedor como eliminado
                eliminados.put(perdedor, false); 
            }

        } else if (puntosB > puntosA) {
            setEquipoGanadorTorneo(equipoGanador2);

            for (Jugador j : equipoGanador2) {
                j.sumarTorneoGanado();
            }

            for (Jugador perdedor : equipoGanador1) {
                participantes.remove(perdedor);
                // Marcamos al perdedor como eliminado
                eliminados.put(perdedor, false); 
            }
        }

        estado = "Terminado";
    }

    public void actualizarCronogramaPorGrupos() {
        if (fase >= getCronograma().length - 1) {
            System.out.println("El torneo ha finalizado.");
            return;
        }

        int faseSiguiente = fase + 1;

        // Verificamos que haya equipos ganadores asignados
        if (equipoGanador1 == null || equipoGanador2 == null) {
            System.out.println("No se puede actualizar el cronograma: faltan equipos ganadores.");
            return;
        }

        for (int i = 0; i < 3; i++) {
            String jugador1 = equipoGanador1[i].getUsuario();
            String jugador2 = equipoGanador2[i].getUsuario();
            String equipo1Nombre = equipoGanador1[i].getEquipo();
            String equipo2Nombre = equipoGanador2[i].getEquipo();

            if (cronograma[faseSiguiente][i].contains("Pendiente")) {
                cronograma[faseSiguiente][i] = "Fase " + (faseSiguiente + 1) + " (" + fechas[faseSiguiente] + "): " +
                        jugador1 + " vs " + jugador2 + " - " + equipo1Nombre + " vs " + equipo2Nombre;
            }
        }

        fase++;
    }

    public void generarCronograma() {
        actualizarEstadisticaTorneosJugados();
        setCronograma(new String[2][]);
        setFechas(new LocalDate[2]);
        LocalDate fechaInicial = LocalDate.now().plusDays(1);

        // Fase 1
        getFechas()[0] = fechaInicial;
        getCronograma()[0] = new String[6]; // 3 enfrentamientos entre equipo1 y equipo2 + 3 entre equipo3 y equipo4

        for (int i = 0; i < 3; i++) {
            String jugador1 = getEquipo1()[i].getUsuario();
            String jugador2 = getEquipo2()[i].getUsuario();
            String equipo1Nombre = getEquipo1()[i].getEquipo();
            String equipo2Nombre = getEquipo2()[i].getEquipo();
            getCronograma()[0][i] = "Fase 1 (" + getFechas()[0] + "): " + jugador1 + " vs " + jugador2 + " - " + equipo1Nombre + " vs " + equipo2Nombre;
        }

        for (int i = 0; i < 3; i++) {
            String jugador1 = getEquipo3()[i].getUsuario();
            String jugador2 = getEquipo4()[i].getUsuario();
            String equipo1Nombre = getEquipo3()[i].getEquipo();
            String equipo2Nombre = getEquipo4()[i].getEquipo();
            getCronograma()[0][i + 3] = "Fase 1 (" + getFechas()[0] + "): " + jugador1 + " vs " + jugador2 + " - " + equipo1Nombre + " vs " + equipo2Nombre;
        }

        // Fase 2 (Final)
        getFechas()[1] = fechaInicial.plusDays(1);
        getCronograma()[1] = new String[3]; // 3 enfrentamientos entre equipoGanador1 y equipoGanador2

        for (int i = 0; i < 3; i++) {
            getCronograma()[1][i] = "Fase 2 (" + getFechas()[1] + "): Pendiente";
        }
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

    public Jugador[] getEquipoGanadorTorneo() {
        return equipoGanadorTorneo;
    }

    public void setEquipoGanadorTorneo(Jugador[] equipoGanadorTorneo) {
        this.equipoGanadorTorneo = equipoGanadorTorneo;
    }

    public Jugador[] getEquipoGanador2() {
        return equipoGanador2;
    }

    public void setEquipoGanador2(Jugador[] equipoGanador2) {
        this.equipoGanador2 = equipoGanador2;
    }

    public Jugador[] getEquipoGanador1() {
        return equipoGanador1;
    }

    public void setEquipoGanador1(Jugador[] equipoGanador1) {
        this.equipoGanador1 = equipoGanador1;
    }

    public Jugador[] getEquipo4() {
        return equipo4;
    }

    public void setEquipo4(Jugador[] equipo4) {
        this.equipo4 = equipo4;
    }

    public Jugador[] getEquipo3() {
        return equipo3;
    }

    public void setEquipo3(Jugador[] equipo3) {
        this.equipo3 = equipo3;
    }

    public Jugador[] getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Jugador[] equipo2) {
        this.equipo2 = equipo2;
    }

    public Jugador[] getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Jugador[] equipo1) {
        this.equipo1 = equipo1;
    }

    public void mostrarCronograma() {
        for (int i = 0; i < getCronograma().length; i++) {
            for (String partido : getCronograma()[i]) {
                System.out.println(partido);
            }
        }
    }
}
