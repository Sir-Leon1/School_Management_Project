package org.zidioschool.userInterface;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;

//Create table with custom TableModel
public class Table extends JScrollPane {
    public Table () {
        JTable table = new JTable(new MyTableModel());

        //Add a button renderer and editor to the last column
        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox()));
    }

    // Custom renderer for button in last column
    public static class ButtonRenderer extends RoundedButton implements TableCellRenderer {
        public ButtonRenderer() {
            super("View", 80, 30);
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            setText((value == null) ? "View" : value.toString());
            return this;
        }
    }
}
