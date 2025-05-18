package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que muestra los detalles de un torneo.
 * Contiene etiquetas con información del torneo (nombre, tipo, participantes restantes, eliminados),
 * una lista de participantes restantes, y botones para volver o acceder al cronograma.
 */
public class PanelDatosTorneo extends JPanel {

    /**
     * Panel que contiene las etiquetas de información del torneo.
     */
    private JPanel panelIzquierda;

    /**
     * Panel que contiene la lista de participantes restantes.
     */
    private JPanel panelDerecha;

    /**
     * Botón para volver a la ventana anterior.
     */
    private JButton botonVolver;

    /**
     * Botón para mostrar el cronograma del torneo.
     */
    private JButton botonCronograma;

    /**
     * Etiqueta que muestra el nombre del torneo.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta que muestra la cantidad de participantes restantes.
     */
    private JLabel lblParticipantesRestantes;

    /**
     * Etiqueta que muestra la cantidad de participantes eliminados.
     */
    private JLabel lblEliminados;

    /**
     * Etiqueta que muestra el tipo de torneo.
     */
    private JLabel lblTipo;

    /**
     * Lista que muestra los nombres de los participantes restantes.
     */
    private JList<String> listParticipantesRestantes;

    /**
     * Modelo que contiene los datos de la lista de participantes restantes.
     */
    private DefaultListModel<String> listModel;

    /**
     * Constructor que inicializa el layout y los componentes del panel.
     * Organiza los paneles, etiquetas, lista y botones.
     */
    public PanelDatosTorneo() {
        setLayout(new BorderLayout());

        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();

        panelIzquierda.setLayout(new GridLayout(4, 1, 10, 10));
        panelDerecha.setLayout(new BorderLayout());

        lblNombre = new JLabel("Nombre: No disponible");
        lblParticipantesRestantes = new JLabel("Participantes Restantes: 0");
        lblEliminados = new JLabel("Eliminados: 0");
        lblTipo = new JLabel("Tipo: No especificado");

        Font fuente = new Font("Arial", Font.BOLD, 16);
        lblNombre.setFont(fuente);
        lblParticipantesRestantes.setFont(fuente);
        lblEliminados.setFont(fuente);
        lblTipo.setFont(fuente);

        panelIzquierda.add(lblNombre);
        panelIzquierda.add(lblParticipantesRestantes);
        panelIzquierda.add(lblEliminados);
        panelIzquierda.add(lblTipo);

        add(panelIzquierda, BorderLayout.WEST);

        listModel = new DefaultListModel<>();
        listParticipantesRestantes = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(listParticipantesRestantes);
        panelDerecha.add(new JLabel("Participantes Restantes"), BorderLayout.NORTH);
        panelDerecha.add(scrollPane, BorderLayout.CENTER);

        add(panelDerecha, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonVolver = new JButton("Volver");
        botonCronograma = new JButton("Cronograma");

        panelInferior.add(botonCronograma);
        panelInferior.add(botonVolver);

        add(panelInferior, BorderLayout.SOUTH);
    }

    /**
     * Actualiza la etiqueta del nombre del torneo.
     * 
     * @param nombre Nuevo nombre del torneo
     */
    public void actualizarNombre(String nombre) {
        lblNombre.setText("Nombre: " + nombre);
    }

    /**
     * Actualiza la etiqueta con la cantidad de participantes restantes.
     * 
     * @param restantes Número de participantes restantes
     */
    public void actualizarParticipantesRestantes(int restantes) {
        lblParticipantesRestantes.setText("Participantes Restantes: " + restantes);
    }

    /**
     * Actualiza la etiqueta con la cantidad de participantes eliminados.
     * 
     * @param eliminados Número de participantes eliminados
     */
    public void actualizarEliminados(int eliminados) {
        lblEliminados.setText("Eliminados: " + eliminados);
    }

    /**
     * Actualiza la etiqueta del tipo de torneo.
     * 
     * @param tipo Nuevo tipo de torneo
     */
    public void actualizarTipo(String tipo) {
        lblTipo.setText("Tipo: " + tipo);
    }

    /**
     * Actualiza la lista de participantes restantes con un arreglo de nombres.
     * 
     * @param participantes Array con los nombres de los participantes restantes
     */
    public void actualizarParticipantesRestantesList(String[] participantes) {
        listModel.clear();
        for (String participante : participantes) {
            listModel.addElement(participante);
        }
    }

    /**
     * Devuelve el botón para volver a la ventana anterior.
     * 
     * @return JButton para volver
     */
    public JButton getBotonVolver() {
        return botonVolver;
    }

    /**
     * Establece el botón para volver a la ventana anterior.
     * 
     * @param botonVolver JButton a establecer
     */
    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }

