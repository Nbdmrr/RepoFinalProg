package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaDatosTorneo extends JFrame{
	
	
	PanelDatosTorneo panelDatosTorneo;
	
	public VentanaDatosTorneo() {
		setTitle("Datos del torneo");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		panelDatosTorneo = new PanelDatosTorneo();
		add(panelDatosTorneo);
		setVisible(false);
	}

}
