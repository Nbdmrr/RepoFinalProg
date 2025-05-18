package co.edu.unbosque.vista;

import javax.swing.JOptionPane;

/**
 * Clase Vista que centraliza la gestión de todas las ventanas de la aplicación.
 * Permite acceder y modificar las diferentes ventanas del sistema, así como mostrar mensajes al usuario.
 * 
 * Ventanas gestionadas:
 * <ul>
 *   <li>VentanaAvanzeYInicioTorneo</li>
 *   <li>VentanaCrearEquipo</li>
 *   <li>VentanaCrearTorneo</li>
 *   <li>VentanaCronograma</li>
 *   <li>VentanaDatosTorneo</li>
 *   <li>VentanaInicioSesion</li>
 *   <li>VentanaPrincipalAdmin</li>
 *   <li>VentanaPrincipalEntrenador</li>
 *   <li>VentanaPrincipalJugador</li>
 *   <li>VentanaRegistroAdmin</li>
 *   <li>VentanaRegistroEntrenador</li>
 *   <li>VentanaRegistroJugador</li>
 * </ul>
 * 
 * Métodos para mostrar mensajes y acceder a cada ventana.
 * 
 * @author 
 */
public class Vista {
    
    private VentanaAvanzeYInicioTorneo ventanaAvanzeTorneo;
    private VentanaCrearEquipo ventanaCrearEquipo;
    private VentanaCrearTorneo ventanaCrearTorneo;
    private VentanaCronograma ventanaCronograma;
    private VentanaDatosTorneo ventanaDatosTorneo;
    private VentanaInicioSesion ventanaInicioSesion;
    private VentanaPrincipalAdmin ventanaPrincipalAdmin;
    private VentanaPrincipalEntrenador ventanaPrincipalEntrenador;
    private VentanaPrincipalJugador ventanaPrincipalJugador;
    private VentanaRegistroAdmin ventanaRegistroAdmin;
    private VentanaRegistroEntrenador ventanaRegistroEntrenador;
    private VentanaRegistroJugador ventanaRegistroJugador;

    /**
     * Constructor de la clase Vista. Inicializa todas las ventanas de la aplicación.
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
    }

    /**
     * Devuelve la ventana de registro de jugador.
     * @return VentanaRegistroJugador
     */
    public VentanaRegistroJugador getVentanaRegistroJugador() {
        return ventanaRegistroJugador;
    }

    /**
     * Establece la ventana de registro de jugador.
     * @param ventanaRegistroJugador VentanaRegistroJugador
     */
    public void setVentanaRegistroJugador(VentanaRegistroJugador ventanaRegistroJugador) {
        this.ventanaRegistroJugador = ventanaRegistroJugador;
    }

    /**
     * Devuelve la ventana de registro de entrenador.
     * @return VentanaRegistroEntrenador
     */
    public VentanaRegistroEntrenador getVentanaRegistroEntrenador() {
        return ventanaRegistroEntrenador;
    }

    /**
     * Establece la ventana de registro de entrenador.
     * @param ventanaRegistroEntrenador VentanaRegistroEntrenador
     */
    public void setVentanaRegistroEntrenador(VentanaRegistroEntrenador ventanaRegistroEntrenador) {
        this.ventanaRegistroEntrenador = ventanaRegistroEntrenador;
    }

    /**
     * Devuelve la ventana de registro de administrador.
     * @return VentanaRegistroAdmin
     */
    public VentanaRegistroAdmin getVentanaRegistroAdmin() {
        return ventanaRegistroAdmin;
    }

    /**
     * Establece la ventana de registro de administrador.
     * @param ventanaRegistroAdmin VentanaRegistroAdmin
     */
    public void setVentanaRegistroAdmin(VentanaRegistroAdmin ventanaRegistroAdmin) {
        this.ventanaRegistroAdmin = ventanaRegistroAdmin;
    }

    /**
     * Devuelve la ventana principal del jugador.
     * @return VentanaPrincipalJugador
     */
    public VentanaPrincipalJugador getVentanaPrincipalJugador() {
        return ventanaPrincipalJugador;
    }

    /**
     * Establece la ventana principal del jugador.
     * @param ventanaPrincipalJugador VentanaPrincipalJugador
     */
    public void setVentanaPrincipalJugador(VentanaPrincipalJugador ventanaPrincipalJugador) {
        this.ventanaPrincipalJugador = ventanaPrincipalJugador;
    }

    /**
     * Devuelve la ventana principal del entrenador.
     * @return VentanaPrincipalEntrenador
     */
    public VentanaPrincipalEntrenador getVentanaPrincipalEntrenador() {
        return ventanaPrincipalEntrenador;
    }

