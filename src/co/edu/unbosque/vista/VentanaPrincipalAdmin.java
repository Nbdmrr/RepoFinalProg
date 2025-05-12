package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipalAdmin extends JFrame{
	
	PanelPrincipalAdmin panelPrincipalAdmin;
	public VentanaPrincipalAdmin() {
		setTitle("Administrador");
		setSize(1100, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		panelPrincipalAdmin= new PanelPrincipalAdmin();
		add(panelPrincipalAdmin);
		setVisible(true);
		
		
	}

}
