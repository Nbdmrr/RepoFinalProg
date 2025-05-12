package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.TorneoGrupos;
import java.util.ArrayList;
import java.util.List;

public class DirectorioTorneosGruposDAO implements InterfaceDAO<TorneoGrupos> {
    private List<TorneoGrupos> torneosGrupos;

    public DirectorioTorneosGruposDAO() {
        this.torneosGrupos = new ArrayList<>();
    }

    @Override
    public boolean add(TorneoGrupos torneo) {
        if (torneo == null || torneo.getNombre() == null || torneo.getNombre().isEmpty()) {
            return false;
        }
        for (TorneoGrupos t : torneosGrupos) {
            if (t.getNombre().equalsIgnoreCase(torneo.getNombre())) {
                return false;
            }
        }
        return torneosGrupos.add(torneo);
    }

    @Override
    public boolean delete(TorneoGrupos torneo) {
        return torneosGrupos.remove(torneo);
    }

    @Override
    public TorneoGrupos find(TorneoGrupos torneo) {
        for (TorneoGrupos t : torneosGrupos) {
            if (t.getNombre().equalsIgnoreCase(torneo.getNombre())) {
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean update(TorneoGrupos torneoActual, TorneoGrupos torneoNuevo) {
        int index = torneosGrupos.indexOf(torneoActual);
        if (index != -1) {
            torneosGrupos.set(index, torneoNuevo);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        if (torneosGrupos.isEmpty()) {
            return "No hay torneos de grupos registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (TorneoGrupos torneo : torneosGrupos) {
            sb.append("Torneo: ").append(torneo.getNombre()).append("\n");
        }
        return sb.toString();
    }
}
