package co.edu.unbosque.modelo;

import co.edu.unbosque.modelo.persistencia.TorneoEliminacionDTO;
import java.util.ArrayList;
import co.edu.unbosque.modelo.persistencia.DirectorioTorneosEliminacionDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

/**
 * Clase encargada de manejar el directorio de torneos por eliminación.
 * Permite realizar operaciones CRUD sobre los torneos, utilizando
 * un objeto DAO para la persistencia.
 */
public class DirectorioTorneosEliminacion {

    /** DAO encargado de la persistencia de los torneos por eliminación */
    private DirectorioTorneosEliminacionDAO directorioTorneosEliminacionDAO;

    /**
     * Constructor que inicializa el DAO de torneos por eliminación.
     */
    public DirectorioTorneosEliminacion() {
        setDirectorioTorneosEliminacionDAO(new DirectorioTorneosEliminacionDAO());
    }

    /**
     * Carga todos los torneos por eliminación desde el almacenamiento.
     */
    public void cargarTorneosEliminacion() {
        directorioTorneosEliminacionDAO.actualizarTorneosEliminacion();
    }

    /**
     * Agrega un nuevo torneo por eliminación al directorio.
     *
     * @param aDTO El DTO con los datos del torneo a agregar
     * @return true si se agregó exitosamente, false en caso contrario
     */
    public boolean adicionarTorneoEliminacion(TorneoEliminacionDTO aDTO) {
        TorneoEliminacion a = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(aDTO);
        return getDirectorioTorneosEliminacionDAO().add(a);
    }

    /**
     * Elimina un torneo por eliminación del directorio.
     *
     * @param aDTO El DTO del torneo a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarTorneoEliminacion(TorneoEliminacionDTO aDTO) {
        TorneoEliminacion a = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(aDTO);
        return getDirectorioTorneosEliminacionDAO().delete(a);
    }

    /**
     * Actualiza un torneo por eliminación existente en el directorio.
     *
     * @param viejoDTO DTO con los datos actuales del torneo
     * @param nuevoDTO DTO con los nuevos datos del torneo
     * @return true si se actualizó correctamente, false si falló
     */
    public boolean actualizarTorneoEliminacion(TorneoEliminacionDTO viejoDTO, TorneoEliminacionDTO nuevoDTO) {
        TorneoEliminacion viejo = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(viejoDTO);
        TorneoEliminacion nuevo = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(nuevoDTO);
        return getDirectorioTorneosEliminacionDAO().update(viejo, nuevo);
    }

    /**
     * Busca un torneo por eliminación en el directorio.
     *
     * @param aDTO DTO del torneo que se desea buscar
     * @return Objeto TorneoEliminacion si se encuentra, null si no existe
     */
    public TorneoEliminacion encontrarTorneoEliminacion(TorneoEliminacionDTO aDTO) {
        TorneoEliminacion a = MapHandler.convertirTorneoEliminacionDTOATorneoEliminacion(aDTO);
        return getDirectorioTorneosEliminacionDAO().find(a);
    }

    /**
     * Obtiene una lista de todos los torneos por eliminación registrados.
     *
     * @return Lista de objetos TorneoEliminacion
     */
    public ArrayList<TorneoEliminacion> obtenerTorneosEliminacio() {
        return getDirectorioTorneosEliminacionDAO().getAll();
    }

    /**
     * Obtiene el DAO que maneja la persistencia de los torneos por eliminación.
     *
     * @return Objeto DirectorioTorneosEliminacionDAO
     */
    public DirectorioTorneosEliminacionDAO getDirectorioTorneosEliminacionDAO() {
        return directorioTorneosEliminacionDAO;
    }

    /**
     * Establece el DAO que se utilizará para manejar la persistencia de los torneos.
     *
     * @param directorioTorneosEliminacionDAO Objeto DAO a establecer
     */
    public void setDirectorioTorneosEliminacionDAO(DirectorioTorneosEliminacionDAO directorioTorneosEliminacionDAO) {
        this.directorioTorneosEliminacionDAO = directorioTorneosEliminacionDAO;
    }
}

