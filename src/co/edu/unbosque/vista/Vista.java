package co.edu.unbosque.vista;

public class Vista {
	
	private VentanaAvanzeTorneo ventanaAvanzeTorneo;
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
	
	public Vista() {
		this.ventanaAvanzeTorneo = new VentanaAvanzeTorneo();
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

	public VentanaRegistroJugador getVentanaRegistroJugador() {
		return ventanaRegistroJugador;
	}

	public void setVentanaRegistroJugador(VentanaRegistroJugador ventanaRegistroJugador) {
		this.ventanaRegistroJugador = ventanaRegistroJugador;
	}

	public VentanaRegistroEntrenador getVentanaRegistroEntrenador() {
		return ventanaRegistroEntrenador;
	}

	public void setVentanaRegistroEntrenador(VentanaRegistroEntrenador ventanaRegistroEntrenador) {
		this.ventanaRegistroEntrenador = ventanaRegistroEntrenador;
	}

	public VentanaRegistroAdmin getVentanaRegistroAdmin() {
		return ventanaRegistroAdmin;
	}

	public void setVentanaRegistroAdmin(VentanaRegistroAdmin ventanaRegistroAdmin) {
		this.ventanaRegistroAdmin = ventanaRegistroAdmin;
	}

	public VentanaPrincipalJugador getVentanaPrincipalJugador() {
		return ventanaPrincipalJugador;
	}

	public void setVentanaPrincipalJugador(VentanaPrincipalJugador ventanaPrincipalJugador) {
		this.ventanaPrincipalJugador = ventanaPrincipalJugador;
	}

	public VentanaPrincipalEntrenador getVentanaPrincipalEntrenador() {
		return ventanaPrincipalEntrenador;
	}

	public void setVentanaPrincipalEntrenador(VentanaPrincipalEntrenador ventanaPrincipalEntrenador) {
		this.ventanaPrincipalEntrenador = ventanaPrincipalEntrenador;
	}

	public VentanaPrincipalAdmin getVentanaPrincipalAdmin() {
		return ventanaPrincipalAdmin;
	}

	public void setVentanaPrincipalAdmin(VentanaPrincipalAdmin ventanaPrincipalAdmin) {
		this.ventanaPrincipalAdmin = ventanaPrincipalAdmin;
	}

	public VentanaInicioSesion getVentanaInicioSesion() {
		return ventanaInicioSesion;
	}

	public void setVentanaInicioSesion(VentanaInicioSesion ventanaInicioSesion) {
		this.ventanaInicioSesion = ventanaInicioSesion;
	}

	public VentanaDatosTorneo getVentanaDatosTorneo() {
		return ventanaDatosTorneo;
	}

	public void setVentanaDatosTorneo(VentanaDatosTorneo ventanaDatosTorneo) {
		this.ventanaDatosTorneo = ventanaDatosTorneo;
	}

	public VentanaCronograma getVentanaCronograma() {
		return ventanaCronograma;
	}

	public void setVentanaCronograma(VentanaCronograma ventanaCronograma) {
		this.ventanaCronograma = ventanaCronograma;
	}

	public VentanaCrearTorneo getVentanaCrearTorneo() {
		return ventanaCrearTorneo;
	}

	public void setVentanaCrearTorneo(VentanaCrearTorneo ventanaCrearTorneo) {
		this.ventanaCrearTorneo = ventanaCrearTorneo;
	}

	public VentanaCrearEquipo getVentanaCrearEquipo() {
		return ventanaCrearEquipo;
	}

	public void setVentanaCrearEquipo(VentanaCrearEquipo ventanaCrearEquipo) {
		this.ventanaCrearEquipo = ventanaCrearEquipo;
	}

	public VentanaAvanzeTorneo getVentanAvanzeTorneo() {
		return ventanaAvanzeTorneo;
	}

	public void setVentanAvanzeTorneo(VentanaAvanzeTorneo ventanAvanzeTorneo) {
		this.ventanaAvanzeTorneo = ventanAvanzeTorneo;
	}

    public void mostrarMensaje(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarMensaje'");
    }
	

}
