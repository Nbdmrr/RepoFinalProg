package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import co.edu.unbosque.modelo.Administrador;
import co.edu.unbosque.modelo.DirectorioPrincipal;
import co.edu.unbosque.modelo.Entrenador;
import co.edu.unbosque.modelo.Equipo;
import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.TorneoGrupos;
import co.edu.unbosque.modelo.persistencia.Archivo;
import co.edu.unbosque.modelo.persistencia.DirectorioJugadoresDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;
import co.edu.unbosque.vista.Vista;

public class Controlador implements ActionListener{

	private Vista vista;
	private DirectorioPrincipal directorioPrincipal;



	public Controlador() {
		this.vista = new Vista();
		this.directorioPrincipal = new DirectorioPrincipal();
		asignarOyentes();
		directorioPrincipal.getDirectorioEntrenadores().cargarEntrenadores();
		directorioPrincipal.getDirectorioAdministradores().cargarAdministradores();
		directorioPrincipal.getDirectorioEquipos().cargarEquipos();
		directorioPrincipal.getDirectorioJugadores().cargarJugadores();
		directorioPrincipal.getDirectorioTorneosGrupos().cargarTorneosGrupos();
		directorioPrincipal.getDirectorioTorneosEliminacion().cargarTorneosEliminacion();
		directorioPrincipal.getDirectorioTorneosPuntos().cargarTorneosPuntos();
		actualizarComboBoxRegistroJugador();
		Administrador admin = new Administrador("admin", "123", "Colombia", "dsgomezd@unbosque.edu.co", "administradorPrincipal");
		directorioPrincipal.getDirectorioAdministradores().adicionarAdministrador(MapHandler.convertirAdministradorAAdministradorDTO(admin));
	}
	public void asignarOyentes() {

		vista.getVentanaInicioSesion().getPanelInicioSesion().getBtnRegistrarEntrenador().addActionListener(this);
		vista.getVentanaInicioSesion().getPanelInicioSesion().getBtnRegistrarJugador().addActionListener(this);
		vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getBtnVolver().addActionListener(this);
		vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getBtnRegistrarse().addActionListener(this);
		vista.getVentanaRegistroJugador().getPanelRegistroJugador().getBtnVolver().addActionListener(this);
		vista.getVentanaRegistroJugador().getPanelRegistroJugador().getBtnRegistrarse().addActionListener(this);
		vista.getVentanaInicioSesion().getPanelInicioSesion().getBtnIniciarSesion().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();



		if(comando.equals("ABRIRREGISTROJUGADOR") ) {

			vista.getVentanaInicioSesion().setVisible(false);
			vista.getVentanaRegistroJugador().setVisible(true);

		}else if(comando.equals("ABRIRREGISTROENTRENADOR") ) {

			vista.getVentanaInicioSesion().setVisible(false);
			vista.getVentanaRegistroEntrenador().setVisible(true);

		}else if(comando.equals("VOLVERAINICIOSESIONDEREGISTROENTRENADOR")) {

			vista.getVentanaRegistroEntrenador().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);

		}else if(comando.equals("VOLVERAINICIOSESIONDEREGISTROJUGADOR")) {

			vista.getVentanaRegistroJugador().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);



		}else if(comando.equals("REGISTRARJUGADOR")) {

			String contraseña = vista.getVentanaRegistroJugador().getPanelRegistroJugador().getTxtContrasena().getText();
			String correo = vista.getVentanaRegistroJugador().getPanelRegistroJugador().getTxtCorreo().getText();
			String especialidad = vista.getVentanaRegistroJugador().getPanelRegistroJugador().getTxtEspecialidad().getText();
			String usuario = vista.getVentanaRegistroJugador().getPanelRegistroJugador().getTxtUsuario().getText();
			String equipo = vista.getVentanaRegistroJugador().getPanelRegistroJugador().getComboEquipo().getSelectedItem().toString();
			String nacionalidad = vista.getVentanaRegistroJugador().getPanelRegistroJugador().getComboNacionalidad().getSelectedItem().toString();

			if (!vista.getVentanaRegistroJugador().getPanelRegistroJugador().validarCorreo(correo)) {
				return;
			} 
			if(!ValidarUsuario(usuario)) {
				return;
			}  
			Jugador jugadorNuevo= new Jugador(usuario,contraseña,nacionalidad,correo,especialidad,equipo);
			directorioPrincipal.getDirectorioJugadores().adicionarJugador(MapHandler.convertirJugadorAJugadorDTO(jugadorNuevo));
			Equipo equipoAux = new Equipo(equipo, null);
			Equipo equipoAlQueEntra =directorioPrincipal.getDirectorioEquipos().encontrarEquipo(MapHandler.convertirEquipoAEquipoDTO(equipoAux));
			equipoAlQueEntra.getEquipo().add(jugadorNuevo);
			directorioPrincipal.getDirectorioEquipos().actualizarEquipo(MapHandler.convertirEquipoAEquipoDTO(equipoAux), MapHandler.convertirEquipoAEquipoDTO(equipoAlQueEntra));
			vista.getVentanaRegistroJugador().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);

			directorioPrincipal.getDirectorioJugadores().cargarJugadores();
			directorioPrincipal.getDirectorioEquipos().cargarEquipos();


		}else if(comando.equals("REGISTRARENTRENADOR")) {
			String contraseña = vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getTxtContrasena().getText();
			String correo = vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getTxtCorreo().getText();

			String usuario = vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getTxtUsuario().getText();
			String equipo = vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getTxtEquipo().getText();
			String nacionalidad = vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getComboNacionalidad().getSelectedItem().toString();

			if (!vista.getVentanaRegistroJugador().getPanelRegistroJugador().validarCorreo(correo)) {
				return;
			} 
			if(!ValidarUsuario(usuario)) {
				return;
			}


			Entrenador entrenadorNuevo = new Entrenador(usuario,contraseña,nacionalidad,correo,equipo);

			Equipo equipoNuevo = new Equipo(equipo, entrenadorNuevo);

			directorioPrincipal.getDirectorioEntrenadores().adicionarEntrenador(MapHandler.convertirEntrenadorAEntrenadorDTO(entrenadorNuevo));
			directorioPrincipal.getDirectorioEquipos().adicionarEquipo(MapHandler.convertirEquipoAEquipoDTO(equipoNuevo));

			vista.getVentanaRegistroEntrenador().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);

			directorioPrincipal.getDirectorioEntrenadores().cargarEntrenadores();
			directorioPrincipal.getDirectorioEquipos().cargarEquipos();

			actualizarComboBoxRegistroJugador();  

		}else if(comando.equals("INICIARSESION")) {

			String usuario = vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtUsuario().getText();
			String contraseña = vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtContrasena().getText();

			ArrayList<Jugador> jugadoresAux = directorioPrincipal.getDirectorioJugadores().obtenerJugador();
			ArrayList<Administrador> administradoresAux = directorioPrincipal.getDirectorioAdministradores().obtenerAdministradores();
			ArrayList<Entrenador> entrenadorAux = directorioPrincipal.getDirectorioEntrenadores().obtenerEntrenadores();

			for (Entrenador entrenador : entrenadorAux) {

				if(entrenador.getUsuario().equals(usuario)&& entrenador.getContraseña().equals(contraseña)) {


					vista.getVentanaInicioSesion().setVisible(false);
					vista.getVentanaPrincipalEntrenador().setVisible(true);
					return;
				}

			}
			for (Jugador jugador: jugadoresAux) {

				if(jugador.getUsuario().equals(usuario)&& jugador.getContraseña().equals(contraseña)) {


					vista.getVentanaInicioSesion().setVisible(false);
					vista.getVentanaPrincipalJugador().setVisible(true);
					return;
				}
			}
			for (Administrador administrador : administradoresAux) {

				if(administrador.getUsuario().equals(usuario)&& administrador.getContraseña().equals(contraseña)) {

					vista.getVentanaInicioSesion().setVisible(false);
					vista.getVentanaPrincipalAdmin().setVisible(true);
					return;

				}

			}

			vista.mostrarMensaje("Usuario no encontrado o contraseña mal ingresada");   

		}

	}

	public void actualizarComboBoxRegistroJugador() {

		ArrayList<String> stringsEquipos = directorioPrincipal.getDirectorioEquipos().convertirEquiposAStrings(directorioPrincipal.getDirectorioEquipos().obtenerEquipos());
		vista.getVentanaRegistroJugador().getPanelRegistroJugador().setEquipos(stringsEquipos);
	}
	public Boolean ValidarUsuario(String usuario) {


		ArrayList<Jugador> jugadoresAux = directorioPrincipal.getDirectorioJugadores().obtenerJugador();
		ArrayList<Administrador> administradoresAux = directorioPrincipal.getDirectorioAdministradores().obtenerAdministradores();
		ArrayList<Entrenador> entrenadorAux = directorioPrincipal.getDirectorioEntrenadores().obtenerEntrenadores();

		for (Entrenador entrenador : entrenadorAux) {

			if(entrenador.getUsuario().equals(usuario)) {

				vista.mostrarMensaje("Usuario ya registrado, utiliza otro");

				return false;
			}

		}
		for (Jugador jugador: jugadoresAux) {

			if(jugador.getUsuario().equals(usuario)) {


				vista.mostrarMensaje("Usuario ya registrado, utiliza otro");
				return false;
			}
		}
		for (Administrador administrador : administradoresAux) {

			if(administrador.getUsuario().equals(usuario)) {


				vista.mostrarMensaje("Usuario ya registrado, utiliza otro");
				return false;


			}


		}
		return true;
	}



	// TODO Auto-generated method stub




	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}



	public DirectorioPrincipal getDirectorioPrincipal() {
		return directorioPrincipal;
	}



	public void setDirectorioPrincipal(DirectorioPrincipal directorioPrincipal) {
		this.directorioPrincipal = directorioPrincipal;
	}
}