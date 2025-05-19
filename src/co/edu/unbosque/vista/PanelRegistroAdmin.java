package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Panel específico para el registro de administradores, extendiendo la funcionalidad
 * del panel de registro base (PanelRegistro).
 * Permite a los usuarios ingresar información adicional requerida para el registro
 * de un administrador, como el cargo.
 */
public class PanelRegistroAdmin extends PanelRegistro {

    private JTextField txtCargo;

    /**
     * Constructor de la clase PanelRegistroAdmin.
     * Inicializa el panel llamando al constructor de la clase base y agregando
     * el campo específico para el registro de administradores.
     */
    public PanelRegistroAdmin() {
        
        super(); 
        
        agregarCampoCargo(); 
        
    }

    /**
     * Agrega el campo específico para el registro de administradores al panel.
     * Este campo incluye un campo de texto para el cargo del administrador.
     */
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
        btnVolver.setActionCommand("VOLVERDEREGISTROADMINAPRINCIPALADMIN");
        btnRegistrarse.setActionCommand("REGISTRARADMIN");
    }

    /**
     * Devuelve el campo de texto para el cargo del administrador.
     * @return JTextField Campo de texto para el cargo.
     */
    public JTextField getTxtCargo() {
        return txtCargo;
    }

    /**
     * Establece el campo de texto para el cargo del administrador.
     * @param txtCargo Campo de texto para el cargo.
     */
    public void setTxtCargo(JTextField txtCargo) {
        this.txtCargo = txtCargo;
    }

}