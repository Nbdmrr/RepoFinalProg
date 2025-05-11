package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaRegistroAdmin extends JFrame{
	
	PanelRegistro panelRegistroAdmin;
	public VentanaRegistroAdmin() {
		setTitle("Registro Administrador");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		panelRegistroAdmin=new PanelRegistro();
		add(panelRegistroAdmin);
		setVisible(true);
	}

}
