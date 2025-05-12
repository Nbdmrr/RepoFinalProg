package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.TorneoEliminacion;
import java.util.ArrayList;
import java.util.List;

public class DirectorioTorneosEliminacionDAO implements InterfaceDAO<TorneoEliminacion> {
    private List<TorneoEliminacion> torneosEliminacion;

    public DirectorioTorneosEliminacionDAO() {
        this.torneosEliminacion = new ArrayList<>();
    }

    @Override
    public boolean add(TorneoEliminacion torneo) {
        if (torneo == null || torneo.getNombre() == null || torneo.getNombre().isEmpty()) {
            return false;
        }
        for (TorneoEliminacion t : torneosEliminacion) {
            if (t.getNombre().equalsIgnoreCase(torneo.getNombre())) {
                return false;
            }
        }
        return torneosEliminacion.add(torneo);
    }

    @Override
    public boolean delete(TorneoEliminacion torneo) {
        return torneosEliminacion.remove(torneo);
    }

    @Override
    public TorneoEliminacion find(TorneoEliminacion torneo) {
        for (TorneoEliminacion t : torneosEliminacion) {
            if (t.getNombre().equalsIgnoreCase(torneo.getNombre())) {
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean update(TorneoEliminacion torneoActual, TorneoEliminacion torneoNuevo) {
        int index = torneosEliminacion.indexOf(torneoActual);
        if (index != -1) {
            torneosEliminacion.set(index, torneoNuevo);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        if (torneosEliminacion.isEmpty()) {
            return "No hay torneos de eliminación registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (TorneoEliminacion torneo : torneosEliminacion) {
            sb.append("Torneo: ").append(torneo.getNombre()).append("\n");
        }
        return sb.toString();
    }
}
