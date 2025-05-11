package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaRegistroEntrenador extends JFrame{
	
	
	public VentanaRegistroEntrenador() {
		setTitle("Registro entrenador");
		setSize(1000, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		
		setVisible(false);
	}

}
