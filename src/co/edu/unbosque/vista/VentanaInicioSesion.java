package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaInicioSesion extends JFrame{

	PanelInicioSesion panelInicioSesion;

	public VentanaInicioSesion() {
		setTitle("Inicio sesion");
		setSize(1600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		
		
		
		panelInicioSesion = new PanelInicioSesion();
		add(panelInicioSesion);
		
		setVisible(true);

	}	
	
	
	
	
	
	
	

}
