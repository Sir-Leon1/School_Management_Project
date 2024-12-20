package org.zidioschool.userInterface;

import org.zidioschool.model.ClassDAO;
import org.zidioschool.model.StudentDAO;
import org.zidioschool.model.modelClasses.Clss;
import org.zidioschool.model.modelClasses.Student;
import org.zidioschool.services.DataFilter;
import org.zidioschool.userInterface.customComponents.*;
import org.zidioschool.userInterface.customComponents.panels.GradientPanel;
import org.zidioschool.userInterface.customComponents.HorizontalRuleWithText;
import org.zidioschool.userInterface.customComponents.panels.helpers.GridBagHelper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class UpdatePanel extends JPanel {
    private JPanel searchBarPanel;
    private RoundedButton searchBtn;
    private DataFilter dataFilter;
    private SearchBar searchField;
    private HorizontalRuleWithText horizontalRule;
    private JLabel label;
    private RoundedTextField firstNameField;
    private RoundedTextField middleNameField;
    private RoundedTextField lastNameField;
    private RoundedTextField idNumberField;
    private RoundedTextField ageField;
    private RoundedTextField classField;
    private RoundedTextField phone1Field;
    private RoundedTextField phone2Field;
    private RoundedTextField emailField;
    private RoundedTextField guardianPhone1Field;
    private RoundedTextField guardianPhone2Field;
    private RoundedTextField guardianEmailField;
    private GradientPanel lastPanel;
    private Student studentInView;
    private List<Student> students;
    private GridBagHelper GridBagHelper;

    public UpdatePanel() {
        Border outer = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border inner = BorderFactory.createTitledBorder("Update");
        setBorder(new CompoundBorder(outer, inner));
        setBackground(Color.WHITE);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        searchBarPanel = new JPanel();
        searchBarPanel.setLayout(new FlowLayout());
        searchBarPanel.setBorder(new EmptyBorder(0, 150, 0, 150));
        searchBarPanel.setBackground(Color.WHITE);
        //Retrieve data from the database and create an instance of the stdt-table model
        students = new StudentDAO().getAllStudents();
        dataFilter = new DataFilter(students, null);
        searchBtn = new RoundedButton("Search", 100, 40);
        searchBtn.addActionListener(e -> {
            List<Student> studentData = searchField.getFilteredDataList();
            updateFieldsWithStudentData(studentData);
        });
        searchBarPanel.add(searchBtn);
        searchField = new SearchBar(20, students, dataFilter);
        searchField.setPreferredSize(new Dimension(300, 40));
        searchBarPanel.add(searchField);
        constraints = GridBagHelper.createConstraints(0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 0, 20, 20);
        constraints.gridwidth = 6;
        add(searchBarPanel, constraints);

        horizontalRule = new HorizontalRuleWithText("Student Information");
        constraints = GridBagHelper.createConstraints(0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        constraints.gridwidth = 6;
        add(horizontalRule, constraints);

        label = new JLabel("First Name*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 2, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        firstNameField = new RoundedTextField(20, "First Name");
        constraints = GridBagHelper.createConstraints(1, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(firstNameField, constraints);

        // Middle Name
        label = new JLabel("Middle Name");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 2, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        middleNameField = new RoundedTextField(20, "Middle Name");
        constraints = GridBagHelper.createConstraints(3, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(middleNameField, constraints);

        // Last Name
        label = new JLabel("Last Name*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(4, 2, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        lastNameField = new RoundedTextField(20, "Last Name");
        constraints = GridBagHelper.createConstraints(5, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(lastNameField, constraints);

        // ID Number
        label = new JLabel("ID Number*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 3, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        idNumberField = new RoundedTextField(20, "ID Number");
        constraints = GridBagHelper.createConstraints(1, 3, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(idNumberField, constraints);

        // Age
        label = new JLabel("Age*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 4, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        ageField = new RoundedTextField(20, "Age");
        constraints = GridBagHelper.createConstraints(1, 4, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(ageField, constraints);

        // Class
        label = new JLabel("Class*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 4, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        classField = new RoundedTextField(20, "Class");
        constraints = GridBagHelper.createConstraints(3, 4, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(classField, constraints);

        horizontalRule = new HorizontalRuleWithText("Contact Information");
        constraints = GridBagHelper.createConstraints(0, 5, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        constraints.gridwidth = 6;
        add(horizontalRule, constraints);

        // Phone1
        label = new JLabel("Phone1*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 6, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        phone1Field = new RoundedTextField(20, "Phone1");
        constraints = GridBagHelper.createConstraints(1, 6, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone1Field, constraints);

        // Phone2
        label = new JLabel("Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 6, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        phone2Field = new RoundedTextField(20, "Phone2");
        constraints = GridBagHelper.createConstraints(3, 6, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone2Field, constraints);

        // Email
        label = new JLabel("Email");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 7, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        emailField = new RoundedTextField(20, "Email");
        constraints = GridBagHelper.createConstraints(1, 7, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(emailField, constraints);

        // Guardian Phone1
        label = new JLabel("Guardian Phone1*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 8, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone1Field = new RoundedTextField(20, "Guardian Phone1");
        constraints = GridBagHelper.createConstraints(1, 8, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone1Field, constraints);

        // Guardian Phone2
        label = new JLabel("Guardian Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 8, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone2Field = new RoundedTextField(20, "Guardian Phone2");
        constraints = GridBagHelper.createConstraints(3, 8, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone2Field, constraints);

        // Guardian Email
        label = new JLabel("Guardian Email*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 10, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, 0, 10, 10, 10);
        add(label, constraints);

        guardianEmailField = new RoundedTextField(20, "Guardian Email");
        constraints = GridBagHelper.createConstraints(1, 10, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, 1, 10, 10, 10);
        add(guardianEmailField, constraints);

        lastPanel = new GradientPanel();
        lastPanel.setLayout(new GridBagLayout());
        constraints = GridBagHelper.createConstraints(0, 11, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 0, 100, 100);
        constraints.gridwidth = 6;
        constraints.gridheight = 5;
        add(lastPanel, constraints);

        //Add a button to the last panel
        RoundedButton saveButton = new RoundedButton("Save", 150, 40);
        saveButton.addActionListener(e -> validateAndShowConfirmationDialog());
        constraints = GridBagHelper.createConstraints(0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        lastPanel.add(saveButton, constraints);

        RoundedButton clearButton = new RoundedButton("clear", 150, 40);
        clearButton.addActionListener(e -> clearFields());
        clearButton.setBackground(new Color(255, 255, 255));
        clearButton.setForeground(new Color(0, 0, 0));
        constraints = GridBagHelper.createConstraints(1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        lastPanel.add(clearButton, constraints);

        RoundedButton deleteButton = new RoundedButton("Delete", 150, 40);
        deleteButton.addActionListener(e -> showDeleteDialog());
        deleteButton.setBackground(new Color(255, 255, 255));
        deleteButton.setForeground(new Color(210, 1, 59));
        constraints = GridBagHelper.createConstraints(2, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        lastPanel.add(deleteButton, constraints);
    }

    public void updateStudentData() {
        this.students = new StudentDAO().getAllStudents();
    }

    private void setLabelFont(JLabel label) {
        label.setFont(new Font("Grauda", Font.BOLD, 16));
    }

    private void setLabelFont(JLabel label, int size) {
        label.setFont(new Font("Grauda", Font.BOLD, size));
    }

    private void clearFields() {
        firstNameField.setText("First Name");
        middleNameField.setText("Middle Name");
        lastNameField.setText("Last Name");
        idNumberField.setText("ID Number");
        ageField.setText("Age");
        classField.setText("Class");
        phone1Field.setText("Phone1");
        phone2Field.setText("Phone2");
        emailField.setText("Email");
        guardianPhone1Field.setText("Guardian Phone1");
        guardianPhone2Field.setText("Guardian Phone2");
        guardianEmailField.setText("Guardian Email");
    }

    public void updateFieldsWithStudentData(List<Student> studentData) {
        if (studentData.size() == 1) {
            List<Clss> classes = new ClassDAO().getAllClasses();
            Student student = studentData.getFirst();
            firstNameField.setText(student.getFirstName());
            middleNameField.setText(student.getMiddleName());
            lastNameField.setText(student.getLastName());
            idNumberField.setText(String.valueOf(student.getIdNumber()));
            ageField.setText(String.valueOf(student.getAge()));
            classField.setText(student.getClassName(classes));
            phone1Field.setText(student.getPhone1());
            phone2Field.setText(student.getPhone2());
            emailField.setText(student.getEmail());
            guardianPhone1Field.setText(student.getGuardianPhone1());
            guardianPhone2Field.setText(student.getGuardianPhone2());
            guardianEmailField.setText(student.getGuardianEmail());
            studentInView = student;
        }
    }

    private void validateAndShowConfirmationDialog() {
        if (Objects.equals(getFirstName(), "First Name")
                || Objects.equals(getLastName(), "Middle Name")
                || Objects.equals(getIdNumber(), "ID Number")
                || Objects.equals(getAge(), "Age")
                || Objects.equals(getClassField(), "Class")
                || Objects.equals(getPhone1(), "Phone1")
                || Objects.equals(getGuardianPhone1(), "Guardian Phone1")
                || Objects.equals(getGuardianEmail(), "Guardian Email")) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields marked with *.", "Incomplete Details", JOptionPane.WARNING_MESSAGE);
        } else {
            showConfirmationDialog();
        }
    }

    private void showConfirmationDialog() {
        String message = String.format(
                "First Name: %s\nMiddle Name: %s\nLast Name: %s\nID Number: %s\nAge: %s\nClass: %s\nPhone1: %s\nPhone2: %s\nEmail: %s\nGuardian Phone1: %s\nGuardian Phone2: %s\nGuardian Email: %s",
                getFirstName(), getMiddleName(), getLastName(), getIdNumber(), getAge(), getClassField(), getPhone1(), getPhone2(), getEmail(), getGuardianPhone1(), getGuardianPhone2(), getGuardianEmail()
        );

        int option = JOptionPane.showConfirmDialog(this, message, "Confirm Update : ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            updateStudent();
        }
    }

    private void showDeleteDialog() {
        String message = String.format(
                "WARNING : THIS ACTION IS IRREVERSIBLE\nFirst Name: %s\nMiddle Name: %s\nLast Name: %s\nID Number: %s\nAge: %s\nClass: %s\nPhone1: %s\nPhone2: %s\nEmail: %s\nGuardian Phone1: %s\nGuardian Phone2: %s\nGuardian Email: %s",
                getFirstName(), getMiddleName(), getLastName(), getIdNumber(), getAge(), getClassField(), getPhone1(), getPhone2(), getEmail(), getGuardianPhone1(), getGuardianPhone2(), getGuardianEmail()
        );

        int option = JOptionPane.showConfirmDialog(this, message, "Confirm Data Deletion : ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            deleteStudent();
        }
    }
    //TODO: Handle invalid data input for registration and update panels

    //TODO: Make sure to update the table after deleting a student

    /**
     *
     * Accesed the current student in view object via the
     * stdInView variable that is set whenever a student is inserted to the fields.
     */
    private void deleteStudent() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteStudent(studentInView.getId());
        MainUI.getInstance().getViewList().updateStudentData();
        MainUI.getInstance().getUpdatePanel().updateStudentData();

    }

    private void updateStudent() {
        Clss clss = new Clss();
        studentInView.setFirstName(getFirstName());
        studentInView.setMiddleName(getMiddleName());
        studentInView.setLastName(getLastName());
        studentInView.setIdNumber(getIdNumber());
        studentInView.setClassId(new ClassDAO().getClassIdByName(getClassField()));
        studentInView.setAge(Integer.parseInt(getAge()));
        studentInView.setPhone1(getPhone1());
        studentInView.setPhone2(getPhone2());
        studentInView.setEmail(getEmail());
        studentInView.setGuardianPhone1(getGuardianPhone1());
        studentInView.setGuardianPhone2(getGuardianPhone2());
        studentInView.setGuardianEmail(getGuardianEmail());

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.updateStudent(studentInView);
        MainUI.getInstance().getViewList().updateStudentData();
        MainUI.getInstance().getUpdatePanel().updateStudentData();

    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getMiddleName() {
        return middleNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getIdNumber() {
        return idNumberField.getText();
    }

    public String getAge() {
        return ageField.getText();
    }

    public String getClassField() {
        return classField.getText();
    }

    public String getPhone1() {
        return phone1Field.getText();
    }

    public String getPhone2() {
        return phone2Field.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getGuardianPhone1() {
        return guardianPhone1Field.getText();
    }

    public String getGuardianPhone2() {
        return guardianPhone2Field.getText();
    }

    public String getGuardianEmail() {
        return guardianEmailField.getText();
    }

}