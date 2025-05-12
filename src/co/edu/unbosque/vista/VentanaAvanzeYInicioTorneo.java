package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaAvanzeYInicioTorneo extends JFrame{
	
	PanelAvanceYInicioTorneo panelAvanceYInicioTorneo;
	public VentanaAvanzeYInicioTorneo() {
		setTitle("AvanzeTorneo");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		panelAvanceYInicioTorneo= new PanelAvanceYInicioTorneo();
		add(panelAvanceYInicioTorneo,BorderLayout.CENTER);
		setVisible(false);
	}

}
