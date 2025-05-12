package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaCrearTorneo extends JFrame{
	
	PanelCrearTorneo panelCrearTorneo;
	public VentanaCrearTorneo() {
		setTitle("Crear Torneo");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		panelCrearTorneo = new PanelCrearTorneo();
		add(panelCrearTorneo);
		setVisible(false);
	}

}
