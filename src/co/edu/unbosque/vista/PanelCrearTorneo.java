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
    private JLabel lblTitulo;

    public PanelCrearTorneo() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        // Titulo
        setLblTitulo(new JLabel("Crear Torneo", SwingConstants.CENTER));
        getLblTitulo().setFont(new Font("Arial", Font.BOLD, 22));
        add(getLblTitulo(), BorderLayout.NORTH);

        // Panel central con 6 filas
        JPanel panelCampos = new JPanel(new GridLayout(6, 1, 10, 10));

        // Fila 1: Nombre del Torneo
        JPanel panelNombre = new JPanel(new BorderLayout());
        JLabel lblNombre = new JLabel("Nombre del Torneo:");
        txtNombre = new JTextField();
        panelNombre.add(lblNombre, BorderLayout.NORTH);
        panelNombre.add(txtNombre, BorderLayout.CENTER);
        panelCampos.add(panelNombre);

        // Fila 2: Tipo de Torneo
        JPanel panelTipo = new JPanel(new BorderLayout());
        JLabel lblTipo = new JLabel("Tipo de Torneo:");
        comboTipo = new JComboBox<>(new String[]{"Eliminación Directa", "Puntos", "Grupos"});
        panelTipo.add(lblTipo, BorderLayout.NORTH);
        panelTipo.add(comboTipo, BorderLayout.CENTER);
        panelCampos.add(panelTipo);

        // Fila 3: Límite de Participantes
        JPanel panelLimite = new JPanel(new BorderLayout());
        JLabel lblLimite = new JLabel("Límite de Participantes:");
        comboLimiteParticipantes = new JComboBox<>();
        panelLimite.add(lblLimite, BorderLayout.NORTH);
        panelLimite.add(comboLimiteParticipantes, BorderLayout.CENTER);
        panelCampos.add(panelLimite);

        // Fila 4: Juego
        JPanel panelJuego = new JPanel(new BorderLayout());
        JLabel lblJuego = new JLabel("Juego:");
        comboJuego = new JComboBox<>(new String[]{"Rocket League", "League Of Legends", "FIFA", "Formula 1", "Gran Turismo", "Fortnite", "Super Smash Bros", "Clash Royale", "Apex Legends", "Valorant", "Call of Duty"});
        panelJuego.add(lblJuego, BorderLayout.NORTH);
        panelJuego.add(comboJuego, BorderLayout.CENTER);
        panelCampos.add(panelJuego);

        // Fila 5: Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
        btnVolver = new JButton("Volver");
        btnCrear = new JButton("Crear");
        panelBotones.add(btnVolver);
        panelBotones.add(btnCrear);
        btnVolver.setActionCommand("VOLVERDEVENTANACREARTORNEOAPRINCIPALADMIN");
        btnCrear.setActionCommand("CREARTORNEO");
        panelCampos.add(panelBotones);

        add(panelCampos, BorderLayout.CENTER);

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

        if ("Eliminación Directa".equals(tipo)) {
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

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }
}
