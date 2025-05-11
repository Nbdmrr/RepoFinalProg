package co.edu.unbosque.modelo;

public class ParticipacionTorneo {
    private Jugador jugador;
    private int puntos;

    public ParticipacionTorneo(Jugador jugador) {
        this.jugador = jugador;
        this.puntos = 0;
    }

    // Getters y Setters
    public void agregarPunto() {
        this.puntos++;
    }

    public int getPuntos() {
        return puntos;
    }

    public Jugador getJugador() {
        return jugador;
    }
}