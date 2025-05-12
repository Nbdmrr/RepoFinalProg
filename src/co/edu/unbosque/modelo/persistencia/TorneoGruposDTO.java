package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.TorneoGrupos;
import java.time.LocalDate;

public class TorneoGruposDTO extends TorneoDTO {
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

    public TorneoGrupos toEntity() {
        TorneoGrupos torneoGrupos = new TorneoGrupos(nombre, limiteParticipantes, tipo, juego);
        torneoGrupos.setEstado(estado);
        torneoGrupos.setFase(fase);
        torneoGrupos.setCronograma(cronograma);
        torneoGrupos.setFechas(fechas);
        return torneoGrupos;
    }

    public static TorneoGruposDTO fromEntity(TorneoGrupos torneoGrupos) {
        TorneoGruposDTO dto = new TorneoGruposDTO();
        dto.setNombre(torneoGrupos.getNombre());
        dto.setLimiteParticipantes(torneoGrupos.getLimiteParticipantes());
        dto.setTipo(torneoGrupos.getTipo());
        dto.setJuego(torneoGrupos.getJuego());
        dto.setEstado(torneoGrupos.getEstado());
        dto.setFase(torneoGrupos.getFase());
        dto.setCronograma(torneoGrupos.getCronograma());
        dto.setFechas(torneoGrupos.getFechas());
        return dto;
    }
}
