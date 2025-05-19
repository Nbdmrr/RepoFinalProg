package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana principal para la interfaz de usuario del entrenador.
 * Muestra las opciones y funcionalidades disponibles para el entrenador.
 */
public class VentanaPrincipalEntrenador extends JFrame{
    
    private PanelPrincipalEntrenador panelPrincipalEntrenador;

    /**
     * Constructor de la clase VentanaPrincipalEntrenador.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaPrincipalEntrenador() {
        setTitle("Entrenador");
        setSize(1100, 500);		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelPrincipalEntrenador(new PanelPrincipalEntrenador());
        add(getPanelPrincipalEntrenador());
        setVisible(false);
    }

    /**
     * Devuelve el panel principal del entrenador.
     * @return PanelPrincipalEntrenador
     */
    public PanelPrincipalEntrenador getPanelPrincipalEntrenador() {
        return panelPrincipalEntrenador;
    }

    /**
     * Establece el panel principal del entrenador.
     * @param panelPrincipalEntrenador PanelPrincipalEntrenador
     */
    public void setPanelPrincipalEntrenador(PanelPrincipalEntrenador panelPrincipalEntrenador) {
        this.panelPrincipalEntrenador = panelPrincipalEntrenador;
    }

}