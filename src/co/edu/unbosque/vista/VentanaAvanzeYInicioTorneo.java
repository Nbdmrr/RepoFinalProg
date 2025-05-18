package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Ventana para mostrar el avance y permitir el inicio de un torneo.
 * Permite visualizar el estado actual del torneo y ofrece la opción de iniciarlo.
 */
public class VentanaAvanzeYInicioTorneo extends JFrame{
    
    PanelAvanceYInicioTorneo panelAvanceYInicioTorneo;

    /**
     * Constructor de la clase VentanaAvanzeYInicioTorneo.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaAvanzeYInicioTorneo() {
        setTitle("AvanzeTorneo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        panelAvanceYInicioTorneo= new PanelAvanceYInicioTorneo();
        add(panelAvanceYInicioTorneo,BorderLayout.CENTER);
        setVisible(false);
    }

    /**
     * Devuelve el panel de avance e inicio del torneo.
     * @return PanelAvanceYInicioTorneo
     */
    public PanelAvanceYInicioTorneo getPanelAvanceYInicioTorneo() {
        return panelAvanceYInicioTorneo;
    }

    /**
     * Establece el panel de avance e inicio del torneo.
     * @param panelAvanceYInicioTorneo PanelAvanceYInicioTorneo
     */
    public void setPanelAvanceYInicioTorneo(PanelAvanceYInicioTorneo panelAvanceYInicioTorneo) {
        this.panelAvanceYInicioTorneo = panelAvanceYInicioTorneo;
    }

}