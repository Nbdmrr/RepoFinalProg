package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana que contiene el panel de lista con botón "Volver".
 */
public class VentanaListaEquipos extends JFrame {

    private PanelListaEquipos panelListaEquipos;

    /**
     * Constructor de la ventana.
     */
    public VentanaListaEquipos() {
        setTitle("Lista de Jugadores");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelListaEquipos = new PanelListaEquipos();
        add(panelListaEquipos);
    }

    /**
     * Obtiene el panel de lista con botón "Volver".
     * 
     * @return PanelListaConVolver panel de lista
     */
    public PanelListaEquipos getPanelListaEquipos() {
        return panelListaEquipos;
    }
}
