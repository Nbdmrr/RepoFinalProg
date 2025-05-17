package co.edu.unbosque.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipalAdmin extends JFrame{
	
	private PanelPrincipalAdmin panelPrincipalAdmin;
	public VentanaPrincipalAdmin() {
		setTitle("Administrador");
		setSize(1100, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(10, 10));

		setPanelPrincipalAdmin(new PanelPrincipalAdmin());
		add(getPanelPrincipalAdmin());
		setVisible(false);
		
		
	}
	public PanelPrincipalAdmin getPanelPrincipalAdmin() {
		return panelPrincipalAdmin;
	}
	public void setPanelPrincipalAdmin(PanelPrincipalAdmin panelPrincipalAdmin) {
		this.panelPrincipalAdmin = panelPrincipalAdmin;
	}

}
