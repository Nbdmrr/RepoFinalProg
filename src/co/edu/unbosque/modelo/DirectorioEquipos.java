package co.edu.unbosque.modelo;

import co.edu.unbosque.modelo.persistencia.EquipoDTO;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.AdministradorDTO;
import co.edu.unbosque.modelo.persistencia.DirectorioEquiposDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

public class DirectorioEquipos {
	private DirectorioEquiposDAO directorioEquiposDAO;
	
	public DirectorioEquipos() {
directorioEquiposDAO = new DirectorioEquiposDAO();
	}
	public void cargarEquipos() {
		directorioEquiposDAO.actualizarEquipos();
		
	}
	public boolean adicionarEquipo( EquipoDTO aDTO)  {
		Equipo a = MapHandler.convertirEquipoDTOAEquipo(aDTO);
		return getDirectorioEquiposDAO().add(a);
	}

	public boolean eliminarEquipo(EquipoDTO aDTO)  {
		Equipo a = MapHandler.convertirEquipoDTOAEquipo(aDTO);
		return getDirectorioEquiposDAO().delete(a);
	}

	public boolean actualizarEquipo(EquipoDTO viejoDTO, EquipoDTO nuevoDTO)  {
		Equipo viejo = MapHandler.convertirEquipoDTOAEquipo(viejoDTO);
		Equipo nuevo = MapHandler.convertirEquipoDTOAEquipo(nuevoDTO);
		return getDirectorioEquiposDAO().update(viejo, nuevo);
	}
	public Equipo encontrarEquipo(EquipoDTO aDTO)  {
		Equipo a = MapHandler.convertirEquipoDTOAEquipo(aDTO);
		return getDirectorioEquiposDAO().find(a);
	}

	public ArrayList<Equipo> obtenerEquipos() {
		return getDirectorioEquiposDAO().getAll();
	}
	public DirectorioEquiposDAO getDirectorioEquiposDAO() {
		return directorioEquiposDAO;
	}
	public void setDirectorioEquiposDAO(DirectorioEquiposDAO directorioEquiposDAO) {
		this.directorioEquiposDAO = directorioEquiposDAO;
	}
	
	public ArrayList<String> convertirEquiposAStrings(ArrayList<Equipo> equipos){
		
		ArrayList<String> stringEquipos = new ArrayList<String>();
		
		for (Equipo equipo : equipos) {
			stringEquipos.add(equipo.getNombre());
			
		}
		return stringEquipos;
	}
	
	

}
