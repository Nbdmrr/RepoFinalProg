package co.edu.unbosque.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Ventana para la interfaz de inicio de sesión.
 * Permite a los usuarios ingresar sus credenciales para acceder al sistema.
 */
public class VentanaInicioSesion extends JFrame{

    private PanelInicioSesion panelInicioSesion;

    /**
     * Constructor de la clase VentanaInicioSesion.
     * Inicializa la ventana con sus componentes y propiedades.
     */
    public VentanaInicioSesion() {
        setTitle("Inicio sesion");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        
        
        setPanelInicioSesion(new PanelInicioSesion());
        add(getPanelInicioSesion());
        
        
        setVisible(true);

    }

    /**
     * Devuelve el panel de inicio de sesión.
     * @return PanelInicioSesion
     */
    public PanelInicioSesion getPanelInicioSesion() {
        return panelInicioSesion;
    }

    /**
     * Establece el panel de inicio de sesión.
     * @param panelInicioSesion PanelInicioSesion
     */
    public void setPanelInicioSesion(PanelInicioSesion panelInicioSesion) {
        this.panelInicioSesion = panelInicioSesion;
    }	
    
    
    
    
    
    
    

}