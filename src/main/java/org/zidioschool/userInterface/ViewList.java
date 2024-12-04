package org.zidioschool.userInterface;
import org.zidioschool.model.StudentDAO;
import org.zidioschool.model.modelClasses.Data;
import org.zidioschool.model.modelClasses.Student;
import org.zidioschool.services.DataFilter;
import org.zidioschool.userInterface.customComponents.*;

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
    private GradientPanel lastPanel;
    private RoundedPanel tablePanel;
    private DataFilter dataFilter;
    private List<Data> dataList;
    private List<Data> filteredDataList;
    private SearchBar searchField;
    private List<Student> students;
    private Table table;
    private Table.StudentsTableModel tableModel;
    private RoundedButton clearBtn;

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

        //Retreives data from the database and creates an instance of the stdt-table model
        students = new StudentDAO().getAllStudents();
        tableModel = new Table.StudentsTableModel(students);
        dataFilter = new DataFilter(students, tableModel);

        //Creating and adding the search bar
        searchField = new SearchBar(20, students, dataFilter);
        searchField.setPreferredSize(new Dimension(250, 40));
        searchBarPanel.add(searchField, BorderLayout.CENTER);

        clearBtn = new RoundedButton("clear", 150, 40);
        clearBtn.addActionListener(e -> clearSearchBar());
        clearBtn.setBackground(new Color(255, 255, 255));
        clearBtn.setForeground(new Color(0, 0, 0));
        clearBtn.setPreferredSize(new Dimension(100, 40));
        searchBarPanel.add(clearBtn, BorderLayout.EAST);

        //dataFilter.displayFilteredData();
        add(searchBarPanel, BorderLayout.NORTH);

        //Table mainPanel Design
        tablePanel = new RoundedPanel(20, Color.GRAY, Color.WHITE, 3);
        tablePanel.setLayout(new BorderLayout(15, 15));
        tablePanel.setBorder(new EmptyBorder(20, 100, 20, 100));
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setPreferredSize(new Dimension(300, 300));

        table = new Table(tableModel);
        tablePanel.add(table, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER);

        //TODO Do something with this lastPanel
        lastPanel = new GradientPanel();
        lastPanel.setLayout(new BorderLayout());
        lastPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        lastPanel.setPreferredSize(new Dimension(300, 100));
        lastPanel.setOpaque(true);
        add(lastPanel, BorderLayout.SOUTH);
    }

    public void updateStudentData(){
        List<Student> student = new StudentDAO().getAllStudents();
        this.students = student;
        tableModel.setStudent(student);
        tableModel.fireTableDataChanged();
        dataFilter.setStudent(student);
        searchField.setStudent(student);
    }

    private void clearSearchBar() {
        searchField.setText("Search...");
    }

    public Table getTable(){
        return table;
    }

    public Table.StudentsTableModel getTableModel() {
        return tableModel;
    }
}
