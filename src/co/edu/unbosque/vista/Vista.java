package co.edu.unbosque.vista;

import javax.swing.JOptionPane;

/**
 * Clase Vista que contiene y administra las diferentes ventanas de la aplicación.
 * Esta clase actúa como un contenedor para las vistas y provee métodos getter y setter
 * para acceder y modificar dichas ventanas.
 */
public class Vista {

    /** Ventana que muestra el avance y el inicio del torneo */
    private VentanaAvanzeYInicioTorneo ventanaAvanzeTorneo;
    
    /** Ventana para crear equipos */
    private VentanaCrearEquipo ventanaCrearEquipo;
    
    /** Ventana para crear torneos */
    private VentanaCrearTorneo ventanaCrearTorneo;
    
    /** Ventana que muestra el cronograma del torneo */
    private VentanaCronograma ventanaCronograma;
    
    /** Ventana que muestra los datos del torneo */
    private VentanaDatosTorneo ventanaDatosTorneo;
    
    /** Ventana para el inicio de sesión */
    private VentanaInicioSesion ventanaInicioSesion;
    
    /** Ventana principal para usuarios con rol administrador */
    private VentanaPrincipalAdmin ventanaPrincipalAdmin;
    
    /** Ventana principal para usuarios con rol entrenador */
    private VentanaPrincipalEntrenador ventanaPrincipalEntrenador;
    
    /** Ventana principal para usuarios con rol jugador */
    private VentanaPrincipalJugador ventanaPrincipalJugador;
    
    /** Ventana para el registro de administradores */
    private VentanaRegistroAdmin ventanaRegistroAdmin;
    
    /** Ventana para el registro de entrenadores */
    private VentanaRegistroEntrenador ventanaRegistroEntrenador;
    
    /** Ventana para el registro de jugadores */
    private VentanaRegistroJugador ventanaRegistroJugador;
    
    /** Ventana que lista los equipos */
    private VentanaListaEquipos ventanaListaEquipos;

    /**
     * Constructor que inicializa todas las ventanas de la aplicación.
     */
    public Vista() {
        this.ventanaAvanzeTorneo = new VentanaAvanzeYInicioTorneo();
        this.ventanaCrearEquipo = new VentanaCrearEquipo();
        this.ventanaCrearTorneo = new VentanaCrearTorneo();
        this.ventanaCronograma = new VentanaCronograma();
        this.ventanaDatosTorneo = new VentanaDatosTorneo();
        this.ventanaInicioSesion = new VentanaInicioSesion();
        this.ventanaPrincipalAdmin = new VentanaPrincipalAdmin();
        this.ventanaPrincipalEntrenador = new VentanaPrincipalEntrenador();
        this.ventanaPrincipalJugador = new VentanaPrincipalJugador();
        this.ventanaRegistroAdmin = new VentanaRegistroAdmin();
        this.ventanaRegistroEntrenador = new VentanaRegistroEntrenador();
        this.ventanaRegistroJugador = new VentanaRegistroJugador();
        this.setVentanaListaEquipos(new VentanaListaEquipos());
    }

    /**
     * Obtiene la ventana de registro de jugador.
     * @return ventanaRegistroJugador la ventana de registro de jugador.
     */
    public VentanaRegistroJugador getVentanaRegistroJugador() {
        return ventanaRegistroJugador;
    }

    /**
     * Establece la ventana de registro de jugador.
     * @param ventanaRegistroJugador la ventana de registro de jugador a establecer.
     */
    public void setVentanaRegistroJugador(VentanaRegistroJugador ventanaRegistroJugador) {
        this.ventanaRegistroJugador = ventanaRegistroJugador;
    }

    /**
     * Obtiene la ventana de registro de entrenador.
     * @return ventanaRegistroEntrenador la ventana de registro de entrenador.
     */
    public VentanaRegistroEntrenador getVentanaRegistroEntrenador() {
        return ventanaRegistroEntrenador;
    }

    /**
     * Establece la ventana de registro de entrenador.
     * @param ventanaRegistroEntrenador la ventana de registro de entrenador a establecer.
     */
    public void setVentanaRegistroEntrenador(VentanaRegistroEntrenador ventanaRegistroEntrenador) {
        this.ventanaRegistroEntrenador = ventanaRegistroEntrenador;
    }

    /**
     * Obtiene la ventana de registro de administrador.
     * @return ventanaRegistroAdmin la ventana de registro de administrador.
     */
    public VentanaRegistroAdmin getVentanaRegistroAdmin() {
        return ventanaRegistroAdmin;
    }

    /**
     * Establece la ventana de registro de administrador.
     * @param ventanaRegistroAdmin la ventana de registro de administrador a establecer.
     */
    public void setVentanaRegistroAdmin(VentanaRegistroAdmin ventanaRegistroAdmin) {
        this.ventanaRegistroAdmin = ventanaRegistroAdmin;
    }

    /**
     * Obtiene la ventana principal para jugadores.
     * @return ventanaPrincipalJugador la ventana principal de jugador.
     */
    public VentanaPrincipalJugador getVentanaPrincipalJugador() {
        return ventanaPrincipalJugador;
    }

    /**
     * Establece la ventana principal para jugadores.
     * @param ventanaPrincipalJugador la ventana principal de jugador a establecer.
     */
    public void setVentanaPrincipalJugador(VentanaPrincipalJugador ventanaPrincipalJugador) {
        this.ventanaPrincipalJugador = ventanaPrincipalJugador;
    }

