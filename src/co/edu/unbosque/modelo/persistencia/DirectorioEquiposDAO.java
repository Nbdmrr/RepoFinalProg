package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Equipo;
import java.util.List;

public class DirectorioEquiposDAO implements InterfaceDAO<Equipo> {

    private Archivo<Equipo> archivo;
    private List<Equipo> equipos;

    public DirectorioEquiposDAO(String rutaArchivo) {
        this.archivo = new Archivo<>(rutaArchivo);
        this.equipos = archivo.cargar();
    }

    @Override
    public boolean add(Equipo equipo) {
        if (equipo == null || equipo.getNombre() == null || equipo.getNombre().isEmpty()) {
            return false;
        }
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(equipo.getNombre())) {
                return false;
            }
        }
        boolean added = equipos.add(equipo);
        if (added) {
            archivo.guardar(equipos);
        }
        return added;
    }

    @Override
    public boolean delete(Equipo equipo) {
        boolean removed = equipos.remove(equipo);
        if (removed) {
            archivo.guardar(equipos);
        }
        return removed;
    }

    @Override
    public Equipo find(Equipo equipo) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(equipo.getNombre())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean update(Equipo equipoActual, Equipo equipoNuevo) {
        int index = equipos.indexOf(equipoActual);
        if (index != -1) {
            equipos.set(index, equipoNuevo);
            archivo.guardar(equipos);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        if (equipos.isEmpty()) {
            return "No hay equipos registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (Equipo equipo : equipos) {
            sb.append("Equipo: ").append(equipo.getNombre()).append("\n");
        }
        return sb.toString();
    }
}