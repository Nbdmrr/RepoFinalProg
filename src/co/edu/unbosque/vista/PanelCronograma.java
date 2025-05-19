package co.edu.unbosque.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Panel que muestra el cronograma de actividades/torneos en formato de tabla.
 */
public class PanelCronograma extends JPanel {

    private JTable tablaCronograma;
    private DefaultTableModel modeloTabla;
    private JButton botonVolver;

    /**
     * Constructor que inicializa el panel del cronograma con sus componentes.
     */
    public PanelCronograma() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 700));

        modeloTabla = new DefaultTableModel();
        tablaCronograma = new JTable(modeloTabla);
        tablaCronograma.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(tablaCronograma);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonVolver = new JButton("Volver");
        botonVolver.setActionCommand("VOLVERAVISTAADMINDECRONOGRAMAADMIN");
        panelInferior.add(botonVolver);

        add(panelInferior, BorderLayout.SOUTH);
    }

    /**
     * Actualiza los datos mostrados en el cronograma.
     * @param datos Matriz bidimensional de objetos con la información a mostrar
     */
    public void actualizarCronogramaGeneral(Object[][] datos) {
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);

        if (datos.length > 0) {
            int columnas = datos[0].length;
            modeloTabla.setColumnCount(columnas);

            // Generar encabezados dinámicos
            String[] encabezados = new String[columnas];
            for (int i = 0; i < columnas; i++) {
                encabezados[i] = "Enfrentamiento " + (i + 1);
            }
            modeloTabla.setColumnIdentifiers(encabezados);

            for (int i = 0; i < columnas; i++) {
                tablaCronograma.getColumnModel().getColumn(i).setPreferredWidth(300);
            }
        }

        for (Object[] fila : datos) {
            modeloTabla.addRow(fila);
        }

        modeloTabla.fireTableDataChanged();

    }

    /**
     * Obtiene la tabla del cronograma.
     * @return JTable con los datos del cronograma
     */
    public JTable getTablaCronograma() {
        return tablaCronograma;
    }

    /**
     * Establece la tabla del cronograma.
     * @param tablaCronograma JTable con los datos del cronograma
     */
    public void setTablaCronograma(JTable tablaCronograma) {
        this.tablaCronograma = tablaCronograma;
    }

    /**
     * Obtiene el modelo de datos de la tabla.
     * @return DefaultTableModel con el modelo de datos
     */
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    /**
     * Establece el modelo de datos de la tabla.
     * @param modeloTabla DefaultTableModel con el modelo de datos
     */
    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    /**
     * Obtiene el botón para volver.
     * @return JButton configurado para volver
     */
    public JButton getBotonVolver() {
        return botonVolver;
    }

    /**
     * Establece el botón para volver.
     * @param botonVolver JButton configurado para volver
     */
    public void setBotonVolver(JButton botonVolver) {
        this.botonVolver = botonVolver;
    }
}