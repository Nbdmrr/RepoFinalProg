package co.edu.unbosque.modelo.persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.Administrador;
import co.edu.unbosque.modelo.Entrenador;
import co.edu.unbosque.modelo.Equipo;
import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.TorneoEliminacion;
import co.edu.unbosque.modelo.TorneoGrupos;
import co.edu.unbosque.modelo.TorneoPuntos;

public class Archivo {
	
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File ubicacionArchivoJugadores = new File("data/jugadores.dat");
	private File ubicacionArchivoAdministradores = new File("data/administradores.dat");
	private File ubicacionArchivoEntrenadores = new File("data/entrenadores.dat");
	private File ubicacionArchivoTorneosEliminacion = new File("data/torneosEliminacion.dat");
	private File ubicacionArchivoTorneosGrupos = new File("data/torneosGrupos.dat");
	private File ubicacionArchivoTorneosPuntos = new File("data/torneosPuntos.dat");
	private File ubicacionArchivoEquipos = new File("data/equipos.dat");
	
	
    

    public Archivo() {
        crearArchivoSiNoExiste(getUbicacionArchivoJugadores());
        crearArchivoSiNoExiste(getUbicacionArchivoAdministradores());
        crearArchivoSiNoExiste(getUbicacionArchivoEntrenadores());
        crearArchivoSiNoExiste(getUbicacionArchivoTorneosEliminacion());
        crearArchivoSiNoExiste(getUbicacionArchivoTorneosGrupos());
        crearArchivoSiNoExiste(getUbicacionArchivoTorneosPuntos());
        crearArchivoSiNoExiste(getUbicacionArchivoEquipos());
        
    }
    
