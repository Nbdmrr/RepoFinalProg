package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana principal para la interfaz de usuario del jugador.
 * Muestra las opciones y funcionalidades disponibles para el jugador.
 */
public class VentanaPrincipalJugador extends JFrame{
    
    private PanelPrincipalJugador panelPrincipalJugador;

    /**
     * Constructor de la clase VentanaPrincipalJugador.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaPrincipalJugador() {
        setTitle("Jugador");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelPrincipalJugador(new PanelPrincipalJugador());
        add(getPanelPrincipalJugador());
        setVisible(false);
    }

    /**
     * Devuelve el panel principal del jugador.
     * @return PanelPrincipalJugador
     */
    public PanelPrincipalJugador getPanelPrincipalJugador() {
        return panelPrincipalJugador;
    }

    /**
     * Establece el panel principal del jugador.
     * @param panelPrincipalJugador PanelPrincipalJugador
     */
    public void setPanelPrincipalJugador(PanelPrincipalJugador panelPrincipalJugador) {
        this.panelPrincipalJugador = panelPrincipalJugador;
    }

}