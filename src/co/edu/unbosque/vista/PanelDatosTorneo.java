package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelDatosTorneo extends JPanel {

    // Paneles internos
    private JPanel panelIzquierda;
    private JPanel panelDerecha;

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
        setLayout(new GridLayout(1, 2)); // Dividir en dos partes, izquierda y derecha

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
        Font fuente = new Font("Arial", Font.BOLD, 16); // Fuente Arial, Negrita, Tamaño 16
        lblNombre.setFont(fuente);
        lblParticipantesRestantes.setFont(fuente);
        lblEliminados.setFont(fuente);
        lblTipo.setFont(fuente);

        // Agregar las etiquetas al panel izquierdo
        panelIzquierda.add(lblNombre);
        panelIzquierda.add(lblParticipantesRestantes);
        panelIzquierda.add(lblEliminados);
        panelIzquierda.add(lblTipo);

        // Agregar el panel izquierdo al panel principal
        add(panelIzquierda);

        // Inicializar el modelo de la lista y la JList
        listModel = new DefaultListModel<>();
        listParticipantesRestantes = new JList<>(listModel);

        // Configurar la JList para que sea scrollable
        JScrollPane scrollPane = new JScrollPane(listParticipantesRestantes);
        panelDerecha.add(new JLabel("Participantes Restantes"), BorderLayout.NORTH);
        panelDerecha.add(scrollPane, BorderLayout.CENTER);

        // Agregar el panel derecho al panel principal
        add(panelDerecha);
    }

    // Métodos para actualizar los datos
    public void actualizarNombre(String nombre) {
        lblNombre.setText("Nombre: " + nombre);
    }

    public void actualizarParticipantesRestantes(int restantes) {
        lblParticipantesRestantes.setText("Participantes Restantes: " + restantes);
    }

    public void actualizarEliminados(int eliminados) {
        lblEliminados.setText("Eliminados: " + eliminados);
    }

    public void actualizarTipo(String tipo) {
        lblTipo.setText("Tipo: " + tipo);
    }

    public void actualizarParticipantesRestantesList(String[] participantes) {
        listModel.clear(); // Limpiar la lista antes de agregar los nuevos participantes
        for (String participante : participantes) {
            listModel.addElement(participante);
        }
    }
}
