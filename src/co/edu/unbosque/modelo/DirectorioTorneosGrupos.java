package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioTorneosGruposDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;
import co.edu.unbosque.modelo.persistencia.TorneoGruposDTO;

public class DirectorioTorneosGrupos {
	private DirectorioTorneosGruposDAO directorioTorneosGruposDAO;
	public DirectorioTorneosGrupos() {
		setDirectorioTorneosGruposDAO(new DirectorioTorneosGruposDAO());
	}
	public void cargarTorneosGrupos() {
		directorioTorneosGruposDAO.actualizarTorneosGrupos();
		
	}

	public boolean adicionarTorneoGrupos( TorneoGruposDTO aDTO)  {
		TorneoGrupos a = MapHandler.convertirTorneoGruposDTOATorneoGrupos(aDTO);
		return getDirectorioTorneosGruposDAO().add(a);
	}

	public boolean eliminarTorneoGrupos(TorneoGruposDTO aDTO)  {
		TorneoGrupos a = MapHandler.convertirTorneoGruposDTOATorneoGrupos(aDTO);
		return getDirectorioTorneosGruposDAO().delete(a);
	}

	public boolean actualizarTorneoGrupos(TorneoGruposDTO viejoDTO, TorneoGruposDTO nuevoDTO)  {
		TorneoGrupos viejo = MapHandler.convertirTorneoGruposDTOATorneoGrupos(viejoDTO);
		TorneoGrupos nuevo = MapHandler.convertirTorneoGruposDTOATorneoGrupos(nuevoDTO);
		return getDirectorioTorneosGruposDAO().update(viejo, nuevo);
	}
	public TorneoGrupos encontrarTorneoGrupos(TorneoGruposDTO aDTO)  {
		TorneoGrupos a = MapHandler.convertirTorneoGruposDTOATorneoGrupos(aDTO);
		return getDirectorioTorneosGruposDAO().find(a);
	}

	public ArrayList<TorneoGrupos> obtenerTorneosGrupos() {
		return getDirectorioTorneosGruposDAO().getAll();
	}

	public DirectorioTorneosGruposDAO getDirectorioTorneosGruposDAO() {
		return directorioTorneosGruposDAO;
	}

	public void setDirectorioTorneosGruposDAO(DirectorioTorneosGruposDAO directorioTorneosGruposDAO) {
		this.directorioTorneosGruposDAO = directorioTorneosGruposDAO;
	}

}
