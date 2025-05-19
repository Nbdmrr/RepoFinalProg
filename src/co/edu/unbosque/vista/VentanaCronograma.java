package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana para mostrar el cronograma de un torneo.
 * Permite visualizar la programación de los partidos y eventos del torneo.
 */
public class VentanaCronograma extends JFrame{
    
    
    
    private PanelCronograma panelCronograma;
    
    /**
     * Constructor de la clase VentanaCronograma.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaCronograma() {
        setTitle("Cronograma");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelCronograma(new PanelCronograma());
        add(getPanelCronograma());
        setVisible(false);
    }

    /**
     * Devuelve el panel del cronograma.
     * @return PanelCronograma
     */
    public PanelCronograma getPanelCronograma() {
        return panelCronograma;
    }

    /**
     * Establece el panel del cronograma.
     * @param panelCronograma PanelCronograma
     */
    public void setPanelCronograma(PanelCronograma panelCronograma) {
        this.panelCronograma = panelCronograma;
    }

}