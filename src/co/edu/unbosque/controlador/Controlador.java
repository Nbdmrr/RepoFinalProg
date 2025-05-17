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
		vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().getBotonVolver().addActionListener(this);
		vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().getBotonVolver().addActionListener(this);
		vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getBotonRegistrarAdmin().addActionListener(this);
		vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getBtnRegistrarse().addActionListener(this);
		vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getBtnVolver().addActionListener(this);
		vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getBotonCrearTorneo().addActionListener(this);
		vista.getVentanaCrearTorneo().getPanelCrearTorneo().getBtnCrear().addActionListener(this);
		vista.getVentanaCrearTorneo().getPanelCrearTorneo().getBtnVolver().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		Administrador administradorPrincipal = null;
		Entrenador entrenadorPrincipal = null;
		Jugador jugadorPrincipal = null;



		if(comando.equals("ABRIRREGISTROJUGADOR") ) {

			vista.getVentanaInicioSesion().setVisible(false);
			vista.getVentanaRegistroJugador().setVisible(true);
			vista.getVentanaRegistroJugador().getPanelRegistroJugador().getTxtContrasena().setText("");
			vista.getVentanaRegistroJugador().getPanelRegistroJugador().getTxtCorreo().setText("");
			vista.getVentanaRegistroJugador().getPanelRegistroJugador().getTxtEspecialidad().setText("");
			vista.getVentanaRegistroJugador().getPanelRegistroJugador().getTxtUsuario().setText("");
			

		}else if(comando.equals("ABRIRREGISTROENTRENADOR") ) {

			vista.getVentanaInicioSesion().setVisible(false);
			vista.getVentanaRegistroEntrenador().setVisible(true);
			vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getTxtContrasena().setText("");
			vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getTxtCorreo().setText("");
			vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getTxtUsuario().setText("");
			vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().getTxtEquipo().setText("");

		}else if (comando.equals("REGISTRARADMINISTRADOR")) {
			
			vista.getVentanaPrincipalAdmin().setVisible(false);
			vista.getVentanaRegistroAdmin().setVisible(true);
			vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtContrasena().setText("");
			vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtCorreo().setText("");
			vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtUsuario().setText("");
			
			
			
			
		}else  if(comando.equals("VOLVERAINICIOSESIONDEREGISTROENTRENADOR")) {

			vista.getVentanaRegistroEntrenador().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);

		}else if(comando.equals("VOLVERAINICIOSESIONDEREGISTROJUGADOR")) {

			vista.getVentanaRegistroJugador().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);



		}else if(comando.equals("VOLVERDEREGISTROADMINAPRINCIPALADMIN")){
		
			
			vista.getVentanaRegistroAdmin().setVisible(false);
			vista.getVentanaPrincipalAdmin().setVisible(true);
			
		
		}else if(comando.equals("REGISTRARADMIN")){
		
			
			String usuario=vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtUsuario().getText();
			String contraseña=vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtContrasena().getText();
			String correo=vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtCorreo().getText();
			String cargo=vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtCargo().getText();
			String nacionalidad=vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getComboNacionalidad().getSelectedItem().toString();
		
			if(!vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().validarCorreo(correo)) {
				
				
				return;
			}
			if(!ValidarUsuario(usuario)) {
				return;
			} 
			
			Administrador adminNuevo = new Administrador(usuario, contraseña, nacionalidad, correo, cargo);
			directorioPrincipal.getDirectorioAdministradores().adicionarAdministrador(MapHandler.convertirAdministradorAAdministradorDTO(adminNuevo));
			
			vista.getVentanaRegistroAdmin().setVisible(false);
			vista.getVentanaPrincipalAdmin().setVisible(true);
			
			directorioPrincipal.getDirectorioAdministradores().cargarAdministradores();
			
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

			if (!vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().validarCorreo(correo)) {
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
					
					entrenadorPrincipal = directorioPrincipal.getDirectorioEntrenadores().encontrarEntrenadores(MapHandler.convertirEntrenadorAEntrenadorDTO(entrenador));
					vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().actualizarDatosEntrenador(entrenadorPrincipal.getUsuario(), entrenadorPrincipal.getNacionalidad(), entrenadorPrincipal.getCorreo());
				


					vista.getVentanaInicioSesion().setVisible(false);
					vista.getVentanaPrincipalEntrenador().setVisible(true);
					vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtContrasena().setText("");
					vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtUsuario().setText("");
					
					
					return;
				}

			}
			for (Jugador jugador: jugadoresAux) {

				if(jugador.getUsuario().equals(usuario)&& jugador.getContraseña().equals(contraseña)) {

					jugadorPrincipal = directorioPrincipal.getDirectorioJugadores().encontrarJugador(MapHandler.convertirJugadorAJugadorDTO(jugador));
					vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().actualizarDatosJugador(jugadorPrincipal.getUsuario(), jugadorPrincipal.getNacionalidad(), jugadorPrincipal.getEspecialidad(), jugadorPrincipal.getCorreo(), jugadorPrincipal.getEquipo(), jugadorPrincipal.getPartidasJugadas(), jugadorPrincipal.getPartidasGanadas(), jugadorPrincipal.getTorneosJugados(), jugadorPrincipal.getTorneosGanados());
					vista.getVentanaInicioSesion().setVisible(false);
					vista.getVentanaPrincipalJugador().setVisible(true);
					vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtContrasena().setText("");
					vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtUsuario().setText("");
					return;
				}
			}
			for (Administrador administrador : administradoresAux) {

				if(administrador.getUsuario().equals(usuario)&& administrador.getContraseña().equals(contraseña)) {
					
					administradorPrincipal = directorioPrincipal.getDirectorioAdministradores().encontrarAdministrador(MapHandler.convertirAdministradorAAdministradorDTO(administrador));
					vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().actualizarDatosAdmin(administradorPrincipal.getUsuario(), administradorPrincipal.getCargo(), administradorPrincipal.getCorreo(), administradorPrincipal.getNacionalidad());

					vista.getVentanaInicioSesion().setVisible(false);
					vista.getVentanaPrincipalAdmin().setVisible(true);
					vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtContrasena().setText("");
					vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtUsuario().setText("");
					
					
					return;

				}
				

			}

			vista.mostrarMensaje("Usuario no encontrado o contraseña mal ingresada");   

		}else if(comando.equals("VOLVERDEJUGADORAINICIOSESION")) {
			
			
			vista.getVentanaPrincipalJugador().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);
			
		}else if(comando.equals("VOLVERDEENTRENADORAINICIO")) {
			
			vista.getVentanaPrincipalEntrenador().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);
			
			
		}else if(comando.equals("CREACIONTORNEO")) {
			
			vista.getVentanaPrincipalAdmin().setVisible(false);
			vista.getVentanaCrearTorneo().setVisible(true);
			vista.getVentanaCrearTorneo().getPanelCrearTorneo().getTxtNombre().setText("");
			
			
		}else if(comando.equals("VOLVERDEVENTANACREARTORNEOAPRINCIPALADMIN")) {
			
			vista.getVentanaCrearTorneo().setVisible(false);
			vista.getVentanaPrincipalAdmin().setVisible(true);
			
			
		}else if(comando.equals("CREARTORNEO")) {
			
			String nombreTorneo =vista.getVentanaCrearTorneo().getPanelCrearTorneo().getTxtNombre().getText();
			int limiteParticipantes = Integer.parseInt(vista.getVentanaCrearTorneo().getPanelCrearTorneo().getComboLimiteParticipantes().getSelectedItem().toString());
			String tipoTorneo =vista.getVentanaCrearTorneo().getPanelCrearTorneo().getComboTipo().getSelectedItem().toString();
			String juego = vista.getVentanaCrearTorneo().getPanelCrearTorneo().getComboJuego().getSelectedItem().toString();
			
			if(tipoTorneo.equals("Eliminacion Directa")) {
				
				
				
			}
			
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