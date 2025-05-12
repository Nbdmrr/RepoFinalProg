package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCrearTorneo extends JPanel {

    private JTextField txtNombre;
    private JComboBox<String> comboTipo;
    private JComboBox<Integer> comboLimiteParticipantes;
    private JComboBox<String> comboJuego;
    private JButton btnVolver;
    private JButton btnCrear;

    public PanelCrearTorneo() {
        setLayout(new GridLayout(5, 2, 40, 40)); // 6 filas, 2 columnas

        // Nombre
        add(new JLabel("Nombre del Torneo:"));
        txtNombre = new JTextField();
        add(txtNombre);

        // Tipo de torneo
        add(new JLabel("Tipo de Torneo:"));
        comboTipo = new JComboBox<>(new String[]{"EliminacionDirecta", "Puntos", "Grupos"});
        add(comboTipo);

        // Límite de participantes
        add(new JLabel("Límite de Participantes:"));
        comboLimiteParticipantes = new JComboBox<>();
        add(comboLimiteParticipantes);

        // Juego
        add(new JLabel("Juego:"));
        comboJuego = new JComboBox<>(new String[]{"Rocket League", "League Of Legends", "FIFA", "Formula 1","Gran Turismo","Fortnite","Super Smash Bros","Clash Royale","Apex Legends","Valorant","Call of Duty"});
        add(comboJuego);

        

        // Panel para los botones
        
        btnVolver = new JButton("Volver");
        btnCrear = new JButton("Crear");
        add(btnVolver);
        add(btnCrear);
        

        // Listener para actualizar el combo de límite
        comboTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarLimites();
            }
        });

        // Inicialización
        actualizarLimites();
    }

    private void actualizarLimites() {
        comboLimiteParticipantes.removeAllItems();
        String tipo = (String) comboTipo.getSelectedItem();

        if ("EliminacionDirecta".equals(tipo)) {
            for (int i = 2; i <= 32; i *= 2) {
                comboLimiteParticipantes.addItem(i);
            }
        } else if ("Puntos".equals(tipo)) {
            for (int i = 2; i <= 20; i++) {
                comboLimiteParticipantes.addItem(i);
            }
        } else if ("Grupos".equals(tipo)) {
            comboLimiteParticipantes.addItem(12);
        }
    }

    // Getters
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JComboBox<String> getComboTipo() {
        return comboTipo;
    }

    public JComboBox<Integer> getComboLimiteParticipantes() {
        return comboLimiteParticipantes;
    }

    public JComboBox<String> getComboJuego() {
        return comboJuego;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }
}