    /**
     * Obtiene la ventana principal para entrenadores.
     * @return ventanaPrincipalEntrenador la ventana principal de entrenador.
     */
    public VentanaPrincipalEntrenador getVentanaPrincipalEntrenador() {
        return ventanaPrincipalEntrenador;
    }

    /**
     * Establece la ventana principal para entrenadores.
     * @param ventanaPrincipalEntrenador la ventana principal de entrenador a establecer.
     */
    public void setVentanaPrincipalEntrenador(VentanaPrincipalEntrenador ventanaPrincipalEntrenador) {
        this.ventanaPrincipalEntrenador = ventanaPrincipalEntrenador;
    }

    /**
     * Obtiene la ventana principal para administradores.
     * @return ventanaPrincipalAdmin la ventana principal de administrador.
     */
    public VentanaPrincipalAdmin getVentanaPrincipalAdmin() {
        return ventanaPrincipalAdmin;
    }

    /**
     * Establece la ventana principal para administradores.
     * @param ventanaPrincipalAdmin la ventana principal de administrador a establecer.
     */
    public void setVentanaPrincipalAdmin(VentanaPrincipalAdmin ventanaPrincipalAdmin) {
        this.ventanaPrincipalAdmin = ventanaPrincipalAdmin;
    }

    /**
     * Obtiene la ventana de inicio de sesión.
     * @return ventanaInicioSesion la ventana de inicio de sesión.
     */
    public VentanaInicioSesion getVentanaInicioSesion() {
        return ventanaInicioSesion;
    }

    /**
     * Establece la ventana de inicio de sesión.
     * @param ventanaInicioSesion la ventana de inicio de sesión a establecer.
     */
    public void setVentanaInicioSesion(VentanaInicioSesion ventanaInicioSesion) {
        this.ventanaInicioSesion = ventanaInicioSesion;
    }

    /**
     * Obtiene la ventana con los datos del torneo.
     * @return ventanaDatosTorneo la ventana de datos del torneo.
     */
    public VentanaDatosTorneo getVentanaDatosTorneo() {
        return ventanaDatosTorneo;
    }

    /**
     * Establece la ventana con los datos del torneo.
     * @param ventanaDatosTorneo la ventana de datos del torneo a establecer.
     */
    public void setVentanaDatosTorneo(VentanaDatosTorneo ventanaDatosTorneo) {
        this.ventanaDatosTorneo = ventanaDatosTorneo;
    }

    /**
     * Obtiene la ventana del cronograma del torneo.
     * @return ventanaCronograma la ventana de cronograma.
     */
    public VentanaCronograma getVentanaCronograma() {
        return ventanaCronograma;
    }

    /**
     * Establece la ventana del cronograma del torneo.
     * @param ventanaCronograma la ventana de cronograma a establecer.
     */
    public void setVentanaCronograma(VentanaCronograma ventanaCronograma) {
        this.ventanaCronograma = ventanaCronograma;
    }

    /**
     * Obtiene la ventana para crear un torneo.
     * @return ventanaCrearTorneo la ventana para crear torneo.
     */
    public VentanaCrearTorneo getVentanaCrearTorneo() {
        return ventanaCrearTorneo;
    }

    /**
     * Establece la ventana para crear un torneo.
     * @param ventanaCrearTorneo la ventana para crear torneo a establecer.
     */
    public void setVentanaCrearTorneo(VentanaCrearTorneo ventanaCrearTorneo) {
        this.ventanaCrearTorneo = ventanaCrearTorneo;
    }

    /**
     * Obtiene la ventana para crear un equipo.
     * @return ventanaCrearEquipo la ventana para crear equipo.
     */
    public VentanaCrearEquipo getVentanaCrearEquipo() {
        return ventanaCrearEquipo;
    }

    /**
     * Establece la ventana para crear un equipo.
     * @param ventanaCrearEquipo la ventana para crear equipo a establecer.
     */
    public void setVentanaCrearEquipo(VentanaCrearEquipo ventanaCrearEquipo) {
        this.ventanaCrearEquipo = ventanaCrearEquipo;
    }

    /**
     * Obtiene la ventana que muestra el avance y el inicio del torneo.
     * @return ventanaAvanzeTorneo la ventana de avance e inicio del torneo.
     */
    public VentanaAvanzeYInicioTorneo getVentanAvanzeTorneo() {
        return ventanaAvanzeTorneo;
    }

    /**
     * Establece la ventana que muestra el avance y el inicio del torneo.
     * @param ventanAvanzeTorneo la ventana de avance e inicio del torneo a establecer.
     */
    public void setVentanAvanzeTorneo(VentanaAvanzeYInicioTorneo ventanAvanzeTorneo) {
        this.ventanaAvanzeTorneo = ventanAvanzeTorneo;
    }

    /**
     * Muestra un mensaje de advertencia en pantalla con un cuadro de diálogo.
     * @param string el mensaje que se mostrará en el cuadro de diálogo.
     */
    public void mostrarMensaje(String string) {
        JOptionPane.showMessageDialog(
            null,
            string,
            "Advertencia",
            JOptionPane.WARNING_MESSAGE
        );
    }

    /**
     * Obtiene la ventana que lista los equipos.
     * @return ventanaListaEquipos la ventana de lista de equipos.
     */
    public VentanaListaEquipos getVentanaListaEquipos() {
        return ventanaListaEquipos;
    }

    /**
     * Establece la ventana que lista los equipos.
     * @param ventanaListaEquipos la ventana de lista de equipos a establecer.
     */
    public void setVentanaListaEquipos(VentanaListaEquipos ventanaListaEquipos) {
        this.ventanaListaEquipos = ventanaListaEquipos;
    }

}
