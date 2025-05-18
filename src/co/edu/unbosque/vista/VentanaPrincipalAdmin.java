package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana principal para la interfaz de usuario del administrador.
 * Muestra las opciones y funcionalidades disponibles para el administrador.
 */
public class VentanaPrincipalAdmin extends JFrame{
    
    private PanelPrincipalAdmin panelPrincipalAdmin;

    /**
     * Constructor de la clase VentanaPrincipalAdmin.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaPrincipalAdmin() {
        setTitle("Administrador");
        setSize(1100, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        setPanelPrincipalAdmin(new PanelPrincipalAdmin());
        add(getPanelPrincipalAdmin());
        setVisible(false);
    }

    /**
     * Devuelve el panel principal del administrador.
     * @return PanelPrincipalAdmin
     */
    public PanelPrincipalAdmin getPanelPrincipalAdmin() {
        return panelPrincipalAdmin;
    }

    /**
     * Establece el panel principal del administrador.
     * @param panelPrincipalAdmin PanelPrincipalAdmin
     */
    public void setPanelPrincipalAdmin(PanelPrincipalAdmin panelPrincipalAdmin) {
        this.panelPrincipalAdmin = panelPrincipalAdmin;
    }

}