package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Equipo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectorioEquiposDAO implements InterfaceDAO<Equipo> {

    private ArrayList<Equipo> equipos;
    private Archivo archivo;

    public DirectorioEquiposDAO() {
        equipos = new ArrayList<Equipo>();
        archivo = new Archivo();
    }

    public void actualizarEquipos() {
        equipos = archivo.leerArchivoEquipos();
    }

    @Override
    public boolean add(Equipo x) {
        if (find(x) == null) {
            equipos.add(x);
            archivo.escribirArchivoEquipos(equipos);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Equipo x) {
        Equipo y = find(x);
        if (y != null) {
            try {
                equipos.remove(y);
                archivo.getUbicacionArchivoEquipos().delete();
                archivo.getUbicacionArchivoEquipos().createNewFile();
                archivo.escribirArchivoEquipos(equipos);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public Equipo find(Equipo x) {
        for (Equipo e : equipos) {
            if (e.getNombre().equals(x.getNombre())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Equipo> getAll() {
    	// TODO Auto-generated method stub
    	return equipos;
    }

    @Override
    public boolean update(Equipo x, Equipo y) {
        Equipo e = find(x);
        if (e != null) {
            try {
                equipos.remove(e);
                e.setNombre(y.getNombre());
                e.setEntrenador1(y.getEntrenador1());
                e.setEntrenador2(y.getEntrenador2());
                e.setEntrenador3(y.getEntrenador3());
                e.setEquipo(y.getEquipo());
                archivo.getUbicacionArchivoEquipos().delete();
                archivo.getUbicacionArchivoEquipos().createNewFile();
                archivo.escribirArchivoEquipos(equipos);
                return true;
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
