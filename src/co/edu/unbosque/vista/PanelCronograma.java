package co.edu.unbosque.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelCronograma extends JPanel {

    private JTable tablaCronograma;
    private DefaultTableModel modeloTabla;
    private JButton botonVolver;

    public PanelCronograma() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1000, 700)); // Tamaño base más amplio

        modeloTabla = new DefaultTableModel();
        tablaCronograma = new JTable(modeloTabla);

        // Evitar que la tabla ajuste automáticamente el tamaño de las columnas
        tablaCronograma.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Panel con scroll que envuelve la tabla
        JScrollPane scrollPane = new JScrollPane(tablaCronograma);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Agregar scrollPane al centro del panel
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con botón "Volver"
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botonVolver = new JButton("Volver");
        panelInferior.add(botonVolver);

        add(panelInferior, BorderLayout.SOUTH);
    }

    public void actualizarCronogramaGeneral(Object[][] datos) {
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);

        if (datos.length > 0) {
            int columnas = datos[0].length;
            modeloTabla.setColumnCount(columnas);

            // Ajustar ancho de columnas para mostrar mejor el texto largo
            for (int i = 0; i < columnas; i++) {
                tablaCronograma.getColumnModel().getColumn(i).setPreferredWidth(300);
            }
        }

        for (Object[] fila : datos) {
            modeloTabla.addRow(fila);
        }

        modeloTabla.fireTableDataChanged();
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}