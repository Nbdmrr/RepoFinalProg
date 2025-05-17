package co.edu.unbosque.modelo;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioTorneosPuntosDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;
import co.edu.unbosque.modelo.persistencia.TorneoPuntosDTO;

/**
 * Clase que administra un directorio de torneos por puntos.
 * Utiliza un DAO para realizar operaciones CRUD sobre los torneos.
 */
public class DirectorioTorneosPuntos {

    /** Objeto DAO que maneja la persistencia de los torneos por puntos */
    private DirectorioTorneosPuntosDAO directorioTorneosPuntosDAO;

    /**
     * Constructor que inicializa el DAO para torneos por puntos.
     */
    public DirectorioTorneosPuntos() {
        setDirectorioTorneosPuntosDAO(new DirectorioTorneosPuntosDAO());
    }

    /**
     * Carga todos los torneos por puntos desde el origen de datos.
     */
    public void cargarTorneosPuntos() {
        directorioTorneosPuntosDAO.actualizarTorneosPuntos();
    }

    /**
     * Adiciona un nuevo torneo por puntos al directorio.
     *
     * @param aDTO Objeto DTO con los datos del torneo
     * @return true si se agregó exitosamente, false si falló
     */
    public boolean adicionarTorneoPuntos(TorneoPuntosDTO aDTO) {
        TorneoPuntos a = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(aDTO);
        return getDirectorioTorneosPuntosDAO().add(a);
    }

    /**
     * Elimina un torneo por puntos del directorio.
     *
     * @param aDTO DTO del torneo a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarTorneoPuntos(TorneoPuntosDTO aDTO) {
        TorneoPuntos a = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(aDTO);
        return getDirectorioTorneosPuntosDAO().delete(a);
    }

    /**
     * Actualiza un torneo por puntos existente en el directorio.
     *
     * @param viejoDTO DTO con los datos antiguos
     * @param nuevoDTO DTO con los nuevos datos
     * @return true si se actualizó correctamente, false si falló
     */
    public boolean actualizarTorneoPuntos(TorneoPuntosDTO viejoDTO, TorneoPuntosDTO nuevoDTO) {
        TorneoPuntos viejo = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(viejoDTO);
        TorneoPuntos nuevo = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(nuevoDTO);
        return getDirectorioTorneosPuntosDAO().update(viejo, nuevo);
    }

    /**
     * Busca un torneo por puntos en el directorio.
     *
     * @param aDTO DTO del torneo que se desea buscar
     * @return Objeto TorneoPuntos si se encuentra, null si no
     */
    public TorneoPuntos encontrarTorneoPuntos(TorneoPuntosDTO aDTO) {
        TorneoPuntos a = MapHandler.convertirTorneoPuntosDTOATorneoPuntos(aDTO);
        return getDirectorioTorneosPuntosDAO().find(a);
    }

    /**
     * Obtiene una lista de todos los torneos por puntos almacenados.
     *
     * @return Lista de torneos por puntos
     */
    public ArrayList<TorneoPuntos> obtenerTorneosPuntos() {
        return getDirectorioTorneosPuntosDAO().getAll();
    }

    /**
     * Obtiene el DAO que maneja la persistencia de torneos por puntos.
     *
     * @return Objeto DirectorioTorneosPuntosDAO
     */
    public DirectorioTorneosPuntosDAO getDirectorioTorneosPuntosDAO() {
        return directorioTorneosPuntosDAO;
    }

    /**
     * Establece el DAO que maneja la persistencia de torneos por puntos.
     *
     * @param directorioTorneosPuntosDAO Objeto DAO
     */
    public void setDirectorioTorneosPuntosDAO(DirectorioTorneosPuntosDAO directorioTorneosPuntosDAO) {
        this.directorioTorneosPuntosDAO = directorioTorneosPuntosDAO;
    }
}
