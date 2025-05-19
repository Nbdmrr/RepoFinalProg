package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel específico para el registro de jugadores, extendiendo la funcionalidad
 * del panel de registro base (PanelRegistro).
 * Permite a los usuarios ingresar información adicional requerida para el registro
 * de un jugador, como la especialidad y el equipo al que pertenece.
 */
public class PanelRegistroJugador extends PanelRegistro {

    private JTextField txtEspecialidad;
    private JComboBox<String> comboEquipo;

    /**
     * Constructor de la clase PanelRegistroJugador.
     * Inicializa el panel llamando al constructor de la clase base y agregando
     * los campos específicos para el registro de jugadores.
     */
    public PanelRegistroJugador() {
        super();
        agregarCampos();
        
    }
    
    /**
     * Agrega los campos específicos para el registro de jugadores al panel.
     * Estos campos incluyen un campo de texto para la especialidad y un combo box
     * para seleccionar el equipo al que pertenece el jugador.
     */
    public void agregarCampos() {
        
        getLblTitulo().setText("Registro jugador:"); 
    
        JPanel panelEspecialidad = new JPanel(new BorderLayout());
        JLabel lblEspecialidad = new JLabel("Especialidad:");
        txtEspecialidad = new JTextField();
        panelEspecialidad.add(lblEspecialidad, BorderLayout.NORTH);
        panelEspecialidad.add(txtEspecialidad, BorderLayout.CENTER);

        JPanel panelEquipo = new JPanel(new BorderLayout());
        JLabel lblEquipo = new JLabel("Equipo:");
        comboEquipo = new JComboBox<>();
        comboEquipo.setMaximumRowCount(10);
        panelEquipo.add(lblEquipo, BorderLayout.NORTH);
        panelEquipo.add(comboEquipo, BorderLayout.CENTER);

        campoExtra1.add(panelEspecialidad, BorderLayout.CENTER);
        campoExtra2.add(panelEquipo, BorderLayout.CENTER);

        campoExtra1.revalidate();
        campoExtra2.revalidate();
        campoExtra1.repaint();
        campoExtra2.repaint();
        btnVolver.setActionCommand("VOLVERAINICIOSESIONDEREGISTROJUGADOR");
        btnRegistrarse.setActionCommand("REGISTRARJUGADOR");
    }
    
    /**
     * Establece los equipos disponibles en el combo box de selección de equipo.
     * @param equipos Lista de nombres de equipos a mostrar en el combo box.
     */
    public void setEquipos(ArrayList<String> equipos) {
        comboEquipo.removeAllItems();
        if (equipos != null) {
            for (String equipo : equipos) {
                comboEquipo.addItem(equipo);
            }
        }
    }

    /**
     * Devuelve el campo de texto para la especialidad del jugador.
     * @return JTextField Campo de texto para la especialidad.
     */
    public JTextField getTxtEspecialidad() {
        return txtEspecialidad;
    }

    /**
     * Establece el campo de texto para la especialidad del jugador.
     * @param txtEspecialidad Campo de texto para la especialidad.
     */
    public void setTxtEspecialidad(JTextField txtEspecialidad) {
        this.txtEspecialidad = txtEspecialidad;
    }

    /**
     * Devuelve el combo box para la selección del equipo del jugador.
     * @return JComboBox<String> Combo box para la selección del equipo.
     */
    public JComboBox<String> getComboEquipo() {
        return comboEquipo;
    }

    /**
     * Establece el combo box para la selección del equipo del jugador.
     * @param comboEquipo Combo box para la selección del equipo.
     */
    public void setComboEquipo(JComboBox<String> comboEquipo) {
        this.comboEquipo = comboEquipo;
    }

    
}