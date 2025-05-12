package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelCrearEquipo extends JPanel {

    private JTextField txtNombreEquipo;
    private JButton btnVolver;
    private JButton btnCrearEquipo;

    public PanelCrearEquipo() {
        setLayout(new BorderLayout(10, 20));
        inicializarComponentes();
       
    }
    public void inicializarComponentes() {
    	
    	 // Título
        JLabel lblInstruccion = new JLabel("Escriba nombre del equipo a crear", SwingConstants.CENTER);
        lblInstruccion.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblInstruccion, BorderLayout.NORTH);

        // Campo de texto centrado en el medio con panel contenedor
        JPanel panelCentro = new JPanel(new GridLayout(1, 1));
        txtNombreEquipo = new JTextField();
        txtNombreEquipo.setFont(new Font("Arial", Font.PLAIN, 16));
        panelCentro.add(txtNombreEquipo);
        add(panelCentro, BorderLayout.CENTER);

        // Botones en la parte inferior
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
        btnVolver = new JButton("Volver");
        btnCrearEquipo = new JButton("Crear Equipo");
        panelBotones.add(btnVolver);
        panelBotones.add(btnCrearEquipo);

        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters
    public JTextField getTxtNombreEquipo() {
        return txtNombreEquipo;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JButton getBtnCrearEquipo() {
        return btnCrearEquipo;
    }
}
