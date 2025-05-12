package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipalEntrenador extends JPanel {

    private JList<String> listaEquiposDisponibles;
    private JList<String> listaEquiposEntrenados;
    private JTextField campoMensaje;
    private JButton botonEnviar;
    private JButton botonVolver;
    private JButton botonUnirse;
    private JLabel etiquetaImagen;
    private JLabel etiquetaUsuario;
    private JLabel valorUsuario;
    private JLabel etiquetaNacionalidad;
    private JLabel valorCargo;


    public PanelPrincipalEntrenador() {
    	setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1100, 500));
        inicializarComponentes();
    }
    
    public void inicializarComponentes(){
    	
    	

        // Panel Centro con dos listas
        JPanel panelListas = new JPanel(new GridLayout(1, 2, 10, 0));

        setListaEquiposDisponibles(new JList<>());
        getListaEquiposDisponibles().setBorder(BorderFactory.createTitledBorder("Equipos Disponibles"));
        panelListas.add(new JScrollPane(getListaEquiposDisponibles()));

        setListaEquiposEntrenados(new JList<>());
        getListaEquiposEntrenados().setBorder(BorderFactory.createTitledBorder("Equipos que Entrena"));
        panelListas.add(new JScrollPane(getListaEquiposEntrenados()));

        add(panelListas, BorderLayout.CENTER);

     // Panel derecha con imagen y datos
        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setPreferredSize(new Dimension(250, 0));

        setEtiquetaImagen(new JLabel());
        getEtiquetaImagen().setPreferredSize(new Dimension(200, 200));
        getEtiquetaImagen().setMaximumSize(new Dimension(200, 200));
        getEtiquetaImagen().setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getEtiquetaImagen().setAlignmentX(Component.CENTER_ALIGNMENT);

        setEtiquetaUsuario(new JLabel("Usuario:"));
        setValorUsuario(new JLabel(" - "));
        setEtiquetaNacionalidad(new JLabel("Nacionalidad:"));
        setValorCargo(new JLabel(" - "));

        getEtiquetaUsuario().setAlignmentX(Component.CENTER_ALIGNMENT);
        getValorUsuario().setAlignmentX(Component.CENTER_ALIGNMENT);
        getEtiquetaNacionalidad().setAlignmentX(Component.CENTER_ALIGNMENT);
        getValorCargo().setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDerecha.add(Box.createRigidArea(new Dimension(0, 15)));
        panelDerecha.add(getEtiquetaImagen());
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 20)));
        panelDerecha.add(getEtiquetaUsuario());
        panelDerecha.add(getValorUsuario());
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(getEtiquetaNacionalidad());
        panelDerecha.add(getValorCargo());

        add(panelDerecha, BorderLayout.EAST);


        // Panel inferior con botones y mensaje
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelMensaje = new JPanel(new BorderLayout());
        setCampoMensaje(new JTextField());
        getCampoMensaje().setPreferredSize(new Dimension(600, 30));
        setBotonEnviar(new JButton("➤"));
        getBotonEnviar().setPreferredSize(new Dimension(60, 30));
        panelMensaje.add(getCampoMensaje(), BorderLayout.CENTER);
        panelMensaje.add(getBotonEnviar(), BorderLayout.EAST);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        setBotonVolver(new JButton("Volver"));
        setBotonUnirse(new JButton("Unirse a un equipo"));
        panelBotones.add(getBotonVolver());
        panelBotones.add(getBotonUnirse());

        panelInferior.add(panelMensaje);
        panelInferior.add(Box.createHorizontalStrut(20)); // espacio entre mensaje y botones
        panelInferior.add(panelBotones);

       

        add(panelInferior, BorderLayout.SOUTH);
    }

	public JLabel getValorCargo() {
		return valorCargo;
	}

	public void setValorCargo(JLabel valorCargo) {
		this.valorCargo = valorCargo;
	}

	public JLabel getEtiquetaNacionalidad() {
		return etiquetaNacionalidad;
	}

	public void setEtiquetaNacionalidad(JLabel etiquetaNacionalidad) {
		this.etiquetaNacionalidad = etiquetaNacionalidad;
	}

	public JLabel getValorUsuario() {
		return valorUsuario;
	}

	public void setValorUsuario(JLabel valorUsuario) {
		this.valorUsuario = valorUsuario;
	}

	public JLabel getEtiquetaUsuario() {
		return etiquetaUsuario;
	}

	public void setEtiquetaUsuario(JLabel etiquetaUsuario) {
		this.etiquetaUsuario = etiquetaUsuario;
	}

	public JLabel getEtiquetaImagen() {
		return etiquetaImagen;
	}

	public void setEtiquetaImagen(JLabel etiquetaImagen) {
		this.etiquetaImagen = etiquetaImagen;
	}

	public JButton getBotonUnirse() {
		return botonUnirse;
	}

	public void setBotonUnirse(JButton botonUnirse) {
		this.botonUnirse = botonUnirse;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}

	public JButton getBotonEnviar() {
		return botonEnviar;
	}

	public void setBotonEnviar(JButton botonEnviar) {
		this.botonEnviar = botonEnviar;
	}

	public JTextField getCampoMensaje() {
		return campoMensaje;
	}

	public void setCampoMensaje(JTextField campoMensaje) {
		this.campoMensaje = campoMensaje;
	}

	public JList<String> getListaEquiposEntrenados() {
		return listaEquiposEntrenados;
	}

	public void setListaEquiposEntrenados(JList<String> listaEquiposEntrenados) {
		this.listaEquiposEntrenados = listaEquiposEntrenados;
	}

	public JList<String> getListaEquiposDisponibles() {
		return listaEquiposDisponibles;
	}

	public void setListaEquiposDisponibles(JList<String> listaEquiposDisponibles) {
		this.listaEquiposDisponibles = listaEquiposDisponibles;
	}

	
}
