package co.edu.unbosque.modelo;

import java.util.ArrayList;

/**
 * Clase que funciona como directorio principal que agrupa y administra
 * los diferentes directorios de la aplicación relacionados con
 * administradores, entrenadores, equipos, jugadores y tipos de torneos.
 */
public class DirectorioPrincipal {

    /** Directorio de administradores */
    private DirectorioAdministradores directorioAdministradores;

    /** Directorio de entrenadores */
    private DirectorioEntrenadores directorioEntrenadores;

    /** Directorio de equipos */
    private DirectorioEquipos directorioEquipos;

    /** Directorio de jugadores */
    private DirectorioJugadores directorioJugadores;

    /** Directorio de torneos por grupos */
    private DirectorioTorneosGrupos directorioTorneosGrupos;

    /** Directorio de torneos por eliminación */
    private DirectorioTorneosEliminacion directorioTorneosEliminacion;

    /** Directorio de torneos por puntos */
    private DirectorioTorneosPuntos directorioTorneosPuntos;

    /**
     * Constructor que inicializa todos los directorios internos.
     */
    public DirectorioPrincipal() {
        setDirectorioAdministradores(new DirectorioAdministradores());
        setDirectorioEntrenadores(new DirectorioEntrenadores());
        setDirectorioEquipos(new DirectorioEquipos());
        setDirectorioJugadores(new DirectorioJugadores());
        setDirectorioTorneosGrupos(new DirectorioTorneosGrupos());
        setDirectorioTorneosEliminacion(new DirectorioTorneosEliminacion());
        setDirectorioTorneosPuntos(new DirectorioTorneosPuntos());
    }

    /**
     * Obtiene el directorio de torneos por puntos.
     * @return El objeto DirectorioTorneosPuntos
     */
    public DirectorioTorneosPuntos getDirectorioTorneosPuntos() {
        return directorioTorneosPuntos;
    }

    /**
     * Establece el directorio de torneos por puntos.
     * @param directorioTorneosPuntos El directorio a establecer
     */
    public void setDirectorioTorneosPuntos(DirectorioTorneosPuntos directorioTorneosPuntos) {
        this.directorioTorneosPuntos = directorioTorneosPuntos;
    }

    /**
     * Obtiene el directorio de torneos por eliminación.
     * @return El objeto DirectorioTorneosEliminacion
     */
    public DirectorioTorneosEliminacion getDirectorioTorneosEliminacion() {
        return directorioTorneosEliminacion;
    }

    /**
     * Establece el directorio de torneos por eliminación.
     * @param directorioTorneosEliminacion El directorio a establecer
     */
    public void setDirectorioTorneosEliminacion(DirectorioTorneosEliminacion directorioTorneosEliminacion) {
        this.directorioTorneosEliminacion = directorioTorneosEliminacion;
    }

    /**
     * Obtiene el directorio de torneos por grupos.
     * @return El objeto DirectorioTorneosGrupos
     */
    public DirectorioTorneosGrupos getDirectorioTorneosGrupos() {
        return directorioTorneosGrupos;
    }

    /**
     * Establece el directorio de torneos por grupos.
     * @param directorioTorneoGrupos El directorio a establecer
     */
    public void setDirectorioTorneosGrupos(DirectorioTorneosGrupos directorioTorneoGrupos) {
        this.directorioTorneosGrupos = directorioTorneoGrupos;
    }

    /**
     * Obtiene el directorio de jugadores.
     * @return El objeto DirectorioJugadores
     */
    public DirectorioJugadores getDirectorioJugadores() {
        return directorioJugadores;
    }

    /**
     * Establece el directorio de jugadores.
     * @param directorioJugadores El directorio a establecer
     */
    public void setDirectorioJugadores(DirectorioJugadores directorioJugadores) {
        this.directorioJugadores = directorioJugadores;
    }

    /**
     * Obtiene el directorio de equipos.
     * @return El objeto DirectorioEquipos
     */
    public DirectorioEquipos getDirectorioEquipos() {
        return directorioEquipos;
    }

    /**
     * Establece el directorio de equipos.
     * @param directorioEquipos El directorio a establecer
     */
    public void setDirectorioEquipos(DirectorioEquipos directorioEquipos) {
        this.directorioEquipos = directorioEquipos;
    }

    /**
     * Obtiene el directorio de entrenadores.
     * @return El objeto DirectorioEntrenadores
     */
    public DirectorioEntrenadores getDirectorioEntrenadores() {
        return directorioEntrenadores;
    }

    /**
     * Establece el directorio de entrenadores.
     * @param directorioEntrenadores El directorio a establecer
     */
    public void setDirectorioEntrenadores(DirectorioEntrenadores directorioEntrenadores) {
        this.directorioEntrenadores = directorioEntrenadores;
    }

    /**
     * Obtiene el directorio de administradores.
     * @return El objeto DirectorioAdministradores
     */
    public DirectorioAdministradores getDirectorioAdministradores() {
        return directorioAdministradores;
    }

    /**
     * Establece el directorio de administradores.
     * @param directorioAdministradores El directorio a establecer
     */
    public void setDirectorioAdministradores(DirectorioAdministradores directorioAdministradores) {
        this.directorioAdministradores = directorioAdministradores;
    }
    
    /**
     * Convierte los torneos de los diferentes tipos (`TorneoEliminacion`, `TorneoPuntos`, `TorneoGrupos`) 
     * en una lista de cadenas (`ArrayList<String>`) representando cada torneo.
     * 
     * Obtiene los torneos de los directorios correspondientes, los convierte a `String` mediante su método 
     * `toString()` y los agrega a un único `ArrayList<String>`.
     * 
     * @return Un `ArrayList<String>` con las representaciones en texto de todos los torneos.
     */
    public ArrayList<String> convertirTorneosAStrings() {
        
        ArrayList<String> torneosEnString = new ArrayList<>();
        ArrayList<TorneoEliminacion> torneosEliminacion = getDirectorioTorneosEliminacion().obtenerTorneosEliminacio();
        ArrayList<TorneoPuntos> torneosPuntos = getDirectorioTorneosPuntos().obtenerTorneosPuntos();
        ArrayList<TorneoGrupos> torneosGrupos = getDirectorioTorneosGrupos().obtenerTorneosGrupos();
        
        for (TorneoEliminacion torneoEliminacion : torneosEliminacion) {
            torneosEnString.add(torneoEliminacion.toString());
        }
        
        for (TorneoGrupos torneoGrupos : torneosGrupos) {
            torneosEnString.add(torneoGrupos.toString());
        }
        
        for (TorneoPuntos torneoPuntos : torneosPuntos) {
            torneosEnString.add(torneoPuntos.toString());
        }
        
        return torneosEnString;
    }


}
