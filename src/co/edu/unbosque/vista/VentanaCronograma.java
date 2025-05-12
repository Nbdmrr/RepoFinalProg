package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaCronograma extends JFrame{
	
	
	
	PanelCronograma panelCronograma;
	
	public VentanaCronograma() {
		setTitle("Cronograma");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		panelCronograma = new PanelCronograma();
		add(panelCronograma);
		setVisible(false);
	}

}
