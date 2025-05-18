package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Panel para la creación de un nuevo equipo.
 * Contiene un campo de texto para ingresar el nombre del equipo,
 * y botones para crear el equipo o volver a la pantalla anterior.
 */
public class PanelCrearEquipo extends JPanel {

    /**
     * Campo de texto para ingresar el nombre del equipo a crear.
     */
    private JTextField txtNombreEquipo;

    /**
     * Botón para volver a la pantalla anterior.
     */
    private JButton btnVolver;

    /**
     * Botón para crear un nuevo equipo con el nombre especificado.
     */
    private JButton btnCrearEquipo;

    /**
     * Constructor que inicializa el layout y los componentes del panel.
     */
    public PanelCrearEquipo() {
        setLayout(new BorderLayout(10, 20));
        inicializarComponentes();
    }

    /**
     * Inicializa y añade los componentes gráficos al panel.
     * Incluye una etiqueta de instrucción, el campo de texto para el nombre,
     * y los botones para crear equipo y volver.
     */
    public void inicializarComponentes() {
        JLabel lblInstruccion = new JLabel("Escriba nombre del equipo a crear", SwingConstants.CENTER);
        lblInstruccion.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblInstruccion, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new GridLayout(1, 1));
        txtNombreEquipo = new JTextField();
        txtNombreEquipo.setFont(new Font("Arial", Font.PLAIN, 16));
        panelCentro.add(txtNombreEquipo);
        add(panelCentro, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
        btnVolver = new JButton("Volver");
        btnCrearEquipo = new JButton("Crear Equipo");
        panelBotones.add(btnVolver);
        panelBotones.add(btnCrearEquipo);

        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Devuelve el campo de texto para el nombre del equipo.
     * 
     * @return el JTextField donde se escribe el nombre del equipo
     */
    public JTextField getTxtNombreEquipo() {
        return txtNombreEquipo;
    }

    /**
     * Establece el campo de texto para el nombre del equipo.
     * 
     * @param txtNombreEquipo el JTextField a establecer
     */
    public void setTxtNombreEquipo(JTextField txtNombreEquipo) {
        this.txtNombreEquipo = txtNombreEquipo;
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
     * Devuelve el botón para crear un nuevo equipo.
     * 
     * @return el botón Crear Equipo
     */
    public JButton getBtnCrearEquipo() {
        return btnCrearEquipo;
    }

    /**
     * Establece el botón para crear un nuevo equipo.
     * 
     * @param btnCrearEquipo el botón Crear Equipo a establecer
     */
    public void setBtnCrearEquipo(JButton btnCrearEquipo) {
        this.btnCrearEquipo = btnCrearEquipo;
    }
}
