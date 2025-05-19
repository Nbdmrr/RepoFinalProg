package co.edu.unbosque.modelo;

/**
 * Clase que representa a un jugador en el sistema, heredando de la clase Usuario.
 * Contiene información específica sobre el rendimiento del jugador en partidas y torneos.
 */
public class Jugador extends Usuario {
    
    /** Número de partidas jugadas por el jugador. */
    private int partidasJugadas;
    
    /** Número de torneos jugados por el jugador. */
    private int torneosJugados;
    
    /** Número de partidas ganadas por el jugador. */
    private int partidasGanadas;
    
    /** Número de torneos ganados por el jugador. */
    private int torneosGanados;
    
    /** Especialidad del jugador. */
    private String especialidad;
    
    /** Puntos acumulados por el jugador. */
    private int puntos;
    
    /** Equipo al que pertenece el jugador. */
    private String equipo;

    /**
     * Constructor de la clase Jugador.
     * @param usuario Nombre de usuario del jugador.
     * @param contraseña Contraseña del jugador.
     * @param nacionalidad Nacionalidad del jugador.
     * @param correo Correo electrónico del jugador.
     * @param especialidad Especialidad del jugador.
     * @param equipo Equipo al que pertenece el jugador.
     */
    public Jugador(String usuario, String contraseña, String nacionalidad, String correo, String especialidad, String equipo) {
        super(usuario, contraseña, nacionalidad, correo);
        setEspecialidad(especialidad);
        this.setPuntos(0);
        this.equipo = equipo;
        setPartidasGanadas(0);
        setPartidasJugadas(0);
        setTorneosGanados(0);
        setTorneosJugados(0);
        tipo = "Jugador";
    }

    /**
     * Incrementa en 1 el número de partidas ganadas por el jugador.
     */
    public void sumarPartidaGanada() {
        int ganada = 1 + getPartidasGanadas();
        setPartidasGanadas(ganada);
    }

    /**
     * Incrementa en 1 el número de partidas jugadas por el jugador.
     */
    public void sumarPartidaJugada() {
        int ganada = 1 + getPartidasJugadas();
        setPartidasJugadas(ganada);
    }

    /**
     * Incrementa en 1 el número de torneos ganados por el jugador.
     */
    public void sumarTorneoGanado() {
        int ganada = 1 + getTorneosGanados();
        setTorneosGanados(ganada);
    }

    /**
     * Incrementa en 1 el número de torneos jugados por el jugador.
     */
    public void sumarTorneoJugado() {
        int ganada = 1 + getTorneosJugados();
        setTorneosJugados(ganada);
    }

    /**
     * Obtiene la especialidad del jugador.
     * @return Especialidad del jugador.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad del jugador.
     * @param especialidad Especialidad del jugador.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene el número de torneos ganados por el jugador.
     * @return Número de torneos ganados.
     */
    public int getTorneosGanados() {
        return torneosGanados;
    }

    /**
     * Establece el número de torneos ganados por el jugador.
     * @param torneosGanados Número de torneos ganados.
     */
    public void setTorneosGanados(int torneosGanados) {
        this.torneosGanados = torneosGanados;
    }

    /**
     * Obtiene el número de partidas ganadas por el jugador.
     * @return Número de partidas ganadas.
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * Establece el número de partidas ganadas por el jugador.
     * @param partidasGanadas Número de partidas ganadas.
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * Obtiene el número de torneos jugados por el jugador.
     * @return Número de torneos jugados.
     */
    public int getTorneosJugados() {
        return torneosJugados;
    }

    /**
     * Establece el número de torneos jugados por el jugador.
     * @param torneosJugados Número de torneos jugados.
     */
    public void setTorneosJugados(int torneosJugados) {
        this.torneosJugados = torneosJugados;
    }

    /**
     * Obtiene el número de partidas jugadas por el jugador.
     * @return Número de partidas jugadas.
     */
    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    /**
     * Establece el número de partidas jugadas por el jugador.
     * @param partidasJugadas Número de partidas jugadas.
     */
    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    /**
     * Obtiene el equipo al que pertenece el jugador.
     * @return Equipo del jugador.
     */
    public String getEquipo() {
        return equipo;
    }

    /**
     * Establece el equipo al que pertenece el jugador.
     * @param equipo Equipo del jugador.
     */
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    /**
     * Obtiene los puntos acumulados por el jugador.
     * @return Puntos del jugador.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Establece los puntos acumulados por el jugador.
     * @param puntos Puntos del jugador.
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Jugador jugador = (Jugador) obj;
        return usuario != null && usuario.equals(jugador.usuario);
    }

    @Override
    public int hashCode() {
        return usuario != null ? usuario.hashCode() : 0;
    }

}
