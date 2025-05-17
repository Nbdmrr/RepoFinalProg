package co.edu.unbosque.modelo;

import co.edu.unbosque.modelo.persistencia.EntrenadorDTO;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.AdministradorDTO;
import co.edu.unbosque.modelo.persistencia.DirectorioEntrenadoresDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

public class DirectorioEntrenadores {
	
	private DirectorioEntrenadoresDAO directorioEntrenadoresDAO;
	public DirectorioEntrenadores() {
		directorioEntrenadoresDAO = new DirectorioEntrenadoresDAO();
	}
	public void cargarEntrenadores() {
		directorioEntrenadoresDAO.actualizarEntrenadores();
		
	}
	
	
	public boolean adicionarEntrenador( EntrenadorDTO aDTO)  {
		Entrenador a = MapHandler.convertirEntrenadorDTOAEntrenador(aDTO);
		return directorioEntrenadoresDAO.add(a);
	}

	public boolean eliminarEntrenador(EntrenadorDTO aDTO)  {
		Entrenador a = MapHandler.convertirEntrenadorDTOAEntrenador(aDTO);
		return directorioEntrenadoresDAO.delete(a);
	}

	public boolean actualizarEntrenador(EntrenadorDTO viejoDTO, EntrenadorDTO nuevoDTO)  {
		Entrenador viejo = MapHandler.convertirEntrenadorDTOAEntrenador(viejoDTO);
		Entrenador nuevo = MapHandler.convertirEntrenadorDTOAEntrenador(nuevoDTO);
		return directorioEntrenadoresDAO.update(viejo, nuevo);
	}
	public Entrenador encontrarEntrenadores(EntrenadorDTO aDTO)  {
		Entrenador a = MapHandler.convertirEntrenadorDTOAEntrenador(aDTO);
		return getDirectorioEntrenadoresDAO().find(a);
	}

	public ArrayList<Entrenador> obtenerEntrenadores() {
		return directorioEntrenadoresDAO.getAll();
	}
	public DirectorioEntrenadoresDAO getDirectorioEntrenadoresDAO() {
		return directorioEntrenadoresDAO;
	}
	public void setDirectorioEntrenadoresDAO(DirectorioEntrenadoresDAO directorioEntrenadoresDAO) {
		this.directorioEntrenadoresDAO = directorioEntrenadoresDAO;
	}

}
