package org.zidioschool.userInterface.customComponents;

import org.zidioschool.model.ClassDAO;
import org.zidioschool.model.modelClasses.Clss;
import org.zidioschool.model.modelClasses.Student;
import org.zidioschool.userInterface.MainUI;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

//Create table with custom TableModel
public class Table extends JScrollPane {
    private Color headerColor = new Color(52, 152, 219);
    private Color alternateRowColor = new Color(245, 245, 245);
    private Color selectedRowColor = new Color(52, 152, 219, 50);
    private Color hoverRowColor = new Color(52, 152, 219, 30);
    private int hoveredRow = -1;
    private Color buttonColor = new Color(87, 91, 198);
    private Color buttonHoverColor = new Color(102, 177, 255);
    private Color buttonPressedColor = new Color(58, 142, 230);
    private List<Student> students;


    public Table(StudentsTableModel tableModel) {
        JTable table = new JTable(tableModel);
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
                label.setBackground(new Color(87, 91, 198));
                label.setForeground(Color.WHITE);
                label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
                label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                return label;
            }
        });
        header.setBackground(headerColor);
        header.setPreferredSize(new Dimension(header.getWidth(), 45));

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            private int hoveredRow = -1;
            private int hoveredCol = -1;
            private boolean isPressed = false;

            {
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
//                                JOptionPane.showMessageDialog(table,
//                                        "Button clicked at row " + (row + 1) + ", column " + (col + 1));
                                Student student = getStudentAtRow(row);
                                System.out.println(student);
                            }
                        }
                    }
                });
            }

            /**
             * Custom cell renderer for the table.
             * This method is responsible for rendering the cells in the table.
             * It creates a custom button for the last column and a default renderer for other columns.
             *
             * @param table the JTable that is asking the renderer to draw; can be null
             * @param value the value of the cell to be rendered; it is up to the specific renderer to interpret and draw the value
             * @param isSelected true if the cell is to be rendered with the selection highlighted; otherwise false
             * @param hasFocus if true, render cell appropriately; otherwise false
             * @param row the row index of the cell being drawn. When drawing the header, the value of row is -1
             * @param column the column index of the cell being drawn
             * @return the component used for drawing the cell. This component must be configured to match the cell's state,
             *         as specified by the parameters.
             */
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                RoundedButton button;
                JPanel panel;
                if (column == table.getColumnCount() - 1) {
                    button = new RoundedButton("Edit", (table.getColumnModel().getColumn(column).getWidth() - 20) / 2,
                            table.getRowHeight(row) - 20);
                    panel = new JPanel(new GridBagLayout());
                    panel.setBackground(Color.WHITE);
                    panel.add(button);

                    return panel;
                } else {
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }

            // Get student data from the selected row
            public Student getStudentAtRow(int rowIndex) {
                System.out.println(students);
                if (rowIndex >= 0 && rowIndex < students.size()) {
                    List<Student> student = new ArrayList<>();

                    student.add(students.get(rowIndex));
                    MainUI.getInstance().getUpdatePanel().updateFieldsWithStudentData(student);
                    MainUI.getInstance().switchPanel("UpdatePanel");
                    return students.get(rowIndex);
                } else {
                    return null;
                }
            }
        });

        setViewportView(table);
        setBorder(BorderFactory.createEmptyBorder());
        getViewport().setBackground(Color.WHITE);
    }

    public void updateTableData(List<Student> students) {
        this.students = students;
    }

    public static class StudentsTableModel extends AbstractTableModel {
        public List<Student> students;
        private final String[] columnNames = {"First Name", "Last Name", "Phone", "Class", "Action"};
        private List<Clss> classes = new ClassDAO().getAllClasses();

        public StudentsTableModel(List<Student> students) {
            this.students = students;
        }

        public void updateData(List<Student> students) {
            this.students = students;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Student student = students.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return student.getFirstName();
                case 1:
                    return student.getLastName();
                case 2:
                    return student.getPhone1();
                case 3:
                    return student.getClassName(classes);
                default:
                    return null;
            }

        }

        public void setStudent(List<Student> student) {
            this.students = student;
        }


    }

}
