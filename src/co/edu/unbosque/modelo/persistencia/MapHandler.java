package co.edu.unbosque.modelo.persistencia;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import co.edu.unbosque.modelo.Administrador;
import co.edu.unbosque.modelo.Entrenador;
import co.edu.unbosque.modelo.Equipo;
import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.Torneo;
import co.edu.unbosque.modelo.TorneoEliminacion;
import co.edu.unbosque.modelo.TorneoGrupos;
import co.edu.unbosque.modelo.TorneoPuntos;
import co.edu.unbosque.modelo.Usuario;

public class MapHandler {
	
	public static AdministradorDTO convertirAdministradorAAdministradorDTO(Administrador administrador) {
	    AdministradorDTO adminDTO = new AdministradorDTO();
	    adminDTO.setUsuario(administrador.getUsuario());
	    adminDTO.setContraseña(administrador.getContraseña());
	    adminDTO.setNacionalidad(administrador.getNacionalidad());
	    adminDTO.setCorreo(administrador.getCorreo());
	    adminDTO.setCargo(administrador.getCargo());
	    return adminDTO;
	}

	public static Administrador convertirAdministradorDTOAAdministrador(AdministradorDTO adminDTO) {
	    return new Administrador(adminDTO.getUsuario(), adminDTO.getContraseña(), adminDTO.getNacionalidad(), adminDTO.getCorreo(), adminDTO.getCargo());
	}

	public static EntrenadorDTO convertirEntrenadorAEntrenadorDTO(Entrenador entrenador) {
		 
	    EntrenadorDTO entrenadorDTO = new EntrenadorDTO();
	    entrenadorDTO.setUsuario(entrenador.getUsuario());
	    entrenadorDTO.setContraseña(entrenador.getContraseña());
	    entrenadorDTO.setNacionalidad(entrenador.getNacionalidad());
	    entrenadorDTO.setCorreo(entrenador.getCorreo());
	    entrenadorDTO.setEquipo(entrenador.getEquipo());
	    return entrenadorDTO;
	}

	public static Entrenador convertirEntrenadorDTOAEntrenador(EntrenadorDTO entrenadorDTO) {
	    return new Entrenador(entrenadorDTO.getUsuario(), entrenadorDTO.getContraseña(), entrenadorDTO.getNacionalidad(), entrenadorDTO.getCorreo(), entrenadorDTO.getEquipo());
	}

	public static JugadorDTO convertirJugadorAJugadorDTO(Jugador jugador) {
	    JugadorDTO jugadorDTO = new JugadorDTO();
	    jugadorDTO.setUsuario(jugador.getUsuario());
	    jugadorDTO.setContraseña(jugador.getContraseña());
	    jugadorDTO.setNacionalidad(jugador.getNacionalidad());
	    jugadorDTO.setCorreo(jugador.getCorreo());
	    jugadorDTO.setEspecialidad(jugador.getEspecialidad());
	    jugadorDTO.setPuntos(jugador.getPuntos());
	    jugadorDTO.setEquipo(jugador.getEquipo());
	    return jugadorDTO;
	}

	public static Jugador convertirJugadorDTOAJugador(JugadorDTO jugadorDTO) {
	    Jugador jugador = new Jugador(jugadorDTO.getUsuario(), jugadorDTO.getContraseña(), jugadorDTO.getNacionalidad(), jugadorDTO.getCorreo(), jugadorDTO.getEspecialidad(), jugadorDTO.getEquipo());
	    jugador.setPuntos(jugadorDTO.getPuntos());
	    return jugador;
	}

