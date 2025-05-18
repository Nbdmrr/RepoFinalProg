package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Panel específico para el registro de entrenadores, extendiendo la funcionalidad
 * del panel de registro base (PanelRegistro).
 * Permite a los usuarios ingresar información adicional requerida para el registro
 * de un entrenador, como el equipo al que pertenece.
 */
public class PanelRegistroEntrenador extends PanelRegistro {

    private JTextField txtEquipo;

    /**
     * Constructor de la clase PanelRegistroEntrenador.
     * Inicializa el panel llamando al constructor de la clase base y agregando
     * el campo específico para el registro de entrenadores.
     */
    public PanelRegistroEntrenador() {
        super();
        agregarCampo();
    }

    /**
     * Agrega el campo específico para el registro de entrenadores al panel.
     * Este campo incluye un campo de texto para el equipo al que pertenece el entrenador.
     */
    public void agregarCampo() {
        
        getLblTitulo().setText("Registro Entrenador"); 
        JPanel panelEquipo = new JPanel(new BorderLayout());
        JLabel lblEquipo = new JLabel("Equipo:");
        txtEquipo = new JTextField();
        panelEquipo.add(lblEquipo, BorderLayout.NORTH);
        panelEquipo.add(txtEquipo, BorderLayout.CENTER);

        campoExtra1.add(panelEquipo, BorderLayout.CENTER);

        campoExtra1.revalidate();
        campoExtra1.repaint();
        btnVolver.setActionCommand("VOLVERAINICIOSESIONDEREGISTROENTRENADOR");
        btnRegistrarse.setActionCommand("REGISTRARENTRENADOR");
    }

    /**
     * Devuelve el campo de texto para el equipo del entrenador.
     * @return JTextField Campo de texto para el equipo.
     */
    public JTextField getTxtEquipo() {
        return txtEquipo;
    }

    /**
     * Establece el campo de texto para el equipo del entrenador.
     * @param txtEquipo Campo de texto para el equipo.
     */
    public void setTxtEquipo(JTextField txtEquipo) {
        this.txtEquipo = txtEquipo;
    }
}