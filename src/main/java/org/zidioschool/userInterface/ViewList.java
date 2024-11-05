package org.zidioschool.userInterface;
import org.zidioschool.model.StudentDAO;
import org.zidioschool.model.modelClasses.Data;
import org.zidioschool.model.modelClasses.Student;
import org.zidioschool.services.DataFilter;
import org.zidioschool.userInterface.customComponents.RoundedPanel;
import org.zidioschool.userInterface.customComponents.SearchBar;
import org.zidioschool.userInterface.customComponents.Table;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
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

        //TODO: Get data from the database
        List<Student> students = new StudentDAO().getAllStudents();
        Table.StudentsTableModel tableModel = new Table.StudentsTableModel(students);
        dataFilter = new DataFilter(students, tableModel);

        //Creating and adding the search bar
        searchField = new SearchBar(20, students, dataFilter);
        searchField.setPreferredSize(new Dimension(300, 40));
        searchBarPanel.add(searchField, BorderLayout.NORTH);

        dataFilter.displayFilteredData();
        add(searchBarPanel, BorderLayout.NORTH);

        //Table mainPanel Design
        tablePanel = new RoundedPanel(20, Color.GRAY, Color.WHITE, 3);
        tablePanel.setLayout(new BorderLayout(15, 15));
        tablePanel.setBorder(new EmptyBorder(20, 100, 20, 100));
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setPreferredSize(new Dimension(300, 300));

        Table table = new Table(searchField.getFilteredDataList(), tableModel);
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
