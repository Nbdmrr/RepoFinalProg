package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioJugadoresDAO;
import co.edu.unbosque.modelo.persistencia.JugadorDTO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

/**
 * Clase que administra el directorio de jugadores.
 * Proporciona métodos para cargar, agregar, eliminar, actualizar
 * y buscar jugadores en el directorio.
 */
public class DirectorioJugadores {
    
    /** DAO que maneja la persistencia de los jugadores */
    private DirectorioJugadoresDAO directorioJugadoresDAO;
    
    /**
     * Constructor que inicializa el DAO de jugadores.
     */
    public DirectorioJugadores() {
        setDirectorioJugadoresDAO(new DirectorioJugadoresDAO());
    }

    /**
     * Carga la lista de jugadores desde la fuente de datos.
     */
    public void cargarJugadores() {
        directorioJugadoresDAO.actualizarJugadores();
    }
    
    /**
     * Agrega un nuevo jugador al directorio.
     * @param aDTO Objeto DTO con los datos del jugador a agregar
     * @return true si el jugador fue agregado exitosamente, false en caso contrario
     */
    public boolean adicionarJugador(JugadorDTO aDTO) {
        Jugador a = MapHandler.convertirJugadorDTOAJugador(aDTO);
        return getDirectorioJugadoresDAO().add(a);
    }

    /**
     * Elimina un jugador del directorio.
     * @param aDTO Objeto DTO con los datos del jugador a eliminar
     * @return true si el jugador fue eliminado exitosamente, false en caso contrario
     */
    public boolean eliminarJugador(JugadorDTO aDTO) {
        Jugador a = MapHandler.convertirJugadorDTOAJugador(aDTO);
        return getDirectorioJugadoresDAO().delete(a);
    }

    /**
     * Actualiza la información de un jugador existente.
     * @param viejoDTO Objeto DTO con los datos actuales del jugador
     * @param nuevoDTO Objeto DTO con los nuevos datos del jugador
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizarJugador(JugadorDTO viejoDTO, JugadorDTO nuevoDTO) {
        Jugador viejo = MapHandler.convertirJugadorDTOAJugador(viejoDTO);
        Jugador nuevo = MapHandler.convertirJugadorDTOAJugador(nuevoDTO);
        return getDirectorioJugadoresDAO().update(viejo, nuevo);
    }

    /**
     * Busca un jugador en el directorio.
     * @param aDTO Objeto DTO con los datos del jugador a buscar
     * @return El objeto Jugador encontrado, o null si no existe
     */
    public Jugador encontrarJugador(JugadorDTO aDTO) {
        Jugador a = MapHandler.convertirJugadorDTOAJugador(aDTO);
        return getDirectorioJugadoresDAO().find(a);
    }

    /**
     * Obtiene la lista completa de jugadores.
     * @return ArrayList con todos los jugadores en el directorio
     */
    public ArrayList<Jugador> obtenerJugador() {
        return getDirectorioJugadoresDAO().getAll();
    }

    /**
     * Obtiene el DAO encargado de la persistencia de jugadores.
     * @return El objeto DirectorioJugadoresDAO
     */
    public DirectorioJugadoresDAO getDirectorioJugadoresDAO() {
        return directorioJugadoresDAO;
    }

    /**
     * Establece el DAO encargado de la persistencia de jugadores.
     * @param directorioJugadoresDAO El objeto DAO a asignar
     */
    public void setDirectorioJugadoresDAO(DirectorioJugadoresDAO directorioJugadoresDAO) {
        this.directorioJugadoresDAO = directorioJugadoresDAO;
    }

}