    /**
     * Establece la ventana principal del entrenador.
     * @param ventanaPrincipalEntrenador VentanaPrincipalEntrenador
     */
    public void setVentanaPrincipalEntrenador(VentanaPrincipalEntrenador ventanaPrincipalEntrenador) {
        this.ventanaPrincipalEntrenador = ventanaPrincipalEntrenador;
    }

    /**
     * Devuelve la ventana principal del administrador.
     * @return VentanaPrincipalAdmin
     */
    public VentanaPrincipalAdmin getVentanaPrincipalAdmin() {
        return ventanaPrincipalAdmin;
    }

    /**
     * Establece la ventana principal del administrador.
     * @param ventanaPrincipalAdmin VentanaPrincipalAdmin
     */
    public void setVentanaPrincipalAdmin(VentanaPrincipalAdmin ventanaPrincipalAdmin) {
        this.ventanaPrincipalAdmin = ventanaPrincipalAdmin;
    }

    /**
     * Devuelve la ventana de inicio de sesión.
     * @return VentanaInicioSesion
     */
    public VentanaInicioSesion getVentanaInicioSesion() {
        return ventanaInicioSesion;
    }

    /**
     * Establece la ventana de inicio de sesión.
     * @param ventanaInicioSesion VentanaInicioSesion
     */
    public void setVentanaInicioSesion(VentanaInicioSesion ventanaInicioSesion) {
        this.ventanaInicioSesion = ventanaInicioSesion;
    }

    /**
     * Devuelve la ventana de datos del torneo.
     * @return VentanaDatosTorneo
     */
    public VentanaDatosTorneo getVentanaDatosTorneo() {
        return ventanaDatosTorneo;
    }

    /**
     * Establece la ventana de datos del torneo.
     * @param ventanaDatosTorneo VentanaDatosTorneo
     */
    public void setVentanaDatosTorneo(VentanaDatosTorneo ventanaDatosTorneo) {
        this.ventanaDatosTorneo = ventanaDatosTorneo;
    }

    /**
     * Devuelve la ventana del cronograma.
     * @return VentanaCronograma
     */
    public VentanaCronograma getVentanaCronograma() {
        return ventanaCronograma;
    }

    /**
     * Establece la ventana del cronograma.
     * @param ventanaCronograma VentanaCronograma
     */
    public void setVentanaCronograma(VentanaCronograma ventanaCronograma) {
        this.ventanaCronograma = ventanaCronograma;
    }

    /**
     * Devuelve la ventana para crear torneos.
     * @return VentanaCrearTorneo
     */
    public VentanaCrearTorneo getVentanaCrearTorneo() {
        return ventanaCrearTorneo;
    }

    /**
     * Establece la ventana para crear torneos.
     * @param ventanaCrearTorneo VentanaCrearTorneo
     */
    public void setVentanaCrearTorneo(VentanaCrearTorneo ventanaCrearTorneo) {
        this.ventanaCrearTorneo = ventanaCrearTorneo;
    }

    /**
     * Devuelve la ventana para crear equipos.
     * @return VentanaCrearEquipo
     */
    public VentanaCrearEquipo getVentanaCrearEquipo() {
        return ventanaCrearEquipo;
    }

    /**
     * Establece la ventana para crear equipos.
     * @param ventanaCrearEquipo VentanaCrearEquipo
     */
    public void setVentanaCrearEquipo(VentanaCrearEquipo ventanaCrearEquipo) {
        this.ventanaCrearEquipo = ventanaCrearEquipo;
    }

    /**
     * Devuelve la ventana de avance e inicio de torneo.
     * @return VentanaAvanzeYInicioTorneo
     */
    public VentanaAvanzeYInicioTorneo getVentanAvanzeTorneo() {
        return ventanaAvanzeTorneo;
    }

    /**
     * Establece la ventana de avance e inicio de torneo.
     * @param ventanAvanzeTorneo VentanaAvanzeYInicioTorneo
     */
    public void setVentanAvanzeTorneo(VentanaAvanzeYInicioTorneo ventanAvanzeTorneo) {
        this.ventanaAvanzeTorneo = ventanAvanzeTorneo;
    }

    /**
     * Muestra un mensaje al usuario en una ventana de advertencia.
     * @param string Mensaje a mostrar
     */
    public void mostrarMensaje(String string) {
        JOptionPane.showMessageDialog(
            null,
            string,
            "Advertencia",
            JOptionPane.WARNING_MESSAGE
        );
    }
}