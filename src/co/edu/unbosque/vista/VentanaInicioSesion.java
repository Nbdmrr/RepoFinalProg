package co.edu.unbosque.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaInicioSesion extends JFrame{

	private PanelInicioSesion panelInicioSesion;

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

	public PanelInicioSesion getPanelInicioSesion() {
		return panelInicioSesion;
	}

	public void setPanelInicioSesion(PanelInicioSesion panelInicioSesion) {
		this.panelInicioSesion = panelInicioSesion;
	}	
	
	
	
	
	
	
	

}
