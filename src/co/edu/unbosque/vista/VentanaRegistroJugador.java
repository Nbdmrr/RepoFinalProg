package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana para el registro de un nuevo jugador.
 * Permite a los usuarios registrarse en el sistema como jugadores.
 */
public class VentanaRegistroJugador extends JFrame {

    private PanelRegistroJugador panelRegistroJugador;

    /**
     * Constructor de la clase VentanaRegistroJugador.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaRegistroJugador() {
        setTitle("Registro jugador");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelRegistroJugador(new PanelRegistroJugador());
        add(getPanelRegistroJugador());
        setVisible(false);
    }

    /**
     * Devuelve el panel de registro del jugador.
     * @return PanelRegistroJugador
     */
    public PanelRegistroJugador getPanelRegistroJugador() {
        return panelRegistroJugador;
    }

    /**
     * Establece el panel de registro del jugador.
     * @param panelRegistroJugador PanelRegistroJugador
     */
    public void setPanelRegistroJugador(PanelRegistroJugador panelRegistroJugador) {
        this.panelRegistroJugador = panelRegistroJugador;
    }
}