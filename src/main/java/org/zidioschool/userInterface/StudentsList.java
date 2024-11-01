package org.zidioschool.userInterface;
import org.zidioschool.model.Data;
import org.zidioschool.services.DataFilter;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;

public class StudentsList extends JFrame {
    private JPanel panel;
    private JPanel btnPanel;
    private JPanel bottomPanel;
    private JPanel searchBarPanel;
    private JPanel tablePanel;
    private DataFilter dataFilter;
    private List<Data> dataList;
    private List<Data> filteredDataList;
    private SearchBar searchField;

    private RoundedButton registerBtn;
    private RoundedButton updateBtn;
    private RoundedButton viewListBtn;
    private RoundedButton generateReportBtn;

    public StudentsList() {
        setTitle("Zidio School manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 800);
        setLocationRelativeTo(null);
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new BorderLayout());

        //Design for the top panel
        btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        registerBtn = new RoundedButton("Register", 200, 60);
        btnPanel.add(registerBtn);
        updateBtn = new RoundedButton("Update", 200, 60);
        btnPanel.add(updateBtn);
        viewListBtn = new RoundedButton("View List", 200, 60);
        btnPanel.add(viewListBtn);
        generateReportBtn = new RoundedButton("Generate Report", 200, 60);
        btnPanel.add(generateReportBtn);
        panel.add(btnPanel, BorderLayout.NORTH);


        //Design for the bottom panel
        bottomPanel= new JPanel();
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);

        //Design for the search bar panel
        searchBarPanel = new JPanel();
        searchBarPanel.setLayout(new BorderLayout());
        searchBarPanel.setBorder(new EmptyBorder(0, 150, 0, 150));
        searchBarPanel.setBackground(Color.WHITE);
        // TODO: Remove this Sample data
        dataList = new ArrayList<>();
        dataList.add(new Data("Alice", "1234567890", "Class A"));
        dataList.add(new Data("Bob", "0987654321", "Class B"));
        dataList.add(new Data("Charlie", "1234509876", "Class A"));
        dataList.add(new Data("Daisy", "1122334455", "Class C"));

        dataFilter = new DataFilter(dataList);

        //Creating and adding the search bar
        searchField = new SearchBar(20);
        searchField.setPreferredSize(new Dimension(300, 40));
        searchBarPanel.add(searchField, BorderLayout.NORTH);

        searchField.getDocument().addDocumentListener(new DocumentListener() {
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
                String searchText = searchField.getText().toLowerCase();
                if (searchText.equals("search...")) {
                    searchText = "";
                }
                dataFilter.filterData(searchText);
                dataFilter.displayFilteredData();
                refreshUI();
            }
        });

        dataFilter.displayFilteredData();
        bottomPanel.add(searchBarPanel, BorderLayout.NORTH);

        //Table panel Design
        tablePanel = new JPanel(new BorderLayout(15, 15));
        tablePanel.setBorder(new EmptyBorder(20, 100, 20, 100));
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setPreferredSize(new Dimension(300, 300));


        Table table = new Table();
        tablePanel.add(table, BorderLayout.NORTH);
        bottomPanel.add(tablePanel);
        panel.add(bottomPanel);

        setVisible(true);
    }

    public void refreshUI() {
        panel.revalidate();
        panel.repaint();
    }
}
