package co.edu.unbosque.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelCronograma extends JPanel {

    private JTable tablaCronograma;
    private DefaultTableModel modeloTabla;

    public PanelCronograma() {
        setLayout(new BorderLayout()); // Usamos BorderLayout para acomodar bien la tabla.
        setPreferredSize(new Dimension(800, 600)); // Panel de tamaño aumentado

        // Inicializamos la tabla con un modelo vacío.
        modeloTabla = new DefaultTableModel();
        tablaCronograma = new JTable(modeloTabla);
        
        // Agregamos la tabla dentro de un JScrollPane para que se pueda desplazar en ambas direcciones (horizontal y vertical).
        JScrollPane scrollPane = new JScrollPane(tablaCronograma);
        
        // Habilitamos el desplazamiento en ambas direcciones (horizontal y vertical).
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER); // Añadimos el JScrollPane con la tabla al panel
    }

   
    public void actualizarCronogramaGeneral(Object[][] datos, Object[] encabezados) {
        // Limpiamos el modelo de la tabla antes de agregar nuevos datos.
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);
        
        // Establecemos los encabezados de las columnas.
        modeloTabla.setColumnIdentifiers(encabezados);
        
        // Agregamos las filas (los datos).
        for (Object[] fila : datos) {
            modeloTabla.addRow(fila);
        }
        
        // Refrescamos la vista de la tabla.
        modeloTabla.fireTableDataChanged();
    }

    // Métodos para obtener el modelo de la tabla y manipularla si es necesario.
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
    
    public JTable getTablaCronograma() {
        return tablaCronograma;
    }
}
