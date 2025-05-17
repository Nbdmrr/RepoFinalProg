package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.TorneoGrupos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectorioTorneosGruposDAO implements InterfaceDAO<TorneoGrupos> {

    private ArrayList<TorneoGrupos> torneosGrupos;
    private Archivo archivo;

    public DirectorioTorneosGruposDAO() {
        this.torneosGrupos = new ArrayList<>();
        archivo = new Archivo();
    }

    public void actualizarTorneosGrupos() {
        torneosGrupos = archivo.leerArchivoTorneosGrupos();
    }

    @Override
    public boolean add(TorneoGrupos x) {
        if (find(x) == null) {
            torneosGrupos.add(x);
            archivo.escribirArchivoTorneosGrupos(torneosGrupos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(TorneoGrupos x) {
        TorneoGrupos t = find(x);
        if (t != null) {
            try {
                torneosGrupos.remove(t);
                archivo.getUbicacionArchivoTorneosGrupos().delete();
                archivo.getUbicacionArchivoTorneosGrupos().createNewFile();
                archivo.escribirArchivoTorneosGrupos(torneosGrupos);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public TorneoGrupos find(TorneoGrupos x) {
        for (TorneoGrupos t : torneosGrupos) {
            if (t.getNombre().equals(x.getNombre())) {
                return t;
            }
        }
        return null;
    }

    @Override
    public ArrayList<TorneoGrupos> getAll() {
    	// TODO Auto-generated method stub
    	return torneosGrupos;
    }

    @Override
    public boolean update(TorneoGrupos x, TorneoGrupos y) {
        TorneoGrupos t = find(x);
        if (t != null) {
            try {
                torneosGrupos.remove(t);
                t.setNombre(y.getNombre());
                t.setEstado(y.getEstado());
                t.setCronograma(y.getCronograma());
                t.setEquipo1(y.getEquipo1());
                t.setEquipo2(y.getEquipo2());
                t.setEquipo3(y.getEquipo3());
                t.setEquipo4(y.getEquipo4());
                t.setEquipoGanador1(y.getEquipoGanador1());
                t.setEquipoGanador2(y.getEquipoGanador2());
                t.setEquipoGanadorTorneo(y.getEquipoGanadorTorneo());
                t.setFase(y.getFase());
                t.setFechas(y.getFechas());
                t.setJuego(y.getJuego());
                t.setLimiteParticipantes(y.getLimiteParticipantes());
                t.setParticipantes(y.getParticipantes());
                t.setTipo(y.getTipo());
                
                // agregar más campos si tiene TorneoGrupos
                archivo.getUbicacionArchivoTorneosGrupos().delete();
                archivo.getUbicacionArchivoTorneosGrupos().createNewFile();
                archivo.escribirArchivoTorneosGrupos(torneosGrupos);
                return true;
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
