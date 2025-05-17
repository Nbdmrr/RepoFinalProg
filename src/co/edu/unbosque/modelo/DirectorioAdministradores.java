package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.AdministradorDTO;
import co.edu.unbosque.modelo.persistencia.DirectorioAdministradoresDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

/**
 * Clase que administra el directorio de administradores.
 * Permite cargar, agregar, eliminar, actualizar, buscar y obtener administradores.
 */
public class DirectorioAdministradores {
	
	/** DAO para la persistencia de administradores */
	private DirectorioAdministradoresDAO directorioAdministradoresDAO;

	/**
	 * Constructor que inicializa el DAO de administradores.
	 */
	public DirectorioAdministradores() {
		setDirectorioAdministradoresDAO(new DirectorioAdministradoresDAO());
	}

	/**
	 * Carga la lista de administradores desde la fuente de datos.
	 */
	public void cargarAdministradores() {
		directorioAdministradoresDAO.actualizarAdministradores();
	}

	/**
	 * Agrega un nuevo administrador al directorio.
	 * @param aDTO Objeto DTO con los datos del administrador a agregar.
	 * @return true si se agregó correctamente, false en caso contrario.
	 */
	public boolean adicionarAdministrador(AdministradorDTO aDTO) {
		Administrador a = MapHandler.convertirAdministradorDTOAAdministrador(aDTO);
		return getDirectorioAdministradoresDAO().add(a);
	}

	/**
	 * Elimina un administrador del directorio.
	 * @param aDTO Objeto DTO con los datos del administrador a eliminar.
	 * @return true si se eliminó correctamente, false en caso contrario.
	 */
	public boolean eliminarAdministrador(AdministradorDTO aDTO) {
		Administrador a = MapHandler.convertirAdministradorDTOAAdministrador(aDTO);
		return getDirectorioAdministradoresDAO().delete(a);
	}

	/**
	 * Actualiza la información de un administrador existente.
	 * @param viejoDTO DTO con los datos actuales del administrador.
	 * @param nuevoDTO DTO con los nuevos datos del administrador.
	 * @return true si la actualización fue exitosa, false en caso contrario.
	 */
	public boolean actualizarAdministrador(AdministradorDTO viejoDTO, AdministradorDTO nuevoDTO) {
		Administrador viejo = MapHandler.convertirAdministradorDTOAAdministrador(viejoDTO);
		Administrador nuevo = MapHandler.convertirAdministradorDTOAAdministrador(nuevoDTO);
		return getDirectorioAdministradoresDAO().update(viejo, nuevo);
	}

	/**
	 * Busca un administrador en el directorio.
	 * @param aDTO DTO con los datos del administrador a buscar.
	 * @return El objeto Administrador encontrado, o null si no existe.
	 */
	public Administrador encontrarAdministrador(AdministradorDTO aDTO) {
		Administrador a = MapHandler.convertirAdministradorDTOAAdministrador(aDTO);
		return getDirectorioAdministradoresDAO().find(a);
	}

	/**
	 * Obtiene la lista completa de administradores.
	 * @return ArrayList con todos los administradores.
	 */
	public ArrayList<Administrador> obtenerAdministradores() {
		return getDirectorioAdministradoresDAO().getAll();
	}

	/**
	 * Obtiene el DAO para la persistencia de administradores.
	 * @return El objeto DirectorioAdministradoresDAO.
	 */
	public DirectorioAdministradoresDAO getDirectorioAdministradoresDAO() {
		return directorioAdministradoresDAO;
	}

	/**
	 * Establece el DAO para la persistencia de administradores.
	 * @param directorioAdministradoresDAO El objeto DAO a asignar.
	 */
	public void setDirectorioAdministradoresDAO(DirectorioAdministradoresDAO directorioAdministradoresDAO) {
		this.directorioAdministradoresDAO = directorioAdministradoresDAO;
	}

}
