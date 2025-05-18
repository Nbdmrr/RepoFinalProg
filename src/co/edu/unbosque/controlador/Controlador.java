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

    /**
     * Constructor de la clase Controlador.
     * Inicializa la vista, el directorio principal y asigna los oyentes a los componentes de la vista.
     * Carga los datos de los archivos de persistencia y actualiza los componentes de la vista.
     */
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
    /**
     * Asigna los oyentes a los componentes de la vista para manejar los eventos de acción.
     */
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
    }

    /**
     * Método que se ejecuta cuando se produce un evento de acción.
     * @param e El evento de acción.
     */
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
            
            vista.mostrarMensaje("Jugador registrado con exito");
            
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
            
            vista.mostrarMensaje("Entrenador registrado con exito");

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
                    actualizarListaEquiposQueEntrena(entrenadorPrincipal);
                    
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
                
                

            }else if (tipoTorneo.equals("Grupos")) {
                
                TorneoGrupos nuevoTorneoGrupos = new TorneoGrupos(nombreTorneo, limiteParticipantes, tipoTorneo, juego);
                
                directorioPrincipal.getDirectorioTorneosGrupos().adicionarTorneoGrupos(MapHandler.convertirTorneoGruposATorneoGruposDTO(nuevoTorneoGrupos));
                
                vista.mostrarMensaje("Torneo por Grupos Agregador Correctamente");
                actualizarListaTorneosActivos();
                actualizarListaTorneosAdmin();
                vista.getVentanaCrearTorneo().setVisible(false);
                vista.getVentanaPrincipalAdmin().setVisible(true);
                
                
            }else if(tipoTorneo.equals("Puntos")) {
                
                
                
                TorneoPuntos nuevoTorneoPuntos = new TorneoPuntos(nombreTorneo, limiteParticipantes, tipoTorneo, juego);
                
                directorioPrincipal.getDirectorioTorneosPuntos().adicionarTorneoPuntos(MapHandler.convertirTorneoPuntosATorneoPuntosDTO(nuevoTorneoPuntos));
                
                vista.mostrarMensaje("Torneo por Puntos Agregador Correctamente");
                actualizarListaTorneosAdmin();
                actualizarListaTorneosActivos();
                vista.getVentanaCrearTorneo().setVisible(false);
                vista.getVentanaPrincipalAdmin().setVisible(true);
                
                
                
            }
            
            
        }else if(comando.equals("VOLVERAINICIOSESIONDEPRINCIPALADMIN")) {
            
            vista.getVentanaPrincipalAdmin().setVisible(false);
            vista.getVentanaInicioSesion().setVisible(true);
            
            
        }else if(comando.equals("UNIRSEATORNEO")) {
            
            
            String torneoAlQueEntra=vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().getListaTorneosActivos().getSelectedValue();
            
            
            
            
            
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

    /**
     * Actualiza la lista de torneos activos en la vista del jugador.
     */
    public void actualizarListaTorneosActivos() {
        
        vista.getVentanaPrincipalJugador().getPanelPrincipalJugador().llenarListaTorneosActivos(directorioPrincipal.convertirTorneosAStrings());
        
    }
    /**
     * Actualiza la lista de torneos en la vista del administrador.
     */
    public void actualizarListaTorneosAdmin() {
        vista.getVentanaPrincipalAdmin().getPanelPrincipalAdmin().llenarListaTorneos(directorioPrincipal.convertirTorneosAStrings());
        
    }
    /**
     * Actualiza la lista de equipos disponibles en la vista del entrenador.
     */
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

    
    
    
    /**
     * Actualiza el combo box de equipos en la ventana de registro de jugador.
     */
    public void actualizarComboBoxRegistroJugador() {

        ArrayList<String> stringsEquipos = directorioPrincipal.getDirectorioEquipos().convertirEquiposAStrings();
        vista.getVentanaRegistroJugador().getPanelRegistroJugador().setEquipos(stringsEquipos);
    }
    /**
     * Valida si el nombre de usuario ya existe en los registros de jugadores, administradores o entrenadores.
     * @param usuario El nombre de usuario a validar.
     * @return true si el nombre de usuario no existe, false si ya está registrado.
     */
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

    /**
     * Obtiene la vista actual.
     * @return La vista actual.
     */
    public Vista getVista() {
        return vista;
    }

    /**
     * Establece la vista.
     * @param vista La nueva vista.
     */
    public void setVista(Vista vista) {
        this.vista = vista;
    }

    /**
     * Obtiene el directorio principal.
     * @return El directorio principal.
     */
    public DirectorioPrincipal getDirectorioPrincipal() {
        return directorioPrincipal;
    }

    /**
     * Establece el directorio principal.
     * @param directorioPrincipal El nuevo directorio principal.
     */
    public void setDirectorioPrincipal(DirectorioPrincipal directorioPrincipal) {
        this.directorioPrincipal = directorioPrincipal;
    }
}