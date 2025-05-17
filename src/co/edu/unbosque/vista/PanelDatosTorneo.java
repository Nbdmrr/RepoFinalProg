package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;

public class PanelDatosTorneo extends JPanel {

    private JPanel panelIzquierda;
    private JPanel panelDerecha;
    private JButton botonVolver;
    private JButton botonCronograma;

    private JLabel lblNombre;
    private JLabel lblParticipantesRestantes;
    private JLabel lblEliminados;
    private JLabel lblTipo;

    private JList<String> listParticipantesRestantes;
    private DefaultListModel<String> listModel;

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
        listModel.clear();
        for (String participante : participantes) {
            listModel.addElement(participante);
        }
    }

    public JButton getBotonVolver() {
        return botonVolver;
    }

    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }

    public JButton getBotonCronograma() {
        return botonCronograma;
    }

    public void setBotonCronograma(JButton botonCronograma) {
        this.botonCronograma = botonCronograma;
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