    /**
     * Devuelve el botón para mostrar el cronograma.
     * 
     * @return JButton para cronograma
     */
    public JButton getBotonCronograma() {
        return botonCronograma;
    }

    /**
     * Establece el botón para mostrar el cronograma.
     * 
     * @param botonCronograma JButton a establecer
     */
    public void setBotonCronograma(JButton botonCronograma) {
        this.botonCronograma = botonCronograma;
    }

    /**
     * Devuelve el modelo de datos de la lista de participantes restantes.
     * 
     * @return DefaultListModel con los participantes restantes
     */
    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    /**
     * Establece el modelo de datos de la lista de participantes restantes.
     * 
     * @param listModel DefaultListModel a establecer
     */
    public void setListModel(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }

    /**
     * Devuelve la lista de participantes restantes.
     * 
     * @return JList con los participantes restantes
     */
    public JList<String> getListParticipantesRestantes() {
        return listParticipantesRestantes;
    }

    /**
     * Establece la lista de participantes restantes.
     * 
     * @param listParticipantesRestantes JList a establecer
     */
    public void setListParticipantesRestantes(JList<String> listParticipantesRestantes) {
        this.listParticipantesRestantes = listParticipantesRestantes;
    }

    /**
     * Devuelve la etiqueta del tipo de torneo.
     * 
     * @return JLabel del tipo de torneo
     */
    public JLabel getLblTipo() {
        return lblTipo;
    }

    /**
     * Establece la etiqueta del tipo de torneo.
     * 
     * @param lblTipo JLabel a establecer
     */
    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    /**
     * Devuelve la etiqueta de participantes eliminados.
     * 
     * @return JLabel de eliminados
     */
    public JLabel getLblEliminados() {
        return lblEliminados;
    }

    /**
     * Establece la etiqueta de participantes eliminados.
     * 
     * @param lblEliminados JLabel a establecer
     */
    public void setLblEliminados(JLabel lblEliminados) {
        this.lblEliminados = lblEliminados;
    }

    /**
     * Devuelve la etiqueta de participantes restantes.
     * 
     * @return JLabel de participantes restantes
     */
    public JLabel getLblParticipantesRestantes() {
        return lblParticipantesRestantes;
    }

    /**
     * Establece la etiqueta de participantes restantes.
     * 
     * @param lblParticipantesRestantes JLabel a establecer
     */
    public void setLblParticipantesRestantes(JLabel lblParticipantesRestantes) {
        this.lblParticipantesRestantes = lblParticipantesRestantes;
    }

    /**
     * Devuelve la etiqueta del nombre del torneo.
     * 
     * @return JLabel del nombre del torneo
     */
    public JLabel getLblNombre() {
        return lblNombre;
    }

    /**
     * Establece la etiqueta del nombre del torneo.
     * 
     * @param lblNombre JLabel a establecer
     */
    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    /**
     * Devuelve el panel derecho (lista de participantes).
     * 
     * @return JPanel derecho
     */
    public JPanel getPanelDerecha() {
        return panelDerecha;
    }

    /**
     * Establece el panel derecho (lista de participantes).
     * 
     * @param panelDerecha JPanel a establecer
     */
    public void setPanelDerecha(JPanel panelDerecha) {
        this.panelDerecha = panelDerecha;
    }

    /**
     * Devuelve el panel izquierdo (etiquetas de información).
     * 
     * @return JPanel izquierdo
     */
    public JPanel getPanelIzquierda() {
        return panelIzquierda;
    }

    /**
     * Establece el panel izquierdo (etiquetas de información).
     * 
     * @param panelIzquierda JPanel a establecer
     */
    public void setPanelIzquierda(JPanel panelIzquierda) {
        this.panelIzquierda = panelIzquierda;
    }
}
