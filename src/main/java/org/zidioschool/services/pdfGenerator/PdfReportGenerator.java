package org.zidioschool.services.pdfGenerator;

import java.io.File;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import org.zidioschool.model.ClassDAO;
import org.zidioschool.model.StudentDAO;
import org.zidioschool.model.modelClasses.Student;

import javax.swing.*;

public class PdfReportGenerator {
    public static void generateStudentsByClass(String className, String outputPath) throws Exception {
        PdfWriter writer = new PdfWriter(outputPath);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        PdfHeader.addHeader(document, "Student List - Class: " + className);

        List<Student> studentsByClass = new StudentDAO().getStudentsByClass(
                new ClassDAO().getClassIdByName(className)
        );

        Table table = new Table(6); // 3 column Table
        table.addCell("No");
        table.addCell("Name");
        table.addCell("Phone");
        table.addCell("Age");
        table.addCell("Guardian Email");
        table.addCell("RollCall");
        for (Student student : studentsByClass) {
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getFirstName() + " " + student.getLastName());
            table.addCell(String.valueOf(student.getPhone1()));
            table.addCell(String.valueOf(student.getAge()));
            table.addCell(String.valueOf(student.getGuardianEmail()));
            table.addCell(" ");
        }
        document.add(table);

        document.close();
        System.out.println("PDF created successfully!");
    }

    public static void generateAllStudentsReport(String outputPath) throws Exception {
        PdfWriter writer = new PdfWriter(outputPath);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        PdfHeader.addHeader(document, "All Students List");

        List<Student> allStudents = new StudentDAO().getAllStudents();

        Table table = new Table(5); // 3 column Table
        table.addCell("No");
        table.addCell("Name");
        table.addCell("Phone");
        table.addCell("Age");
        table.addCell("Guardian Email");
        for (Student student : allStudents) {
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getFirstName() + " " + student.getLastName());
            table.addCell(String.valueOf(student.getPhone1()));
            table.addCell(String.valueOf(student.getAge()));
            table.addCell(String.valueOf(student.getGuardianEmail()));
        }
        document.add(table);

        document.close();
        System.out.println("PDF created successfully!");
    }

    public static void main(String[] args) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select Output Path");

            // Test generating a PDF report for students by class
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                PdfReportGenerator.generateStudentsByClass("Chicago", selectedFile.getAbsolutePath());
            }

////            // Test generating a PDF report for all students
//            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//                File selectedFile = fileChooser.getSelectedFile();
//                PdfReportGenerator.generateAllStudentsReport(selectedFile.getAbsolutePath());
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
