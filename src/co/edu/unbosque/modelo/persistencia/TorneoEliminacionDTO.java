package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.TorneoEliminacion;
import java.time.LocalDate;

public class TorneoEliminacionDTO extends TorneoDTO {
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

    public TorneoEliminacion toEntity() {
        TorneoEliminacion torneoEliminacion = new TorneoEliminacion(nombre, limiteParticipantes, tipo, juego);
        torneoEliminacion.setEstado(estado);
        torneoEliminacion.setFase(fase);
        torneoEliminacion.setCronograma(cronograma);
        torneoEliminacion.setFechas(fechas);
        return torneoEliminacion;
    }

    public static TorneoEliminacionDTO fromEntity(TorneoEliminacion torneoEliminacion) {
        TorneoEliminacionDTO dto = new TorneoEliminacionDTO();
        dto.setNombre(torneoEliminacion.getNombre());
        dto.setLimiteParticipantes(torneoEliminacion.getLimiteParticipantes());
        dto.setTipo(torneoEliminacion.getTipo());
        dto.setJuego(torneoEliminacion.getJuego());
        dto.setEstado(torneoEliminacion.getEstado());
        dto.setFase(torneoEliminacion.getFase());
        dto.setCronograma(torneoEliminacion.getCronograma());
        dto.setFechas(torneoEliminacion.getFechas());
        return dto;
    }
}
