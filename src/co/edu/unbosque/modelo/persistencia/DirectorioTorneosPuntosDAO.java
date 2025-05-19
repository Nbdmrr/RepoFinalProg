package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Torneo;
import co.edu.unbosque.modelo.TorneoPuntos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectorioTorneosPuntosDAO implements InterfaceDAO<TorneoPuntos> {

    private ArrayList<TorneoPuntos> torneosPuntos;
    private Archivo archivo;

    public DirectorioTorneosPuntosDAO() {
        this.torneosPuntos = new ArrayList<>();
        archivo = new Archivo();
    }

    public void actualizarTorneosPuntos() {
        torneosPuntos = archivo.leerArchivoTorneosPuntos();
    }

    @Override
    public boolean add(TorneoPuntos x) {
        if (find(x) == null) {
            torneosPuntos.add(x);
            archivo.escribirArchivoTorneosPuntos(torneosPuntos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(TorneoPuntos x) {
        TorneoPuntos t = find(x);
        if (t != null) {
            try {
                torneosPuntos.remove(t);
                archivo.getUbicacionArchivoTorneosPuntos().delete();
                archivo.getUbicacionArchivoTorneosPuntos().createNewFile();
                archivo.escribirArchivoTorneosPuntos(torneosPuntos);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public TorneoPuntos find(TorneoPuntos x) {
        for (TorneoPuntos t : torneosPuntos) {
            if (t.getNombre().equals(x.getNombre())) {
                return t;
            }
        }
        return null;
    }

   @Override
public ArrayList<TorneoPuntos> getAll() {
	// TODO Auto-generated method stub
	return torneosPuntos;
}

    @Override
    public boolean update(TorneoPuntos x, TorneoPuntos y) {
        TorneoPuntos t = find(x);
        if (t != null) {
            try {
                torneosPuntos.remove(t);
                t.setNombre(y.getNombre());
                t.setEstado(y.getEstado());
                t.setFase(y.getFase());
                t.setJuego(y.getJuego());
                t.setLimiteParticipantes(y.getLimiteParticipantes());
                t.setParticipantes(y.getParticipantes());
                t.setTipo(y.getTipo());
                t.setCronograma(y.getCronograma());
                t.setFechas(y.getFechas());
                t.setGanadorTorneo(y.getGanadorTorneo());
                
               
                torneosPuntos.add(t);
                archivo.getUbicacionArchivoTorneosPuntos().delete();
                archivo.getUbicacionArchivoTorneosPuntos().createNewFile();
                archivo.escribirArchivoTorneosPuntos(torneosPuntos);
                return true;
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
