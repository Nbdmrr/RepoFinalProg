package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.TorneoPuntos;
import java.time.LocalDate;

public class TorneoPuntosDTO extends TorneoDTO {
    private String[][] cronograma;
    private LocalDate[] fechas;

    public String[][] getCronograma() {
        return cronograma;
    }

    public void setCronograma(String[][] cronograma) {
        this.cronograma = cronograma;
    }

    public LocalDate[] getFechas() {
        return fechas;
    }

    public void setFechas(LocalDate[] fechas) {
        this.fechas = fechas;
    }

    public TorneoPuntos toEntity() {
        TorneoPuntos torneoPuntos = new TorneoPuntos(nombre, limiteParticipantes, tipo, juego);
        torneoPuntos.setEstado(estado);
        torneoPuntos.setFase(fase);
        torneoPuntos.setCronograma(cronograma);
        torneoPuntos.setFechas(fechas);
        return torneoPuntos;
    }

    public static TorneoPuntosDTO fromEntity(TorneoPuntos torneoPuntos) {
        TorneoPuntosDTO dto = new TorneoPuntosDTO();
        dto.setNombre(torneoPuntos.getNombre());
        dto.setLimiteParticipantes(torneoPuntos.getLimiteParticipantes());
        dto.setTipo(torneoPuntos.getTipo());
        dto.setJuego(torneoPuntos.getJuego());
        dto.setEstado(torneoPuntos.getEstado());
        dto.setFase(torneoPuntos.getFase());
        dto.setCronograma(torneoPuntos.getCronograma());
        dto.setFechas(torneoPuntos.getFechas());
        return dto;
    }
}
