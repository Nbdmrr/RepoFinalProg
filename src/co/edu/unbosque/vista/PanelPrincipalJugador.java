package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Panel principal que muestra la interfaz gráfica para un jugador.
 * Contiene información personal, torneos participados, torneos activos y estadísticas del jugador.
 */
public class PanelPrincipalJugador extends JPanel {

    private JList<String> listaTorneosParticipa;
    private JList<String> listaTorneosActivos;
    private JButton botonVolver;
    private JLabel etiquetaImagen;
    private JLabel etiquetaUsuario;
    private JLabel valorUsuario;
    private JLabel etiquetaNacionalidad;
    private JLabel valorNacionalidad;
    private JLabel etiquetaEspecialidad;
    private JLabel valorEspecialidad;
    private JLabel etiquetaCorreo;
    private JLabel valorCorreo;
    private JLabel etiquetaEquipo;
    private JLabel valorEquipo;

    private JLabel etiquetaPartidasJugadas;
    private JLabel valorPartidasJugadas;
    private JLabel etiquetaPartidasGanadas;
    private JLabel valorPartidasGanadas;
    private JLabel etiquetaTorneosJugados;
    private JLabel valorTorneosJugados;
    private JLabel etiquetaTorneosGanados;
    private JLabel valorTorneosGanados;

