package co.edu.unbosque.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelInicioSesion extends JPanel {
    
    private JLabel lblTitulo;
    private JLabel lblImagen;
    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarJugador;
    private JButton btnRegistrarEntrenador;
    
    public PanelInicioSesion() {
        setLayout(new BorderLayout(10, 20));
        inicializarComponentes();
        setPreferredSize(new Dimension(1000, 800));
        
    }
    
    public void inicializarComponentes() {
    	
    	// Panel superior con título e imagen
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2, 20, 0));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título grande centrado
        lblTitulo = new JLabel("Bienvenidos a NeoLeague Arena", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Espacio para imagen (puedes reemplazar con una imagen real)
        lblImagen = new JLabel(); // Cambia por tu imagen
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblImagen);
        
        // Panel central con campos de usuario y contraseña
        JPanel panelCentral = new JPanel(new GridLayout(4, 1, 10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
        
        lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();
        
        lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField();
        
        panelCentral.add(lblUsuario);
        panelCentral.add(txtUsuario);
        panelCentral.add(lblContrasena);
        panelCentral.add(txtContrasena);
        
        // Panel inferior con botones
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(1,3));
        
        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnRegistrarJugador = new JButton("Registrar Jugador");
        btnRegistrarEntrenador = new JButton("Registrar Entrenador");
        
        panelInferior.add(btnIniciarSesion);
        panelInferior.add(btnRegistrarJugador);
        panelInferior.add(btnRegistrarEntrenador);
        
        // Agregar todos los paneles al panel principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        
        // Establecer bordes para mejor visualización
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    	
    	
    	
    	
    }
    
    // Getters para los componentes que necesiten ser accedidos desde fuera
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