	public static EquipoDTO convertirEquipoAEquipoDTO(Equipo equipo) {
	    EquipoDTO equipoDTO = new EquipoDTO();
	    ArrayList<JugadorDTO> equipoConvertido = new ArrayList<JugadorDTO>();

	    // Asignar nombre del equipo
	    equipoDTO.setNombre(equipo.getNombre());

	    // Verificar si el entrenador 1 es null y convertirlo si no lo es
	    if (equipo.getEntrenador1() != null) {
	        equipoDTO.setEntrenador1(convertirEntrenadorAEntrenadorDTO(equipo.getEntrenador1()));
	    } else {
	        equipoDTO.setEntrenador1(null);  // De todos modos, lo puedes establecer explícitamente como null si lo deseas
	    }

	    // Hacer lo mismo para los entrenadores 2 y 3
	    if (equipo.getEntrenador2() != null) {
	        equipoDTO.setEntrenador2(convertirEntrenadorAEntrenadorDTO(equipo.getEntrenador2()));
	    } else {
	        equipoDTO.setEntrenador2(null);  // Si es null, simplemente lo asignas como null
	    }

	    if (equipo.getEntrenador3() != null) {
	        equipoDTO.setEntrenador3(convertirEntrenadorAEntrenadorDTO(equipo.getEntrenador3()));
	    } else {
	        equipoDTO.setEntrenador3(null);  // De igual manera, si es null, lo puedes dejar como null
	    }

	    // Convertir los jugadores del equipo
	    for (Jugador jugador : equipo.getEquipo()) {
	        JugadorDTO jugadorDTO = convertirJugadorAJugadorDTO(jugador);
	        equipoConvertido.add(jugadorDTO);
	    }

	    // Asignar la lista de jugadores al DTO del equipo
	    equipoDTO.setEquipo(equipoConvertido);

	    return equipoDTO;
	}



	public static Equipo convertirEquipoDTOAEquipo(EquipoDTO equipoDTO) {
	    Equipo equipo = new Equipo(equipoDTO.getNombre(), convertirEntrenadorDTOAEntrenador(equipoDTO.getEntrenador1()));

	    if(equipoDTO.getEntrenador2()!=null) {
	        equipo.setEntrenador2(convertirEntrenadorDTOAEntrenador(equipoDTO.getEntrenador2()));
	    
	    }else {
	    	equipo.setEntrenador2(null);
	    }
	    if(equipoDTO.getEntrenador3()!=null) {
	        equipo.setEntrenador3(convertirEntrenadorDTOAEntrenador(equipoDTO.getEntrenador3()));
	    }else {
	    	equipo.setEntrenador3(null);
	    	
	    }

	    ArrayList<Jugador> jugadores = new ArrayList<>();
	    for (JugadorDTO jugadorDTO : equipoDTO.getEquipo()) {
	        jugadores.add(convertirJugadorDTOAJugador(jugadorDTO));
	    }
	    equipo.setEquipo(jugadores);

	    return equipo;
	}



	

	
	

	

	public static TorneoEliminacion convertirTorneoEliminacionDTOATorneoEliminacion(TorneoEliminacionDTO dto) {
	    TorneoEliminacion torneo = new TorneoEliminacion(dto.getNombre(),dto.limiteParticipantes,dto.tipo,dto.juego);
	    ArrayList<Jugador> participantes = new ArrayList<Jugador>();
	    ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
	    
	    for (JugadorDTO jugadorDTO : dto.participantes) {
			participantes.add(convertirJugadorDTOAJugador(jugadorDTO));
		}
	    for (JugadorDTO jugadorDTO : dto.getGanadores()) {
	    	
	    	ganadores.add(convertirJugadorDTOAJugador(jugadorDTO));
			
		}
	    torneo.setGanadores(ganadores);
	    torneo.setParticipantes(participantes);
	    torneo.setFase(dto.getFase());
	    torneo.setFechas(dto.getFechas());
	    torneo.setCronograma(dto.getCronograma());
	    if(dto.getGanadorTorneo()==null) {
	    torneo.setGanadorTorneo(null);
	    }else {
	    	torneo.setGanadorTorneo(convertirJugadorDTOAJugador(dto.getGanadorTorneo()));
	    }
	    return torneo;
	    
	}

