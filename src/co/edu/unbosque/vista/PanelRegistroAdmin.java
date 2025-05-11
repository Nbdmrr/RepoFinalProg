package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelRegistroAdmin extends PanelRegistro {

    private JTextField txtCargo;

    public PanelRegistroAdmin() {
        super();

        // Crear el campo "Cargo"
        JPanel panelCargo = new JPanel(new BorderLayout());
        JLabel lblCargo = new JLabel("Cargo:");
        txtCargo = new JTextField();
        panelCargo.add(lblCargo, BorderLayout.NORTH);
        panelCargo.add(txtCargo, BorderLayout.CENTER);

        // Agregar al campo extra y actualizar visualmente
        campoExtra1.add(panelCargo, BorderLayout.CENTER);
        campoExtra1.revalidate();
        campoExtra1.repaint();
    }

    public JTextField getTxtCargo() {
        return txtCargo;
    }
}
