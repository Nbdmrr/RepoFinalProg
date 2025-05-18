package co.edu.unbosque.vista;

import java.awt.*;
import javax.swing.*;

/**
 * Panel que representa la interfaz de inicio de sesión.
 * Contiene campos para ingresar usuario y contraseña,
 * botones para iniciar sesión y para registrar jugadores o entrenadores,
 * además de un fondo con logo y etiquetas descriptivas.
 */
public class PanelInicioSesion extends JPanel {

    /**
     * Etiqueta del título principal del panel.
     */
    private JLabel lblTitulo;

    /**
     * Etiqueta que indica el campo de usuario.
     */
    private JLabel lblUsuario;

    /**
     * Etiqueta que indica el campo de contraseña.
     */
    private JLabel lblContrasena;

    /**
     * Campo de texto para ingresar el usuario.
     */
    private JTextField txtUsuario;

    /**
     * Campo para ingresar la contraseña.
     */
    private JPasswordField txtContrasena;

    /**
     * Botón para iniciar sesión.
     */
    private JButton btnIniciarSesion;

    /**
     * Botón para abrir el registro de jugador.
     */
    private JButton btnRegistrarJugador;

    /**
     * Botón para abrir el registro de entrenador.
     */
    private JButton btnRegistrarEntrenador;

    /**
     * Constructor que inicializa el panel y sus componentes,
     * estableciendo el layout y tamaño preferido.
     */
    public PanelInicioSesion() {
        setLayout(null);
        inicializarComponentes();
        setPreferredSize(new Dimension(700, 400)); 
    }

    /**
     * Método que crea y posiciona todos los componentes gráficos
     * dentro del panel, incluyendo etiquetas, campos de texto, botones y fondo.
     */
    public void inicializarComponentes() {
   
        JLabel lblFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/logo.jpg")));
        lblFondo.setBounds(0, 0, 700, 400);  
        add(lblFondo);

        lblTitulo = new JLabel("Bienvenidos a NeoLeague Arena", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));  
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setBounds(150, 30, 400, 40);  
        lblFondo.add(lblTitulo);

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setBounds(170, 100, 100, 30);  
        lblFondo.add(lblUsuario);

        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setForeground(Color.BLACK);
        lblContrasena.setBounds(170, 150, 100, 30); 
        lblFondo.add(lblContrasena);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(250, 100, 200, 30); 
        lblFondo.add(txtUsuario);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(250, 150, 200, 30); 
        lblFondo.add(txtContrasena);

        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnIniciarSesion.setBounds(275, 270, 150, 40);
        btnIniciarSesion.setActionCommand("INICIARSESION");
        lblFondo.add(btnIniciarSesion);

        btnRegistrarJugador = new JButton("Registrar Jugador");
        btnRegistrarJugador.setBounds(350, 220, 200, 40); 
        btnRegistrarJugador.setActionCommand("ABRIRREGISTROJUGADOR");
        lblFondo.add(btnRegistrarJugador);
        
        btnRegistrarEntrenador = new JButton("Registrar Entrenador");
        btnRegistrarEntrenador.setActionCommand("ABRIRREGISTROENTRENADOR");
        btnRegistrarEntrenador.setBounds(150, 220, 200, 40); 
        lblFondo.add(btnRegistrarEntrenador);
    }

    /**
     * Devuelve la etiqueta del título.
     * 
     * @return JLabel del título
     */
    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    /**
     * Establece la etiqueta del título.
     * 
     * @param lblTitulo JLabel a establecer
     */
    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    /**
     * Devuelve la etiqueta del usuario.
     * 
     * @return JLabel del usuario
     */
    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    /**
     * Establece la etiqueta del usuario.
     * 
     * @param lblUsuario JLabel a establecer
     */
    public void setLblUsuario(JLabel lblUsuario) {
        this.lblUsuario = lblUsuario;
    }

    /**
     * Devuelve la etiqueta de la contraseña.
     * 
     * @return JLabel de la contraseña
     */
    public JLabel getLblContrasena() {
        return lblContrasena;
    }

    /**
     * Establece la etiqueta de la contraseña.
     * 
     * @param lblContrasena JLabel a establecer
     */
    public void setLblContrasena(JLabel lblContrasena) {
        this.lblContrasena = lblContrasena;
    }

    /**
     * Devuelve el campo de texto para el usuario.
     * 
     * @return JTextField del usuario
     */
    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    /**
     * Establece el campo de texto para el usuario.
     * 
     * @param txtUsuario JTextField a establecer
     */
    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    /**
     * Devuelve el campo de texto para la contraseña.
     * 
     * @return JPasswordField de la contraseña
     */
    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }

    /**
     * Establece el campo de texto para la contraseña.
     * 
     * @param txtContrasena JPasswordField a establecer
     */
    public void setTxtContrasena(JPasswordField txtContrasena) {
        this.txtContrasena = txtContrasena;
    }

    /**
     * Devuelve el botón para iniciar sesión.
     * 
     * @return JButton de iniciar sesión
     */
    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    /**
     * Establece el botón para iniciar sesión.
     * 
     * @param btnIniciarSesion JButton a establecer
     */
    public void setBtnIniciarSesion(JButton btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    /**
     * Devuelve el botón para registrar un jugador.
     * 
     * @return JButton de registrar jugador
     */
    public JButton getBtnRegistrarJugador() {
        return btnRegistrarJugador;
    }

    /**
     * Establece el botón para registrar un jugador.
     * 
     * @param btnRegistrarJugador JButton a establecer
     */
    public void setBtnRegistrarJugador(JButton btnRegistrarJugador) {
        this.btnRegistrarJugador = btnRegistrarJugador;
    }

    /**
     * Devuelve el botón para registrar un entrenador.
     * 
     * @return JButton de registrar entrenador
     */
    public JButton getBtnRegistrarEntrenador() {
        return btnRegistrarEntrenador;
    }

    /**
     * Establece el botón para registrar un entrenador.
     * 
     * @param btnRegistrarEntrenador JButton a establecer
     */
    public void setBtnRegistrarEntrenador(JButton btnRegistrarEntrenador) {
        this.btnRegistrarEntrenador = btnRegistrarEntrenador;
    }
}
