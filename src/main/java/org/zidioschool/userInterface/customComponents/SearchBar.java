package org.zidioschool.userInterface.customComponents;
import org.zidioschool.model.modelClasses.Student;
import org.zidioschool.services.DataFilter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SearchBar extends JTextField {
    private boolean isClicked = false;
    private List<Student> students;
    private List<Student> filteredDataList;
    private DataFilter dataFilter;

    public SearchBar(int columns, List<Student> students, DataFilter dataFilter) {
        super(columns);
        this.students = students;
        this.dataFilter = dataFilter;
        this.filteredDataList = students;

        // Set placeholder text
        setText("Search...");
        setForeground(Color.GRAY);
        setFont(new Font("Grauda", Font.PLAIN, 16));

        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performSearch();
            }
            //Checks for default search string and filters data
            private void performSearch() {
                String searchText = getText().toLowerCase();
                if (searchText.equals("search...")) {
                    searchText = "";
                }
                //dataFilter = new DataFilter(students);
                filteredDataList = dataFilter.filterData(searchText);
                //dataFilter.displayFilteredData();
            }
        });


        // Add a focus listener to handle placeholder text
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                isClicked = true;
                if (getText().equals("Search...")) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                isClicked = false;
                if (getText().isEmpty()) {
                    setText("Search...");
                    setForeground(Color.GRAY);
                }
            }
        });

        // Add a mouse listener to handle hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (getText().equals("Search...")) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isClicked && getText().isEmpty()) {
                    setText("Search...");
                    setForeground(Color.GRAY);
                }
            }
        });

        // Set rounded border
        setBorder(BorderFactory.createCompoundBorder(
                new RoundedCornerBorder(),
                new EmptyBorder(0, 10, 0, 10)
        ));
    }

    public List<Student> getFilteredDataList() {
        return filteredDataList;
    }

    // Custom border for rounded corners
    private static class RoundedCornerBorder extends MatteBorder {
        public RoundedCornerBorder() {
            super(1, 1, 1, 1, Color.LIGHT_GRAY);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawRoundRect(x, y, width - 1, height - 1, 15, 15); // Rounded rectangle
        }
    }

}