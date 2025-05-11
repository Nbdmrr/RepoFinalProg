package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelRegistroAdmin extends PanelRegistro {

    private JTextField txtCargo;

    public PanelRegistroAdmin() {
        // Crear y configurar el campo "Cargo"
        JPanel panelCargo = new JPanel(new BorderLayout());
        JLabel lblCargo = new JLabel("Cargo:");
        txtCargo = new JTextField();
        panelCargo.add(lblCargo, BorderLayout.NORTH);
        panelCargo.add(txtCargo, BorderLayout.CENTER);

        // Insertar en el espacio reservado del panel padre
        campoExtra1.add(panelCargo, BorderLayout.CENTER);
    }

    public JTextField getTxtCargo() {
        return txtCargo;
    }
}
