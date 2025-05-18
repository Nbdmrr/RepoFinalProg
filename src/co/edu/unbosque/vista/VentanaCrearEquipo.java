package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaCrearEquipo extends JFrame{
	
	
	private PanelCrearEquipo panelCrearEquipo;
	public VentanaCrearEquipo() {
		
		setTitle("Crear Equipo");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		panelCrearEquipo = new PanelCrearEquipo();
		add(panelCrearEquipo);
		
		setVisible(false);
	}
	public PanelCrearEquipo getPanelCrearEquipo() {
		return panelCrearEquipo;
	}
	public void setPanelCrearEquipo(PanelCrearEquipo panelCrearEquipo) {
		this.panelCrearEquipo = panelCrearEquipo;
	}
	

}
