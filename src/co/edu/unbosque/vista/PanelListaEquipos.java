package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Panel que contiene una lista y un botón "Volver".
 */
public class PanelListaEquipos extends JPanel {

    private JList<String> listaElementos;
    private JButton btnVolver;

    /**
     * Constructor del panel.
     */
    public PanelListaEquipos() {
        setLayout(new BorderLayout());

        setListaElementos(new JList<>());
        JScrollPane scrollLista = new JScrollPane(getListaElementos());
        add(scrollLista, BorderLayout.CENTER);

        setBtnVolver(new JButton("Volver"));
        getBtnVolver().setActionCommand("VOLVERAPRINCIPALENTRENADORDELISTAEQUIPOS");
        JPanel panelBoton = new JPanel();
        panelBoton.add(getBtnVolver());
        add(panelBoton, BorderLayout.SOUTH);
    }

    /**
     * Actualiza la lista con los jugadores del equipo.
     * 
     * @param jugadores ArrayList de Strings con los nombres de los jugadores
     */
    public void actualizarLista(ArrayList<String> jugadores) {
        getListaElementos().setListData(jugadores.toArray(new String[0]));
    }

    /**
     * Agrega un ActionListener al botón "Volver".
     * 
     * @param listener ActionListener a agregar
     */
    public void addVolverListener(ActionListener listener) {
        getBtnVolver().addActionListener(listener);
    }

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JList<String> getListaElementos() {
		return listaElementos;
	}

	public void setListaElementos(JList<String> listaElementos) {
		this.listaElementos = listaElementos;
	}
}
