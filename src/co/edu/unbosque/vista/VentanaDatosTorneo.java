package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana para mostrar los datos de un torneo.
 * Permite visualizar la información relevante del torneo.
 */
public class VentanaDatosTorneo extends JFrame{
    
    
    private PanelDatosTorneo panelDatosTorneo;
    
    /**
     * Constructor de la clase VentanaDatosTorneo.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaDatosTorneo() {
        setTitle("Datos del torneo");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelDatosTorneo(new PanelDatosTorneo());
        add(getPanelDatosTorneo());
        setVisible(false);
    }

    /**
     * Devuelve el panel de datos del torneo.
     * @return PanelDatosTorneo
     */
    public PanelDatosTorneo getPanelDatosTorneo() {
        return panelDatosTorneo;
    }

    /**
     * Establece el panel de datos del torneo.
     * @param panelDatosTorneo PanelDatosTorneo
     */
    public void setPanelDatosTorneo(PanelDatosTorneo panelDatosTorneo) {
        this.panelDatosTorneo = panelDatosTorneo;
    }

}