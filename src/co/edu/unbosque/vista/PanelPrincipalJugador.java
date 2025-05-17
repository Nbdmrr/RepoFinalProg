package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

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

    // Nuevos atributos (estadísticas)
    private JLabel etiquetaPartidasJugadas;
    private JLabel valorPartidasJugadas;
    private JLabel etiquetaPartidasGanadas;
    private JLabel valorPartidasGanadas;
    private JLabel etiquetaTorneosJugados;
    private JLabel valorTorneosJugados;
    private JLabel etiquetaTorneosGanados;
    private JLabel valorTorneosGanados;

    public PanelPrincipalJugador() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1100, 500));

        // Panel central con listas
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

        // Panel derecha con imagen y datos personales
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

        // Cargar la imagen cuadrada
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

        // Panel inferior que contiene estadísticas y botón Volver
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());

        // Panel de estadísticas
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

        // Botón "Volver" alineado a la derecha
        botonVolver = new JButton("Volver");
        botonVolver.setActionCommand("VOLVERDEJUGADORAINICIOSESION");
        JPanel panelBotonDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        panelBotonDerecha.add(botonVolver);
        panelInferior.add(panelBotonDerecha, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private JPanel alinearCentro(JLabel label) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalGlue());
        panel.add(label);
        panel.add(Box.createHorizontalGlue());
        return panel;
    }
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



    public JList<String> getListaTorneosParticipa() { return listaTorneosParticipa; }
    public JList<String> getListaTorneosActivos() { return listaTorneosActivos; }
    public JButton getBotonVolver() { return botonVolver; }
    public JLabel getEtiquetaImagen() { return etiquetaImagen; }
    public JLabel getValorUsuario() { return valorUsuario; }
    public JLabel getValorNacionalidad() { return valorNacionalidad; }
    public JLabel getValorEspecialidad() { return valorEspecialidad; }
    public JLabel getValorCorreo() { return valorCorreo; }
    public JLabel getValorEquipo() { return valorEquipo; }

    public JLabel getValorPartidasJugadas() { return valorPartidasJugadas; }
    public JLabel getValorPartidasGanadas() { return valorPartidasGanadas; }
    public JLabel getValorTorneosJugados() { return valorTorneosJugados; }
    public JLabel getValorTorneosGanados() { return valorTorneosGanados; }
}
