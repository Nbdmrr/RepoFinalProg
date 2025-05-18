package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * PanelPrincipalEntrenador es un JPanel que contiene la interfaz principal para el entrenador.
 * Incluye listas de equipos disponibles y entrenados, información del usuario y botones para acciones.
 */
public class PanelPrincipalEntrenador extends JPanel {

    private JList<String> listaEquiposDisponibles;
    private JList<String> listaEquiposEntrenados;
    private JTextField campoMensaje;
    private JButton botonEnviar;
    private JButton botonVolver;
    private JButton botonUnirse;
    private JButton botonCrear;
    private JButton botonElegirEquipo;
    private JLabel etiquetaImagen;
    private JLabel etiquetaUsuario;
    private JLabel valorUsuario;
    private JLabel etiquetaNacionalidad;
    private JLabel valorNacionalidad;
    private JLabel etiquetaCorreo;
    private JLabel valorCorreo;
    

    /**
     * Constructor que inicializa el panel principal del entrenador.
     * Establece el layout y el tamaño preferido y llama a inicializar los componentes.
     */
    public PanelPrincipalEntrenador() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1100, 500));
        inicializarComponentes();
    }

    /**
     * Inicializa y configura todos los componentes gráficos del panel.
     * Incluye listas, etiquetas, botones y la disposición de los mismos en el panel.
     */
    public void inicializarComponentes() {

        JPanel panelListas = new JPanel(new GridLayout(1, 2, 10, 0));

        listaEquiposDisponibles = new JList<>();
        listaEquiposDisponibles.setBorder(BorderFactory.createTitledBorder("Equipos Disponibles"));
        panelListas.add(new JScrollPane(listaEquiposDisponibles));

        listaEquiposEntrenados = new JList<>();
        listaEquiposEntrenados.setBorder(BorderFactory.createTitledBorder("Equipos que Entrena"));
        panelListas.add(new JScrollPane(listaEquiposEntrenados));

        add(panelListas, BorderLayout.CENTER);

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
        botonCrear.setActionCommand("CREACIONEQUIPO");
        
        setBotonElegirEquipo(new JButton("Elegir Equipo"));
        getBotonElegirEquipo().setActionCommand("ELEGIREQUIPO");

        botonVolver.setActionCommand("VOLVERDEENTRENADORAINICIO");
        botonUnirse.setActionCommand("UNIRSEAEQUIPO");
        panelBotones.add(botonVolver);
        panelBotones.add(botonUnirse);
        panelBotones.add(botonCrear);
        panelBotones.add(getBotonElegirEquipo());

        panelInferior.add(panelMensaje);
        panelInferior.add(Box.createHorizontalStrut(20));
        panelInferior.add(panelBotones);

        add(panelInferior, BorderLayout.SOUTH);
    }
    /**
     * Llena la lista de equipos disponibles con los datos recibidos.
     * 
     * @param equiposDisponibles ArrayList<String> con los nombres de los equipos disponibles.
     */
    public void llenarListaEquiposDisponibles(ArrayList<String> equiposDisponibles) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (String equipo : equiposDisponibles) {
            modelo.addElement(equipo);
        }
        listaEquiposDisponibles.setModel(modelo);
    }

    /**
     * Llena la lista de equipos entrenados con los datos recibidos.
     * 
     * @param equiposEntrenados ArrayList<String> con los nombres de los equipos entrenados.
     */
    public void llenarListaEquiposEntrenados(ArrayList<String> equiposEntrenados) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (String equipo : equiposEntrenados) {
            modelo.addElement(equipo);
        }
        listaEquiposEntrenados.setModel(modelo);
    }



    /**
     * Actualiza los datos del entrenador que se muestran en el panel.
     * 
     * @param usuario      Nombre o usuario del entrenador.
     * @param nacionalidad Nacionalidad del entrenador.
     * @param correo      Correo electrónico del entrenador.
     */
    public void actualizarDatosEntrenador(String usuario, String nacionalidad, String correo) {
        valorUsuario.setText(usuario);
        valorNacionalidad.setText(nacionalidad);
        valorCorreo.setText(correo);
    }

    // === Getters y Setters ===

    /**
     * Obtiene la lista de equipos disponibles.
     * 
     * @return JList<String> con los equipos disponibles.
     */
    public JList<String> getListaEquiposDisponibles() {
        return listaEquiposDisponibles;
    }

    /**
     * Establece la lista de equipos disponibles.
     * 
     * @param listaEquiposDisponibles JList<String> para equipos disponibles.
     */
    public void setListaEquiposDisponibles(JList<String> listaEquiposDisponibles) {
        this.listaEquiposDisponibles = listaEquiposDisponibles;
    }

    /**
     * Obtiene la lista de equipos entrenados.
     * 
     * @return JList<String> con los equipos que entrena el entrenador.
     */
    public JList<String> getListaEquiposEntrenados() {
        return listaEquiposEntrenados;
    }

    /**
     * Establece la lista de equipos entrenados.
     * 
     * @param listaEquiposEntrenados JList<String> para equipos entrenados.
     */
    public void setListaEquiposEntrenados(JList<String> listaEquiposEntrenados) {
        this.listaEquiposEntrenados = listaEquiposEntrenados;
    }

    /**
     * Obtiene el campo de texto para escribir mensajes.
     * 
     * @return JTextField para mensajes.
     */
    public JTextField getCampoMensaje() {
        return campoMensaje;
    }

    /**
     * Establece el campo de texto para mensajes.
     * 
     * @param campoMensaje JTextField para mensajes.
     */
    public void setCampoMensaje(JTextField campoMensaje) {
        this.campoMensaje = campoMensaje;
    }

    /**
     * Obtiene el botón para enviar mensajes.
     * 
     * @return JButton para enviar.
     */
    public JButton getBotonEnviar() {
        return botonEnviar;
    }

    /**
     * Establece el botón para enviar mensajes.
     * 
     * @param botonEnviar JButton para enviar.
     */
    public void setBotonEnviar(JButton botonEnviar) {
        this.botonEnviar = botonEnviar;
    }

    /**
     * Obtiene el botón para volver.
     * 
     * @return JButton para volver.
     */
    public JButton getBotonVolver() {
        return botonVolver;
    }

    /**
     * Establece el botón para volver.
     * 
     * @param botonVolver JButton para volver.
     */
    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }

    /**
     * Obtiene el botón para unirse a un equipo.
     * 
     * @return JButton para unirse a un equipo.
     */
    public JButton getBotonUnirse() {
        return botonUnirse;
    }

    /**
     * Establece el botón para unirse a un equipo.
     * 
     * @param botonUnirse JButton para unirse a un equipo.
     */
    public void setBotonUnirse(JButton botonUnirse) {
        this.botonUnirse = botonUnirse;
    }

    /**
     * Obtiene el botón para crear un equipo.
     * 
     * @return JButton para crear equipo.
     */
    public JButton getBotonCrear() {
        return botonCrear;
    }

    /**
     * Establece el botón para crear un equipo.
     * 
     * @param botonCrear JButton para crear equipo.
     */
    public void setBotonCrear(JButton botonCrear) {
        this.botonCrear = botonCrear;
    }

    /**
     * Obtiene la etiqueta que muestra la imagen del usuario.
     * 
     * @return JLabel con la imagen del usuario.
     */
    public JLabel getEtiquetaImagen() {
        return etiquetaImagen;
    }

    /**
     * Establece la etiqueta de imagen del usuario.
     * 
     * @param etiquetaImagen JLabel con la imagen del usuario.
     */
    public void setEtiquetaImagen(JLabel etiquetaImagen) {
        this.etiquetaImagen = etiquetaImagen;
    }

    /**
     * Obtiene la etiqueta del texto "Usuario:".
     * 
     * @return JLabel para la etiqueta de usuario.
     */
    public JLabel getEtiquetaUsuario() {
        return etiquetaUsuario;
    }

    /**
     * Establece la etiqueta del texto "Usuario:".
     * 
     * @param etiquetaUsuario JLabel para la etiqueta de usuario.
     */
    public void setEtiquetaUsuario(JLabel etiquetaUsuario) {
        this.etiquetaUsuario = etiquetaUsuario;
    }

    /**
     * Obtiene la etiqueta que muestra el nombre del usuario.
     * 
     * @return JLabel con el nombre del usuario.
     */
    public JLabel getValorUsuario() {
        return valorUsuario;
    }

    /**
     * Establece la etiqueta que muestra el nombre del usuario.
     * 
     * @param valorUsuario JLabel con el nombre del usuario.
     */
    public void setValorUsuario(JLabel valorUsuario) {
        this.valorUsuario = valorUsuario;
    }

    /**
     * Obtiene la etiqueta del texto "Nacionalidad:".
     * 
     * @return JLabel para la etiqueta de nacionalidad.
     */
    public JLabel getEtiquetaNacionalidad() {
        return etiquetaNacionalidad;
    }

    /**
     * Establece la etiqueta del texto "Nacionalidad:".
     * 
     * @param etiquetaNacionalidad JLabel para la etiqueta de nacionalidad.
     */
    public void setEtiquetaNacionalidad(JLabel etiquetaNacionalidad) {
        this.etiquetaNacionalidad = etiquetaNacionalidad;
    }

    /**
     * Obtiene la etiqueta que muestra la nacionalidad del usuario.
     * 
     * @return JLabel con la nacionalidad.
     */
    public JLabel getValorNacionalidad() {
        return valorNacionalidad;
    }

    /**
     * Establece la etiqueta que muestra la nacionalidad del usuario.
     * 
     * @param valorNacionalidad JLabel con la nacionalidad.
     */
    public void setValorNacionalidad(JLabel valorNacionalidad) {
        this.valorNacionalidad = valorNacionalidad;
    }

    /**
     * Obtiene la etiqueta del texto "Correo:".
     * 
     * @return JLabel para la etiqueta de correo.
     */
    public JLabel getEtiquetaCorreo() {
        return etiquetaCorreo;
    }

    /**
     * Establece la etiqueta del texto "Correo:".
     * 
     * @param etiquetaCorreo JLabel para la etiqueta de correo.
     */
    public void setEtiquetaCorreo(JLabel etiquetaCorreo) {
        this.etiquetaCorreo = etiquetaCorreo;
    }

    /**
     * Obtiene la etiqueta que muestra el correo electrónico del usuario.
     * 
     * @return JLabel con el correo electrónico.
     */
    public JLabel getValorCorreo() {
        return valorCorreo;
    }

    /**
     * Establece la etiqueta que muestra el correo electrónico del usuario.
     * 
     * @param valorCorreo JLabel con el correo electrónico.
     */
    public void setValorCorreo(JLabel valorCorreo) {
        this.valorCorreo = valorCorreo;
    }

    /**
     * Obtiene el botón "Elegir Equipo".
     * 
     * @return el botón "Elegir Equipo"
     */
    public JButton getBotonElegirEquipo() {
        return botonElegirEquipo;
    }

    /**
     * Establece el botón "Elegir Equipo".
     * 
     * @param botonElegirEquipo el botón "Elegir Equipo" a asignar
     */
    public void setBotonElegirEquipo(JButton botonElegirEquipo) {
        this.botonElegirEquipo = botonElegirEquipo;
    }

}
