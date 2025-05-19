package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.net.Authenticator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import co.edu.unbosque.modelo.Administrador;
import co.edu.unbosque.modelo.DirectorioPrincipal;
import co.edu.unbosque.modelo.Entrenador;
import co.edu.unbosque.modelo.Equipo;
import co.edu.unbosque.modelo.Jugador;
import co.edu.unbosque.modelo.TorneoEliminacion;
import co.edu.unbosque.modelo.TorneoGrupos;
import co.edu.unbosque.modelo.TorneoPuntos;
import co.edu.unbosque.modelo.persistencia.Archivo;
import co.edu.unbosque.modelo.persistencia.DirectorioJugadoresDAO;
import co.edu.unbosque.modelo.persistencia.MapHandler;
import co.edu.unbosque.vista.Vista;

/**
 * Controlador principal de la aplicación.
 * Implementa la interfaz ActionListener para manejar eventos de la interfaz gráfica.
 */
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
		actualizarListaTorneosAdmin();
		actualizarListaEquiposDisponibles();
		actualizarListaTorneosActivos();
		
		
		
		
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
		vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getBotonEnviar().addActionListener(this);
		vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getBotonPDF().addActionListener(this);
		vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getBotonVolver().addActionListener(this);
		vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().getBotonUnirseTorneo().addActionListener(this);
		vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().getBotonVerTorneo().addActionListener(this);
		vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getBotonElegirTorneo().addActionListener(this);
		vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnAvanzarFase().addActionListener(this);
		vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnCronograma().addActionListener(this);
		vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnIniciarTorneo().addActionListener(this);
		vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnVolver().addActionListener(this);
		vista.getVentanaCronograma().getPanelCronograma().getBotonVolver().addActionListener(this);
		vista.getVentanaDatosTorneo().getPanelDatosTorneo().getBotonCronograma().addActionListener(this);
		vista.getVentanaDatosTorneo().getPanelDatosTorneo().getBotonVolver().addActionListener(this);
		vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().getBotonUnirse().addActionListener(this);
		vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().getBotonCrear().addActionListener(this);
		vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().getBotonEnviar().addActionListener(this);
		vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().getBotonVolver().addActionListener(this);
		vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().getBotonElegirEquipo().addActionListener(this);
		vista.getVentanaCrearEquipo().getPanelCrearEquipo().getBtnCrearEquipo().addActionListener(this);
		vista.getVentanaCrearEquipo().getPanelCrearEquipo().getBtnVolver().addActionListener(this);
		vista.getVentanaListaEquipos().getPanelListaEquipos().getBtnVolver().addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		



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
		
			
			String usuario = vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtUsuario().getText();
			String contraseña = vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtContrasena().getText();
			String correo = vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtCorreo().getText();
			String cargo = vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getTxtCargo().getText();
			String nacionalidad = vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().getComboNacionalidad().getSelectedItem().toString();

			if (usuario.isEmpty() || contraseña.isEmpty() || correo.isEmpty() || cargo.isEmpty() || nacionalidad.isEmpty()) {
			    vista.mostrarMensaje("Todos los campos deben estar completos.");
			    return;
			}

			if (!vista.getVentanaRegistroAdmin().getPanelRegistroAdmin().validarCorreo(correo)) {
			    return;
			}

			if (!ValidarUsuario(usuario)) {
			    return;
			}

			Administrador adminNuevo = new Administrador(usuario, contraseña, nacionalidad, correo, cargo);

			directorioPrincipal.getDirectorioAdministradores().adicionarAdministrador(MapHandler.convertirAdministradorAAdministradorDTO(adminNuevo));

			vista.mostrarMensaje("Administrador registrado con exito");

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

			if (contraseña.isEmpty() || correo.isEmpty() || especialidad.isEmpty() || usuario.isEmpty() || equipo.isEmpty() || nacionalidad.isEmpty()) {
			    vista.mostrarMensaje("Todos los campos deben estar completos.");
			    return;
			}

			if (!vista.getVentanaRegistroJugador().getPanelRegistroJugador().validarCorreo(correo)) {
			    return;
			}

			if (!ValidarUsuario(usuario)) {
			    return;
			}

			Jugador jugadorNuevo = new Jugador(usuario, contraseña, nacionalidad, correo, especialidad, equipo);

			directorioPrincipal.getDirectorioJugadores().adicionarJugador(MapHandler.convertirJugadorAJugadorDTO(jugadorNuevo));

			Equipo equipoAux = new Equipo(equipo, null);
			Equipo equipoAlQueEntra = directorioPrincipal.getDirectorioEquipos().encontrarEquipo(MapHandler.convertirEquipoAEquipoDTO(equipoAux));

			if (equipoAlQueEntra != null) {
			    equipoAlQueEntra.getEquipo().add(jugadorNuevo);
			    directorioPrincipal.getDirectorioEquipos().actualizarEquipo(
			        MapHandler.convertirEquipoAEquipoDTO(equipoAux),
			        MapHandler.convertirEquipoAEquipoDTO(equipoAlQueEntra)
			    );
			}

			vista.mostrarMensaje("Jugador registrado con éxito");

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

			
			if (contraseña.isEmpty() || correo.isEmpty() || usuario.isEmpty() || equipo.isEmpty() || nacionalidad.isEmpty()) {
			    vista.mostrarMensaje("Todos los campos deben estar completos.");
			    return;
			}

			
			if (!vista.getVentanaRegistroEntrenador().getPanelRegistroEntrenador().validarCorreo(correo)) {
			    return;
			}

			
			if (!ValidarUsuario(usuario)) {
			    return;
			}

			
			Entrenador entrenadorNuevo = new Entrenador(usuario, contraseña, nacionalidad, correo, equipo);
			Equipo equipoNuevo = new Equipo(equipo, entrenadorNuevo);

			
			directorioPrincipal.getDirectorioEntrenadores().adicionarEntrenador(MapHandler.convertirEntrenadorAEntrenadorDTO(entrenadorNuevo));
			directorioPrincipal.getDirectorioEquipos().adicionarEquipo(MapHandler.convertirEquipoAEquipoDTO(equipoNuevo));

		
			vista.mostrarMensaje("Entrenador registrado con éxito");

			
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
			    if (entrenador.getUsuario().equals(usuario) && entrenador.getContraseña().equals(contraseña)) {
			        directorioPrincipal.setEntrenadorPrincipal(
			            directorioPrincipal.getDirectorioEntrenadores().encontrarEntrenadores(
			                MapHandler.convertirEntrenadorAEntrenadorDTO(entrenador)
			            )
			        );

			        vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().actualizarDatosEntrenador(
			            directorioPrincipal.getEntrenadorPrincipal().getUsuario(),
			            directorioPrincipal.getEntrenadorPrincipal().getNacionalidad(),
			            directorioPrincipal.getEntrenadorPrincipal().getCorreo()
			        );

			        vista.getVentanaInicioSesion().setVisible(false);
			        vista.getVentanaPrincipalEntrenador().setVisible(true);
			        vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtContrasena().setText("");
			        vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtUsuario().setText("");
			        actualizarListaEquiposQueEntrena(directorioPrincipal.getEntrenadorPrincipal());
			        return;
			    }
			}

			for (Jugador jugador : jugadoresAux) {
			    if (jugador.getUsuario().equals(usuario) && jugador.getContraseña().equals(contraseña)) {
			        directorioPrincipal.setJugadorPrincipal(
			            directorioPrincipal.getDirectorioJugadores().encontrarJugador(
			                MapHandler.convertirJugadorAJugadorDTO(jugador)
			            )
			        );

			        vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().actualizarDatosJugador(
			            directorioPrincipal.getJugadorPrincipal().getUsuario(),
			            directorioPrincipal.getJugadorPrincipal().getNacionalidad(),
			            directorioPrincipal.getJugadorPrincipal().getEspecialidad(),
			            directorioPrincipal.getJugadorPrincipal().getCorreo(),
			            directorioPrincipal.getJugadorPrincipal().getEquipo(),
			            directorioPrincipal.getJugadorPrincipal().getPartidasJugadas(),
			            directorioPrincipal.getJugadorPrincipal().getPartidasGanadas(),
			            directorioPrincipal.getJugadorPrincipal().getTorneosJugados(),
			            directorioPrincipal.getJugadorPrincipal().getTorneosGanados()
			        );
			        actualizarListaTorneosEnLosQueParticipa();

			        vista.getVentanaInicioSesion().setVisible(false);
			        vista.getVentanaPrincipalJugador().setVisible(true);
			        vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtContrasena().setText("");
			        vista.getVentanaInicioSesion().getPanelInicioSesion().getTxtUsuario().setText("");
			        return;
			    }
			}

			for (Administrador administrador : administradoresAux) {
			    if (administrador.getUsuario().equals(usuario) && administrador.getContraseña().equals(contraseña)) {
			        directorioPrincipal.setAdministradorPrincipal(
			            directorioPrincipal.getDirectorioAdministradores().encontrarAdministrador(
			                MapHandler.convertirAdministradorAAdministradorDTO(administrador)
			            )
			        );

			        vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().actualizarDatosAdmin(
			            directorioPrincipal.getAdministradorPrincipal().getUsuario(),
			            directorioPrincipal.getAdministradorPrincipal().getCargo(),
			            directorioPrincipal.getAdministradorPrincipal().getCorreo(),
			            directorioPrincipal.getAdministradorPrincipal().getNacionalidad()
			        );

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
			
			if(!validarNombreTorneo(nombreTorneo)) {
				return;
			} 
			
			if(tipoTorneo.equals("Eliminación Directa")) {
				
				TorneoEliminacion nuevoTorneoEliminacion = new TorneoEliminacion(nombreTorneo, limiteParticipantes, tipoTorneo, juego);
				
				directorioPrincipal.getDirectorioTorneosEliminacion().adicionarTorneoEliminacion(MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(nuevoTorneoEliminacion));
				
				vista.mostrarMensaje("Torneo de Eliminacion Agregador Correctamente");
				
				vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().llenarListaTorneos(directorioPrincipal.convertirTorneosAStrings());
				actualizarListaTorneosAdmin();
				actualizarListaTorneosActivos();
				vista.getVentanaCrearTorneo().setVisible(false);
				vista.getVentanaPrincipalAdmin().setVisible(true);
				directorioPrincipal.getDirectorioTorneosEliminacion().cargarTorneosEliminacion();
				

			}else if (tipoTorneo.equals("Grupos")) {
				
				TorneoGrupos nuevoTorneoGrupos = new TorneoGrupos(nombreTorneo, limiteParticipantes, tipoTorneo, juego);
				
				directorioPrincipal.getDirectorioTorneosGrupos().adicionarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(nuevoTorneoGrupos));
				
				vista.mostrarMensaje("Torneo por Grupos Agregador Correctamente");
				actualizarListaTorneosActivos();
				actualizarListaTorneosAdmin();
				vista.getVentanaCrearTorneo().setVisible(false);
				vista.getVentanaPrincipalAdmin().setVisible(true);
				directorioPrincipal.getDirectorioTorneosGrupos().cargarTorneosGrupos();
				
				
			}else if(tipoTorneo.equals("Puntos")) {
				
				
				
				TorneoPuntos nuevoTorneoPuntos = new TorneoPuntos(nombreTorneo, limiteParticipantes, tipoTorneo, juego);
				
				directorioPrincipal.getDirectorioTorneosPuntos().adicionarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(nuevoTorneoPuntos));
				
				vista.mostrarMensaje("Torneo por Puntos Agregador Correctamente");
				actualizarListaTorneosAdmin();
				actualizarListaTorneosActivos();
				vista.getVentanaCrearTorneo().setVisible(false);
				vista.getVentanaPrincipalAdmin().setVisible(true);
				directorioPrincipal.getDirectorioTorneosPuntos().cargarTorneosPuntos();
				
				
			}
			
			
		}else if(comando.equals("VOLVERAINICIOSESIONDEPRINCIPALADMIN")) {
			
			vista.getVentanaPrincipalAdmin().setVisible(false);
			vista.getVentanaInicioSesion().setVisible(true);
			
			
		}else if(comando.equals("UNIRSEATORNEO")) {
			
			
			String torneoAlQueEntraString = vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().getListaTorneosActivos().getSelectedValue();

			if (torneoAlQueEntraString != null) {
			    String[] partes = torneoAlQueEntraString.split("\\|\\|");
			    if (partes.length > 0) {
			        String[] subPartes = partes[0].split(":");
			        if (subPartes.length > 1) {
			            String nombreTorneo = subPartes[1].trim();
			            Jugador jugadorPrincipal = directorioPrincipal.getJugadorPrincipal();

			            // ------------------------------
			            // TORNEO DE ELIMINACIÓN
			            // ------------------------------
			            TorneoEliminacion torneoEliminacionAux = new TorneoEliminacion(nombreTorneo, 0, "", "");
			            TorneoEliminacion torneoEliminacion = directorioPrincipal.getDirectorioTorneosEliminacion()
			                    .encontrarTorneoEliminacion(MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(torneoEliminacionAux));
			            
			            

			            if (torneoEliminacion != null) {
			            	if(torneoEliminacion.getEstado().equals("iniciado")) {
			            		
			            		vista.mostrarMensaje("torneo ya fue iniciado, no puede unirse");
			            		return;
			            	}
			            if(torneoEliminacion.getEstado().equals("Terminado")) {
		            		
			            	vista.mostrarMensaje("torneo Terminado, no puede unirse");
		            		return;
		            	}
			                if (torneoEliminacion.getParticipantes().contains(jugadorPrincipal)) {
			                    vista.mostrarMensaje("Ya está inscrito en el torneo de Eliminación");
			                } else if (torneoEliminacion.getLimiteParticipantes() > torneoEliminacion.getParticipantes().size()) {
			                    torneoEliminacion.getParticipantes().add(jugadorPrincipal);
			                    directorioPrincipal.getDirectorioTorneosEliminacion().actualizarTorneoEliminacion(
			                            MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(torneoEliminacion),
			                            MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(torneoEliminacion));
			                    actualizarListaTorneosEnLosQueParticipa();
			                    vista.mostrarMensaje("Se ha unido al torneo de Eliminación con éxito");
			                } else {
			                    vista.mostrarMensaje("Torneo de Eliminación lleno");
			                }
			                return;
			            }

			            // ------------------------------
			            // TORNEO DE GRUPOS
			            // ------------------------------
			            TorneoGrupos torneoGruposAux = new TorneoGrupos(nombreTorneo, 0, "", "");
			            TorneoGrupos torneoGrupos = directorioPrincipal.getDirectorioTorneosGrupos()
			                    .encontrarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(torneoGruposAux));

			            if (torneoGrupos != null) {
			            	if(torneoGrupos.getEstado().equals("iniciado")) {
			            		
			            		vista.mostrarMensaje("torneo ya fue iniciado, no puede unirse");
			            		return;
			            	}
			            if(torneoGrupos.getEstado().equals("Terminado")) {
		            		
			            	vista.mostrarMensaje("torneo Terminado, no puede unirse");
		            		return;
		            	}
			                if (torneoGrupos.getParticipantes().contains(jugadorPrincipal)) {
			                    vista.mostrarMensaje("Ya está inscrito en el torneo de Grupos");
			                } else if (torneoGrupos.getLimiteParticipantes() > torneoGrupos.getParticipantes().size()) {
			                	
			                	
			                    if(!torneoGrupos.agregarJugador(jugadorPrincipal)) {
			                    	return;
			                    }
			                    directorioPrincipal.getDirectorioTorneosGrupos().actualizarTorneoGrupos(
			                            MapHandler.convertirTorneoGruposATorneoGruposDTO(torneoGrupos),
			                            MapHandler.convertirTorneoGruposATorneoGruposDTO(torneoGrupos));
			                    actualizarListaTorneosEnLosQueParticipa();
			                    vista.mostrarMensaje("Se ha unido al torneo de Grupos con éxito");
			                } else {
			                    vista.mostrarMensaje("Torneo de Grupos lleno");
			                }
			                return;
			            }

			            // ------------------------------
			            // TORNEO DE PUNTOS
			            // ------------------------------
			            TorneoPuntos torneoPuntosAux = new TorneoPuntos(nombreTorneo, 0, "", "");
			            TorneoPuntos torneoPuntos = directorioPrincipal.getDirectorioTorneosPuntos()
			                    .encontrarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(torneoPuntosAux));

			            if (torneoPuntos != null) {
			            	if(torneoPuntos.getEstado().equals("iniciado")) {
			            		
			            		vista.mostrarMensaje("torneo ya fue iniciado, no puede unirse");
			            		return;
			            	}
			            if(torneoPuntos.getEstado().equals("Terminado")) {
		            		
			            	vista.mostrarMensaje("torneo Terminado, no puede unirse");
		            		return;
		            	}
			                if (torneoPuntos.getParticipantes().contains(jugadorPrincipal)) {
			                    vista.mostrarMensaje("Ya está inscrito en el torneo de Puntos");
			                } else if (torneoPuntos.getLimiteParticipantes() > torneoPuntos.getParticipantes().size()) {
			                    torneoPuntos.getParticipantes().add(jugadorPrincipal);
			                    directorioPrincipal.getDirectorioTorneosPuntos().actualizarTorneoPuntos(
			                            MapHandler.convertirTorneoPuntosATorneoPuntosDTO(torneoPuntos),
			                            MapHandler.convertirTorneoPuntosATorneoPuntosDTO(torneoPuntos));
			                    actualizarListaTorneosEnLosQueParticipa();
			                    vista.mostrarMensaje("Se ha unido al torneo de Puntos con éxito");
			                } else {
			                    vista.mostrarMensaje("Torneo de Puntos lleno");
			                }
			                return;
			            }

			            vista.mostrarMensaje("Torneo no encontrado");
			        }
			    }
			}
			
		
		}else if(comando.equals("ELEGIRTORNEO")) {

		    String nombreTorneoString = vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getListaTorneos().getSelectedValue();

		    if (nombreTorneoString != null) {
		        String[] partes = nombreTorneoString.split("\\|\\|");
		        if (partes.length > 0) {
		            String[] subPartes = partes[0].split(":");
		            if (subPartes.length > 1) {
		                String nombreTorneo = subPartes[1].trim();

		                // Torneo Eliminación
		                TorneoEliminacion torneoEliminacion = directorioPrincipal.getDirectorioTorneosEliminacion()
		                    .encontrarTorneoEliminacion(MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(new TorneoEliminacion(nombreTorneo, 0, "", "")));
		                
		               
		                

		                if (torneoEliminacion != null) {
		                    directorioPrincipal.setTorneoEliminacionPrincipal(torneoEliminacion);
		                    switch (torneoEliminacion.getEstado()) {
		                        case "preparando":
		                            vista.getVentanaPrincipalAdmin().setVisible(false);
		                            vista.getVentanAvanzeTorneo().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnAvanzarFase().setVisible(false);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnCronograma().setVisible(false);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnVolver().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnIniciarTorneo().setVisible(true);
		                            
		                            break;
		                        case "iniciado":
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnAvanzarFase().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnCronograma().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnVolver().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnIniciarTorneo().setVisible(false);
		                            vista.getVentanaPrincipalAdmin().setVisible(false);
		                            vista.getVentanAvanzeTorneo().setVisible(true);
		                            break;
		                        case "Terminado":
		                            vista.mostrarMensaje("El torneo ha terminado.");
		                            break;
		                    }
		                    return;
		                }

		                // Torneo Grupos
		                TorneoGrupos torneoGrupos = directorioPrincipal.getDirectorioTorneosGrupos()
		                    .encontrarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(new TorneoGrupos(nombreTorneo, 0, "", "")));

		                if (torneoGrupos != null) {
		                    directorioPrincipal.setTorneoGruposPrincipal(torneoGrupos);
		                    switch (torneoGrupos.getEstado()) {
		                        case "preparando":
		                            vista.getVentanaPrincipalAdmin().setVisible(false);
		                            vista.getVentanAvanzeTorneo().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnAvanzarFase().setVisible(false);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnCronograma().setVisible(false);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnVolver().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnIniciarTorneo().setVisible(true);
		                            break;
		                        case "iniciado":
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnAvanzarFase().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnCronograma().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnVolver().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnIniciarTorneo().setVisible(false);
		                            vista.getVentanaPrincipalAdmin().setVisible(false);
		                            vista.getVentanAvanzeTorneo().setVisible(true);
		                            break;
		                        case "Terminado":
		                            vista.mostrarMensaje("El torneo ha terminado.");
		                            break;
		                    }
		                    return;
		                }

		                // Torneo Puntos
		                TorneoPuntos torneoPuntos = directorioPrincipal.getDirectorioTorneosPuntos()
		                    .encontrarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(new TorneoPuntos(nombreTorneo, 0, "", "")));

		                if (torneoPuntos != null) {
		                    directorioPrincipal.setTorneoPuntosPrincipal(torneoPuntos);
		                    switch (torneoPuntos.getEstado()) {
		                        case "preparando":
		                            vista.getVentanaPrincipalAdmin().setVisible(false);
		                            vista.getVentanAvanzeTorneo().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnAvanzarFase().setVisible(false);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnCronograma().setVisible(false);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnVolver().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnIniciarTorneo().setVisible(true);	
		                            break;
		                        case "iniciado":
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnAvanzarFase().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnCronograma().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnVolver().setVisible(true);
		                            vista.getVentanAvanzeTorneo().getPanelAvanceYInicioTorneo().getBtnIniciarTorneo().setVisible(false);
		                            vista.getVentanaPrincipalAdmin().setVisible(false);
		                            vista.getVentanAvanzeTorneo().setVisible(true);
		                            break;
		                        case "Terminado":
		                            vista.mostrarMensaje("El torneo ha terminado.");
		                            break;
		                    }
		                    return;
		                }

		                vista.mostrarMensaje("Torneo no encontrado.");
		            }
		        }
		    }
		}
