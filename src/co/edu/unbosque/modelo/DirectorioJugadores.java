package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioJugadoresDAO;
import co.edu.unbosque.modelo.persistencia.JugadorDTO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

public class DirectorioJugadores {
	private DirectorioJugadoresDAO directorioJugadoresDAO;
	
	public DirectorioJugadores() {
		setDirectorioJugadoresDAO(new DirectorioJugadoresDAO());
	}
	public void cargarJugadores() {
		directorioJugadoresDAO.actualizarJugadores();
		
	}
	
	public boolean adicionarJugador( JugadorDTO aDTO)  {
		Jugador a = MapHandler.convertirJugadorDTOAJugador(aDTO);
		return getDirectorioJugadoresDAO().add(a);
	}

	public boolean eliminarJugador(JugadorDTO aDTO)  {
		Jugador a = MapHandler.convertirJugadorDTOAJugador(aDTO);
		return getDirectorioJugadoresDAO().delete(a);
	}

	public boolean actualizarJugador(JugadorDTO viejoDTO, JugadorDTO nuevoDTO)  {
		Jugador viejo = MapHandler.convertirJugadorDTOAJugador(viejoDTO);
		Jugador nuevo = MapHandler.convertirJugadorDTOAJugador(nuevoDTO);
		return getDirectorioJugadoresDAO().update(viejo, nuevo);
	}
	public Jugador encontrarJugador(JugadorDTO aDTO)  {
		Jugador a = MapHandler.convertirJugadorDTOAJugador(aDTO);
		return getDirectorioJugadoresDAO().find(a);
	}

	public ArrayList<Jugador> obtenerJugador() {
		return getDirectorioJugadoresDAO().getAll();
	}

	public DirectorioJugadoresDAO getDirectorioJugadoresDAO() {
		return directorioJugadoresDAO;
	}

	public void setDirectorioJugadoresDAO(DirectorioJugadoresDAO directorioJugadoresDAO) {
		this.directorioJugadoresDAO = directorioJugadoresDAO;
	}

}
