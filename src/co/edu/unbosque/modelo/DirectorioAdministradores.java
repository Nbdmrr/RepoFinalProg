package co.edu.unbosque.modelo;


import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.AdministradorDTO;
import co.edu.unbosque.modelo.persistencia.DirectorioAdministradoresDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;


public class DirectorioAdministradores {
	
	private DirectorioAdministradoresDAO directorioAdministradoresDAO;
	public DirectorioAdministradores() {
		setDirectorioAdministradoresDAO(new DirectorioAdministradoresDAO());
		
	}
	public void cargarAdministradores() {
		directorioAdministradoresDAO.actualizarAdministradores();
		
	}
	public boolean adicionarAdministrador( AdministradorDTO aDTO)  {
		Administrador a = MapHandler.convertirAdministradorDTOAAdministrador(aDTO);
		return getDirectorioAdministradoresDAO().add(a);
	}

	public boolean eliminarAdministrador(AdministradorDTO aDTO)  {
		Administrador a = MapHandler.convertirAdministradorDTOAAdministrador(aDTO);
		return getDirectorioAdministradoresDAO().delete(a);
	}

	public boolean actualizarAdministrador(AdministradorDTO viejoDTO, AdministradorDTO nuevoDTO)  {
		Administrador viejo = MapHandler.convertirAdministradorDTOAAdministrador(viejoDTO);
		Administrador nuevo = MapHandler.convertirAdministradorDTOAAdministrador(nuevoDTO);
		return getDirectorioAdministradoresDAO().update(viejo, nuevo);
	}
	public Administrador encontrarAdministrador( AdministradorDTO aDTO)  {
		Administrador a = MapHandler.convertirAdministradorDTOAAdministrador(aDTO);
		return getDirectorioAdministradoresDAO().find(a);
	}

	public ArrayList<Administrador> obtenerAdministradores() {
		return getDirectorioAdministradoresDAO().getAll();
	}
	public DirectorioAdministradoresDAO getDirectorioAdministradoresDAO() {
		return directorioAdministradoresDAO;
	}
	public void setDirectorioAdministradoresDAO(DirectorioAdministradoresDAO directorioAdministradoresDAO) {
		this.directorioAdministradoresDAO = directorioAdministradoresDAO;
	}

}
