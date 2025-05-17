package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Torneo;

import java.io.Serializable;
import java.util.ArrayList;

public class TorneoDTO implements Serializable{

    protected static final long serialVersionUID = 1L;
    protected ArrayList<JugadorDTO> participantes;
    protected String tipo;
    protected String nombre;
    protected int limiteParticipantes;
    protected String juego;
    protected int fase;
    protected String estado;

    // Getters y setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public int getLimiteParticipantes() {
        return limiteParticipantes;
    }

    public void setLimiteParticipantes(int limiteParticipantes) {
        this.limiteParticipantes = limiteParticipantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<JugadorDTO> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<JugadorDTO> participantes) {
        this.participantes = participantes;
    }
}
