package co.edu.unbosque.modelo;

import co.edu.unbosque.modelo.persistencia.EquipoDTO;

import java.util.ArrayList;

import co.edu.unbosque.modelo.persistencia.DirectorioEquiposDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;

/**
 * Clase que administra el directorio de equipos.
 * Permite cargar, agregar, eliminar, actualizar, buscar y obtener equipos.
 */
public class DirectorioEquipos {
    
    /** DAO encargado de la persistencia de los equipos */
    private DirectorioEquiposDAO directorioEquiposDAO;
    
    /**
     * Constructor que inicializa el DAO de equipos.
     */
    public DirectorioEquipos() {
        directorioEquiposDAO = new DirectorioEquiposDAO();
    }
    
    /**
     * Carga la lista de equipos desde la fuente de datos.
     */
    public void cargarEquipos() {
        directorioEquiposDAO.actualizarEquipos();
    }
    
    /**
     * Agrega un nuevo equipo al directorio.
     * @param aDTO Objeto DTO con los datos del equipo a agregar
     * @return true si el equipo fue agregado exitosamente, false en caso contrario
     */
    public boolean adicionarEquipo(EquipoDTO aDTO) {
        Equipo a = MapHandler.convertirEquipoDTOAEquipo(aDTO);
        return getDirectorioEquiposDAO().add(a);
    }

    /**
     * Elimina un equipo del directorio.
     * @param aDTO Objeto DTO con los datos del equipo a eliminar
     * @return true si el equipo fue eliminado exitosamente, false en caso contrario
     */
    public boolean eliminarEquipo(EquipoDTO aDTO) {
        Equipo a = MapHandler.convertirEquipoDTOAEquipo(aDTO);
        return getDirectorioEquiposDAO().delete(a);
    }

    /**
     * Actualiza la información de un equipo existente.
     * @param viejoDTO Objeto DTO con los datos actuales del equipo
     * @param nuevoDTO Objeto DTO con los nuevos datos del equipo
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizarEquipo(EquipoDTO viejoDTO, EquipoDTO nuevoDTO) {
        Equipo viejo = MapHandler.convertirEquipoDTOAEquipo(viejoDTO);
        Equipo nuevo = MapHandler.convertirEquipoDTOAEquipo(nuevoDTO);
        return getDirectorioEquiposDAO().update(viejo, nuevo);
    }

    /**
     * Busca un equipo en el directorio.
     * @param aDTO Objeto DTO con los datos del equipo a buscar
     * @return El objeto Equipo encontrado, o null si no existe
     */
    public Equipo encontrarEquipo(EquipoDTO aDTO) {
        Equipo a = MapHandler.convertirEquipoDTOAEquipo(aDTO);
        return getDirectorioEquiposDAO().find(a);
    }

    /**
     * Obtiene la lista completa de equipos.
     * @return ArrayList con todos los equipos en el directorio
     */
    public ArrayList<Equipo> obtenerEquipos() {
        return getDirectorioEquiposDAO().getAll();
    }

    /**
     * Obtiene el DAO encargado de la persistencia de equipos.
     * @return El objeto DirectorioEquiposDAO
     */
    public DirectorioEquiposDAO getDirectorioEquiposDAO() {
        return directorioEquiposDAO;
    }

    /**
     * Establece el DAO encargado de la persistencia de equipos.
     * @param directorioEquiposDAO El objeto DAO a asignar
     */
    public void setDirectorioEquiposDAO(DirectorioEquiposDAO directorioEquiposDAO) {
        this.directorioEquiposDAO = directorioEquiposDAO;
    }
    
    /**
     * Convierte una lista de objetos Equipo a una lista de sus nombres como Strings.
     * @param equipos Lista de objetos Equipo
     * @return Lista de nombres de equipos en formato String
     */
    public ArrayList<String> convertirEquiposAStrings() {
    	ArrayList<Equipo> equipos = obtenerEquipos();
        ArrayList<String> stringEquipos = new ArrayList<String>();
        for (Equipo equipo : equipos) {
            stringEquipos.add(equipo.getNombre());
        }
        return stringEquipos;
    }
}