else if(comando.equals("INICIARTORNEO")) {
			
			String nombreTorneoString = vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getListaTorneos().getSelectedValue();

			if (nombreTorneoString != null) {
			    String[] partes = nombreTorneoString.split("\\|\\|");
			    if (partes.length > 0) {
			        String[] subPartes = partes[0].split(":");
			        if (subPartes.length > 1) {
			            String nombreTorneo = subPartes[1].trim();
			            

			            // Torneo Eliminación
			            TorneoEliminacion torneoEliminacion = directorioPrincipal.getTorneoEliminacionPrincipal();
			            if (torneoEliminacion!=null) {
			                directorioPrincipal.setTorneoEliminacionPrincipal(torneoEliminacion);
			                
			                if (torneoEliminacion.getLimiteParticipantes() == torneoEliminacion.getParticipantes().size()) {
			                    directorioPrincipal.getTorneoEliminacionPrincipal().setEstado("iniciado");
			                    directorioPrincipal.getTorneoEliminacionPrincipal().generarCronograma();
			                    directorioPrincipal.getTorneoEliminacionPrincipal().actualizarEstadisticaTorneosJugados();

			                    // ACTUALIZACIÓN
			                    directorioPrincipal.getDirectorioTorneosEliminacion().actualizarTorneoEliminacion(
			                        MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(torneoEliminacion),
			                        MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(directorioPrincipal.getTorneoEliminacionPrincipal())
			                    );
			                    

			                    vista.getVentanAvanzeTorneo().setVisible(false);
			                    vista.getVentanaPrincipalAdmin().setVisible(true);
			                } else {
			                    vista.mostrarMensaje("El torneo aún no está lleno. Espere a que se llene para comenzarlo.");
			                }
			                return;
			            }

			            // Torneo Grupos
			            TorneoGrupos torneoGruposAux = new TorneoGrupos(nombreTorneo, 0, "", "");
			            TorneoGrupos torneoGrupos = directorioPrincipal.getDirectorioTorneosGrupos()
			                .encontrarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(torneoGruposAux));

			            if (torneoGrupos != null) {
			                directorioPrincipal.setTorneoGruposPrincipal(torneoGrupos);
			                
			               
			                if (torneoGrupos.getLimiteParticipantes() == torneoGrupos.getParticipantes().size()) {
			                    directorioPrincipal.getTorneoGruposPrincipal().setEstado("iniciado");
			                    directorioPrincipal.getTorneoGruposPrincipal().organizarEquipos();
			                    directorioPrincipal.getTorneoGruposPrincipal().generarCronograma();
			                    directorioPrincipal.getTorneoGruposPrincipal().actualizarEstadisticaTorneosJugados();
			                    

			                    // ACTUALIZACIÓN
			                    directorioPrincipal.getDirectorioTorneosGrupos().actualizarTorneoGrupos(
			                        MapHandler.convertirTorneoGruposATorneoGruposDTO(torneoGrupos),
			                        MapHandler.convertirTorneoGruposATorneoGruposDTO(directorioPrincipal.getTorneoGruposPrincipal())
			                    );

			                    vista.getVentanAvanzeTorneo().setVisible(false);
			                    vista.getVentanaPrincipalAdmin().setVisible(true);
			                } else {
			                    vista.mostrarMensaje("El torneo aún no está lleno. Espere a que se llene para comenzarlo.");
			                }
			                return;
			            }

			            // Torneo Puntos
			            TorneoPuntos torneoPuntosAux = new TorneoPuntos(nombreTorneo, 0, "", "");
			            TorneoPuntos torneoPuntos = directorioPrincipal.getDirectorioTorneosPuntos()
			                .encontrarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(torneoPuntosAux));

			            if (torneoPuntos != null) {
			                directorioPrincipal.setTorneoPuntosPrincipal(torneoPuntos);
			                if (torneoPuntos.getLimiteParticipantes() == torneoPuntos.getParticipantes().size()) {
			                    directorioPrincipal.getTorneoPuntosPrincipal().setEstado("iniciado");
			                    directorioPrincipal.getTorneoPuntosPrincipal().generarCronogramaPorPuntos();
			                    directorioPrincipal.getTorneoEliminacionPrincipal().actualizarEstadisticaTorneosJugados();

			                    // ACTUALIZACIÓN
			                    directorioPrincipal.getDirectorioTorneosPuntos().actualizarTorneoPuntos(
			                        MapHandler.convertirTorneoPuntosATorneoPuntosDTO(torneoPuntos),
			                        MapHandler.convertirTorneoPuntosATorneoPuntosDTO(directorioPrincipal.getTorneoPuntosPrincipal())
			                    );

			                    vista.getVentanAvanzeTorneo().setVisible(false);
			                    vista.getVentanaPrincipalAdmin().setVisible(true);
			                } else {
			                    vista.mostrarMensaje("El torneo aún no está lleno. Espere a que se llene para comenzarlo.");
			                }
			                return;
			            }

			            vista.mostrarMensaje("Torneo no encontrado.");
			        }
			    }
			}


			
			
			
		}else if (comando.equals("VOLVERAPRINCIPALADMINDEINICIOYAVACETORNEO")) {
			
			vista.getVentanAvanzeTorneo().setVisible(false);
			vista.getVentanaPrincipalAdmin().setVisible(true);
			
			
			
		}else if(comando.equals("CRONOGRAMAADMIN")) {
			
			
            String nombreTorneoString = vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getListaTorneos().getSelectedValue();

            if (nombreTorneoString != null) {
                String[] partes = nombreTorneoString.split("\\|\\|");
                if (partes.length > 0) {
                    String[] subPartes = partes[0].split(":");
                    if (subPartes.length > 1) {
                        String nombreTorneo = subPartes[1].trim();

                        vista.getVentanAvanzeTorneo().setVisible(false);
                        

                        // Torneo Eliminación
                        TorneoEliminacion torneoEliminacion = directorioPrincipal.getDirectorioTorneosEliminacion()
                            .encontrarTorneoEliminacion(MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(new TorneoEliminacion(nombreTorneo, 0, "", "")));

                        if (torneoEliminacion != null) {
                            
                            vista.getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(directorioPrincipal.getTorneoEliminacionPrincipal().getCronograma());
                            vista.getVentanaCronograma().setVisible(true);
                            return;
                        }

                        // Torneo Grupos
                        TorneoGrupos torneoGrupos = directorioPrincipal.getDirectorioTorneosGrupos()
                            .encontrarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(new TorneoGrupos(nombreTorneo, 0, "", "")));

                        if (torneoGrupos != null) {
                            directorioPrincipal.setTorneoGruposPrincipal(torneoGrupos);
                            vista.getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(torneoGrupos.getCronograma());
                            vista.getVentanaCronograma().setVisible(true);
                            return;
                        }

                        // Torneo Puntos
                        TorneoPuntos torneoPuntos = directorioPrincipal.getDirectorioTorneosPuntos()
                            .encontrarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(new TorneoPuntos(nombreTorneo, 0, "", "")));

                        if (torneoPuntos != null) {
                            directorioPrincipal.setTorneoPuntosPrincipal(torneoPuntos);
                            vista.getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(torneoPuntos.getCronograma());
                            vista.getVentanaCronograma().setVisible(true);
                            return;
                        }

                        vista.mostrarMensaje("Torneo no encontrado.");
                    }
                }
            }

			
		}else if (comando.equals("VOLVERAVISTAADMINDECRONOGRAMAADMIN")) {
			
			
			vista.getVentanaCronograma().setVisible(false);
			vista.getVentanaPrincipalAdmin().setVisible(true);
			directorioPrincipal.getAdministradorPrincipal();
		}else if (comando.equals("AVANZARFASE")) {
			
			
			
			
			String nombreTorneoString = vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().getListaTorneos().getSelectedValue();

			if (nombreTorneoString != null) {
			    String[] partes = nombreTorneoString.split("\\|\\|");
			    if (partes.length > 0) {
			        String[] subPartes = partes[0].split(":");
			        if (subPartes.length > 1) {
			            String nombreTorneo = subPartes[1].trim();

			           

			            // Torneo Eliminación
			            TorneoEliminacion torneoEliminacion = directorioPrincipal.getDirectorioTorneosEliminacion()
			                .encontrarTorneoEliminacion(MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(new TorneoEliminacion(nombreTorneo, 0, "", "")));

			            if (torneoEliminacion != null) {
			                torneoEliminacion.avanzarFase();
			                actualizarJugadores(torneoEliminacion.getParticipantes(), torneoEliminacion.getEliminados());
			                
			                directorioPrincipal.getDirectorioTorneosEliminacion().actualizarTorneoEliminacion(
			                    MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(torneoEliminacion),
			                    MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(torneoEliminacion)
			                    
			                );
			                vista.getVentanAvanzeTorneo().setVisible(false);
			                vista.getVentanaPrincipalAdmin().setVisible(true);
			                vista.mostrarMensaje("Fase del Torneo Eliminación avanzada con éxito.");
			                return;
			            }

			            // Torneo Grupos
			            TorneoGrupos torneoGrupos = directorioPrincipal.getDirectorioTorneosGrupos()
			                .encontrarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(new TorneoGrupos(nombreTorneo, 0, "", "")));

			            if (torneoGrupos != null) {
			                if (torneoGrupos.getFase() == 1) {
			                    torneoGrupos.avanzarAFase2();
			                    vista.mostrarMensaje("Fase 1 del Torneo Grupos avanzada a Fase 2.");

				                vista.getVentanAvanzeTorneo().setVisible(false);
				                vista.getVentanaPrincipalAdmin().setVisible(true);
			                } else if (torneoGrupos.getFase() == 2) {
			                    torneoGrupos.elegirGanadorFinal();
			                    vista.mostrarMensaje("Fase 2 del Torneo Grupos completada. Ganador seleccionado.");

				                vista.getVentanAvanzeTorneo().setVisible(false);
				                vista.getVentanaPrincipalAdmin().setVisible(true);
			                }

			                actualizarJugadores(torneoGrupos.getParticipantes(), torneoGrupos.getEliminados());
			                
			                directorioPrincipal.getDirectorioTorneosGrupos().actualizarTorneoGrupos(
			                    MapHandler.convertirTorneoGruposATorneoGruposDTO(torneoGrupos),
			                    MapHandler.convertirTorneoGruposATorneoGruposDTO(torneoGrupos)
			                );
			                return;
			            }

			            // Torneo Puntos
			            TorneoPuntos torneoPuntos = directorioPrincipal.getDirectorioTorneosPuntos()
			                .encontrarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(new TorneoPuntos(nombreTorneo, 0, "", "")));

			            if (torneoPuntos != null) {
			                actualizarJugadores(torneoPuntos.getParticipantes());
			                
			                directorioPrincipal.getDirectorioTorneosPuntos().actualizarTorneoPuntos(
			                    MapHandler.convertirTorneoPuntosATorneoPuntosDTO(torneoPuntos),
			                    MapHandler.convertirTorneoPuntosATorneoPuntosDTO(torneoPuntos)
			                );

			                vista.getVentanAvanzeTorneo().setVisible(false);
			                vista.getVentanaPrincipalAdmin().setVisible(true);
			                vista.mostrarMensaje("Fase del Torneo Puntos avanzada con éxito.");
			                return;
			            }

			            vista.mostrarMensaje("Torneo no encontrado.");
			        }
			    }
			}
		} else if (comando.equals("VERTORNEO")) {

			String nombreTorneoString = vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().getListaTorneosParticipa().getSelectedValue();

			if (nombreTorneoString != null) {
			    String[] partes = nombreTorneoString.split("\\|\\|");
			    if (partes.length > 0) {
			        String[] subPartes = partes[0].split(":");
			        if (subPartes.length > 1) {
			            String nombreTorneo = subPartes[1].trim();

			            // Buscar en todos los directorios de torneos
			            TorneoEliminacion torneoEliminacion = directorioPrincipal.getDirectorioTorneosEliminacion()
			                .encontrarTorneoEliminacion(MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(
			                    new TorneoEliminacion(nombreTorneo, 0, "", "")));

			            TorneoGrupos torneoGrupos = directorioPrincipal.getDirectorioTorneosGrupos()
			                .encontrarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(
			                    new TorneoGrupos(nombreTorneo, 0, "", "")));

			            TorneoPuntos torneoPuntos = directorioPrincipal.getDirectorioTorneosPuntos()
			                .encontrarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(
			                    new TorneoPuntos(nombreTorneo, 0, "", "")));

			            if (torneoEliminacion != null) {
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarNombre(torneoEliminacion.getNombre());
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarParticipantesRestantes(torneoEliminacion.getParticipantes().size());
			                
			                // Obtener cantidad de eliminados del HashMap de eliminados
			                int cantidadEliminados = torneoEliminacion.getEliminados().size();
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarEliminados(cantidadEliminados);
			                
			                ArrayList<String> usuariosParticipantes = directorioPrincipal.obtenerUsuarios(torneoEliminacion.getParticipantes());
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarParticipantesRestantesList(usuariosParticipantes);

			            } else if (torneoGrupos != null) {
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarNombre(torneoGrupos.getNombre());
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarParticipantesRestantes(torneoGrupos.getParticipantes().size());
			                
			                // Obtener cantidad de eliminados del HashMap de eliminados
			                int cantidadEliminados = torneoGrupos.getEliminados().size();
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarEliminados(cantidadEliminados);

			                ArrayList<String> usuariosParticipantes = directorioPrincipal.obtenerUsuarios(torneoGrupos.getParticipantes());
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarParticipantesRestantesList(usuariosParticipantes);

			            } else if (torneoPuntos != null) {
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarNombre(torneoPuntos.getNombre());
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarParticipantesRestantes(torneoPuntos.getParticipantes().size());
			                
			                // No hay eliminados en Torneo Puntos, se deja el método sin actualización.
			                ArrayList<String> usuariosParticipantes = directorioPrincipal.obtenerUsuarios(torneoPuntos.getParticipantes());
			                vista.getVentanaDatosTorneo().getPanelDatosTorneo().actualizarParticipantesRestantesList(usuariosParticipantes);

			            } else {
			                vista.mostrarMensaje("Torneo no encontrado.");
			                return;
			            }

			            vista.getVentanaPrincipalJugador().setVisible(false);
			            vista.getVentanaDatosTorneo().setVisible(true);
			        }
			    }
			}



			
			
			
		}else if(comando.equals("VOLVERAPRINCIPALJUGADORDEDATOSTORNEO")) {
			
			
			vista.getVentanaDatosTorneo().setVisible(false);
			vista.getVentanaPrincipalJugador().setVisible(true);
			
			
		}else if(comando.equals("CRONOGRAMAJUGADOR")) {
			
			
			String nombreTorneoString = vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().getListaTorneosParticipa().getSelectedValue();

			if (nombreTorneoString != null) {
			    String[] partes = nombreTorneoString.split("\\|\\|");
			    if (partes.length > 0) {
			        String[] subPartes = partes[0].split(":");
			        if (subPartes.length > 1) {
			            String nombreTorneo = subPartes[1].trim();

			            vista.getVentanAvanzeTorneo().setVisible(false);

			            // Torneo Eliminación
			            TorneoEliminacion torneoEliminacion = directorioPrincipal.getDirectorioTorneosEliminacion()
			                .encontrarTorneoEliminacion(MapHandler.convertirTorneoEliminacionATorneoEliminacionDTO(new TorneoEliminacion(nombreTorneo, 0, "", "")));

			            if (torneoEliminacion != null) {
			            	
			                if (torneoEliminacion.getEstado().equalsIgnoreCase("preparando")) {
			                    vista.mostrarMensaje("Aún no hay cronograma.");
			                    return;
			                }
			                vista.getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(torneoEliminacion.getCronograma());
			                vista.getVentanaCronograma().setVisible(true);
			                return;
			            }

			            // Torneo Grupos
			            TorneoGrupos torneoGrupos = directorioPrincipal.getDirectorioTorneosGrupos()
			                .encontrarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(new TorneoGrupos(nombreTorneo, 0, "", "")));

			            if (torneoGrupos != null) {
			                if (torneoGrupos.getEstado().equalsIgnoreCase("preparando")) {
			                    vista.mostrarMensaje("Aún no hay cronograma.");
			                    return;
			                }
			                directorioPrincipal.setTorneoGruposPrincipal(torneoGrupos);
			                vista.getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(torneoGrupos.getCronograma());
			                vista.getVentanaCronograma().setVisible(true);
			                return;
			            }

			            // Torneo Puntos
			            TorneoPuntos torneoPuntos = directorioPrincipal.getDirectorioTorneosPuntos()
			                .encontrarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(new TorneoPuntos(nombreTorneo, 0, "", "")));

			            if (torneoPuntos != null) {
			                if (torneoPuntos.getEstado().equalsIgnoreCase("preparando")) {
			                    vista.mostrarMensaje("Aún no hay cronograma.");
			                    return;
			                }
			                directorioPrincipal.setTorneoPuntosPrincipal(torneoPuntos);
			                vista.getVentanaCronograma().getPanelCronograma().actualizarCronogramaGeneral(torneoPuntos.getCronograma());
			                vista.getVentanaCronograma().setVisible(true);
			                return;
			            }

			            vista.mostrarMensaje("Torneo no encontrado.");
			        }
			    }
			}
		}else if(comando.equals("UNIRSEAEQUIPO")) {
			
			
			String nombreEquipo = vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().getListaEquiposDisponibles().getSelectedValue();

			if (nombreEquipo != null) {
			    Equipo equipoAux = new Equipo(nombreEquipo, null);
			    Equipo equipo = directorioPrincipal.getDirectorioEquipos().encontrarEquipo(MapHandler.convertirEquipoAEquipoDTO(equipoAux));

			    if (equipo == null) {
			        vista.mostrarMensaje("Equipo no encontrado.");
			        return;
			    }

			    Entrenador entrenadorPrincipal = directorioPrincipal.getEntrenadorPrincipal();
			    String usuarioEntrenador = entrenadorPrincipal.getUsuario();

			    // Verificar si el entrenador ya está en el equipo
			    if ((equipo.getEntrenador1() != null && equipo.getEntrenador1().getUsuario().equals(usuarioEntrenador)) ||
			        (equipo.getEntrenador2() != null && equipo.getEntrenador2().getUsuario().equals(usuarioEntrenador)) ||
			        (equipo.getEntrenador3() != null && equipo.getEntrenador3().getUsuario().equals(usuarioEntrenador))) {

			        vista.mostrarMensaje("El entrenador ya está asignado a este equipo.");
			        return;
			    }

			    if (equipo.getEntrenador2() == null) {
			        equipo.setEntrenador2(entrenadorPrincipal);
			        actualizarListaEquiposQueEntrena(entrenadorPrincipal);
			    } else if (equipo.getEntrenador3() == null) {
			        equipo.setEntrenador3(entrenadorPrincipal);
			        actualizarListaEquiposQueEntrena(entrenadorPrincipal);
			    } else {
			        vista.mostrarMensaje("El equipo ya tiene 3 entrenadores.");
			        return;
			    }

			    // Actualizar el equipo en el directorio
			    directorioPrincipal.getDirectorioEquipos().actualizarEquipo(
			        MapHandler.convertirEquipoAEquipoDTO(equipo),
			        MapHandler.convertirEquipoAEquipoDTO(equipo)
			    );

			    vista.mostrarMensaje("Entrenador asignado al equipo " + nombreEquipo + " con éxito.");
			}


			
		}else if(comando.equals("VOLVERAPRINCIPALENTRENADORDECREARQUIPO")) {
			
			
			
			vista.getVentanaCrearEquipo().setVisible(false);
			vista.getVentanaPrincipalEntrenador().setVisible(true);
			
			
			
			
		}else if(comando.equals("CREACIONEQUIPO")) {
			
			vista.getVentanaPrincipalEntrenador().setVisible(false);
			vista.getVentanaCrearEquipo().setVisible(true);
			
			
		}else if(comando.equals("CREAREQUIPO")) {
			
			String nombreEquipo = vista.getVentanaCrearEquipo().getPanelCrearEquipo().getTxtNombreEquipo().getText();

			if (nombreEquipo.isEmpty()) {
			    vista.mostrarMensaje("El nombre del equipo no puede estar vacío.");
			    return;
			}

			
			Equipo equipoExistente = directorioPrincipal.getDirectorioEquipos().encontrarEquipo(
			        MapHandler.convertirEquipoAEquipoDTO(new Equipo(nombreEquipo, null))
			);

			if (equipoExistente != null) {
			    vista.mostrarMensaje("Ya existe un equipo con ese nombre.");
			    return;
			}

			
			Equipo equipoNuevo = new Equipo(nombreEquipo, directorioPrincipal.getEntrenadorPrincipal());

			
			directorioPrincipal.getDirectorioEquipos().adicionarEquipo(MapHandler.convertirEquipoAEquipoDTO(equipoNuevo));

			
			vista.mostrarMensaje("Equipo " + nombreEquipo + " registrado con éxito.");

			
			vista.getVentanaCrearEquipo().setVisible(false);
			vista.getVentanaPrincipalEntrenador().setVisible(true);
			actualizarListaEquiposDisponibles();

			
			
		}else if (comando.equals("ELEGIREQUIPO")) {
			
			String seleccion = vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().getListaEquiposEntrenados().getSelectedValue();

			if (seleccion != null) {
			    // Eliminar "Nombre del Equipo:" y los espacios
			    String nombreEquipo = seleccion.replace("Nombre del Equipo:", "").trim();

			    // Crear un equipo auxiliar con el nombre obtenido
			    Equipo equipoAux = new Equipo(nombreEquipo, null);

			    // Buscar el equipo en el directorio
			    Equipo equipo = directorioPrincipal.getDirectorioEquipos().encontrarEquipo(MapHandler.convertirEquipoAEquipoDTO(equipoAux));

			    if (equipo != null) {
			    	
			    	
			    ArrayList<String>  jugadoresString  =directorioPrincipal.obtenerUsuarios(equipo.getEquipo());
			    	
			        vista.getVentanaListaEquipos().getPanelListaEquipos().actualizarLista(jugadoresString);
			        
			        vista.getVentanaPrincipalEntrenador().setVisible(false);
			        vista.getVentanaListaEquipos().setVisible(true);
			        
			    } else {
			        vista.mostrarMensaje("Equipo no encontrado.");
			    }
			} else {
			    vista.mostrarMensaje("No se ha seleccionado ningún equipo.");
			}

			
			
		}else if(comando.equals("VOLVERAPRINCIPALENTRENADORDELISTAEQUIPOS")) {
			
			
			vista.getVentanaListaEquipos().setVisible(false);
			vista.getVentanaPrincipalEntrenador().setVisible(true);
			
			
		}






			
			
			
			
		}
		
		
		
		
		
		

	
	/**
	 * Actualiza la lista de equipos que entrena el entrenador especificado.  
	 * Recorre todos los equipos registrados y verifica si el entrenador es asignado como `entrenador1`, `entrenador2` o `entrenador3`.  
	 * Solo se validan aquellos entrenadores que no sean `null`.
	 * 
	 * @param entrenador El entrenador del que se quiere obtener la lista de equipos que entrena.
	 */
	public void actualizarListaEquiposQueEntrena(Entrenador entrenador) {
	    ArrayList<String> equiposQueEntrenaString = new ArrayList<>();
	    ArrayList<Equipo> equipos = directorioPrincipal.getDirectorioEquipos().obtenerEquipos();

	    for (Equipo equipo : equipos) {
	        String usuarioEntrenador1Aux = equipo.getEntrenador1() != null ? equipo.getEntrenador1().getUsuario() : "";
	        String usuarioEntrenador2Aux = equipo.getEntrenador2() != null ? equipo.getEntrenador2().getUsuario() : "";
	        String usuarioEntrenador3Aux = equipo.getEntrenador3() != null ? equipo.getEntrenador3().getUsuario() : "";

	        if (entrenador.getUsuario().equals(usuarioEntrenador1Aux) || 
	            (!usuarioEntrenador2Aux.isEmpty() && entrenador.getUsuario().equals(usuarioEntrenador2Aux)) || 
	            (!usuarioEntrenador3Aux.isEmpty() && entrenador.getUsuario().equals(usuarioEntrenador3Aux))) {
	            
	            equiposQueEntrenaString.add(equipo.toString());
	        }
	    }

	    vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().llenarListaEquiposEntrenados(equiposQueEntrenaString);
	}
	public void actualizarListaTorneosEnLosQueParticipa() {
	    Jugador jugadorPrincipal = directorioPrincipal.getJugadorPrincipal();
	    ArrayList<String> torneosEnLosQueParticipa = new ArrayList<>();

	    // ------------------------------
	    // TORNEOS DE ELIMINACIÓN
	    // ------------------------------
	    ArrayList<TorneoEliminacion> torneosEliminacion = directorioPrincipal.getDirectorioTorneosEliminacion().obtenerTorneosEliminacio();
	    for (TorneoEliminacion torneo : torneosEliminacion) {
	        for (Jugador jugador : torneo.getParticipantes()) {
	            if (jugador.getUsuario().equals(jugadorPrincipal.getUsuario())) {
	                torneosEnLosQueParticipa.add(torneo.toString());
	                break;
	            }
	        }
	    }

	    // ------------------------------
	    // TORNEOS DE GRUPOS
	    // ------------------------------
	    ArrayList<TorneoGrupos> torneosGrupos = directorioPrincipal.getDirectorioTorneosGrupos().obtenerTorneosGrupos();
	    for (TorneoGrupos torneo : torneosGrupos) {
	        for (Jugador jugador : torneo.getParticipantes()) {
	            if (jugador.getUsuario().equals(jugadorPrincipal.getUsuario())) {
	                torneosEnLosQueParticipa.add(torneo.toString());
	                break;
	            }
	        }
	    }

	    // ------------------------------
	    // TORNEOS DE PUNTOS
	    // ------------------------------
	    ArrayList<TorneoPuntos> torneosPuntos = directorioPrincipal.getDirectorioTorneosPuntos().obtenerTorneosPuntos();
	    for (TorneoPuntos torneo : torneosPuntos) {
	        for (Jugador jugador : torneo.getParticipantes()) {
	            if (jugador.getUsuario().equals(jugadorPrincipal.getUsuario())) {
	                torneosEnLosQueParticipa.add(torneo.toString());
	                break;
	            }
	        }
	    }

	    vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().llenarListaTorneosParticipa(torneosEnLosQueParticipa);
	}


	public void actualizarListaTorneosActivos() {
		
		vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().llenarListaTorneosActivos(directorioPrincipal.convertirTorneosAStrings());
		
	}
	public void actualizarListaTorneosAdmin() {
		vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().llenarListaTorneos(directorioPrincipal.convertirTorneosAStrings());
		
	}
	public void actualizarListaEquiposDisponibles() {
		
		
		vista.getVentanaPrincipalEntrenador().getPanelPrincipalEntrenador().llenarListaEquiposDisponibles(directorioPrincipal.getDirectorioEquipos().convertirEquiposAStrings());
	}
	/**
	 * Valida si el nombre de un torneo ya existe en los torneos de eliminación, puntos o grupos.  
	 * Si el nombre ya existe en alguno de los torneos, muestra un mensaje y retorna `false`.  
	 * 
	 * @param nombreTorneo El nombre del torneo a verificar.
	 * @return `true` si el nombre del torneo no existe, `false` si ya está registrado.
	 */
	public Boolean validarNombreTorneo(String nombreTorneo) {

	    ArrayList<TorneoEliminacion> torneosEliminacion = directorioPrincipal.getDirectorioTorneosEliminacion().obtenerTorneosEliminacio();
	    ArrayList<TorneoPuntos> torneosPuntos = directorioPrincipal.getDirectorioTorneosPuntos().obtenerTorneosPuntos();
	    ArrayList<TorneoGrupos> torneosGrupos = directorioPrincipal.getDirectorioTorneosGrupos().obtenerTorneosGrupos();

	    for (TorneoEliminacion torneoEliminacion : torneosEliminacion) {
	        if (torneoEliminacion.getNombre().equals(nombreTorneo)) {
	            vista.mostrarMensaje("Nombre de torneo ya registrado, utiliza otro");
	            return false;
	        }
	    }

	    for (TorneoPuntos torneoPuntos : torneosPuntos) {
	        if (torneoPuntos.getNombre().equals(nombreTorneo)) {
	            vista.mostrarMensaje("Nombre de torneo ya registrado, utiliza otro");
	            return false;
	        }
	    }

	    for (TorneoGrupos torneoGrupos : torneosGrupos) {
	        if (torneoGrupos.getNombre().equals(nombreTorneo)) {
	            vista.mostrarMensaje("Nombre de torneo ya registrado, utiliza otro");
	            return false;
	        }
	    }

	    return true;
	}

	
	
	

	public void actualizarComboBoxRegistroJugador() {

		ArrayList<String> stringsEquipos = directorioPrincipal.getDirectorioEquipos().convertirEquiposAStrings();
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
	
	private void actualizarJugadores(ArrayList<Jugador> participantes) {
	    for (Jugador jugador : participantes) {
	        directorioPrincipal.getDirectorioJugadores().actualizarJugador(
	            MapHandler.convertirJugadorAJugadorDTO(jugador),
	            MapHandler.convertirJugadorAJugadorDTO(jugador)
	        );
	    }
	}

	private void actualizarJugadores(ArrayList<Jugador> participantes, HashMap<Jugador, Boolean> eliminados) {
	    actualizarJugadores(participantes);

	    for (Map.Entry<Jugador, Boolean> entrada : eliminados.entrySet()) {
	        Jugador jugador = entrada.getKey();
	        directorioPrincipal.getDirectorioJugadores().actualizarJugador(
	            MapHandler.convertirJugadorAJugadorDTO(jugador),
	            MapHandler.convertirJugadorAJugadorDTO(jugador)
	        );
	    }
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

    