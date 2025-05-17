package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Entrenador;
import java.util.ArrayList;
import java.util.List;

public class DirectorioEntrenadoresDAO implements InterfaceDAO<Entrenador> {

    private ArrayList<Entrenador> entrenadores;
    private Archivo archivo;

    public DirectorioEntrenadoresDAO() {
        this.entrenadores = new ArrayList<>();
        archivo = new Archivo();
    }

    public void actualizarEntrenadores() {
    	entrenadores = archivo.leerArchivoEntrenadores();
    	if (entrenadores == null) {
    	    entrenadores = new ArrayList<>();
    	}

    }

    @Override
    public boolean add(Entrenador x) {
        if (find(x) == null) {
            entrenadores.add(x);
            archivo.escribirArchivoEntrenadores(entrenadores);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Entrenador x) {
        Entrenador y = find(x);
        if (y != null) {
            entrenadores.remove(y);
            archivo.escribirArchivoEntrenadores(entrenadores);
            return true;
        }
        return false;
    }

    @Override
    public Entrenador find(Entrenador x) {
        if (x == null || x.getUsuario() == null) {
            return null;
        }

        for (Entrenador e : entrenadores) {
            if (e != null && x.getUsuario().equals(e.getUsuario())) {
                return e;
            }
        }
        return null;
    }


   @Override
public ArrayList<Entrenador> getAll() {
	// TODO Auto-generated method stub
	return entrenadores;
}

    @Override
    public boolean update(Entrenador x, Entrenador y) {
        Entrenador e = find(x);
        if (e != null) {
            entrenadores.remove(e);
            e.setUsuario(y.getUsuario());
            e.setContraseña(y.getContraseña());
            e.setEquipo(y.getEquipo());
            e.setCorreo(y.getCorreo());
            e.setNacionalidad(y.getNacionalidad());
            archivo.escribirArchivoEntrenadores(entrenadores);
            return true;
        }
        return false;
    }
}
