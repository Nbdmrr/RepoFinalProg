package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipalJugador extends JFrame{
	
	private PanelPrincipalJugador panelPrincipalJugador;
	public VentanaPrincipalJugador() {
		setTitle("Jugador");
		setSize(1100, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		setPanelPrincipalJugador(new PanelPrincipalJugador());
		add(getPanelPrincipalJugador());
		setVisible(false);
	}
	public PanelPrincipalJugador getPanelPrincipalJugador() {
		return panelPrincipalJugador;
	}
	public void setPanelPrincipalJugador(PanelPrincipalJugador panelPrincipalJugador) {
		this.panelPrincipalJugador = panelPrincipalJugador;
	}

}
