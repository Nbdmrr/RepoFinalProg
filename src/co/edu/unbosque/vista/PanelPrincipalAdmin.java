package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * PanelPrincipalAdmin representa el panel principal de la vista para el administrador.
 * Contiene una lista de torneos, campos y botones para interacción, y una sección con datos del administrador.
 */
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

    /**
     * Constructor que inicializa el panel principal con su diseño y componentes.
     */
    public PanelPrincipalAdmin() {
        setLayout(new BorderLayout());

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

    /**
     * Actualiza los valores visibles en la sección de datos del administrador.
     * 
     * @param usuario      Nombre de usuario a mostrar.
     * @param cargo        Cargo del administrador.
     * @param correo       Correo electrónico del administrador.
     * @param nacionalidad Nacionalidad del administrador.
     */
    public void actualizarDatosAdmin(String usuario, String cargo, String correo, String nacionalidad) {
        valorUsuario.setText(usuario);
        valorCargo.setText(cargo);
        valorCorreo.setText(correo);
        valorNacionalidad.setText(nacionalidad);
    }

    /**
     * Obtiene la lista de torneos mostrada en el panel.
     * 
     * @return la JList con los torneos.
     */
    public JList<String> getListaTorneos() {
        return listaTorneos;
    }

    /**
     * Establece la lista de torneos en el panel.
     * 
     * @param listaTorneos la nueva JList con torneos.
     */
    public void setListaTorneos(JList<String> listaTorneos) {
        this.listaTorneos = listaTorneos;
    }

    /**
     * Obtiene el campo de texto para mensajes.
     * 
     * @return el JTextField del campo de mensaje.
     */
    public JTextField getCampoMensaje() {
        return campoMensaje;
    }

    /**
     * Establece el campo de texto para mensajes.
     * 
     * @param campoMensaje el JTextField a establecer.
     */
    public void setCampoMensaje(JTextField campoMensaje) {
        this.campoMensaje = campoMensaje;
    }

    /**
     * Obtiene el botón para enviar mensajes.
     * 
     * @return el JButton de enviar.
     */
    public JButton getBotonEnviar() {
        return botonEnviar;
    }

    /**
     * Establece el botón para enviar mensajes.
     * 
     * @param botonEnviar el JButton a establecer.
     */
    public void setBotonEnviar(JButton botonEnviar) {
        this.botonEnviar = botonEnviar;
    }

    /**
     * Obtiene la etiqueta que muestra la imagen del usuario.
     * 
     * @return el JLabel con la imagen.
     */
    public JLabel getEtiquetaImagen() {
        return etiquetaImagen;
    }

    /**
     * Establece la etiqueta que muestra la imagen del usuario.
     * 
     * @param etiquetaImagen el JLabel a establecer.
     */
    public void setEtiquetaImagen(JLabel etiquetaImagen) {
        this.etiquetaImagen = etiquetaImagen;
    }

    /**
     * Obtiene la etiqueta con el texto "Usuario:".
     * 
     * @return el JLabel de la etiqueta Usuario.
     */
    public JLabel getEtiquetaUsuario() {
        return etiquetaUsuario;
    }

    /**
     * Establece la etiqueta con el texto "Usuario:".
     * 
     * @param etiquetaUsuario el JLabel a establecer.
     */
    public void setEtiquetaUsuario(JLabel etiquetaUsuario) {
        this.etiquetaUsuario = etiquetaUsuario;
    }

    /**
     * Obtiene la etiqueta con el texto "Cargo:".
     * 
     * @return el JLabel de la etiqueta Cargo.
     */
    public JLabel getEtiquetaCargo() {
        return etiquetaCargo;
    }

    /**
     * Establece la etiqueta con el texto "Cargo:".
     * 
     * @param etiquetaCargo el JLabel a establecer.
     */
    public void setEtiquetaCargo(JLabel etiquetaCargo) {
        this.etiquetaCargo = etiquetaCargo;
    }

    /**
     * Obtiene la etiqueta que muestra el valor del usuario.
     * 
     * @return el JLabel con el nombre de usuario.
     */
    public JLabel getValorUsuario() {
        return valorUsuario;
    }

    /**
     * Establece la etiqueta que muestra el valor del usuario.
     * 
     * @param valorUsuario el JLabel a establecer.
     */
    public void setValorUsuario(JLabel valorUsuario) {
        this.valorUsuario = valorUsuario;
    }

    /**
     * Obtiene la etiqueta que muestra el valor del cargo.
     * 
     * @return el JLabel con el cargo.
     */
    public JLabel getValorCargo() {
        return valorCargo;
    }

    /**
     * Establece la etiqueta que muestra el valor del cargo.
     * 
     * @param valorCargo el JLabel a establecer.
     */
    public void setValorCargo(JLabel valorCargo) {
        this.valorCargo = valorCargo;
    }

    /**
     * Obtiene el botón para volver a la pantalla anterior.
     * 
     * @return el JButton Volver.
     */
    public JButton getBotonVolver() {
        return botonVolver;
    }

    /**
     * Establece el botón para volver a la pantalla anterior.
     * 
     * @param botonVolver el JButton a establecer.
     */
    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }

    /**
     * Obtiene el botón para registrar un nuevo administrador.
     * 
     * @return el JButton Registrar Administrador.
     */
    public JButton getBotonRegistrarAdmin() {
        return botonRegistrarAdmin;
    }

    /**
     * Establece el botón para registrar un nuevo administrador.
     * 
     * @param botonRegistrarAdmin el JButton a establecer.
     */
    public void setBotonRegistrarAdmin(JButton botonRegistrarAdmin) {
        this.botonRegistrarAdmin = botonRegistrarAdmin;
    }

    /**
     * Obtiene el botón para generar un PDF.
     * 
     * @return el JButton PDF.
     */
    public JButton getBotonPDF() {
        return botonPDF;
    }

    /**
     * Establece el botón para generar un PDF.
     * 
     * @param botonPDF el JButton a establecer.
     */
    public void setBotonPDF(JButton botonPDF) {
        this.botonPDF = botonPDF;
    }

    /**
     * Obtiene el botón para crear un nuevo torneo.
     * 
     * @return el JButton Crear Torneo.
     */
    public JButton getBotonCrearTorneo() {
        return botonCrearTorneo;
    }

    /**
     * Establece el botón para crear un nuevo torneo.
     * 
     * @param botonCrearTorneo el JButton a establecer.
     */
    public void setBotonCrearTorneo(JButton botonCrearTorneo) {
        this.botonCrearTorneo = botonCrearTorneo;
    }
}

