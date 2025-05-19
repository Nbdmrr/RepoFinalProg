package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana para el registro de un nuevo entrenador.
 * Permite a los usuarios registrarse en el sistema como entrenadores.
 */
public class VentanaRegistroEntrenador extends JFrame {

    private PanelRegistroEntrenador panelRegistroEntrenador;

    /**
     * Constructor de la clase VentanaRegistroEntrenador.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaRegistroEntrenador() {
        setTitle("Registro entrenador");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelRegistroEntrenador(new PanelRegistroEntrenador());
        add(getPanelRegistroEntrenador());
        setVisible(false);
    }

    /**
     * Devuelve el panel de registro del entrenador.
     * @return PanelRegistroEntrenador
     */
    public PanelRegistroEntrenador getPanelRegistroEntrenador() {
        return panelRegistroEntrenador;
    }

    /**
     * Establece el panel de registro del entrenador.
     * @param panelRegistroEntrenador PanelRegistroEntrenador
     */
    public void setPanelRegistroEntrenador(PanelRegistroEntrenador panelRegistroEntrenador) {
        this.panelRegistroEntrenador = panelRegistroEntrenador;
    }
}