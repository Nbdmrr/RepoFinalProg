package co.edu.unbosque.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel para la creación de un torneo.
 * Permite ingresar el nombre, seleccionar el tipo de torneo,
 * límite de participantes y juego, además de botones para crear o volver.
 */
public class PanelCrearTorneo extends JPanel {

    /**
     * Campo de texto para ingresar el nombre del torneo.
     */
    private JTextField txtNombre;

    /**
     * ComboBox para seleccionar el tipo de torneo.
     * Opciones: "Eliminación Directa", "Puntos", "Grupos".
     */
    private JComboBox<String> comboTipo;

    /**
     * ComboBox para seleccionar el límite de participantes.
     * Los valores dependen del tipo de torneo seleccionado.
     */
    private JComboBox<Integer> comboLimiteParticipantes;

    /**
     * ComboBox para seleccionar el juego del torneo.
     */
    private JComboBox<String> comboJuego;

    /**
     * Botón para volver a la ventana anterior.
     */
    private JButton btnVolver;

    /**
     * Botón para crear el torneo con los parámetros seleccionados.
     */
    private JButton btnCrear;

    /**
     * Etiqueta que muestra el título del panel.
     */
    private JLabel lblTitulo;

    /**
     * Constructor que inicializa el layout, bordes y componentes del panel.
     */
    public PanelCrearTorneo() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        inicializarComponentes();
    }

    /**
     * Inicializa y agrega los componentes gráficos al panel.
     * Incluye campos para nombre, tipo, límite, juego y botones de acción.
     * Añade listener para actualizar límites según tipo de torneo.
     */
    public void inicializarComponentes() {

        setLblTitulo(new JLabel("Crear Torneo", SwingConstants.CENTER));
        getLblTitulo().setFont(new Font("Arial", Font.BOLD, 22));
        add(getLblTitulo(), BorderLayout.NORTH);

        JPanel panelCampos = new JPanel(new GridLayout(6, 1, 10, 10));

        JPanel panelNombre = new JPanel(new BorderLayout());
        JLabel lblNombre = new JLabel("Nombre del Torneo:");
        txtNombre = new JTextField();
        panelNombre.add(lblNombre, BorderLayout.NORTH);
        panelNombre.add(txtNombre, BorderLayout.CENTER);
        panelCampos.add(panelNombre);

        JPanel panelTipo = new JPanel(new BorderLayout());
        JLabel lblTipo = new JLabel("Tipo de Torneo:");
        comboTipo = new JComboBox<>(new String[]{"Eliminación Directa", "Puntos", "Grupos"});
        panelTipo.add(lblTipo, BorderLayout.NORTH);
        panelTipo.add(comboTipo, BorderLayout.CENTER);
        panelCampos.add(panelTipo);

        JPanel panelLimite = new JPanel(new BorderLayout());
        JLabel lblLimite = new JLabel("Límite de Participantes:");
        comboLimiteParticipantes = new JComboBox<>();
        panelLimite.add(lblLimite, BorderLayout.NORTH);
        panelLimite.add(comboLimiteParticipantes, BorderLayout.CENTER);
        panelCampos.add(panelLimite);

        JPanel panelJuego = new JPanel(new BorderLayout());
        JLabel lblJuego = new JLabel("Juego:");
        comboJuego = new JComboBox<>(new String[]{
            "Rocket League", "League Of Legends", "FIFA", "Formula 1", 
            "Gran Turismo", "Fortnite", "Super Smash Bros", "Clash Royale", 
            "Apex Legends", "Valorant", "Call of Duty"
        });
        panelJuego.add(lblJuego, BorderLayout.NORTH);
        panelJuego.add(comboJuego, BorderLayout.CENTER);
        panelCampos.add(panelJuego);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 20, 0));
        btnVolver = new JButton("Volver");
        btnCrear = new JButton("Crear");
        panelBotones.add(btnVolver);
        panelBotones.add(btnCrear);
        btnVolver.setActionCommand("VOLVERDEVENTANACREARTORNEOAPRINCIPALADMIN");
        btnCrear.setActionCommand("CREARTORNEO");
        panelCampos.add(panelBotones);

        add(panelCampos, BorderLayout.CENTER);

        comboTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarLimites();
            }
        });

        actualizarLimites();
    }

    /**
     * Actualiza las opciones del combo de límite de participantes
     * según el tipo de torneo seleccionado.
     */
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

    /**
     * Devuelve el campo de texto para el nombre del torneo.
     * 
     * @return JTextField del nombre del torneo
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * Establece el campo de texto para el nombre del torneo.
     * 
     * @param txtNombre JTextField a establecer
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * Devuelve el combo para seleccionar el tipo de torneo.
     * 
     * @return JComboBox con los tipos de torneo
     */
    public JComboBox<String> getComboTipo() {
        return comboTipo;
    }

    /**
     * Establece el combo para seleccionar el tipo de torneo.
     * 
     * @param comboTipo JComboBox a establecer
     */
    public void setComboTipo(JComboBox<String> comboTipo) {
        this.comboTipo = comboTipo;
    }

    /**
     * Devuelve el combo para seleccionar el límite de participantes.
     * 
     * @return JComboBox con los límites de participantes
     */
    public JComboBox<Integer> getComboLimiteParticipantes() {
        return comboLimiteParticipantes;
    }

    /**
     * Establece el combo para seleccionar el límite de participantes.
     * 
     * @param comboLimiteParticipantes JComboBox a establecer
     */
    public void setComboLimiteParticipantes(JComboBox<Integer> comboLimiteParticipantes) {
        this.comboLimiteParticipantes = comboLimiteParticipantes;
    }

    /**
     * Devuelve el combo para seleccionar el juego del torneo.
     * 
     * @return JComboBox con los juegos disponibles
     */
    public JComboBox<String> getComboJuego() {
        return comboJuego;
    }

    /**
     * Establece el combo para seleccionar el juego del torneo.
     * 
     * @param comboJuego JComboBox a establecer
     */
    public void setComboJuego(JComboBox<String> comboJuego) {
        this.comboJuego = comboJuego;
    }

    /**
     * Devuelve el botón para volver a la pantalla anterior.
     * 
     * @return JButton Volver
     */
    public JButton getBtnVolver() {
        return btnVolver;
    }

    /**
     * Establece el botón para volver a la pantalla anterior.
     * 
     * @param btnVolver JButton a establecer
     */
    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    /**
     * Devuelve el botón para crear el torneo.
     * 
     * @return JButton Crear
     */
    public JButton getBtnCrear() {
        return btnCrear;
    }

    /**
     * Establece el botón para crear el torneo.
     * 
     * @param btnCrear JButton a establecer
     */
    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    /**
     * Devuelve la etiqueta del título del panel.
     * 
     * @return JLabel del título
     */
    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    /**
     * Establece la etiqueta del título del panel.
     * 
     * @param lblTitulo JLabel a establecer
     */
    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

}
