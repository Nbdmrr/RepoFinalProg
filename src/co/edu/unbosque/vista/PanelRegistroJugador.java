package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelRegistroJugador extends PanelRegistro {

    private JTextField txtEspecialidad;
    private JComboBox<String> comboEquipo;

    public PanelRegistroJugador() {
        super();
        agregarCampos();
        
    }
    
    public void agregarCampos() {
    	// Campo especialidad
        JPanel panelEspecialidad = new JPanel(new BorderLayout());
        JLabel lblEspecialidad = new JLabel("Especialidad:");
        txtEspecialidad = new JTextField();
        panelEspecialidad.add(lblEspecialidad, BorderLayout.NORTH);
        panelEspecialidad.add(txtEspecialidad, BorderLayout.CENTER);

        // Campo equipo
        JPanel panelEquipo = new JPanel(new BorderLayout());
        JLabel lblEquipo = new JLabel("Equipo:");
        comboEquipo = new JComboBox<>();
        comboEquipo.setMaximumRowCount(10);
        panelEquipo.add(lblEquipo, BorderLayout.NORTH);
        panelEquipo.add(comboEquipo, BorderLayout.CENTER);

        // Agregar los campos personalizados a los paneles extra
        campoExtra1.add(panelEspecialidad, BorderLayout.CENTER);
        campoExtra2.add(panelEquipo, BorderLayout.CENTER);

        campoExtra1.revalidate();
        campoExtra2.revalidate();
        campoExtra1.repaint();
        campoExtra2.repaint();
    }

    // Método para cargar los equipos desde un arreglo de strings
    public void setEquipos(String[] equipos) {
        comboEquipo.removeAllItems();
        if (equipos != null) {
            for (String equipo : equipos) {
                comboEquipo.addItem(equipo);
            }
        }
    }

    // Getters
    public JTextField getTxtEspecialidad() {
        return txtEspecialidad;
    }

    public JComboBox<String> getComboEquipo() {
        return comboEquipo;
    }
}
