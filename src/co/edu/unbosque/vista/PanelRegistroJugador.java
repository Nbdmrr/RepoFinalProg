package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelRegistroJugador extends PanelRegistro {

    private JTextField txtEspecialidad;
    private JComboBox<String> comboEquipo;

    public PanelRegistroJugador() {
        super();
        agregarCampos();
        
    }
    
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
    

    public void setEquipos(ArrayList<String> equipos) {
        comboEquipo.removeAllItems();
        if (equipos != null) {
            for (String equipo : equipos) {
                comboEquipo.addItem(equipo);
            }
        }
    }

	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}

	public void setTxtEspecialidad(JTextField txtEspecialidad) {
		this.txtEspecialidad = txtEspecialidad;
	}

	public JComboBox<String> getComboEquipo() {
		return comboEquipo;
	}

	public void setComboEquipo(JComboBox<String> comboEquipo) {
		this.comboEquipo = comboEquipo;
	}

    
}
