package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Jugador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectorioJugadoresDAO implements InterfaceDAO<Jugador> {

    private ArrayList<Jugador> jugadores;
    private Archivo archivo;

    public DirectorioJugadoresDAO() {
        this.jugadores = new ArrayList<>();
        archivo = new Archivo();
    }

    public void actualizarJugadores() {
        jugadores = archivo.leerArchivoJugadores();
    }

    @Override
    public boolean add(Jugador x) {
        if (find(x) == null) {
            jugadores.add(x);
            archivo.escribirArchivoJugadores(jugadores);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Jugador x) {
        Jugador y = find(x);
        if (y != null) {
            try {
                jugadores.remove(y);
                archivo.getUbicacionArchivoJugadores().delete();
                archivo.getUbicacionArchivoJugadores().createNewFile();
                archivo.escribirArchivoJugadores(jugadores);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public Jugador find(Jugador x) {
        for (Jugador j : jugadores) {
            if (j.getUsuario().equals(x.getUsuario())) {
                return j;
            }
        }
        return null;
    }

   @Override
public ArrayList<Jugador> getAll() {
	// TODO Auto-generated method stub
	return jugadores;
}

    @Override
    public boolean update(Jugador x, Jugador y) {
        Jugador j = find(x);
        if (j != null) {
            try {
                jugadores.remove(j);
                j.setUsuario(y.getUsuario());
                j.setContraseña(y.getContraseña());
                j.setCorreo(y.getCorreo());
                j.setEquipo(y.getEquipo());
                j.setEspecialidad(y.getEspecialidad());
                j.setNacionalidad(y.getNacionalidad());
                j.setPartidasGanadas(y.getPartidasGanadas());
                j.setPartidasJugadas(y.getPartidasJugadas());
                j.setPuntos(y.getPuntos());
                j.setTorneosGanados(y.getTorneosGanados());
                j.setTorneosJugados(y.getTorneosJugados());
                jugadores.add(j);
         
                archivo.getUbicacionArchivoJugadores().delete();
                archivo.getUbicacionArchivoJugadores().createNewFile();
                archivo.escribirArchivoJugadores(jugadores);
                return true;
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
