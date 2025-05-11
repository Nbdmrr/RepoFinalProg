package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaRegistroJugador extends JFrame{
	
	private PanelRegistroJugador panelRegistroJugador;
	
	
	public VentanaRegistroJugador() {
		setTitle("Registro jugador");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		setPanelRegistroJugador(new PanelRegistroJugador());
		add(getPanelRegistroJugador());
		setVisible(true);
	}


	public PanelRegistroJugador getPanelRegistroJugador() {
		return panelRegistroJugador;
	}


	public void setPanelRegistroJugador(PanelRegistroJugador panelRegistroJugador) {
		this.panelRegistroJugador = panelRegistroJugador;
	}

}
