package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelRegistroEntrenador extends PanelRegistro {

    private JTextField txtEquipo;

    public PanelRegistroEntrenador() {
        super();

       agregarCampo();
    }
    public void agregarCampo() {
    	
    	getLblTitulo().setText("Registro Entrenador"); 
    JPanel panelEquipo = new JPanel(new BorderLayout());
    JLabel lblEquipo = new JLabel("Equipo:");
    txtEquipo = new JTextField();
    panelEquipo.add(lblEquipo, BorderLayout.NORTH);
    panelEquipo.add(txtEquipo, BorderLayout.CENTER);

    // Agregar al campoExtra1 o campoExtra2 (si ya está ocupado)
    campoExtra1.add(panelEquipo, BorderLayout.CENTER);

    campoExtra1.revalidate();
    campoExtra1.repaint();
    btnVolver.setActionCommand("VOLVERAINICIOSESIONDEREGISTROENTRENADOR");
    btnRegistrarse.setActionCommand("REGISTRARENTRENADOR");
    }

    public JTextField getTxtEquipo() {
        return txtEquipo;
    }
}
