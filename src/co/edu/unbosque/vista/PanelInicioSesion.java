package co.edu.unbosque.vista;

import java.awt.*;
import javax.swing.*;

public class PanelInicioSesion extends JPanel {

    private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarJugador;
    private JButton btnRegistrarEntrenador;

    public PanelInicioSesion() {
        setLayout(null);
        inicializarComponentes();
        setPreferredSize(new Dimension(700, 400)); // Tamaño ajustado
    }

    public void inicializarComponentes() {
        // Fondo
        JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/logo.jpg")));
        lblFondo.setBounds(0, 0, 700, 400);  // Fondo ajustado a 700x400
        add(lblFondo);

        // Título centrado
        lblTitulo = new JLabel("Bienvenidos a NeoLeague Arena", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));  // Fuente ajustada
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setBounds(150, 30, 400, 40);  // Posición ajustada
        lblFondo.add(lblTitulo);

        // Etiquetas de Usuario y Contraseña
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setBounds(170, 100, 100, 30);  // Posición ajustada
        lblFondo.add(lblUsuario);

        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setForeground(Color.BLACK);
        lblContrasena.setBounds(170, 150, 100, 30);  // Posición ajustada
        lblFondo.add(lblContrasena);

        // Campos de usuario y contraseña
        txtUsuario = new JTextField();
        txtUsuario.setBounds(250, 100, 200, 30);  // Ajustado
        lblFondo.add(txtUsuario);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(250, 150, 200, 30);  // Ajustado
        lblFondo.add(txtContrasena);

        // Botones
        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setBounds(275, 270, 150, 40);  // Ajustado
        lblFondo.add(btnIniciarSesion);

        btnRegistrarJugador = new JButton("Registrar Jugador");
        btnRegistrarJugador.setBounds(350, 220, 200, 40);  // Ajustado
        lblFondo.add(btnRegistrarJugador);
        
        btnRegistrarEntrenador = new JButton("Registrar Entrenador");
        btnRegistrarEntrenador.setBounds(150, 220, 200, 40);  // Ajustado
        lblFondo.add(btnRegistrarEntrenador);
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public JButton getBtnRegistrarJugador() {
        return btnRegistrarJugador;
    }

    public JButton getBtnRegistrarEntrenador() {
        return btnRegistrarEntrenador;
    }
}
