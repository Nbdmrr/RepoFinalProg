package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaAvanzeTorneo extends JFrame{
	
	
	public VentanaAvanzeTorneo() {
		setTitle("AvanzeTorneo");
		setSize(1600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		
		setVisible(false);
	}

}