    private void crearArchivoSiNoExiste(File archivo) {
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void escribirArchivoJugadores(ArrayList<Jugador> jugadores) {
        try {
            setSalida(new ObjectOutputStream(new FileOutputStream(getUbicacionArchivoJugadores())));
            ArrayList<JugadorDTO> datos = MapHandler.convertirJugadoresAJugadoresDTO(jugadores);
            getSalida().writeObject(datos);
            getSalida().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Jugador> leerArchivoJugadores() {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        if (getUbicacionArchivoJugadores().length() != 0) {
            try {
                setEntrada(new ObjectInputStream(new FileInputStream(getUbicacionArchivoJugadores())));
                ArrayList<JugadorDTO> datos = (ArrayList<JugadorDTO>) getEntrada().readObject();
                jugadores = MapHandler.convertirJugadoresDTOAJugadores(datos);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return jugadores;
    }

    public void escribirArchivoTorneosEliminacion(ArrayList<TorneoEliminacion> torneos) {
        try {
            setSalida(new ObjectOutputStream(new FileOutputStream(getUbicacionArchivoTorneosEliminacion())));
            ArrayList<TorneoEliminacionDTO> datos = MapHandler.convertirTorneosEliminacionATorneosEliminacionDTO(torneos);
            getSalida().writeObject(datos);
            getSalida().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TorneoEliminacion> leerArchivoTorneosEliminacion() {
        ArrayList<TorneoEliminacion> torneos = new ArrayList<TorneoEliminacion>();
        if (getUbicacionArchivoTorneosEliminacion().length() != 0) {
            try {
                setEntrada(new ObjectInputStream(new FileInputStream(getUbicacionArchivoTorneosEliminacion())));
                ArrayList<TorneoEliminacionDTO> datos = (ArrayList<TorneoEliminacionDTO>) getEntrada().readObject();
                torneos = MapHandler.convertirTorneosEliminacionDTOATorneosEliminacion(datos);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return torneos;
    }
    public void escribirArchivoAdministradores(ArrayList<Administrador> administradores) {
        try {
            setSalida(new ObjectOutputStream(new FileOutputStream(getUbicacionArchivoAdministradores())));
            ArrayList<AdministradorDTO> datos = MapHandler.convertirAdministradoresAAdministradoresDTO(administradores);
            getSalida().writeObject(datos);
            getSalida().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Administrador> leerArchivoAdministradores() {
        ArrayList<Administrador> administradores = new ArrayList<Administrador>();
        if (getUbicacionArchivoAdministradores().length() != 0) {
            try {
                setEntrada(new ObjectInputStream(new FileInputStream(getUbicacionArchivoAdministradores())));
                ArrayList<AdministradorDTO> datos = (ArrayList<AdministradorDTO>) getEntrada().readObject();
                administradores = MapHandler.convertirAdministradoresDTOAAdministradores(datos);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return administradores;
    } 
    public void escribirArchivoEntrenadores(ArrayList<Entrenador> entrenadores) {
        try {
            setSalida(new ObjectOutputStream(new FileOutputStream(getUbicacionArchivoEntrenadores())));
            ArrayList<EntrenadorDTO> datos = MapHandler.convertirEntrenadoresAEntrenadoresDTO(entrenadores);
            getSalida().writeObject(datos);
            getSalida().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Entrenador> leerArchivoEntrenadores() {
        ArrayList<Entrenador> entrenadores = null;
        if (getUbicacionArchivoEntrenadores().length() != 0) {
            try {
                setEntrada(new ObjectInputStream(new FileInputStream(getUbicacionArchivoEntrenadores())));
                ArrayList<EntrenadorDTO> datos = (ArrayList<EntrenadorDTO>) getEntrada().readObject();
                entrenadores = MapHandler.convertirEntrenadoresDTOAEntrenadores(datos);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return entrenadores;
    }
    public void escribirArchivoEquipos(ArrayList<Equipo> equipos) {
        try {
            setSalida(new ObjectOutputStream(new FileOutputStream(getUbicacionArchivoEquipos())));
            ArrayList<EquipoDTO> datos = MapHandler.convertirEquiposAEquiposDTO(equipos);
            getSalida().writeObject(datos);
            getSalida().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Equipo> leerArchivoEquipos() {
        ArrayList<Equipo> equipos = new ArrayList<>();

        if (getUbicacionArchivoEquipos().length() != 0) {
            try {
                setEntrada(new ObjectInputStream(new FileInputStream(getUbicacionArchivoEquipos())));
                ArrayList<EquipoDTO> datos = (ArrayList<EquipoDTO>) getEntrada().readObject();
                equipos = MapHandler.convertirEquiposDTOAEquipos(datos);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return equipos;
    }

    public void escribirArchivoTorneosGrupos(ArrayList<TorneoGrupos> torneosGrupos) {
        try {
            setSalida(new ObjectOutputStream(new FileOutputStream(getUbicacionArchivoTorneosGrupos())));
            ArrayList<TorneoGruposDTO> datos = MapHandler.convertirTorneosGruposATorneosGruposDTO(torneosGrupos);
            getSalida().writeObject(datos);
            getSalida().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TorneoGrupos> leerArchivoTorneosGrupos() {
        ArrayList<TorneoGrupos> torneosGrupos = new ArrayList<TorneoGrupos>();
        if (getUbicacionArchivoTorneosGrupos().length() != 0) {
            try {
                setEntrada(new ObjectInputStream(new FileInputStream(getUbicacionArchivoTorneosGrupos())));
                ArrayList<TorneoGruposDTO> datos = (ArrayList<TorneoGruposDTO>) getEntrada().readObject();
                torneosGrupos = MapHandler.convertirTorneosGruposDTOATorneosGrupos(datos);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return torneosGrupos;
    }

    public void escribirArchivoTorneosPuntos(ArrayList<TorneoPuntos> torneosPuntos) {
        try {
            setSalida(new ObjectOutputStream(new FileOutputStream(getUbicacionArchivoTorneosPuntos())));
            ArrayList<TorneoPuntosDTO> datos = MapHandler.convertirTorneosPuntosATorneosPuntosDTO(torneosPuntos);
            getSalida().writeObject(datos);
            getSalida().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TorneoPuntos> leerArchivoTorneosPuntos() {
        ArrayList<TorneoPuntos> torneosPuntos = new ArrayList<TorneoPuntos>();
        if (getUbicacionArchivoTorneosPuntos().length() != 0) {
            try {
                setEntrada(new ObjectInputStream(new FileInputStream(getUbicacionArchivoTorneosPuntos())));
                ArrayList<TorneoPuntosDTO> datos = (ArrayList<TorneoPuntosDTO>) getEntrada().readObject();
                torneosPuntos = MapHandler.convertirTorneosPuntosDTOATorneosPuntos(datos);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return torneosPuntos;
    }

	public File getUbicacionArchivoEquipos() {
		return ubicacionArchivoEquipos;
	}

	public void setUbicacionArchivoEquipos(File ubicacionArchivoEquipos) {
		this.ubicacionArchivoEquipos = ubicacionArchivoEquipos;
	}

	public File getUbicacionArchivoTorneosPuntos() {
		return ubicacionArchivoTorneosPuntos;
	}

	public void setUbicacionArchivoTorneosPuntos(File ubicacionArchivoTorneosPuntos) {
		this.ubicacionArchivoTorneosPuntos = ubicacionArchivoTorneosPuntos;
	}

	public File getUbicacionArchivoTorneosGrupos() {
		return ubicacionArchivoTorneosGrupos;
	}

	public void setUbicacionArchivoTorneosGrupos(File ubicacionArchivoTorneoGrupos) {
		this.ubicacionArchivoTorneosGrupos = ubicacionArchivoTorneoGrupos;
	}

	public File getUbicacionArchivoTorneosEliminacion() {
		return ubicacionArchivoTorneosEliminacion;
	}

	public void setUbicacionArchivoTorneosEliminacion(File ubicacionArchivoTorneosEliminacion) {
		this.ubicacionArchivoTorneosEliminacion = ubicacionArchivoTorneosEliminacion;
	}

	public File getUbicacionArchivoEntrenadores() {
		return ubicacionArchivoEntrenadores;
	}

	public void setUbicacionArchivoEntrenadores(File ubicacionArchivoEntrenadores) {
		this.ubicacionArchivoEntrenadores = ubicacionArchivoEntrenadores;
	}

	public File getUbicacionArchivoAdministradores() {
		return ubicacionArchivoAdministradores;
	}

	public void setUbicacionArchivoAdministradores(File ubicacionArchivoAdministradores) {
		this.ubicacionArchivoAdministradores = ubicacionArchivoAdministradores;
	}

	public File getUbicacionArchivoJugadores() {
		return ubicacionArchivoJugadores;
	}

	public void setUbicacionArchivoJugadores(File ubicacionArchivoJugadores) {
		this.ubicacionArchivoJugadores = ubicacionArchivoJugadores;
	}

	public ObjectOutputStream getSalida() {
		return salida;
	}

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}

	public ObjectInputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}
    
}