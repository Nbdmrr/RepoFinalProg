package co.edu.unbosque.modelo.persistencia;

public class JugadorDTO extends UsuarioDTO{
	
	private int partidasJugadas;
	private int torneosJugados;
	private int partidasGanadas;
	private int torneosGanados;
	private String especialidad;
	private int puntos;
	private String equipo;
	
	
	
	
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getTorneosGanados() {
		return torneosGanados;
	}
	public void setTorneosGanados(int torneosGanados) {
		this.torneosGanados = torneosGanados;
	}
	public int getPartidasGanadas() {
		return partidasGanadas;
	}
	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}
	public int getTorneosJugados() {
		return torneosJugados;
	}
	public void setTorneosJugados(int torneosJugados) {
		this.torneosJugados = torneosJugados;
	}
	public int getPartidasJugadas() {
		return partidasJugadas;
	}
	public void setPartidasJugadas(int partidasJugadas) {
		this.partidasJugadas = partidasJugadas;
	}
	

}
