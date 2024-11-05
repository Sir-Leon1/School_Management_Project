package org.zidioschool.services;

import org.zidioschool.model.ClassDAO;
import org.zidioschool.model.modelClasses.Clss;
import org.zidioschool.model.modelClasses.Student;
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
        this.tableModel = tableModel;
        this.filteredDataList = dataList; //Initial Data
    }


    public List<Student> filterData(String searchText) {
        if (searchText.isEmpty()) {
            filteredDataList = dataList;
        } else {
            //TODO: Get classes from the database
            List<Clss> classes = new ClassDAO().getAllClasses();
            filteredDataList = dataList.stream()
                    .filter(d -> d.getFirstName().toLowerCase().contains(searchText) ||
                            d.getLastName().toLowerCase().contains(searchText) ||
                            d.getPhone1().contains(searchText) ||
                            d.getMiddleName().contains(searchText) ||
                            d.getClassName(classes).toLowerCase().contains(searchText))
                    .collect(Collectors.toList());
        }
        tableModel.updateData(filteredDataList);
        displayFilteredData();
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
}
