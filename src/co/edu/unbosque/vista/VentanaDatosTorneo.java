package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaDatosTorneo extends JFrame{
	
	
	
	
	public VentanaDatosTorneo() {
		setTitle("Datos del torneo");
		setSize(1600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		
		setVisible(false);
	}

}
