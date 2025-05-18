package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Ventana para la creación de un nuevo equipo.
 * Permite a los usuarios crear y configurar un nuevo equipo en el sistema.
 */
public class VentanaCrearEquipo extends JFrame{
    
    
    private PanelCrearEquipo panelCrearEquipo;

    /**
     * Constructor de la clase VentanaCrearEquipo.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaCrearEquipo() {
        
        setTitle("Crear Equipo");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        panelCrearEquipo = new PanelCrearEquipo();
        add(panelCrearEquipo);
        
        setVisible(false);
    }

    /**
     * Devuelve el panel de creación del equipo.
     * @return PanelCrearEquipo
     */
    public PanelCrearEquipo getPanelCrearEquipo() {
        return panelCrearEquipo;
    }

    /**
     * Establece el panel de creación del equipo.
     * @param panelCrearEquipo PanelCrearEquipo
     */
    public void setPanelCrearEquipo(PanelCrearEquipo panelCrearEquipo) {
        this.panelCrearEquipo = panelCrearEquipo;
    }
    

}