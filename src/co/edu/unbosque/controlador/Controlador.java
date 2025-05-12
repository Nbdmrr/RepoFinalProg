package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.TorneoGrupos;
import co.edu.unbosque.modelo.persistencia.DirectorioJugadoresDAO;
import co.edu.unbosque.modelo.persistencia.DirectorioTorneosDAO;
import co.edu.unbosque.vista.Vista;

public class Controlador {

    private Vista vista;
    private DirectorioJugadoresDAO jugadoresDAO;
    private DirectorioTorneosDAO torneosDAO;

    public Controlador() {
        this.vista = new Vista();
        this.jugadoresDAO = new DirectorioJugadoresDAO("jugadores.bin");
        this.torneosDAO = new DirectorioTorneosDAO("torneos.bin");
    }

    public void registrarJugador(String usuario, String contraseña, String nacionalidad, String correo, String especialidad, String equipo) {
        Jugador jugador = new Jugador(usuario, contraseña, nacionalidad, correo, especialidad, equipo);
        if (jugadoresDAO.add(jugador)) {
            vista.mostrarMensaje("Jugador registrado exitosamente: " + usuario);
        } else {
            vista.mostrarMensaje("Error: No se pudo registrar el jugador. Es posible que ya exista.");
        }
    }

    public void mostrarJugadores() {
        String jugadores = jugadoresDAO.getAll();
        vista.mostrarMensaje("Jugadores registrados:\n" + jugadores);
    }

    public void registrarTorneo(String nombre, int limiteParticipantes, String tipo, String juego) {
        TorneoGrupos torneo = new TorneoGrupos(nombre, limiteParticipantes, tipo, juego);
        if (torneosDAO.add(torneo)) {
            vista.mostrarMensaje("Torneo registrado exitosamente: " + nombre);
        } else {
            vista.mostrarMensaje("Error: No se pudo registrar el torneo. Es posible que ya exista.");
        }
    }

    public void mostrarTorneos() {
        String torneos = torneosDAO.getAll();
        vista.mostrarMensaje("Torneos registrados:\n" + torneos);
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }
}