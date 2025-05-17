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
    private JButton botonCrear;

    private JLabel etiquetaImagen;
    private JLabel etiquetaUsuario;
    private JLabel valorUsuario;
    private JLabel etiquetaNacionalidad;
    private JLabel valorNacionalidad;
    private JLabel etiquetaCorreo;
    private JLabel valorCorreo;

    public PanelPrincipalEntrenador() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1100, 500));
        inicializarComponentes();
    }

    public void inicializarComponentes() {

        // Panel Centro con dos listas
        JPanel panelListas = new JPanel(new GridLayout(1, 2, 10, 0));

        listaEquiposDisponibles = new JList<>();
        listaEquiposDisponibles.setBorder(BorderFactory.createTitledBorder("Equipos Disponibles"));
        panelListas.add(new JScrollPane(listaEquiposDisponibles));

        listaEquiposEntrenados = new JList<>();
        listaEquiposEntrenados.setBorder(BorderFactory.createTitledBorder("Equipos que Entrena"));
        panelListas.add(new JScrollPane(listaEquiposEntrenados));

        add(panelListas, BorderLayout.CENTER);

        // Panel derecha con imagen y datos
        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setPreferredSize(new Dimension(250, 0));

        etiquetaImagen = new JLabel();
        etiquetaImagen.setPreferredSize(new Dimension(200, 200));
        etiquetaImagen.setMaximumSize(new Dimension(200, 200));
        etiquetaImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiquetaImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaImagen.setIcon(new ImageIcon(new ImageIcon("src/imagenes/usuario.png")
                .getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

        etiquetaUsuario = new JLabel("Usuario:");
        valorUsuario = new JLabel(" - ");
        etiquetaNacionalidad = new JLabel("Nacionalidad:");
        valorNacionalidad = new JLabel(" - ");
        etiquetaCorreo = new JLabel("Correo:");
        valorCorreo = new JLabel(" - ");

        etiquetaUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        valorUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaNacionalidad.setAlignmentX(Component.CENTER_ALIGNMENT);
        valorNacionalidad.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        valorCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDerecha.add(Box.createRigidArea(new Dimension(0, 15)));
        panelDerecha.add(etiquetaImagen);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 20)));
        panelDerecha.add(etiquetaUsuario);
        panelDerecha.add(valorUsuario);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(etiquetaNacionalidad);
        panelDerecha.add(valorNacionalidad);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(etiquetaCorreo);
        panelDerecha.add(valorCorreo);

        add(panelDerecha, BorderLayout.EAST);

        // Panel inferior con botones y mensaje
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelMensaje = new JPanel(new BorderLayout());
        campoMensaje = new JTextField();
        campoMensaje.setPreferredSize(new Dimension(600, 30));
        botonEnviar = new JButton("➤");
        botonEnviar.setPreferredSize(new Dimension(60, 30));
        panelMensaje.add(campoMensaje, BorderLayout.CENTER);
        panelMensaje.add(botonEnviar, BorderLayout.EAST);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonVolver = new JButton("Volver");
        botonUnirse = new JButton("Unirse a un equipo");
        botonCrear = new JButton("Crear Equipo");
        
        botonVolver.setActionCommand("VOLVERDEENTRENADORAINICIO");

        panelBotones.add(botonVolver);
        panelBotones.add(botonUnirse);
        panelBotones.add(botonCrear);

        panelInferior.add(panelMensaje);
        panelInferior.add(Box.createHorizontalStrut(20));
        panelInferior.add(panelBotones);

        add(panelInferior, BorderLayout.SOUTH);
    }

    // Método para actualizar los datos del entrenador
    public void actualizarDatosEntrenador(String usuario, String nacionalidad, String correo) {
        valorUsuario.setText(usuario);
        valorNacionalidad.setText(nacionalidad);
        valorCorreo.setText(correo);
    }

    // === Getters y Setters ===

    public JList<String> getListaEquiposDisponibles() {
        return listaEquiposDisponibles;
    }

    public void setListaEquiposDisponibles(JList<String> listaEquiposDisponibles) {
        this.listaEquiposDisponibles = listaEquiposDisponibles;
    }

    public JList<String> getListaEquiposEntrenados() {
        return listaEquiposEntrenados;
    }

    public void setListaEquiposEntrenados(JList<String> listaEquiposEntrenados) {
        this.listaEquiposEntrenados = listaEquiposEntrenados;
    }

    public JTextField getCampoMensaje() {
        return campoMensaje;
    }

    public void setCampoMensaje(JTextField campoMensaje) {
        this.campoMensaje = campoMensaje;
    }

    public JButton getBotonEnviar() {
        return botonEnviar;
    }

    public void setBotonEnviar(JButton botonEnviar) {
        this.botonEnviar = botonEnviar;
    }

    public JButton getBotonVolver() {
        return botonVolver;
    }

    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }

    public JButton getBotonUnirse() {
        return botonUnirse;
    }

    public void setBotonUnirse(JButton botonUnirse) {
        this.botonUnirse = botonUnirse;
    }

    public JButton getBotonCrear() {
        return botonCrear;
    }

    public void setBotonCrear(JButton botonCrear) {
        this.botonCrear = botonCrear;
    }

    public JLabel getEtiquetaImagen() {
        return etiquetaImagen;
    }

    public void setEtiquetaImagen(JLabel etiquetaImagen) {
        this.etiquetaImagen = etiquetaImagen;
    }

    public JLabel getEtiquetaUsuario() {
        return etiquetaUsuario;
    }

    public void setEtiquetaUsuario(JLabel etiquetaUsuario) {
        this.etiquetaUsuario = etiquetaUsuario;
    }

    public JLabel getValorUsuario() {
        return valorUsuario;
    }

    public void setValorUsuario(JLabel valorUsuario) {
        this.valorUsuario = valorUsuario;
    }

    public JLabel getEtiquetaNacionalidad() {
        return etiquetaNacionalidad;
    }

    public void setEtiquetaNacionalidad(JLabel etiquetaNacionalidad) {
        this.etiquetaNacionalidad = etiquetaNacionalidad;
    }

    public JLabel getValorNacionalidad() {
        return valorNacionalidad;
    }

    public void setValorNacionalidad(JLabel valorNacionalidad) {
        this.valorNacionalidad = valorNacionalidad;
    }

    public JLabel getEtiquetaCorreo() {
        return etiquetaCorreo;
    }

    public void setEtiquetaCorreo(JLabel etiquetaCorreo) {
        this.etiquetaCorreo = etiquetaCorreo;
    }

    public JLabel getValorCorreo() {
        return valorCorreo;
    }

    public void setValorCorreo(JLabel valorCorreo) {
        this.valorCorreo = valorCorreo;
    }
}
