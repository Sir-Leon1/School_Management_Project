package org.zidioschool.userInterface;

import org.zidioschool.model.ClassDAO;
import org.zidioschool.model.StudentDAO;
import org.zidioschool.model.modelClasses.Clss;
import org.zidioschool.model.modelClasses.Student;
import org.zidioschool.services.DataFilter;
import org.zidioschool.userInterface.customComponents.*;

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

    private static final String FIRST_NAME_PLACEHOLDER = "First Name";
    private static final String MIDDLE_NAME_PLACEHOLDER = "Middle Name";
    private static final String LAST_NAME_PLACEHOLDER = "Last Name";
    private static final String ID_NUMBER_PLACEHOLDER = "ID Number";
    private static final String AGE_PLACEHOLDER = "Age";
    private static final String CLASS_PLACEHOLDER = "Class";
    private static final String PHONE1_PLACEHOLDER = "Phone1";
    private static final String PHONE2_PLACEHOLDER = "Phone2";
    private static final String EMAIL_PLACEHOLDER = "Email";
    private static final String GUARDIAN_PHONE1_PLACEHOLDER = "Guardian Phone1";
    private static final String GUARDIAN_PHONE2_PLACEHOLDER = "Guardian Phone2";
    private static final String GUARDIAN_EMAIL_PLACEHOLDER = "Guardian Email";

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

        firstNameField = new RoundedTextField(20, FIRST_NAME_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(1, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(firstNameField, constraints);

        // Middle Name
        label = new JLabel("Middle Name");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 2, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        middleNameField = new RoundedTextField(20, MIDDLE_NAME_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(3, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(middleNameField, constraints);

        // Last Name
        label = new JLabel("Last Name*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(4, 2, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        lastNameField = new RoundedTextField(20, LAST_NAME_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(5, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(lastNameField, constraints);

        // ID Number
        label = new JLabel("ID Number*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 3, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        idNumberField = new RoundedTextField(20, ID_NUMBER_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(1, 3, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(idNumberField, constraints);

        // Age
        label = new JLabel("Age*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 4, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        ageField = new RoundedTextField(20, AGE_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(1, 4, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(ageField, constraints);

        // Class
        label = new JLabel("Class*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 4, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        classField = new RoundedTextField(20, CLASS_PLACEHOLDER);
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

        phone1Field = new RoundedTextField(20, PHONE1_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(1, 6, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone1Field, constraints);

        // Phone2
        label = new JLabel("Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 6, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        phone2Field = new RoundedTextField(20, PHONE2_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(3, 6, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone2Field, constraints);

        // Email
        label = new JLabel("Email");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 7, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        emailField = new RoundedTextField(20, EMAIL_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(1, 7, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(emailField, constraints);

        // Guardian Phone1
        label = new JLabel("Guardian Phone1*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 8, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone1Field = new RoundedTextField(20, GUARDIAN_PHONE1_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(1, 8, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone1Field, constraints);

        // Guardian Phone2
        label = new JLabel("Guardian Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 8, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone2Field = new RoundedTextField(20, GUARDIAN_PHONE2_PLACEHOLDER);
        constraints = GridBagHelper.createConstraints(3, 8, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone2Field, constraints);

        // Guardian Email
        label = new JLabel("Guardian Email*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 10, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, 0, 10, 10, 10);
        add(label, constraints);

        guardianEmailField = new RoundedTextField(20, GUARDIAN_EMAIL_PLACEHOLDER);
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
        firstNameField.setText(FIRST_NAME_PLACEHOLDER);
        middleNameField.setText(MIDDLE_NAME_PLACEHOLDER);
        lastNameField.setText(LAST_NAME_PLACEHOLDER);
        idNumberField.setText(ID_NUMBER_PLACEHOLDER);
        ageField.setText(AGE_PLACEHOLDER);
        classField.setText(CLASS_PLACEHOLDER);
        phone1Field.setText(PHONE1_PLACEHOLDER);
        phone2Field.setText(PHONE2_PLACEHOLDER);
        emailField.setText(EMAIL_PLACEHOLDER);
        guardianPhone1Field.setText(GUARDIAN_PHONE1_PLACEHOLDER);
        guardianPhone2Field.setText(GUARDIAN_PHONE2_PLACEHOLDER);
        guardianEmailField.setText(GUARDIAN_EMAIL_PLACEHOLDER);
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
        if (Objects.equals(firstNameField.getText(), FIRST_NAME_PLACEHOLDER)
                || Objects.equals(lastNameField.getText(), LAST_NAME_PLACEHOLDER)
                || Objects.equals(idNumberField.getText(), ID_NUMBER_PLACEHOLDER)
                || Objects.equals(ageField.getText(), AGE_PLACEHOLDER)
                || Objects.equals(classField.getText(), CLASS_PLACEHOLDER)
                || Objects.equals(phone1Field.getText(), PHONE1_PLACEHOLDER)
                || Objects.equals(guardianPhone1Field.getText(), GUARDIAN_PHONE1_PLACEHOLDER)
                || Objects.equals(guardianEmailField.getText(), GUARDIAN_EMAIL_PLACEHOLDER)) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields marked with *.", "Incomplete Details", JOptionPane.WARNING_MESSAGE);
        } else {

            if (Objects.equals(middleNameField.getText(), MIDDLE_NAME_PLACEHOLDER)) {
                middleNameField.setText("");
            }
            if (Objects.equals(phone2Field.getText(), PHONE2_PLACEHOLDER)) {
                phone2Field.setText("");
            }
            if (Objects.equals(emailField.getText(), EMAIL_PLACEHOLDER)) {
                emailField.setText("");
            }
            if (Objects.equals(guardianPhone2Field.getText(), GUARDIAN_PHONE2_PLACEHOLDER)) {
                guardianPhone2Field.setText("");
            }
            showConfirmationDialog();
        }
    }

    private void showConfirmationDialog() {
        String message = String.format(
                "First Name: %s\nMiddle Name: %s\nLast Name: %s\nID Number: %s\nAge: %s\nClass: %s\nPhone1: %s\nPhone2: %s\nEmail: %s\nGuardian Phone1: %s\nGuardian Phone2: %s\nGuardian Email: %s",
                firstNameField.getText(), middleNameField.getText(), lastNameField.getText(), idNumberField.getText(), ageField.getText(), classField.getText(), phone1Field.getText(), phone2Field.getText(), emailField.getText(), guardianPhone1Field.getText(), guardianPhone2Field.getText(), guardianEmailField.getText()
        );

        int option = JOptionPane.showConfirmDialog(this, message, "Confirm Update : ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            updateStudent();
        }
    }

    private void showDeleteDialog() {
        String message = String.format(
                "WARNING : THIS ACTION IS IRREVERSIBLE\nFirst Name: %s\nMiddle Name: %s\nLast Name: %s\nID Number: %s\nAge: %s\nClass: %s\nPhone1: %s\nPhone2: %s\nEmail: %s\nGuardian Phone1: %s\nGuardian Phone2: %s\nGuardian Email: %s",
                firstNameField.getText(), middleNameField.getText(), lastNameField.getText(), idNumberField.getText(), ageField.getText(), classField.getText(), phone1Field.getText(), phone2Field.getText(), emailField.getText(), guardianPhone1Field.getText(), guardianPhone2Field.getText(), guardianEmailField.getText()
        );

        int option = JOptionPane.showConfirmDialog(this, message, "Confirm Data Deletion : ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            deleteStudent();
        }
    }
    //TODO: Handle invalid data input for registration and update panels


    //TODO: Make sure to update the table after deleting a student

    /**
     * Accesed the current student in view object via the
     * stdInView variable that is set whenever a student is inserted to the fields.
     */
    private void deleteStudent() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteStudent(studentInView.getId());
        MainUI.getInstance().getViewList().updateStudentData();
        MainUI.getInstance().getUpdatePanel().updateStudentData();
        clearFields();

    }

    private void updateStudent() {
        Clss clss = new Clss();
        studentInView.setFirstName(firstNameField.getText());
        studentInView.setMiddleName(middleNameField.getText());
        studentInView.setLastName(lastNameField.getText());
        studentInView.setIdNumber(idNumberField.getText());
        studentInView.setClassId(new ClassDAO().getClassIdByName(classField.getText()));
        studentInView.setAge(Integer.parseInt(ageField.getText()));
        studentInView.setPhone1(phone1Field.getText());
        studentInView.setPhone2(phone2Field.getText());
        studentInView.setEmail(emailField.getText());
        studentInView.setGuardianPhone1(guardianPhone1Field.getText());
        studentInView.setGuardianPhone2(guardianPhone2Field.getText());
        studentInView.setGuardianEmail(guardianEmailField.getText());

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.updateStudent(studentInView);
        MainUI.getInstance().getViewList().updateStudentData();
        MainUI.getInstance().getUpdatePanel().updateStudentData();
    }


    public class GridBagHelper {
        public static GridBagConstraints createConstraints(int gridx, int gridy) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = gridx;
            constraints.gridy = gridy;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.insets = new Insets(10, 10, 10, 10);
            constraints.anchor = GridBagConstraints.NORTH;
            constraints.fill = GridBagConstraints.NONE;

            return constraints;
        }

        //Overload method to have custom weight or anchor if needed
        public static GridBagConstraints createConstraints(int gridx, int gridy, int anchor, int fill, double weightx, double weighty, int ipadx, int ipady) {
            GridBagConstraints constraints = createConstraints(gridx, gridy);
            constraints.anchor = anchor;
            constraints.weightx = weightx;
            constraints.weighty = weighty;
            constraints.ipadx = ipadx;
            constraints.ipady = ipady;
            constraints.fill = fill;

            return constraints;
        }
    }
}