    /**
     * Constructor que inicializa los componentes del panel principal del jugador.
     * Configura el diseño, componentes y disposición de los elementos gráficos.
     */
    public PanelPrincipalJugador() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1100, 500));

        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 10, 0));

        JPanel panelParticipa = new JPanel(new BorderLayout());
        JLabel tituloParticipa = new JLabel("Torneos en los que Participa", SwingConstants.CENTER);
        tituloParticipa.setFont(new Font("Arial", Font.BOLD, 16));
        panelParticipa.add(tituloParticipa, BorderLayout.NORTH);
        listaTorneosParticipa = new JList<>();
        panelParticipa.add(new JScrollPane(listaTorneosParticipa), BorderLayout.CENTER);

        JPanel panelActivos = new JPanel(new BorderLayout());
        JLabel tituloActivos = new JLabel("Torneos Activos", SwingConstants.CENTER);
        tituloActivos.setFont(new Font("Arial", Font.BOLD, 16));
        panelActivos.add(tituloActivos, BorderLayout.NORTH);
        listaTorneosActivos = new JList<>();
        panelActivos.add(new JScrollPane(listaTorneosActivos), BorderLayout.CENTER);

        panelCentro.add(panelParticipa);
        panelCentro.add(panelActivos);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setPreferredSize(new Dimension(250, 0));
        panelDerecha.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        etiquetaImagen = new JLabel();
        etiquetaImagen.setPreferredSize(new Dimension(150, 150));
        etiquetaImagen.setMaximumSize(new Dimension(150, 150));
        etiquetaImagen.setMinimumSize(new Dimension(150, 150));
        etiquetaImagen.setSize(150, 150);
        etiquetaImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiquetaImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon originalIcon = new ImageIcon("src/imagenes/usuario.png");
        Image imagenOriginal = originalIcon.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));

        etiquetaUsuario = new JLabel("Usuario:");
        valorUsuario = new JLabel(" - ");
        etiquetaNacionalidad = new JLabel("Nacionalidad:");
        valorNacionalidad = new JLabel(" - ");
        etiquetaEspecialidad = new JLabel("Especialidad:");
        valorEspecialidad = new JLabel(" - ");
        etiquetaCorreo = new JLabel("Correo:");
        valorCorreo = new JLabel(" - ");
        etiquetaEquipo = new JLabel("Equipo:");
        valorEquipo = new JLabel(" - ");

        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(etiquetaImagen);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 20)));
        panelDerecha.add(alinearCentro(etiquetaUsuario));
        panelDerecha.add(alinearCentro(valorUsuario));
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(alinearCentro(etiquetaNacionalidad));
        panelDerecha.add(alinearCentro(valorNacionalidad));
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(alinearCentro(etiquetaEspecialidad));
        panelDerecha.add(alinearCentro(valorEspecialidad));
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(alinearCentro(etiquetaCorreo));
        panelDerecha.add(alinearCentro(valorCorreo));
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDerecha.add(alinearCentro(etiquetaEquipo));
        panelDerecha.add(alinearCentro(valorEquipo));

        add(panelDerecha, BorderLayout.EAST);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());

        JPanel panelEstadisticas = new JPanel(new GridLayout(4, 2, 10, 5));
        panelEstadisticas.setBorder(BorderFactory.createTitledBorder("Estadísticas"));

        etiquetaPartidasJugadas = new JLabel("Partidas Jugadas:");
        valorPartidasJugadas = new JLabel(" - ");
        etiquetaPartidasGanadas = new JLabel("Partidas Ganadas:");
        valorPartidasGanadas = new JLabel(" - ");
        etiquetaTorneosJugados = new JLabel("Torneos Jugados:");
        valorTorneosJugados = new JLabel(" - ");
        etiquetaTorneosGanados = new JLabel("Torneos Ganados:");
        valorTorneosGanados = new JLabel(" - ");

        panelEstadisticas.add(etiquetaPartidasJugadas);
        panelEstadisticas.add(valorPartidasJugadas);
        panelEstadisticas.add(etiquetaPartidasGanadas);
        panelEstadisticas.add(valorPartidasGanadas);
        panelEstadisticas.add(etiquetaTorneosJugados);
        panelEstadisticas.add(valorTorneosJugados);
        panelEstadisticas.add(etiquetaTorneosGanados);
        panelEstadisticas.add(valorTorneosGanados);

        panelInferior.add(panelEstadisticas, BorderLayout.CENTER);

        botonVolver = new JButton("Volver");
        botonVolver.setActionCommand("VOLVERDEJUGADORAINICIOSESION");
        JPanel panelBotonDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        panelBotonDerecha.add(botonVolver);
        panelInferior.add(panelBotonDerecha, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);
    }


    /**
     * Crea un panel con un JLabel centrado horizontalmente utilizando BoxLayout.
     * 
     * @param label El JLabel que se desea centrar en el panel
     * @return JPanel con el label centrado horizontalmente
     */
    private JPanel alinearCentro(JLabel label) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalGlue());
        panel.add(label);
        panel.add(Box.createHorizontalGlue());
        return panel;
    }

    /**
     * Actualiza todos los datos del jugador en la interfaz gráfica.
     * 
     * @param usuario Nombre de usuario del jugador
     * @param nacionalidad Nacionalidad del jugador
     * @param especialidad Área de especialización del jugador
     * @param correo Dirección de correo electrónico del jugador
     * @param equipo Nombre del equipo al que pertenece el jugador
     * @param partidasJugadas Número total de partidas jugadas
     * @param partidasGanadas Número de partidas ganadas
     * @param torneosJugados Número total de torneos participados
     * @param torneosGanados Número de torneos ganados
     */
    public void actualizarDatosJugador(
            String usuario, String nacionalidad, String especialidad, String correo, String equipo,
            int partidasJugadas, int partidasGanadas,
            int torneosJugados, int torneosGanados
    ) {
        valorUsuario.setText(usuario);
        valorNacionalidad.setText(nacionalidad);
        valorEspecialidad.setText(especialidad);
        valorCorreo.setText(correo);
        valorEquipo.setText(equipo);
        valorPartidasJugadas.setText(String.valueOf(partidasJugadas));
        valorPartidasGanadas.setText(String.valueOf(partidasGanadas));
        valorTorneosJugados.setText(String.valueOf(torneosJugados));
        valorTorneosGanados.setText(String.valueOf(torneosGanados));
    }

    /**
     * Obtiene la lista de torneos en los que participa el jugador
     * @return JList<String> con los torneos de participación
     */
    public JList<String> getListaTorneosParticipa() {
        return listaTorneosParticipa;
    }

    /**
     * Establece la lista de torneos en los que participa el jugador
     * @param listaTorneosParticipa JList<String> con los torneos de participación
     */
    public void setListaTorneosParticipa(JList<String> listaTorneosParticipa) {
        this.listaTorneosParticipa = listaTorneosParticipa;
    }

    /**
     * Obtiene la lista de torneos activos disponibles
     * @return JList<String> con los torneos activos
     */
    public JList<String> getListaTorneosActivos() {
        return listaTorneosActivos;
    }

    /**
     * Establece la lista de torneos activos disponibles
     * @param listaTorneosActivos JList<String> con los torneos activos
     */
    public void setListaTorneosActivos(JList<String> listaTorneosActivos) {
        this.listaTorneosActivos = listaTorneosActivos;
    }

    /**
     * Obtiene el botón para volver atrás
     * @return JButton de volver
     */
    public JButton getBotonVolver() {
        return botonVolver;
    }

    /**
     * Establece el botón para volver atrás
     * @param botonVolver JButton de volver
     */
    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }

    /**
     * Obtiene la etiqueta que contiene la imagen del jugador
     * @return JLabel con la imagen
     */
    public JLabel getEtiquetaImagen() {
        return etiquetaImagen;
    }

    /**
     * Establece la etiqueta que contiene la imagen del jugador
     * @param etiquetaImagen JLabel con la imagen
     */
    public void setEtiquetaImagen(JLabel etiquetaImagen) {
        this.etiquetaImagen = etiquetaImagen;
    }

    /**
     * Obtiene la etiqueta de texto "Usuario"
     * @return JLabel con el texto de usuario
     */
    public JLabel getEtiquetaUsuario() {
        return etiquetaUsuario;
    }

    // Continúan los demás getters y setters con el mismo formato...

    /**
     * Obtiene la etiqueta que muestra el valor del equipo
     * @return JLabel con el nombre del equipo
     */
    public JLabel getValorEquipo() {
        return valorEquipo;
    }

    /**
     * Establece la etiqueta que muestra el valor del equipo
     * @param valorEquipo JLabel con el nombre del equipo
     */
    public void setValorEquipo(JLabel valorEquipo) {
        this.valorEquipo = valorEquipo;
    }

    /**
     * Obtiene la etiqueta de texto "Partidas Jugadas"
     * @return JLabel con el texto
     */
    public JLabel getEtiquetaPartidasJugadas() {
        return etiquetaPartidasJugadas;
    }

    // ... (los demás métodos siguen el mismo patrón)

    /**
     * Obtiene la etiqueta que muestra el valor de torneos ganados
     * @return JLabel con la cantidad de torneos ganados
     */
    public JLabel getValorTorneosGanados() {
        return valorTorneosGanados;
    }

    /**
     * Establece la etiqueta que muestra el valor de torneos ganados
     * @param valorTorneosGanados JLabel con la cantidad de torneos ganados
     */
    public void setValorTorneosGanados(JLabel valorTorneosGanados) {
        this.valorTorneosGanados = valorTorneosGanados;
    }}