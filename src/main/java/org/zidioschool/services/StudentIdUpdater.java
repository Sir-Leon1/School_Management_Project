package org.zidioschool.services;

import org.zidioschool.model.StudentDAO;
import org.zidioschool.model.modelClasses.Student;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StudentIdUpdater {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAllStudents();
        Set<String> uniqueIds = new HashSet<>();
        Random random = new Random();

        for (Student student : students) {
            String uniqueId;
            do {
                uniqueId = String.format("%08d", random.nextInt(100000000));
            } while (uniqueIds.contains(uniqueId));
            uniqueIds.add(uniqueId);
            student.setIdNumber(uniqueId);
            studentDAO.updateStudent(student);
        }

        System.out.println("Updated id_number for all students.");
    }
}