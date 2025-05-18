package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que contiene los botones para avanzar fases del torneo, iniciar el torneo,
 * acceder al cronograma y volver a la pantalla anterior.
 * Organizado en una cuadrícula de 3 filas por 3 columnas.
 */
public class PanelAvanceYInicioTorneo extends JPanel {

    /**
     * Botón para volver a la pantalla anterior.
     */
    private JButton btnVolver;

    /**
     * Botón para avanzar a la siguiente fase del torneo.
     */
    private JButton btnAvanzarFase;

    /**
     * Botón para mostrar el cronograma del torneo.
     */
    private JButton btnCronograma;

    /**
     * Botón para iniciar el torneo. Inicialmente está oculto.
     */
    private JButton btnIniciarTorneo;

    /**
     * Constructor que inicializa el panel con un layout de cuadrícula (3x3)
     * y los componentes correspondientes.
     */
    public PanelAvanceYInicioTorneo() {
        setLayout(new GridLayout(3, 3));
        inicializarComponentes();
    }

    /**
     * Inicializa y añade los componentes gráficos al panel.
     */
    public void inicializarComponentes() {
        add(new JLabel());
        btnAvanzarFase = new JButton("Avanzar Fase");
        add(btnAvanzarFase);
        add(new JLabel());

        add(new JLabel());
        btnIniciarTorneo = new JButton("Iniciar Torneo");
        btnIniciarTorneo.setVisible(false);
        add(btnIniciarTorneo);
        add(new JLabel());

        btnVolver = new JButton("Volver");
        add(btnVolver);
        add(new JLabel());
        btnCronograma = new JButton("Cronograma");
        add(btnCronograma);
    }

    /**
     * Devuelve el botón para volver a la pantalla anterior.
     * 
     * @return el botón Volver
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Establece el botón para volver a la pantalla anterior.
     * 
     * @param btnVolver el botón Volver a establecer
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Devuelve el botón para avanzar a la siguiente fase del torneo.
     * 
     * @return el botón Avanzar Fase
     */
    public JButton getBtnAvanzarFase() {
        return btnAvanzarFase;
    }

    /**
     * Establece el botón para avanzar a la siguiente fase del torneo.
     * 
     * @param btnAvanzarFase el botón Avanzar Fase a establecer
     */
    public void setBtnAvanzarFase(JButton btnAvanzarFase) {
        this.btnAvanzarFase = btnAvanzarFase;
    }

    /**
     * Devuelve el botón para mostrar el cronograma del torneo.
     * 
     * @return el botón Cronograma
     */
    public JButton getBtnCronograma() {
        return btnCronograma;
    }

    /**
     * Establece el botón para mostrar el cronograma del torneo.
     * 
     * @param btnCronograma el botón Cronograma a establecer
     */
    public void setBtnCronograma(JButton btnCronograma) {
        this.btnCronograma = btnCronograma;
    }

    /**
     * Devuelve el botón para iniciar el torneo.
     * 
     * @return el botón Iniciar Torneo
     */
    public JButton getBtnIniciarTorneo() {
        return btnIniciarTorneo;
    }

    /**
     * Establece el botón para iniciar el torneo.
     * 
     * @param btnIniciarTorneo el botón Iniciar Torneo a establecer
     */
    public void setBtnIniciarTorneo(JButton btnIniciarTorneo) {
        this.btnIniciarTorneo = btnIniciarTorneo;
    }
}
