package co.edu.unbosque.modelo;

import java.util.ArrayList;

/**
 * Clase base que representa un torneo genérico.
 * Maneja atributos comunes como nombre, tipo, estado, juego y participantes.
 */
public class Torneo {

    /** Lista de jugadores que participan en el torneo */
    protected ArrayList<Jugador> participantes;
    
    /** Tipo de torneo (puntos, eliminación, grupos, etc.) */
    protected String tipo;
    
    /** Nombre del torneo */
    protected String nombre;
    
    /** Número máximo de participantes permitidos en el torneo */
    protected int limiteParticipantes;
    
    /** Nombre del juego que se disputará en el torneo */
    protected String juego;
    
    /** Número de la fase actual del torneo */
    protected int fase;
    
    /** Estado actual del torneo (preparando, en curso, terminado, etc.) */
    protected String estado;

    /**
     * Constructor de la clase Torneo.
     * Inicializa el torneo con los valores indicados y asigna el estado a "preparando".
     *
     * @param nombre Nombre del torneo
     * @param limiteParticipantes Número máximo de jugadores
     * @param tipo Tipo de torneo
     * @param juego Nombre del juego que se jugará
     */
    public Torneo(String nombre, int limiteParticipantes, String tipo, String juego) {
        participantes = new ArrayList<Jugador>();
        this.fase = 1;
        this.nombre = nombre;
        this.limiteParticipantes = limiteParticipantes;
        this.tipo = tipo;
        this.setJuego(juego);
        this.setEstado("preparando");
    }

    /**
     * Aumenta el contador de torneos jugados para cada jugador del torneo.
     */
    public void actualizarEstadisticaTorneosJugados() {
        for (Jugador jugador : participantes) {
            jugador.sumarTorneoJugado();
        }
    }

    /**
     * Obtiene el número máximo de participantes del torneo.
     *
     * @return Límite de participantes
     */
    public int getLimiteParticipantes() {
        return limiteParticipantes;
    }

    /**
     * Establece el número máximo de participantes del torneo.
     *
     * @param limiteParticipantes Nuevo límite de participantes
     */
    public void setLimiteParticipantes(int limiteParticipantes) {
        this.limiteParticipantes = limiteParticipantes;
    }

    /**
     * Obtiene el nombre del torneo.
     *
     * @return Nombre del torneo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del torneo.
     *
     * @param nombre Nuevo nombre del torneo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tipo de torneo.
     *
     * @return Tipo del torneo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de torneo.
     *
     * @param tipo Tipo del torneo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la lista de jugadores participantes.
     *
     * @return Lista de jugadores
     */
    public ArrayList<Jugador> getParticipantes() {
        return participantes;
    }

    /**
     * Establece la lista de jugadores participantes.
     *
     * @param participantes Nueva lista de jugadores
     */
    public void setParticipantes(ArrayList<Jugador> participantes) {
        this.participantes = participantes;
    }

    /**
     * Devuelve una representación en texto del torneo.
     *
     * @return Cadena con los datos del torneo
     */
    @Override
    public String toString() {
        return "Nombre del torneo: " + nombre+"||Tipo: "+tipo+"||Limite de Participantes: "+limiteParticipantes+"||Juego: "+juego;
    }

    /**
     * Obtiene el estado actual del torneo.
     *
     * @return Estado del torneo
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del torneo.
     *
     * @param estado Nuevo estado del torneo
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el número de la fase actual del torneo.
     *
     * @return Número de fase
     */
    public int getFase() {
        return fase;
    }

    /**
     * Establece el número de la fase actual del torneo.
     *
     * @param fase Número de fase
     */
    public void setFase(int fase) {
        this.fase = fase;
    }

    /**
     * Obtiene el nombre del juego que se disputará en el torneo.
     *
     * @return Nombre del juego
     */
    public String getJuego() {
        return juego;
    }

    /**
     * Establece el nombre del juego del torneo.
     *
     * @param juego Nuevo nombre del juego
     */
    public void setJuego(String juego) {
        this.juego = juego;
}
    
    
    }


