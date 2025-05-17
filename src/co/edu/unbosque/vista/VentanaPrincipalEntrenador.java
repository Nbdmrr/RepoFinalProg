package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipalEntrenador extends JFrame{
	
	private PanelPrincipalEntrenador panelPrincipalEntrenador;
	public VentanaPrincipalEntrenador() {
		setTitle("Entrenador");
		setSize(1100, 500);		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		setPanelPrincipalEntrenador(new PanelPrincipalEntrenador());
		add(getPanelPrincipalEntrenador());
		setVisible(false);
	}
	public PanelPrincipalEntrenador getPanelPrincipalEntrenador() {
		return panelPrincipalEntrenador;
	}
	public void setPanelPrincipalEntrenador(PanelPrincipalEntrenador panelPrincipalEntrenador) {
		this.panelPrincipalEntrenador = panelPrincipalEntrenador;
	}

}
