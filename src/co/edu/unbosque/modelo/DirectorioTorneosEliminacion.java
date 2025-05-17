package co.edu.unbosque.modelo;

import co.edu.unbosque.modelo.persistencia.TorneoEliminacionDTO;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioTorneosEliminacionDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

public class DirectorioTorneosEliminacion {
	private DirectorioTorneosEliminacionDAO directorioTorneosEliminacionDAO;
	
	public DirectorioTorneosEliminacion() {
		setDirectorioTorneosEliminacionDAO(new DirectorioTorneosEliminacionDAO());
	}
	public void cargarTorneosEliminacion() {
		directorioTorneosEliminacionDAO.actualizarTorneosEliminacion();
		
	}
	
	
	public boolean adicionarTorneoEliminacion( TorneoEliminacionDTO aDTO)  {
		TorneoEliminacion a = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(aDTO);
		return getDirectorioTorneosEliminacionDAO().add(a);
	}

	public boolean eliminarTorneoEliminacion(TorneoEliminacionDTO aDTO)  {
		TorneoEliminacion a = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(aDTO);
		return getDirectorioTorneosEliminacionDAO().delete(a);
	}

	public boolean actualizarTorneoEliminacio(TorneoEliminacionDTO viejoDTO, TorneoEliminacionDTO nuevoDTO)  {
		TorneoEliminacion viejo = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(viejoDTO);
		TorneoEliminacion nuevo = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(nuevoDTO);
		return getDirectorioTorneosEliminacionDAO().update(viejo, nuevo);
	}
	public TorneoEliminacion encontrarTorneoEliminacio(TorneoEliminacionDTO aDTO)  {
		TorneoEliminacion a = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(aDTO);
		return getDirectorioTorneosEliminacionDAO().find(a);
	}

	public ArrayList<TorneoEliminacion> obtenerTorneosEliminacio() {
		return getDirectorioTorneosEliminacionDAO().getAll();
	}


	public DirectorioTorneosEliminacionDAO getDirectorioTorneosEliminacionDAO() {
		return directorioTorneosEliminacionDAO;
	}


	public void setDirectorioTorneosEliminacionDAO(DirectorioTorneosEliminacionDAO directorioTorneosEliminacionDAO) {
		this.directorioTorneosEliminacionDAO = directorioTorneosEliminacionDAO;
	}

}
