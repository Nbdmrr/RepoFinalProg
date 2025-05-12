package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipalJugador extends JFrame{
	
	PanelPrincipalJugador panelPrincipalJugador;
	public VentanaPrincipalJugador() {
		setTitle("Jugador");
		setSize(1100, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		panelPrincipalJugador = new PanelPrincipalJugador();
		add(panelPrincipalJugador);
		setVisible(false);
	}

}