	public static TorneoEliminacionDTO convertirTorneoEliminacionATorneoEliminacionDTO(TorneoEliminacion torneo) {
	    TorneoEliminacionDTO dto = new TorneoEliminacionDTO();
	    
	    dto.setNombre(torneo.getNombre());
	    dto.setJuego(torneo.getJuego());
	    dto.setLimiteParticipantes(torneo.getLimiteParticipantes());
	    dto.setFase(torneo.getFase());
	    dto.setEstado(torneo.getEstado());
	    
	    
	   

	    ArrayList<JugadorDTO> participantes = new ArrayList<>();
	    for (Jugador jugador : torneo.getParticipantes()) {
	        participantes.add(convertirJugadorAJugadorDTO(jugador));
	    }
	    
	    dto.setParticipantes(participantes);
	    HashMap<JugadorDTO, Boolean> eliminados = new HashMap<>();
	    ArrayList<JugadorDTO> ganadores= new ArrayList<JugadorDTO>();
	    for (Jugador jugador : torneo.getEliminados().keySet()) {
	        JugadorDTO jugadorDTO = convertirJugadorAJugadorDTO(jugador);
	        eliminados.put(jugadorDTO, torneo.getEliminados().get(jugador));
	    }
	    dto.setEliminados(eliminados);
	    if(torneo.getGanadorTorneo() ==null) {
	    	dto.setGanadorTorneo(null);
	    }else {
	    	dto.setGanadorTorneo(convertirJugadorAJugadorDTO(torneo.getGanadorTorneo()));
		    
	    }

	    for (Jugador jugador : torneo.getGanadores()) {
	    	
	    	ganadores.add(convertirJugadorAJugadorDTO(jugador));
	    	
			
		}
	    
	    dto.setGanadores(ganadores);
	    dto.setFechas(torneo.getFechas());
	    dto.setCronograma(torneo.getCronograma());
	    dto.setTipo(torneo.getTipo());

	    return dto;
	}

	public static TorneoGrupos convertirTorneoGruposDTOATorneoGrupos(TorneoGruposDTO dto) {
	    TorneoGrupos torneo = new TorneoGrupos(dto.getNombre(), dto.limiteParticipantes, dto.tipo, dto.juego);
	    ArrayList<Jugador> participantes = new ArrayList<Jugador>();

	    Jugador[] equipo1 = new Jugador[3];
	    Jugador[] equipo2 = new Jugador[3];
	    Jugador[] equipo3 = new Jugador[3];
	    Jugador[] equipo4 = new Jugador[3];
	    Jugador[] equipoGanador1 = new Jugador[3];
	    Jugador[] equipoGanador2 = new Jugador[3];
	    Jugador[] equipoGanadorTorneo = new Jugador[3];

	    for (int i = 0; i < 3; i++) {
	        equipo1[i] = dto.getEquipo1()[i] != null ? convertirJugadorDTOAJugador(dto.getEquipo1()[i]) : null;
	        equipo2[i] = dto.getEquipo2()[i] != null ? convertirJugadorDTOAJugador(dto.getEquipo2()[i]) : null;
	        equipo3[i] = dto.getEquipo3()[i] != null ? convertirJugadorDTOAJugador(dto.getEquipo3()[i]) : null;
	        equipo4[i] = dto.getEquipo4()[i] != null ? convertirJugadorDTOAJugador(dto.getEquipo4()[i]) : null;
	        equipoGanador1[i] = dto.getEquipoGanador1()[i] != null ? convertirJugadorDTOAJugador(dto.getEquipoGanador1()[i]) : null;
	        equipoGanador2[i] = dto.getEquipoGanador2()[i] != null ? convertirJugadorDTOAJugador(dto.getEquipoGanador2()[i]) : null;
	        equipoGanadorTorneo[i] = dto.getEquipoGanadorTorneo()[i] != null ? convertirJugadorDTOAJugador(dto.getEquipoGanadorTorneo()[i]) : null;
	    }

	    for (JugadorDTO jugadorDTO : dto.participantes) {
	        if (jugadorDTO != null) {
	            participantes.add(convertirJugadorDTOAJugador(jugadorDTO));
	        }
	    }

	    torneo.setParticipantes(participantes);
	    torneo.setEquipo1(equipo1);
	    torneo.setEquipo2(equipo2);
	    torneo.setEquipo3(equipo3);
	    torneo.setEquipo4(equipo4);
	    torneo.setEquipoGanador1(equipoGanador1);
	    torneo.setEquipoGanador2(equipoGanador2);
	    torneo.setEquipoGanadorTorneo(equipoGanadorTorneo);

	    torneo.setEstado(dto.getEstado());
	    torneo.setFase(dto.getFase());
	    torneo.setFechas(dto.getFechas());
	    torneo.setCronograma(dto.getCronograma());

	    return torneo;
	}



