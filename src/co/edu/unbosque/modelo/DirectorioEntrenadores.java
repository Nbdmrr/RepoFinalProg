package co.edu.unbosque.modelo;

import co.edu.unbosque.modelo.persistencia.EntrenadorDTO;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioEntrenadoresDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

/**
 * Clase que administra el directorio de entrenadores.
 * Proporciona métodos para cargar, agregar, eliminar, actualizar,
 * buscar y obtener entrenadores.
 */
public class DirectorioEntrenadores {
	
	/** DAO para la persistencia de entrenadores */
	private DirectorioEntrenadoresDAO directorioEntrenadoresDAO;

	/**
	 * Constructor que inicializa el DAO de entrenadores.
	 */
	public DirectorioEntrenadores() {
		directorioEntrenadoresDAO = new DirectorioEntrenadoresDAO();
	}

	/**
	 * Carga la lista de entrenadores desde la fuente de datos.
	 */
	public void cargarEntrenadores() {
		directorioEntrenadoresDAO.actualizarEntrenadores();
	}

	/**
	 * Agrega un nuevo entrenador al directorio.
	 * @param aDTO Objeto DTO con los datos del entrenador a agregar.
	 * @return true si el entrenador fue agregado exitosamente, false en caso contrario.
	 */
	public boolean adicionarEntrenador(EntrenadorDTO aDTO) {
		Entrenador a = MapHandler.convertirEntrenadorDTOAEntrenador(aDTO);
		return directorioEntrenadoresDAO.add(a);
	}

	/**
	 * Elimina un entrenador del directorio.
	 * @param aDTO Objeto DTO con los datos del entrenador a eliminar.
	 * @return true si el entrenador fue eliminado exitosamente, false en caso contrario.
	 */
	public boolean eliminarEntrenador(EntrenadorDTO aDTO) {
		Entrenador a = MapHandler.convertirEntrenadorDTOAEntrenador(aDTO);
		return directorioEntrenadoresDAO.delete(a);
	}

	/**
	 * Actualiza la información de un entrenador existente.
	 * @param viejoDTO Objeto DTO con los datos actuales del entrenador.
	 * @param nuevoDTO Objeto DTO con los nuevos datos del entrenador.
	 * @return true si la actualización fue exitosa, false en caso contrario.
	 */
	public boolean actualizarEntrenador(EntrenadorDTO viejoDTO, EntrenadorDTO nuevoDTO) {
		Entrenador viejo = MapHandler.convertirEntrenadorDTOAEntrenador(viejoDTO);
		Entrenador nuevo = MapHandler.convertirEntrenadorDTOAEntrenador(nuevoDTO);
		return directorioEntrenadoresDAO.update(viejo, nuevo);
	}

	/**
	 * Busca un entrenador en el directorio.
	 * @param aDTO Objeto DTO con los datos del entrenador a buscar.
	 * @return El objeto Entrenador encontrado, o null si no existe.
	 */
	public Entrenador encontrarEntrenadores(EntrenadorDTO aDTO) {
		Entrenador a = MapHandler.convertirEntrenadorDTOAEntrenador(aDTO);
		return getDirectorioEntrenadoresDAO().find(a);
	}

	/**
	 * Obtiene la lista completa de entrenadores.
	 * @return ArrayList con todos los entrenadores en el directorio.
	 */
	public ArrayList<Entrenador> obtenerEntrenadores() {
		return directorioEntrenadoresDAO.getAll();
	}

	/**
	 * Obtiene el DAO encargado de la persistencia de entrenadores.
	 * @return El objeto DirectorioEntrenadoresDAO.
	 */
	public DirectorioEntrenadoresDAO getDirectorioEntrenadoresDAO() {
		return directorioEntrenadoresDAO;
	}

	/**
	 * Establece el DAO encargado de la persistencia de entrenadores.
	 * @param directorioEntrenadoresDAO El objeto DAO a asignar.
	 */
	public void setDirectorioEntrenadoresDAO(DirectorioEntrenadoresDAO directorioEntrenadoresDAO) {
		this.directorioEntrenadoresDAO = directorioEntrenadoresDAO;
	}
}
