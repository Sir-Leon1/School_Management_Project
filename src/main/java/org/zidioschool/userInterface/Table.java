package org.zidioschool.userInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

//Create table with custom TableModel
public class Table extends JScrollPane {
    private Color headerColor = new Color(52, 152, 219);
    private Color alternateRowColor = new Color(245, 245, 245);
    private Color selectedRowColor = new Color(52, 152, 219, 50);
    private Color hoverRowColor = new Color(52, 152, 219, 30);
    private int hoveredRow = -1;
    private Color buttonColor = new Color(64, 158, 255);
    private Color buttonHoverColor = new Color(102, 177, 255);
    private Color buttonPressedColor = new Color(58, 142, 230);


    public Table() {
        JTable table = new JTable(new MyTableModel());
        table.setRowHeight(60);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFocusable(false);
        table.setSelectionBackground(new Color(52, 152, 219, 50));
        table.setFont(new Font("Seogoe UI", Font.PLAIN, 16));

        //Custom header renderer
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);
                label.setBackground(new Color(52, 152, 219));
                label.setForeground(Color.WHITE);
                label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
                label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                return label;
            }
        });
        header.setBackground(headerColor);
        header.setPreferredSize(new Dimension(header.getWidth(), 45));

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private JButton button;
            private JPanel panel;
            private int hoveredRow = -1;
            private int hoveredCol = -1;
            private boolean isPressed = false;

            {
                // Initialize button and panel
                button = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        Graphics2D g2d = (Graphics2D) g.create();
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        // Determine button color based on state
                        Color color;
                        if (isPressed) {
                            color = buttonPressedColor;
                        } else if (hoveredRow == table.getSelectedRow() && hoveredCol == table.getSelectedColumn()) {
                            color = buttonHoverColor;
                        } else {
                            color = buttonColor;
                        }

                        // Create gradient paint
                        GradientPaint gradient = new GradientPaint(
                                0, 0, color,
                                0, getHeight(), color.darker()
                        );
                        g2d.setPaint(gradient);

                        // Draw rounded rectangle
                        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15));

                        // Draw text
                        FontMetrics fm = g2d.getFontMetrics();
                        Rectangle2D r = fm.getStringBounds(getText(), g2d);
                        int x = (getWidth() - (int) r.getWidth()) / 2;
                        int y = (getHeight() - (int) r.getHeight()) / 2 + fm.getAscent();

                        g2d.setColor(Color.WHITE);
                        g2d.setFont(getFont());
                        g2d.drawString(getText(), x, y);

                        g2d.dispose();
                    }
                };
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFont(new Font("Segoe UI", Font.BOLD, 16));
                button.setForeground(Color.WHITE);

                panel = new JPanel(new GridBagLayout());
                panel.setBackground(Color.WHITE);
                panel.add(button);

                // Add mouse listener to track hover state
                table.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseMoved(MouseEvent e) {
                        int row = table.rowAtPoint(e.getPoint());
                        int col = table.columnAtPoint(e.getPoint());
                        if (hoveredRow != row || hoveredCol != col) {
                            hoveredRow = row;
                            hoveredCol = col;
                            table.repaint();
                        }
                    }
                });

                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseExited(MouseEvent e) {
                        hoveredRow = -1;
                        hoveredCol = -1;
                        table.repaint();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        int row = table.rowAtPoint(e.getPoint());
                        int col = table.columnAtPoint(e.getPoint());
                        if (row == hoveredRow && col == hoveredCol) {
                            isPressed = true;
                            table.repaint();
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (isPressed) {
                            isPressed = false;
                            table.repaint();
                            // Handle button click only if it's the last column
                            int row = table.rowAtPoint(e.getPoint());
                            int col = table.columnAtPoint(e.getPoint());
                            if (row >= 0 && col == table.getColumnCount() - 1) {
                                JOptionPane.showMessageDialog(table,
                                        "Button clicked at row " + (row + 1) + ", column " + (col + 1));
                            }
                        }
                    }
                });
            }

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == table.getColumnCount() - 1) {
                    button.setText("View");

                    // Set button size relative to cell size
                    Dimension cellSize = new Dimension(
                            (table.getColumnModel().getColumn(column).getWidth() - 20) / 2,
                            table.getRowHeight(row) - 20
                    );
                    button.setPreferredSize(cellSize);

                    return panel;
                } else {
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });

        setViewportView(table);
        setBorder(BorderFactory.createEmptyBorder());
        getViewport().setBackground(Color.WHITE);
    }

    public static class MyTableModel extends AbstractTableModel {
        private final String[] columnNames = {"ID", "Name", "Phone", "Class", "Action"};
        private final Object[][] data = {
                {1, "Alice", "1234567890", "Class A", "Edit"},
                {2, "Bob", "0987654321", "Class B", "Edit"},
                {3, "Charlie", "1122334455", "Class C", "Edit"},
                {4, "Daisy", "5566778899", "Class D", "Edit"},
                {5, "Edward", "6655443322", "Class E", "Edit"}
        };

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 4; //Set only the last column as editable;
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Table Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Instantiate and add the Table class
            Table table = new Table();
            frame.add(table);

            frame.setVisible(true);
        });
    }
}
