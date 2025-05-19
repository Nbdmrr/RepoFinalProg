package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana para el registro de un nuevo administrador.
 * Permite a los usuarios registrarse en el sistema como administradores.
 */
public class VentanaRegistroAdmin extends JFrame {

    private PanelRegistroAdmin panelRegistroAdmin;

    /**
     * Constructor de la clase VentanaRegistroAdmin.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaRegistroAdmin() {
        setTitle("Registro Administrador");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelRegistroAdmin(new PanelRegistroAdmin());
        add(getPanelRegistroAdmin());
        setVisible(false);
    }

    /**
     * Devuelve el panel de registro del administrador.
     * @return PanelRegistroAdmin
     */
    public PanelRegistroAdmin getPanelRegistroAdmin() {
        return panelRegistroAdmin;
    }

    /**
     * Establece el panel de registro del administrador.
     * @param panelRegistroAdmin PanelRegistroAdmin
     */
    public void setPanelRegistroAdmin(PanelRegistroAdmin panelRegistroAdmin) {
        this.panelRegistroAdmin = panelRegistroAdmin;
    }
}