package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioTorneosPuntosDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;
import co.edu.unbosque.modelo.persistencia.TorneoPuntosDTO;

public class DirectorioTorneosPuntos {
	private DirectorioTorneosPuntosDAO directorioTorneosPuntosDAO;
	public DirectorioTorneosPuntos() {
		setDirectorioTorneosPuntosDAO(new DirectorioTorneosPuntosDAO());
		
	}
	public void cargarTorneosPuntos() {
		directorioTorneosPuntosDAO.actualizarTorneosPuntos();
		
	}
	public boolean adicionarTorneoPuntos( TorneoPuntosDTO aDTO)  {
		TorneoPuntos a = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(aDTO);
		return getDirectorioTorneosPuntosDAO().add(a);
	}

	public boolean eliminarTorneoPuntos(TorneoPuntosDTO aDTO)  {
		TorneoPuntos a = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(aDTO);
		return getDirectorioTorneosPuntosDAO().delete(a);
	}

	public boolean actualizarTorneoPuntos(TorneoPuntosDTO viejoDTO, TorneoPuntosDTO nuevoDTO)  {
		TorneoPuntos viejo = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(viejoDTO);
		TorneoPuntos nuevo = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(nuevoDTO);
		return getDirectorioTorneosPuntosDAO().update(viejo, nuevo);
	}
	public TorneoPuntos encontrarTorneoPuntos(TorneoPuntosDTO aDTO)  {
		TorneoPuntos a = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(aDTO);
		return getDirectorioTorneosPuntosDAO().find(a);
	}

	public ArrayList<TorneoPuntos> obtenerTorneosPuntos() {
		return getDirectorioTorneosPuntosDAO().getAll();
	}
	public DirectorioTorneosPuntosDAO getDirectorioTorneosPuntosDAO() {
		return directorioTorneosPuntosDAO;
	}
	public void setDirectorioTorneosPuntosDAO(DirectorioTorneosPuntosDAO directorioTorneosPuntosDAO) {
		this.directorioTorneosPuntosDAO = directorioTorneosPuntosDAO;
	}
	
	

}
