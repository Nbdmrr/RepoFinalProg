package co.edu.unbosque.modelo;

public class DirectorioPrincipal {
	private DirectorioAdministradores directorioAdministradores;
	private DirectorioEntrenadores directorioEntrenadores;
	private DirectorioEquipos directorioEquipos;
	private DirectorioJugadores directorioJugadores;
	private DirectorioTorneosGrupos directorioTorneosGrupos;
	private DirectorioTorneosEliminacion directorioTorneosEliminacion;
	private DirectorioTorneosPuntos directorioTorneosPuntos;
	
	public DirectorioPrincipal() {
		setDirectorioAdministradores(new DirectorioAdministradores());
		setDirectorioEntrenadores(new DirectorioEntrenadores());
		setDirectorioEquipos(new DirectorioEquipos());
		setDirectorioJugadores(new DirectorioJugadores());
		setDirectorioTorneosGrupos(new DirectorioTorneosGrupos());
		setDirectorioTorneosEliminacion(new DirectorioTorneosEliminacion());
		setDirectorioTorneosPuntos(new DirectorioTorneosPuntos());
	}
	public DirectorioTorneosPuntos getDirectorioTorneosPuntos() {
		return directorioTorneosPuntos;
	}
	public void setDirectorioTorneosPuntos(DirectorioTorneosPuntos directorioTorneosPuntos) {
		this.directorioTorneosPuntos = directorioTorneosPuntos;
	}
	public DirectorioTorneosEliminacion getDirectorioTorneosEliminacion() {
		return directorioTorneosEliminacion;
	}
	public void setDirectorioTorneosEliminacion(DirectorioTorneosEliminacion directorioTorneosEliminacion) {
		this.directorioTorneosEliminacion = directorioTorneosEliminacion;
	}
	public DirectorioTorneosGrupos getDirectorioTorneosGrupos() {
		return directorioTorneosGrupos;
	}
	public void setDirectorioTorneosGrupos(DirectorioTorneosGrupos directorioTorneoGrupos) {
		this.directorioTorneosGrupos = directorioTorneoGrupos;
	}
	public DirectorioJugadores getDirectorioJugadores() {
		return directorioJugadores;
	}
	public void setDirectorioJugadores(DirectorioJugadores directorioJugadores) {
		this.directorioJugadores = directorioJugadores;
	}
	public DirectorioEquipos getDirectorioEquipos() {
		return directorioEquipos;
	}
	public void setDirectorioEquipos(DirectorioEquipos directorioEquipos) {
		this.directorioEquipos = directorioEquipos;
	}
	public DirectorioEntrenadores getDirectorioEntrenadores() {
		return directorioEntrenadores;
	}
	public void setDirectorioEntrenadores(DirectorioEntrenadores directorioEntrenadores) {
		this.directorioEntrenadores = directorioEntrenadores;
	}
	public DirectorioAdministradores getDirectorioAdministradores() {
		return directorioAdministradores;
	}
	public void setDirectorioAdministradores(DirectorioAdministradores directorioAdministradores) {
		this.directorioAdministradores = directorioAdministradores;
	}

}
