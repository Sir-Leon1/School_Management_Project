package org.zidioschool.services;

import org.zidioschool.model.ClassDAO;
import org.zidioschool.model.modelClasses.Clss;
import org.zidioschool.model.modelClasses.Student;
import org.zidioschool.userInterface.MainUI;
import org.zidioschool.userInterface.customComponents.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DataFilter {
    private List<Student> filteredDataList;
    private List<Student> dataList;
    private Table.StudentsTableModel tableModel;

    public DataFilter(List<Student> dataList, Table.StudentsTableModel tableModel) {
        this.dataList = dataList;
        if (tableModel == null) {
            this.tableModel = new Table.StudentsTableModel(new ArrayList<>());
        }
        this.tableModel = tableModel;
        this.filteredDataList = dataList; //Initial Data
    }


    public List<Student> filterData(String searchText) {
        if (searchText.isEmpty()) {
            filteredDataList = dataList;
        } else {
            //TODO: Modify this to also search by id number of student
            List<Clss> classes = new ClassDAO().getAllClasses();
            filteredDataList = dataList.stream()
                    .filter(d -> d.getFirstName().toLowerCase().contains(searchText) ||
                            d.getLastName().toLowerCase().contains(searchText) ||
                            d.getPhone1().contains(searchText) ||
                            d.getMiddleName().contains(searchText) ||
                            d.getClassName(classes).toLowerCase().contains(searchText))
                    .collect(Collectors.toList());
        }
        if (tableModel != null) {
            tableModel.updateData(filteredDataList);
        }
        MainUI.getInstance().getViewList().getTable().updateTableData(filteredDataList);
        //displayFilteredData();
        return filteredDataList;
    }

    //Temp Method to display results filtered
    public void displayFilteredData() {
        System.out.println("Filtered Results:");
        for (Student data : filteredDataList) {
            System.out.println(data);
        }
        System.out.println("-----");
    }

    public void setStudent(List<Student> student) {
        this.dataList = student;
    }
}
