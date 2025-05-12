package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaRegistroEntrenador extends JFrame{
	
	private PanelRegistroEntrenador panelRegistroEntrenador;
	public VentanaRegistroEntrenador() {
		setTitle("Registro entrenador");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		setPanelRegistroEntrenador(new PanelRegistroEntrenador());
		add(getPanelRegistroEntrenador());
		setVisible(false);
	}
	public PanelRegistroEntrenador getPanelRegistroEntrenador() {
		return panelRegistroEntrenador;
	}
	public void setPanelRegistroEntrenador(PanelRegistroEntrenador panelRegistroEntrenador) {
		this.panelRegistroEntrenador = panelRegistroEntrenador;
	}

}