	public static TorneoGruposDTO convertirTorneoGruposATorneoGruposDTO(TorneoGrupos torneo) {
	    TorneoGruposDTO torneoDTO = new TorneoGruposDTO();
	    ArrayList<JugadorDTO> participantes = new ArrayList<JugadorDTO>();
	    torneoDTO.setNombre(torneo.getNombre());
	    torneoDTO.setLimiteParticipantes(torneo.getLimiteParticipantes());
	    torneoDTO.setTipo(torneo.getTipo());
	    torneoDTO.setJuego(torneo.getJuego());
	    JugadorDTO[] equipo1 = new JugadorDTO[3];
	    JugadorDTO[] equipo2 = new JugadorDTO[3];
	    JugadorDTO[] equipo3 = new JugadorDTO[3];
	    JugadorDTO[] equipo4 = new JugadorDTO[3];
	    JugadorDTO[] equipoGanador1 = new JugadorDTO[3];
	    JugadorDTO[] equipoGanador2 = new JugadorDTO[3];
	    JugadorDTO[] equipoGanadorTorneo =  new JugadorDTO[3];

	    for (int i = 0; i < 3; i++) {
	        if (torneo.getEquipo1()[i] != null) {
	            equipo1[i] = convertirJugadorAJugadorDTO(torneo.getEquipo1()[i]);
	        }
	        if (torneo.getEquipo2()[i] != null) {
	            equipo2[i] = convertirJugadorAJugadorDTO(torneo.getEquipo2()[i]);
	        }
	        if (torneo.getEquipo3()[i] != null) {
	            equipo3[i] = convertirJugadorAJugadorDTO(torneo.getEquipo3()[i]);
	        }
	        if (torneo.getEquipo4()[i] != null) {
	            equipo4[i] = convertirJugadorAJugadorDTO(torneo.getEquipo4()[i]);
	        }
	        if (torneo.getEquipoGanador1()[i] != null) {
	            equipoGanador1[i] = convertirJugadorAJugadorDTO(torneo.getEquipoGanador1()[i]);
	        }
	        if (torneo.getEquipoGanador2()[i] != null) {
	            equipoGanador2[i] = convertirJugadorAJugadorDTO(torneo.getEquipoGanador2()[i]);
	        }
	        if (torneo.getEquipoGanadorTorneo()[i] != null) {
	            equipoGanadorTorneo[i] = convertirJugadorAJugadorDTO(torneo.getEquipoGanadorTorneo()[i]);
	        }
	    }

	    for (Jugador jugador : torneo.getParticipantes()) {
	        if (jugador != null) {
	            participantes.add(convertirJugadorAJugadorDTO(jugador));
	        }
	    }

	    torneoDTO.setParticipantes(participantes);
	    torneoDTO.setEquipo1(equipo1);
	    torneoDTO.setEquipo2(equipo2);
	    torneoDTO.setEquipo3(equipo3);
	    torneoDTO.setEquipo4(equipo4);
	    torneoDTO.setEquipoGanador1(equipoGanador1);
	    torneoDTO.setEquipoGanador2(equipoGanador2);
	    torneoDTO.setEquipoGanadorTorneo(equipoGanadorTorneo);
	    torneoDTO.setEstado(torneo.getEstado());
	    torneoDTO.setFase(torneo.getFase());
	    torneoDTO.setFechas(torneo.getFechas());
	    torneoDTO.setCronograma(torneo.getCronograma());

	    return torneoDTO;
	}


