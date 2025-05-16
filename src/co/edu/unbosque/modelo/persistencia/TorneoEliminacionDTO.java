package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.TorneoEliminacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TorneoEliminacionDTO extends TorneoDTO {
	
    private ArrayList<JugadorDTO> ganadores;
    private HashMap<JugadorDTO,Boolean> eliminados;
    
    private JugadorDTO ganadorTorneo;
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

	public JugadorDTO getGanadorTorneo() {
		return ganadorTorneo;
	}

	public void setGanadorTorneo(JugadorDTO ganadorTorneo) {
		this.ganadorTorneo = ganadorTorneo;
	}

	public HashMap<JugadorDTO,Boolean> getEliminados() {
		return eliminados;
	}

	public void setEliminados(HashMap<JugadorDTO,Boolean> eliminados) {
		this.eliminados = eliminados;
	}

	public ArrayList<JugadorDTO> getGanadores() {
		return ganadores;
	}

	public void setGanadores(ArrayList<JugadorDTO> ganadores) {
		this.ganadores = ganadores;
	}

   
}
