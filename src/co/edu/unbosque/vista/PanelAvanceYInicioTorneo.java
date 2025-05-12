package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelAvanceYInicioTorneo extends JPanel {

    private JButton btnVolver;
    private JButton btnAvanzarFase;
    private JButton btnCronograma;
    private JButton btnIniciarTorneo; 

    public PanelAvanceYInicioTorneo() {
        setLayout(new GridLayout(3, 3)); // Grid de 3x3 con espacio entre celdas
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        // Fila 1
        add(new JLabel());  // celda (0,0) vacía
        btnAvanzarFase = new JButton("Avanzar Fase");
        add(btnAvanzarFase); // celda (0,1)
        add(new JLabel());  // celda (0,2)

        // Fila 2
        add(new JLabel());  // celda (1,0)
        btnIniciarTorneo = new JButton("Iniciar Torneo");
        btnIniciarTorneo.setVisible(false);  // invisible al inicio
        add(btnIniciarTorneo); // celda (1,1)
        add(new JLabel());  // celda (1,2)

        // Fila 3
        btnVolver = new JButton("Volver");
        add(btnVolver); // celda (2,0)
        add(new JLabel());  // celda (2,1)
        btnCronograma = new JButton("Cronograma");
        add(btnCronograma); // celda (2,2)
    }

    // Getters
    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JButton getBtnAvanzarFase() {
        return btnAvanzarFase;
    }

    public JButton getBtnCronograma() {
        return btnCronograma;
    }

    public JButton getBtnIniciarTorneo() {
        return btnIniciarTorneo;
    }
}
