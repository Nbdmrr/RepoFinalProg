package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelRegistroAdmin extends PanelRegistro {

    private JTextField txtCargo;

    public PanelRegistroAdmin() {
    	
        super(); 
        
        agregarCampoCargo(); 
        
    }

    private void agregarCampoCargo() {
    	getLblTitulo().setText("Registro Administrador"); 
    	
        JPanel panelCargo = new JPanel(new BorderLayout());
        JLabel lblCargo = new JLabel("Cargo:");
        txtCargo = new JTextField();
        panelCargo.add(lblCargo, BorderLayout.NORTH);
        panelCargo.add(txtCargo, BorderLayout.CENTER);

        campoExtra1.add(panelCargo, BorderLayout.CENTER);
        campoExtra1.revalidate();
        campoExtra1.repaint();
    }

    public JTextField getTxtCargo() {
        return txtCargo;
    }
}
