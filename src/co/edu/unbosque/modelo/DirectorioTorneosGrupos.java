package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioTorneosGruposDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;
import co.edu.unbosque.modelo.persistencia.TorneoGruposDTO;

/**
 * Clase encargada de manejar el directorio de torneos por grupos.
 * Permite realizar operaciones CRUD sobre los torneos, utilizando
 * un objeto DAO para la persistencia.
 */
public class DirectorioTorneosGrupos {

    /** DAO que maneja la persistencia de los torneos por grupos */
    private DirectorioTorneosGruposDAO directorioTorneosGruposDAO;

    /**
     * Constructor que inicializa el DAO de torneos por grupos.
     */
    public DirectorioTorneosGrupos() {
        setDirectorioTorneosGruposDAO(new DirectorioTorneosGruposDAO());
    }

    /**
     * Carga todos los torneos por grupos desde la base de datos o almacenamiento.
     */
    public void cargarTorneosGrupos() {
        directorioTorneosGruposDAO.actualizarTorneosGrupos();
    }

    /**
     * Agrega un nuevo torneo por grupos al directorio.
     *
     * @param aDTO El DTO con los datos del torneo a agregar
     * @return true si se agregó exitosamente, false si ocurrió un error
     */
    public boolean adicionarTorneoGrupos(TorneoGruposDTO aDTO) {
        TorneoGrupos a = MapHandler.convertirTorneoGruposDTOATorneoGrupos(aDTO);
        return getDirectorioTorneosGruposDAO().add(a);
    }

    /**
     * Elimina un torneo por grupos del directorio.
     *
     * @param aDTO El DTO del torneo a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarTorneoGrupos(TorneoGruposDTO aDTO) {
        TorneoGrupos a = MapHandler.convertirTorneoGruposDTOATorneoGrupos(aDTO);
        return getDirectorioTorneosGruposDAO().delete(a);
    }

    /**
     * Actualiza un torneo por grupos existente en el directorio.
     *
     * @param viejoDTO DTO con los datos actuales del torneo
     * @param nuevoDTO DTO con los nuevos datos del torneo
     * @return true si se actualizó correctamente, false si falló
     */
    public boolean actualizarTorneoGrupos(TorneoGruposDTO viejoDTO, TorneoGruposDTO nuevoDTO) {
        TorneoGrupos viejo = MapHandler.convertirTorneoGruposDTOATorneoGrupos(viejoDTO);
        TorneoGrupos nuevo = MapHandler.convertirTorneoGruposDTOATorneoGrupos(nuevoDTO);
        return getDirectorioTorneosGruposDAO().update(viejo, nuevo);
    }

    /**
     * Busca un torneo por grupos en el directorio.
     *
     * @param aDTO DTO del torneo que se desea buscar
     * @return Objeto TorneoGrupos si se encuentra, null si no existe
     */
    public TorneoGrupos encontrarTorneoGrupos(TorneoGruposDTO aDTO) {
        TorneoGrupos a = MapHandler.convertirTorneoGruposDTOATorneoGrupos(aDTO);
        return getDirectorioTorneosGruposDAO().find(a);
    }

    /**
     * Obtiene una lista de todos los torneos por grupos registrados.
     *
     * @return Lista de objetos TorneoGrupos
     */
    public ArrayList<TorneoGrupos> obtenerTorneosGrupos() {
        return getDirectorioTorneosGruposDAO().getAll();
    }

    /**
     * Obtiene el DAO que maneja la persistencia de los torneos por grupos.
     *
     * @return Objeto DirectorioTorneosGruposDAO
     */
    public DirectorioTorneosGruposDAO getDirectorioTorneosGruposDAO() {
        return directorioTorneosGruposDAO;
    }

    /**
     * Establece el DAO que se utilizará para manejar la persistencia de los torneos.
     *
     * @param directorioTorneosGruposDAO Objeto DAO a establecer
     */
    public void setDirectorioTorneosGruposDAO(DirectorioTorneosGruposDAO directorioTorneosGruposDAO) {
        this.directorioTorneosGruposDAO = directorioTorneosGruposDAO;
    }
}
