package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Torneo;
import java.util.ArrayList;

public class TorneoDTO {

    protected static final long serialVersionUID = 1L;
    protected ArrayList<JugadorDTO> participantes;
    protected String tipo;
    protected String nombre;
    protected int limiteParticipantes;
    protected ArrayList<JugadorDTO> eliminados;
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

    public ArrayList<JugadorDTO> getEliminados() {
        return eliminados;
    }

    public void setEliminados(ArrayList<JugadorDTO> eliminados) {
        this.eliminados = eliminados;
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

    public Torneo toEntity() {
        Torneo torneo = new Torneo(nombre, limiteParticipantes, tipo, juego);
        torneo.setEstado(estado);
        torneo.setFase(fase);

        return torneo;
    }

    public static TorneoDTO fromEntity(Torneo torneo) {
        TorneoDTO dto = new TorneoDTO();
        dto.setNombre(torneo.getNombre());
        dto.setLimiteParticipantes(torneo.getLimiteParticipantes());
        dto.setTipo(torneo.getTipo());
        dto.setJuego(torneo.getJuego());
        dto.setEstado(torneo.getEstado());
        dto.setFase(torneo.getFase());
        return dto;
    }
}
