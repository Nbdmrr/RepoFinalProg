package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana para la creación de un nuevo torneo.
 * Permite a los usuarios crear y configurar un nuevo torneo en el sistema.
 */
public class VentanaCrearTorneo extends JFrame{
    
    private PanelCrearTorneo panelCrearTorneo;

    /**
     * Constructor de la clase VentanaCrearTorneo.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaCrearTorneo() {
        setTitle("Crear Torneo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelCrearTorneo(new PanelCrearTorneo());
        add(getPanelCrearTorneo());
        setVisible(false);
    }

    /**
     * Devuelve el panel de creación del torneo.
     * @return PanelCrearTorneo
     */
    public PanelCrearTorneo getPanelCrearTorneo() {
        return panelCrearTorneo;
    }

    /**
     * Establece el panel de creación del torneo.
     * @param panelCrearTorneo PanelCrearTorneo
     */
    public void setPanelCrearTorneo(PanelCrearTorneo panelCrearTorneo) {
        this.panelCrearTorneo = panelCrearTorneo;
    }

}