	public static TorneoPuntos convertirTorneoPuntosDTOATorneoPuntos(TorneoPuntosDTO dto) {
		TorneoPuntos torneo = new TorneoPuntos(dto.getNombre(), dto.limiteParticipantes, dto.tipo, dto.juego);
	    ArrayList<Jugador> participantes = new ArrayList<Jugador>();
	    
	    
	    for (JugadorDTO jugadorDTO : dto.participantes) {
	        participantes.add(convertirJugadorDTOAJugador(jugadorDTO));
	    }

	    torneo.setParticipantes(participantes);
	    torneo.setTipo(dto.getTipo());
	    torneo.setEstado(dto.getEstado());
	    torneo.setFase(dto.getFase());
	    torneo.setFechas(dto.getFechas());
	    torneo.setCronograma(dto.getCronograma());
	    if(dto.getGanadorTorneo()==null) {
	    	torneo.setGanadorTorneo(null);
		    
	    }else {
	    torneo.setGanadorTorneo(convertirJugadorDTOAJugador(dto.getGanadorTorneo()));
	    }
	    return torneo;
	}

	public static TorneoPuntosDTO convertirTorneoPuntosATorneoPuntosDTO(TorneoPuntos torneo) {
		TorneoPuntosDTO torneoDTO = new TorneoPuntosDTO();
	    ArrayList<JugadorDTO> participantes = new ArrayList<JugadorDTO>();
	    torneoDTO.setNombre(torneo.getNombre());
	    torneoDTO.setLimiteParticipantes(torneo.getLimiteParticipantes());
	    torneoDTO.setTipo(torneo.getTipo());
	    torneoDTO.setJuego(torneo.getJuego());
	    

	   

	    for (Jugador jugador : torneo.getParticipantes()) {
	        participantes.add(convertirJugadorAJugadorDTO(jugador));
	    }

	    torneoDTO.setParticipantes(participantes);
	   
	    torneoDTO.setEstado(torneo.getEstado());
	    torneoDTO.setFase(torneo.getFase());
	    torneoDTO.setFechas(torneo.getFechas());
	    torneoDTO.setCronograma(torneo.getCronograma());
	    if(torneo.getGanadorTorneo()==null) {
	    	torneoDTO.setGanadorTorneo(null);
		    
	    }else {
	    torneoDTO.setGanadorTorneo(convertirJugadorAJugadorDTO(torneo.getGanadorTorneo()));
	    }
	    return torneoDTO;
	}
	public static ArrayList<AdministradorDTO> convertirAdministradoresAAdministradoresDTO(ArrayList<Administrador> administradores) {
	    ArrayList<AdministradorDTO> administradoresDTO = new ArrayList<>();
	    for (Administrador administrador : administradores) {
	        administradoresDTO.add(convertirAdministradorAAdministradorDTO(administrador));
	    }
	    return administradoresDTO;
	}

	public static ArrayList<Administrador> convertirAdministradoresDTOAAdministradores(ArrayList<AdministradorDTO> administradoresDTO) {
	    ArrayList<Administrador> administradores = new ArrayList<>();
	    for (AdministradorDTO administradorDTO : administradoresDTO) {
	        administradores.add(convertirAdministradorDTOAAdministrador(administradorDTO));
	    }
	    return administradores;
	}

	public static ArrayList<JugadorDTO> convertirJugadoresAJugadoresDTO(ArrayList<Jugador> jugadores) {
	    ArrayList<JugadorDTO> jugadoresDTO = new ArrayList<>();
	    for (Jugador jugador : jugadores) {
	        jugadoresDTO.add(convertirJugadorAJugadorDTO(jugador));
	    }
	    return jugadoresDTO;
	}

	public static ArrayList<Jugador> convertirJugadoresDTOAJugadores(ArrayList<JugadorDTO> jugadoresDTO) {
	    ArrayList<Jugador> jugadores = new ArrayList<>();
	    for (JugadorDTO jugadorDTO : jugadoresDTO) {
	        jugadores.add(convertirJugadorDTOAJugador(jugadorDTO));
	    }
	    return jugadores;
	}

	public static ArrayList<EntrenadorDTO> convertirEntrenadoresAEntrenadoresDTO(ArrayList<Entrenador> entrenadores) {
	    ArrayList<EntrenadorDTO> entrenadoresDTO = new ArrayList<>();
	    for (Entrenador entrenador : entrenadores) {
	        entrenadoresDTO.add(convertirEntrenadorAEntrenadorDTO(entrenador));
	    }
	    return entrenadoresDTO;
	}

