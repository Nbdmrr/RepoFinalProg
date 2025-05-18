package co.edu.unbosque.modelo;

import java.util.ArrayList;

/**
 * Clase que representa un equipo en el sistema.
 * Contiene información sobre el nombre del equipo, sus jugadores y entrenadores.
 */
public class Equipo {
    
    /** Nombre del equipo. */
    private String nombre;
    
    /** Lista de jugadores que pertenecen al equipo. */
    private ArrayList<Jugador> equipo;
    
    /** Primer entrenador del equipo. */
    private Entrenador entrenador1;
    
    /** Segundo entrenador del equipo (opcional). */
    private Entrenador entrenador2;
    
    /** Tercer entrenador del equipo (opcional). */
    private Entrenador entrenador3;

    /**
     * Constructor de la clase Equipo.
     * @param nombre Nombre del equipo.
     * @param entrenador1 Primer entrenador del equipo.
     */
    public Equipo(String nombre, Entrenador entrenador1) {
        this.setNombre(nombre);
        this.setEntrenador1(entrenador1);
        entrenador2 = null;
        entrenador3 = null;
        equipo = new ArrayList<Jugador>();
    }

    /**
     * Obtiene la lista de jugadores del equipo.
     * @return ArrayList de jugadores.
     */
    public ArrayList<Jugador> getEquipo() {
        return equipo;
    }

    /**
     * Establece la lista de jugadores del equipo.
     * @param equipo Lista de jugadores.
     */
    public void setEquipo(ArrayList<Jugador> equipo) {
        this.equipo = equipo;
    }

    /**
     * Obtiene el nombre del equipo.
     * @return Nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del equipo.
     * @param nombre Nombre del equipo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el tercer entrenador del equipo.
     * @return Tercer entrenador.
     */
    public Entrenador getEntrenador3() {
        return entrenador3;
    }

    /**
     * Establece el tercer entrenador del equipo.
     * @param entrenador3 Tercer entrenador.
     */
    public void setEntrenador3(Entrenador entrenador3) {
        this.entrenador3 = entrenador3;
    }

    /**
     * Obtiene el segundo entrenador del equipo.
     * @return Segundo entrenador.
     */
    public Entrenador getEntrenador2() {
        return entrenador2;
    }

    /**
     * Establece el segundo entrenador del equipo.
     * @param entrenador2 Segundo entrenador.
     */
    public void setEntrenador2(Entrenador entrenador2) {
        this.entrenador2 = entrenador2;
    }

    /**
     * Obtiene el primer entrenador del equipo.
     * @return Primer entrenador.
     */
    public Entrenador getEntrenador1() {
        return entrenador1;
    }

    /**
     * Establece el primer entrenador del equipo.
     * @param entrenador1 Primer entrenador.
     */
    public void setEntrenador1(Entrenador entrenador1) {
        this.entrenador1 = entrenador1;
        
    }
    @Override
    public String toString() {
    	
    	
    	
    	
    	return"Nombre del Equipo: "+nombre;
    }
}