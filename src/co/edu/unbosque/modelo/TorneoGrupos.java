package co.edu.unbosque.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class TorneoGrupos extends Torneo{
	
	
	private Jugador[] equipo1;
	private Jugador[] equipo2;
	private Jugador[] equipo3;
	private Jugador[] equipo4;
	private Jugador[] equipoGanador1;
	private Jugador[] equipoGanador2;
	private Jugador[] equipoGanadorTorneo;
	
	
	private String[][] cronograma;
    private LocalDate[] fechas;
	
	
	
	public TorneoGrupos(String nombre, int limiteParticipantes , String tipo, String juego) {
		
		
		super(nombre,limiteParticipantes,tipo,juego);
		setEquipo1(new Jugador[3]);
		setEquipo2(new Jugador[3]);
		setEquipo3(new Jugador[3]);
		setEquipo4(new Jugador[3]);
		setEquipoGanador1(new Jugador[3]);
        setEquipoGanador2(new Jugador[3]);
        setEquipoGanadorTorneo(new Jugador[3]);
		
	}
	public void organizarEquipos() {
        List<Jugador[]> grupos = new ArrayList<>();
        List<Jugador> copiaJugadores = new ArrayList<>(this.participantes);

        while (!copiaJugadores.isEmpty()) {
            Jugador primero = copiaJugadores.get(0);
            String equipo = primero.getEquipo();
            Jugador[] grupo = new Jugador[3];
            int indice = 0;
            for (int i = 0; i < copiaJugadores.size() && indice < 3; i++) {
                Jugador actual = copiaJugadores.get(i);
                if (actual.getEquipo().equals(equipo)) {
                    grupo[indice++] = actual;
                }
            }
            for (Jugador j : grupo) {
                copiaJugadores.remove(j);
            }
            grupos.add(grupo);
        }
        setEquipo1(grupos.get(0));
        setEquipo2(grupos.get(1));
        setEquipo3(grupos.get(2));
        setEquipo4(grupos.get(3));
    }
	public boolean agregarJugador(Jugador jugador) {
	    String equipo = jugador.getEquipo();
	    int cantidadEquipo = 0;

	    for (Jugador j : participantes) {
	        if (j.getEquipo().equals(equipo)) {
	            cantidadEquipo++;
	        }
	    }

	    if (cantidadEquipo >= 3) {
	        JOptionPane.showMessageDialog(null, "Equipo completo");
	        return false;
	    } else {
	        participantes.add(jugador);
	        JOptionPane.showMessageDialog(null, "Jugador añadido al torneo");
	        return true;
	    }
	}
	
	private void avanzarAFase2() {
	    int puntosA = 0;
	    int puntosB = 0;

	    // Primera semifinal: equipo1 vs equipo2
	    for (int i = 0; i < 3; i++) {
	        Jugador jugadorA = getEquipo1()[i];
	        Jugador jugadorB = getEquipo2()[i];
	        Jugador ganador = Math.random() < 0.5 ? jugadorA : jugadorB;

	        if (ganador == jugadorA) {
	            puntosA++;
	        } else {
	            puntosB++;
	        }
	    }

	    if (puntosA > puntosB) {
	        setEquipoGanador1(getEquipo1());
	        // Eliminar jugadores de equipo2
	        for (int i = 0; i < getEquipo2().length; i++) {
	            for (int j = 0; j < participantes.size(); j++) {
	                if (participantes.get(j) == getEquipo2()[i]) {
	                    participantes.remove(j);
	                    break; // Salir del bucle después de eliminar al jugador
	                }
	            }
	        }
	    } else if (puntosB > puntosA) {
	        setEquipoGanador1(getEquipo2());
	        // Eliminar jugadores de equipo1
	        for (int i = 0; i < getEquipo1().length; i++) {
	            for (int j = 0; j < participantes.size(); j++) {
	                if (participantes.get(j) == getEquipo1()[i]) {
	                    participantes.remove(j);
	                    break; // Salir del bucle después de eliminar al jugador
	                }
	            }
	        }
	    }

	    // Reiniciar puntos para la segunda semifinal
	    puntosA = 0;
	    puntosB = 0;

	    // Segunda semifinal: equipo3 vs equipo4
	    for (int i = 0; i < 3; i++) {
	        Jugador jugadorA = getEquipo3()[i];
	        Jugador jugadorB = getEquipo4()[i];
	        Jugador ganador = Math.random() < 0.5 ? jugadorA : jugadorB;

	        if (ganador == jugadorA) {
	            puntosA++;
	        } else {
	            puntosB++;
	        }
	    }

	    if (puntosA > puntosB) {
	        setEquipoGanador2(getEquipo3());
	        // Eliminar jugadores de equipo4
	        for (int i = 0; i < getEquipo4().length; i++) {
	            for (int j = 0; j < participantes.size(); j++) {
	                if (participantes.get(j) == getEquipo4()[i]) {
	                    participantes.remove(j);
	                    break; // Salir del bucle después de eliminar al jugador
	                }
	            }
	        }
	    } else if (puntosB > puntosA) {
	        setEquipoGanador2(getEquipo4());
	        // Eliminar jugadores de equipo3
	        for (int i = 0; i < getEquipo3().length; i++) {
	            for (int j = 0; j < participantes.size(); j++) {
	                if (participantes.get(j) == getEquipo3()[i]) {
	                    participantes.remove(j);
	                    break; // Salir del bucle después de eliminar al jugador
	                }
	            }
	        }
	    }
	}
	public void elegirGanadorFinal() {
		
		int puntosA = 0;
        int puntosB = 0;

        for (int i = 0; i < 3; i++) {
            Jugador jugadorA = getEquipoGanador1()[i];
            Jugador jugadorB = getEquipoGanador2()[i];
            Jugador ganador = Math.random() < 0.5 ? jugadorA : jugadorB;

            if (ganador.equals(jugadorA)) {
                puntosA++;
            } else {
                puntosB++;
            }
        }

        if(puntosA>puntosB) {
        	
        	setEquipoGanadorTorneo(equipoGanador1);
        	
        	    for (Jugador jugador : getEquipoGanador2()) {
        	        participantes.removeIf(j -> j.equals(jugador));
        	    }
        	estado="Terminado";

        	
        }else if(puntosB < puntosA){
        	
        	setEquipoGanadorTorneo(equipoGanador2);
        	for (Jugador jugador : getEquipoGanador1()) {
    	        participantes.removeIf(j -> j.equals(jugador));
    	    }
        	estado="Terminado";
        }
	}
	
	public void generarCronograma() {
	    setCronograma(new String[2][]);
	    setFechas(new LocalDate[2]);
	    LocalDate fechaInicial = LocalDate.now().plusDays(1);

	    // Fase 1
	    getFechas()[0] = fechaInicial;
	    getCronograma()[0] = new String[6]; // 3 enfrentamientos entre equipo1 y equipo2 + 3 entre equipo3 y equipo4

	    for (int i = 0; i < 3; i++) {
	        String jugador1 = getEquipo1()[i].getUsuario();
	        String jugador2 = getEquipo2()[i].getUsuario();
	        String equipo1Nombre = getEquipo1()[i].getEquipo();
	        String equipo2Nombre = getEquipo2()[i].getEquipo();
	        getCronograma()[0][i] = "Fase 1 (" + getFechas()[0] + "): " + jugador1 + " vs " + jugador2 + " - " + equipo1Nombre + " vs " + equipo2Nombre;
	    }

	    for (int i = 0; i < 3; i++) {
	        String jugador1 = getEquipo3()[i].getUsuario();
	        String jugador2 = getEquipo4()[i].getUsuario();
	        String equipo1Nombre = getEquipo3()[i].getEquipo();
	        String equipo2Nombre = getEquipo4()[i].getEquipo();
	        getCronograma()[0][i + 3] = "Fase 1 (" + getFechas()[0] + "): " + jugador1 + " vs " + jugador2 + " - " + equipo1Nombre + " vs " + equipo2Nombre;
	    }

	    // Fase 2 (Final)
	    getFechas()[1] = fechaInicial.plusDays(1);
	    getCronograma()[1] = new String[3]; // 3 enfrentamientos entre equipoGanador1 y equipoGanador2

	    for (int i = 0; i < 3; i++) {
	        getCronograma()[1][i] = "Fase 2 (" + getFechas()[1] + "): Pendiente";
	    }
	}
	public LocalDate[] getFechas() {
		return fechas;
	}
	public void setFechas(LocalDate[] fechas) {
		this.fechas = fechas;
	}
	public String[][] getCronograma() {
		return cronograma;
	}
	public void setCronograma(String[][] cronograma) {
		this.cronograma = cronograma;
	}
	public Jugador[] getEquipoGanadorTorneo() {
		return equipoGanadorTorneo;
	}
	public void setEquipoGanadorTorneo(Jugador[] equipoGanadorTorneo) {
		this.equipoGanadorTorneo = equipoGanadorTorneo;
	}
	public Jugador[] getEquipoGanador2() {
		return equipoGanador2;
	}
	public void setEquipoGanador2(Jugador[] equipoGanador2) {
		this.equipoGanador2 = equipoGanador2;
	}
	public Jugador[] getEquipoGanador1() {
		return equipoGanador1;
	}
	public void setEquipoGanador1(Jugador[] equipoGanador1) {
		this.equipoGanador1 = equipoGanador1;
	}
	public Jugador[] getEquipo4() {
		return equipo4;
	}
	public void setEquipo4(Jugador[] equipo4) {
		this.equipo4 = equipo4;
	}
	public Jugador[] getEquipo3() {
		return equipo3;
	}
	public void setEquipo3(Jugador[] equipo3) {
		this.equipo3 = equipo3;
	}
	public Jugador[] getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Jugador[] equipo2) {
		this.equipo2 = equipo2;
	}
	public Jugador[] getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Jugador[] equipo1) {
		this.equipo1 = equipo1;
	}

	 
	 public void mostrarCronograma() {
	        for (int i = 0; i < getCronograma().length; i++) {
	            for (String partido : getCronograma()[i]) {
	                System.out.println(partido);
	            }
	        }
	    }

	
	

}