	public static ArrayList<Entrenador> convertirEntrenadoresDTOAEntrenadores(ArrayList<EntrenadorDTO> entrenadoresDTO) {
	    ArrayList<Entrenador> entrenadores = new ArrayList<>();
	    for (EntrenadorDTO entrenadorDTO : entrenadoresDTO) {
	        entrenadores.add(convertirEntrenadorDTOAEntrenador(entrenadorDTO));
	    }
	    return entrenadores;
	}

	public static ArrayList<EquipoDTO> convertirEquiposAEquiposDTO(ArrayList<Equipo> equipos) {
	    ArrayList<EquipoDTO> equiposDTO = new ArrayList<>();
	    for (Equipo equipo : equipos) {
	        equiposDTO.add(convertirEquipoAEquipoDTO(equipo));
	    }
	    return equiposDTO;
	}

	public static ArrayList<Equipo> convertirEquiposDTOAEquipos(ArrayList<EquipoDTO> equiposDTO) {
	    ArrayList<Equipo> equipos = new ArrayList<>();
	    for (EquipoDTO equipoDTO : equiposDTO) {
	        equipos.add(convertirEquipoDTOAEquipo(equipoDTO));
	    }
	    return equipos;
	}
	public static ArrayList<TorneoEliminacionDTO> convertirTorneosEliminacionATorneosEliminacionDTO(ArrayList<TorneoEliminacion> torneos) {
	    ArrayList<TorneoEliminacionDTO> torneosDTO = new ArrayList<>();
	    for (TorneoEliminacion torneo : torneos) {
	        torneosDTO.add(convertirTorneoEliminacionATorneoEliminacionDTO(torneo));
	    }
	    return torneosDTO;
	}

	public static ArrayList<TorneoEliminacion> convertirTorneosEliminacionDTOATorneosEliminacion(ArrayList<TorneoEliminacionDTO> torneosDTO) {
	    ArrayList<TorneoEliminacion> torneos = new ArrayList<>();
	    for (TorneoEliminacionDTO torneoDTO : torneosDTO) {
	        torneos.add(convertirTorneoEliminacionDTOATorneoEliminacion(torneoDTO));
	    }
	    return torneos;
	}

	public static ArrayList<TorneoPuntosDTO> convertirTorneosPuntosATorneosPuntosDTO(ArrayList<TorneoPuntos> torneos) {
	    ArrayList<TorneoPuntosDTO> torneosDTO = new ArrayList<>();
	    for (TorneoPuntos torneo : torneos) {
	        torneosDTO.add(convertirTorneoPuntosATorneoPuntosDTO(torneo));
	    }
	    return torneosDTO;
	}

	public static ArrayList<TorneoPuntos> convertirTorneosPuntosDTOATorneosPuntos(ArrayList<TorneoPuntosDTO> torneosDTO) {
	    ArrayList<TorneoPuntos> torneos = new ArrayList<>();
	    for (TorneoPuntosDTO torneoDTO : torneosDTO) {
	        torneos.add(convertirTorneoPuntosDTOATorneoPuntos(torneoDTO));
	    }
	    return torneos;
	}

	public static ArrayList<TorneoGruposDTO> convertirTorneosGruposATorneosGruposDTO(ArrayList<TorneoGrupos> torneos) {
	    ArrayList<TorneoGruposDTO> torneosDTO = new ArrayList<>();
	    for (TorneoGrupos torneo : torneos) {
	        torneosDTO.add(convertirTorneoGruposATorneoGruposDTO(torneo));
	    }
	    return torneosDTO;
	}

	public static ArrayList<TorneoGrupos> convertirTorneosGruposDTOATorneosGrupos(ArrayList<TorneoGruposDTO> torneosDTO) {
	    ArrayList<TorneoGrupos> torneos = new ArrayList<>();
	    for (TorneoGruposDTO torneoDTO : torneosDTO) {
	        torneos.add(convertirTorneoGruposDTOATorneoGrupos(torneoDTO));
	    }
	    return torneos;
	}



	
   
}
