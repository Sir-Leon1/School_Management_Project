package org.zidioschool.userInterface;
import org.zidioschool.model.Data;
import org.zidioschool.services.DataFilter;
import org.zidioschool.userInterface.customComponents.RoundedPanel;
import org.zidioschool.userInterface.customComponents.SearchBar;
import org.zidioschool.userInterface.customComponents.Table;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;

public class ViewList extends JPanel {
    private JPanel viewListPanel;
    private JPanel searchBarPanel;
    private JPanel lastPanel;
    private RoundedPanel tablePanel;
    private DataFilter dataFilter;
    private List<Data> dataList;
    private List<Data> filteredDataList;
    private SearchBar searchField;

    public ViewList() {
        Border outer = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border inner = BorderFactory.createTitledBorder("Home");
        setBorder(new CompoundBorder(outer, inner));
        setLayout(new BorderLayout(15, 15));
        setBackground(Color.WHITE);

        //Design for the search bar mainPanel
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
            }
        });

        dataFilter.displayFilteredData();
        add(searchBarPanel, BorderLayout.NORTH);

        //Table mainPanel Design
        tablePanel = new RoundedPanel(20, Color.GRAY, Color.WHITE, 3);
        tablePanel.setLayout(new BorderLayout(15, 15));
        tablePanel.setBorder(new EmptyBorder(20, 100, 20, 100));
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setPreferredSize(new Dimension(300, 300));

        Table table = new Table();
        tablePanel.add(table, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        //TODO Do something with this mainPanel
        lastPanel = new JPanel();
        lastPanel.setLayout(new BorderLayout());
        lastPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        lastPanel.setBackground(Color.GRAY);
        lastPanel.setPreferredSize(new Dimension(300, 100));
        lastPanel.setOpaque(true);
        add(lastPanel, BorderLayout.SOUTH);
    }

}
