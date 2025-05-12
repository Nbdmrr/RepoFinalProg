package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Entrenador;
import java.util.ArrayList;
import java.util.List;

public class DirectorioEntrenadoresDAO implements InterfaceDAO<Entrenador> {

    private List<Entrenador> entrenadores;

    public DirectorioEntrenadoresDAO() {
        this.entrenadores = new ArrayList<>();
    }

    @Override
    public boolean add(Entrenador entrenador) {
        if (entrenador == null || entrenador.getUsuario() == null || entrenador.getUsuario().isEmpty()) {
            return false;
        }
        for (Entrenador e : entrenadores) {
            if (e.getUsuario().equalsIgnoreCase(entrenador.getUsuario())) {
                return false;
            }
        }
        return entrenadores.add(entrenador);
    }

    @Override
    public boolean delete(Entrenador entrenador) {
        return entrenadores.remove(entrenador);
    }

    @Override
    public Entrenador find(Entrenador entrenador) {
        for (Entrenador e : entrenadores) {
            if (e.getUsuario().equalsIgnoreCase(entrenador.getUsuario())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean update(Entrenador entrenadorActual, Entrenador entrenadorNuevo) {
        int index = entrenadores.indexOf(entrenadorActual);
        if (index != -1) {
            entrenadores.set(index, entrenadorNuevo);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        if (entrenadores.isEmpty()) {
            return "No hay entrenadores registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (Entrenador entrenador : entrenadores) {
            sb.append("Entrenador: ").append(entrenador.getUsuario()).append("\n");
        }
        return sb.toString();
    }
}