package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelDatosTorneo extends JPanel {

    // Paneles internos
    private JPanel panelIzquierda;
    private JPanel panelDerecha;
    private JButton botonVolver;

    // Etiquetas para los datos del torneo
    private JLabel lblNombre;
    private JLabel lblParticipantesRestantes;
    private JLabel lblEliminados;
    private JLabel lblTipo;

    // JList para los participantes restantes
    private JList<String> listParticipantesRestantes;
    private DefaultListModel<String> listModel;

    public PanelDatosTorneo() {
        // Configuración básica del layout
        setLayout(new BorderLayout());

        // Inicializar los paneles
        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();

        // Configurar el layout de los paneles
        panelIzquierda.setLayout(new GridLayout(4, 1, 10, 10)); // 4 filas para las etiquetas
        panelDerecha.setLayout(new BorderLayout()); // JList con encabezado

        // Inicializar las etiquetas con texto por defecto
        lblNombre = new JLabel("Nombre: No disponible");
        lblParticipantesRestantes = new JLabel("Participantes Restantes: 0");
        lblEliminados = new JLabel("Eliminados: 0");
        lblTipo = new JLabel("Tipo: No especificado");

        // Cambiar el tamaño de la fuente de las etiquetas en la parte izquierda
        Font fuente = new Font("Arial", Font.BOLD, 16);
        lblNombre.setFont(fuente);
        lblParticipantesRestantes.setFont(fuente);
        lblEliminados.setFont(fuente);
        lblTipo.setFont(fuente);

        // Agregar las etiquetas al panel izquierdo
        panelIzquierda.add(lblNombre);
        panelIzquierda.add(lblParticipantesRestantes);
        panelIzquierda.add(lblEliminados);
        panelIzquierda.add(lblTipo);

        // Agregar el panel izquierdo al panel principal (izquierda)
        add(panelIzquierda, BorderLayout.WEST);

        // Inicializar el modelo de la lista y la JList
        listModel = new DefaultListModel<>();
        listParticipantesRestantes = new JList<>(listModel);

        // Configurar la JList para que sea scrollable
        JScrollPane scrollPane = new JScrollPane(listParticipantesRestantes);
        panelDerecha.add(new JLabel("Participantes Restantes"), BorderLayout.NORTH);
        panelDerecha.add(scrollPane, BorderLayout.CENTER);

        // Agregar el panel derecho al panel principal (centro)
        add(panelDerecha, BorderLayout.CENTER);

        // Panel inferior con el botón "Volver"
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonVolver = new JButton("Volver");
        panelInferior.add(botonVolver);

        // Agregar el panel inferior al panel principal (sur)
        add(panelInferior, BorderLayout.SOUTH);
    }


    // Métodos para actualizar los datos
    public void actualizarNombre(String nombre) {
        getLblNombre().setText("Nombre: " + nombre);
    }

    public void actualizarParticipantesRestantes(int restantes) {
        getLblParticipantesRestantes().setText("Participantes Restantes: " + restantes);
    }

    public void actualizarEliminados(int eliminados) {
        getLblEliminados().setText("Eliminados: " + eliminados);
    }

    public void actualizarTipo(String tipo) {
        getLblTipo().setText("Tipo: " + tipo);
    }

    public void actualizarParticipantesRestantesList(String[] participantes) {
        getListModel().clear(); // Limpiar la lista antes de agregar los nuevos participantes
        for (String participante : participantes) {
            getListModel().addElement(participante);
        }
    }
    public JButton getBotonVolver() {
        return botonVolver;
    }

    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}

	public JList<String> getListParticipantesRestantes() {
		return listParticipantesRestantes;
	}

	public void setListParticipantesRestantes(JList<String> listParticipantesRestantes) {
		this.listParticipantesRestantes = listParticipantesRestantes;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public void setLblTipo(JLabel lblTipo) {
		this.lblTipo = lblTipo;
	}

	public JLabel getLblEliminados() {
		return lblEliminados;
	}

	public void setLblEliminados(JLabel lblEliminados) {
		this.lblEliminados = lblEliminados;
	}

	public JLabel getLblParticipantesRestantes() {
		return lblParticipantesRestantes;
	}

	public void setLblParticipantesRestantes(JLabel lblParticipantesRestantes) {
		this.lblParticipantesRestantes = lblParticipantesRestantes;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JPanel getPanelDerecha() {
		return panelDerecha;
	}

	public void setPanelDerecha(JPanel panelDerecha) {
		this.panelDerecha = panelDerecha;
	}

	public JPanel getPanelIzquierda() {
		return panelIzquierda;
	}

	public void setPanelIzquierda(JPanel panelIzquierda) {
		this.panelIzquierda = panelIzquierda;
	}
}
