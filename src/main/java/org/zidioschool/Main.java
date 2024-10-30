package org.zidioschool;

import org.zidioschool.userInterface.StudentsList;
import org.zidioschool.userInterface.StudentsView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentsList studentsList = new StudentsList();
            studentsList.setVisible(true);

            studentsList.refreshUI();
        });
    }
}