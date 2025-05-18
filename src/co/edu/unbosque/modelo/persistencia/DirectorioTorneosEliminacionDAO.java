package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.TorneoEliminacion;
import java.io.IOException;
import java.util.ArrayList;

public class DirectorioTorneosEliminacionDAO implements InterfaceDAO<TorneoEliminacion> {

    private ArrayList<TorneoEliminacion> torneosEliminacion;
    private Archivo archivo;

    public DirectorioTorneosEliminacionDAO() {
        this.torneosEliminacion = new ArrayList<>();
        archivo = new Archivo();
    }

    public void actualizarTorneosEliminacion() {
        torneosEliminacion = archivo.leerArchivoTorneosEliminacion();
    }

    @Override
    public boolean add(TorneoEliminacion x) {
        if (find(x) == null) {
            torneosEliminacion.add(x);
            archivo.escribirArchivoTorneosEliminacion(torneosEliminacion);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(TorneoEliminacion x) {
        TorneoEliminacion t = find(x);
        if (t != null) {
            try {
                torneosEliminacion.remove(t);
                archivo.getUbicacionArchivoTorneosEliminacion().delete();
                archivo.getUbicacionArchivoTorneosEliminacion().createNewFile();
                archivo.escribirArchivoTorneosEliminacion(torneosEliminacion);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public TorneoEliminacion find(TorneoEliminacion x) {
        for (TorneoEliminacion t : torneosEliminacion) {
            if (t.getNombre().equals(x.getNombre())) {
                return t;
            }
        }
        return null;
    }

   @Override
public ArrayList<TorneoEliminacion> getAll() {
	// TODO Auto-generated method stub
	return torneosEliminacion;
}

    @Override
    public boolean update(TorneoEliminacion x, TorneoEliminacion y) {
        TorneoEliminacion t = find(x);
        if (t != null) {
            try {
                torneosEliminacion.remove(t);
                t.setNombre(y.getNombre());
                t.setEstado(y.getEstado());
                t.setCronograma(y.getCronograma());
                t.setFase(y.getFase());
                t.setFechas(y.getFechas());
                t.setGanadores(y.getGanadores());
                t.setGanadorTorneo(y.getGanadorTorneo());
                t.setJuego(y.getJuego());
                t.setLimiteParticipantes(y.getLimiteParticipantes());
                t.setParticipantes(y.getParticipantes());
                t.setTipo(y.getTipo());
                torneosEliminacion.add(t);
                archivo.getUbicacionArchivoTorneosEliminacion().delete();
                archivo.getUbicacionArchivoTorneosEliminacion().createNewFile();
                archivo.escribirArchivoTorneosEliminacion(torneosEliminacion);
                return true;
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
        
    }
}
