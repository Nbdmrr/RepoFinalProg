package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Torneo;
import java.util.List;

public class DirectorioTorneosDAO implements InterfaceDAO<Torneo> {

    private Archivo<Torneo> archivo;
    private List<Torneo> torneos;

    public DirectorioTorneosDAO(String rutaArchivo) {
        this.archivo = new Archivo<>(rutaArchivo);
        this.torneos = archivo.cargar();
    }

    @Override
    public boolean add(Torneo torneo) {
        if (torneo == null || torneo.getNombre() == null || torneo.getNombre().isEmpty()) {
            return false;
        }
        for (Torneo t : torneos) {
            if (t.getNombre().equalsIgnoreCase(torneo.getNombre())) {
                return false;
            }
        }
        boolean added = torneos.add(torneo);
        if (added) {
            archivo.guardar(torneos);
        }
        return added;
    }

    @Override
    public boolean delete(Torneo torneo) {
        boolean removed = torneos.remove(torneo);
        if (removed) {
            archivo.guardar(torneos);
        }
        return removed;
    }

    @Override
    public Torneo find(Torneo torneo) {
        for (Torneo t : torneos) {
            if (t.getNombre().equalsIgnoreCase(torneo.getNombre())) {
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean update(Torneo torneoActual, Torneo torneoNuevo) {
        int index = torneos.indexOf(torneoActual);
        if (index != -1) {
            torneos.set(index, torneoNuevo);
            archivo.guardar(torneos);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        if (torneos.isEmpty()) {
            return "No hay torneos registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (Torneo torneo : torneos) {
            sb.append("Torneo: ").append(torneo.getNombre()).append("\n");
        }
        return sb.toString();
    }
}