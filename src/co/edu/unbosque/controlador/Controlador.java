package co.edu.unbosque.controlador;

import co.edu.unbosque.vista.Vista;

public class Controlador {
	
	private Vista vista;
	
	
	
	public Controlador() {
		this.vista=new Vista();
	}

	public Vista getVista() {
		return vista;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

}