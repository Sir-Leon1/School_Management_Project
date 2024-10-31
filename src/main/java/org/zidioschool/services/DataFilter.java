package org.zidioschool.services;

import org.zidioschool.model.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class DataFilter {
    private List<Data> filteredDataList;
    private List<Data> dataList;

    public DataFilter(List<Data> dataList) {
        this.dataList = dataList;
        this.filteredDataList = dataList; //Initial Data
    }


    public List<Data> filterData(String searchText) {
        if (searchText.isEmpty()) {
            filteredDataList = dataList;
        } else {

            filteredDataList = dataList.stream()
                    .filter(d -> d.getName().toLowerCase().contains(searchText) ||
                            d.getPhoneNumber().contains(searchText) ||
                            d.getClassName().toLowerCase().contains(searchText))
                    .collect(Collectors.toList());
        }

        return filteredDataList;
    }

    //Temp Method to display results filtered
    public void displayFilteredData() {
        System.out.println("Filtered Results:");
        for (Data data : filteredDataList) {
            System.out.println(data);
        }
        System.out.println("-----");
    }
}
