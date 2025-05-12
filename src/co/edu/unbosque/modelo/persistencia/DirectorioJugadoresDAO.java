package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Jugador;
import java.util.List;

public class DirectorioJugadoresDAO implements InterfaceDAO<Jugador> {

    private Archivo<Jugador> archivo;
    private List<Jugador> jugadores;

    public DirectorioJugadoresDAO(String rutaArchivo) {
        this.archivo = new Archivo<>(rutaArchivo);
        this.jugadores = archivo.cargar();
    }

    @Override
    public boolean add(Jugador jugador) {
        if (jugador == null || jugador.getUsuario() == null || jugador.getUsuario().isEmpty()) {
            return false;
        }
        for (Jugador j : jugadores) {
            if (j.getUsuario().equalsIgnoreCase(jugador.getUsuario())) {
                return false;
            }
        }
        boolean added = jugadores.add(jugador);
        if (added) {
            archivo.guardar(jugadores);
        }
        return added;
    }

    @Override
    public boolean delete(Jugador jugador) {
        boolean removed = jugadores.remove(jugador);
        if (removed) {
            archivo.guardar(jugadores);
        }
        return removed;
    }

    @Override
    public Jugador find(Jugador jugador) {
        for (Jugador j : jugadores) {
            if (j.getUsuario().equalsIgnoreCase(jugador.getUsuario())) {
                return j;
            }
        }
        return null;
    }

    @Override
    public boolean update(Jugador jugadorActual, Jugador jugadorNuevo) {
        int index = jugadores.indexOf(jugadorActual);
        if (index != -1) {
            jugadores.set(index, jugadorNuevo);
            archivo.guardar(jugadores);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        if (jugadores.isEmpty()) {
            return "No hay jugadores registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (Jugador jugador : jugadores) {
            sb.append("Jugador: ").append(jugador.getUsuario()).append("\n");
        }
        return sb.toString();
    }
}
