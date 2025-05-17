package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaCrearTorneo extends JFrame{
	
	private PanelCrearTorneo panelCrearTorneo;
	public VentanaCrearTorneo() {
		setTitle("Crear Torneo");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		setPanelCrearTorneo(new PanelCrearTorneo());
		add(getPanelCrearTorneo());
		setVisible(false);
	}
	public PanelCrearTorneo getPanelCrearTorneo() {
		return panelCrearTorneo;
	}
	public void setPanelCrearTorneo(PanelCrearTorneo panelCrearTorneo) {
		this.panelCrearTorneo = panelCrearTorneo;
	}

}
