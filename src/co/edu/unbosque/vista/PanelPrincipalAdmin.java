package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipalAdmin extends JPanel {

    private JList<String> listaTorneos;
    private JTextField campoMensaje;
    private JButton botonEnviar;
    private JLabel etiquetaImagen;
    private JLabel etiquetaUsuario;
    private JLabel etiquetaCargo;
    private JLabel valorUsuario;
    private JLabel valorCargo;
    private JLabel etiquetaCorreo;
    private JLabel valorCorreo;
    private JLabel etiquetaNacionalidad;
    private JLabel valorNacionalidad;
    private JButton botonVolver;
    private JButton botonRegistrarAdmin;
    private JButton botonPDF;
    private JButton botonCrearTorneo;

    public PanelPrincipalAdmin() {
        setLayout(new BorderLayout());

        // === Centro ===
        JPanel panelCentro = new JPanel(new BorderLayout());

        JLabel tituloLista = new JLabel("Torneos", SwingConstants.CENTER);
        tituloLista.setFont(new Font("Arial", Font.BOLD, 16));
        panelCentro.add(tituloLista, BorderLayout.NORTH);

        listaTorneos = new JList<>(new DefaultListModel<>());
        JScrollPane scrollLista = new JScrollPane(listaTorneos);
        panelCentro.add(scrollLista, BorderLayout.CENTER);

        JPanel panelMensaje = new JPanel(new BorderLayout());
        panelMensaje.setPreferredSize(new Dimension(0, 40));

        campoMensaje = new JTextField();
        campoMensaje.setPreferredSize(new Dimension(0, 30));
        botonEnviar = new JButton("➤");
        botonEnviar.setPreferredSize(new Dimension(60, 30));
        panelMensaje.add(campoMensaje, BorderLayout.CENTER);
        panelMensaje.add(botonEnviar, BorderLayout.EAST);

        panelCentro.add(panelMensaje, BorderLayout.SOUTH);
        add(panelCentro, BorderLayout.CENTER);

        // === Derecha ===
        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setPreferredSize(new Dimension(250, 0));

        etiquetaImagen = new JLabel();
        etiquetaImagen.setPreferredSize(new Dimension(200, 200));
        etiquetaImagen.setMaximumSize(new Dimension(200, 200));
        etiquetaImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiquetaImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        etiquetaUsuario = new JLabel("Usuario:");
        valorUsuario = new JLabel(" - ");
        etiquetaCargo = new JLabel("Cargo:");
        valorCargo = new JLabel(" - ");
        etiquetaCorreo = new JLabel("Correo:");
        valorCorreo = new JLabel(" - ");
        etiquetaNacionalidad = new JLabel("Nacionalidad:");
        valorNacionalidad = new JLabel(" - ");

        etiquetaUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        valorUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaCargo.setAlignmentX(Component.CENTER_ALIGNMENT);
        valorCargo.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        valorCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaNacionalidad.setAlignmentX(Component.CENTER_ALIGNMENT);
        valorNacionalidad.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaImagen.setIcon(new ImageIcon(new ImageIcon("src/imagenes/usuario.png")
        .getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));


        panelDerecha.add(Box.createRigidArea(new Dimension(0, 15)));
        panelDerecha.add(etiquetaImagen);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 20)));
        panelDerecha.add(etiquetaUsuario);
        panelDerecha.add(valorUsuario);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(etiquetaCargo);
        panelDerecha.add(valorCargo);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(etiquetaCorreo);
        panelDerecha.add(valorCorreo);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(etiquetaNacionalidad);
        panelDerecha.add(valorNacionalidad);

        add(panelDerecha, BorderLayout.EAST);

        // === Inferior ===
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelInferior.setPreferredSize(new Dimension(0, 60));

        botonVolver = new JButton("Volver");
        botonRegistrarAdmin = new JButton("Registrar Administrador");
        botonRegistrarAdmin.setActionCommand("REGISTRARADMINISTRADOR");
        botonPDF = new JButton("PDF");
        botonCrearTorneo = new JButton("Crear Torneo");
        botonCrearTorneo.setActionCommand("CREACIONTORNEO");

        panelInferior.add(botonVolver);
        panelInferior.add(botonRegistrarAdmin);
        panelInferior.add(botonPDF);
        panelInferior.add(botonCrearTorneo);

        add(panelInferior, BorderLayout.SOUTH);
    }
    public void actualizarDatosAdmin(String usuario, String cargo, String correo, String nacionalidad) {
        valorUsuario.setText(usuario);
        valorCargo.setText(cargo);
        valorCorreo.setText(correo);
        valorNacionalidad.setText(nacionalidad);
    }


    // === Getters y Setters ===

    public JList<String> getListaTorneos() {
        return listaTorneos;
    }

    public void setListaTorneos(JList<String> listaTorneos) {
        this.listaTorneos = listaTorneos;
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

    public JLabel getEtiquetaCargo() {
        return etiquetaCargo;
    }

    public void setEtiquetaCargo(JLabel etiquetaCargo) {
        this.etiquetaCargo = etiquetaCargo;
    }

    public JLabel getValorUsuario() {
        return valorUsuario;
    }

    public void setValorUsuario(JLabel valorUsuario) {
        this.valorUsuario = valorUsuario;
    }

    public JLabel getValorCargo() {
        return valorCargo;
    }

    public void setValorCargo(JLabel valorCargo) {
        this.valorCargo = valorCargo;
    }

    public JButton getBotonVolver() {
        return botonVolver;
    }

    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }

    public JButton getBotonRegistrarAdmin() {
        return botonRegistrarAdmin;
    }

    public void setBotonRegistrarAdmin(JButton botonRegistrarAdmin) {
        this.botonRegistrarAdmin = botonRegistrarAdmin;
    }

    public JButton getBotonPDF() {
        return botonPDF;
    }

    public void setBotonPDF(JButton botonPDF) {
        this.botonPDF = botonPDF;
    }

    public JButton getBotonCrearTorneo() {
        return botonCrearTorneo;
    }

    public void setBotonCrearTorneo(JButton botonCrearTorneo) {
        this.botonCrearTorneo = botonCrearTorneo;
    }
}
