package co.edu.unbosque.modelo.persistencia;


import java.time.LocalDate;
import java.util.ArrayList;

public class TorneoGruposDTO extends TorneoDTO {
	private JugadorDTO[] equipo1;
	private JugadorDTO[] equipo2;
	private JugadorDTO[] equipo3;
	private JugadorDTO[] equipo4;
	private JugadorDTO[] equipoGanador1;
	private JugadorDTO[] equipoGanador2;
	private JugadorDTO[] equipoGanadorTorneo;
	private ArrayList<JugadorDTO> eliminados;
	
	
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

	public ArrayList<JugadorDTO> getEliminados() {
		return eliminados;
	}

	public void setEliminados(ArrayList<JugadorDTO> eliminados) {
		this.eliminados = eliminados;
	}

	public JugadorDTO[] getEquipoGanadorTorneo() {
		return equipoGanadorTorneo;
	}

	public void setEquipoGanadorTorneo(JugadorDTO[] equipoGanadorTorneo) {
		this.equipoGanadorTorneo = equipoGanadorTorneo;
	}

	public JugadorDTO[] getEquipoGanador2() {
		return equipoGanador2;
	}

	public void setEquipoGanador2(JugadorDTO[] equipoGanador2) {
		this.equipoGanador2 = equipoGanador2;
	}

	public JugadorDTO[] getEquipoGanador1() {
		return equipoGanador1;
	}

	public void setEquipoGanador1(JugadorDTO[] equipoGanador1) {
		this.equipoGanador1 = equipoGanador1;
	}

	public JugadorDTO[] getEquipo4() {
		return equipo4;
	}

	public void setEquipo4(JugadorDTO[] equipo4) {
		this.equipo4 = equipo4;
	}

	public JugadorDTO[] getEquipo3() {
		return equipo3;
	}

	public void setEquipo3(JugadorDTO[] equipo3) {
		this.equipo3 = equipo3;
	}

	public JugadorDTO[] getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(JugadorDTO[] equipo2) {
		this.equipo2 = equipo2;
	}

	public JugadorDTO[] getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(JugadorDTO[] equipo1) {
		this.equipo1 = equipo1;
	}

	

    
}
