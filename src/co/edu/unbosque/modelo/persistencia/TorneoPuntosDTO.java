package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.TorneoPuntos;
import java.time.LocalDate;

public class TorneoPuntosDTO extends TorneoDTO {
    private String[][] cronograma;
    private LocalDate[] fechas;
    private JugadorDTO ganadorTorneo;
    
    
    
    
    

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

	public JugadorDTO getGanadorTorneo() {
		return ganadorTorneo;
	}

	public void setGanadorTorneo(JugadorDTO ganadorTorneo) {
		this.ganadorTorneo = ganadorTorneo;
	}

    	
}
