package org.zidioschool.userInterface;

import org.zidioschool.model.ClassDAO;
import org.zidioschool.model.StudentDAO;
import org.zidioschool.model.modelClasses.Student;
import org.zidioschool.userInterface.customComponents.GradientPanel;
import org.zidioschool.userInterface.customComponents.RoundedButton;
import org.zidioschool.userInterface.customComponents.RoundedTextField;
import org.zidioschool.userInterface.customComponents.HorizontalRuleWithText;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.Objects;

public class NewStudentPanel extends JPanel {
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

    public NewStudentPanel() {
        Border outer = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border inner = BorderFactory.createTitledBorder("Registration");
        setBorder(new CompoundBorder(outer, inner));
        setBackground(Color.WHITE);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        horizontalRule = new HorizontalRuleWithText("Student Information");
        constraints = GridBagHelper.createConstraints(0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        constraints.gridwidth = 6;
        add(horizontalRule, constraints);

        label = new JLabel("First Name*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        firstNameField = new RoundedTextField(20, "eg..John");
        constraints = GridBagHelper.createConstraints(1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(firstNameField, constraints);

        // Middle Name
        label = new JLabel("Middle Name");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        middleNameField = new RoundedTextField(20, "eg..Doe");
        constraints = GridBagHelper.createConstraints(3, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(middleNameField, constraints);

        // Last Name
        label = new JLabel("Last Name*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(4, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        lastNameField = new RoundedTextField(20, "eg..Smith");
        constraints = GridBagHelper.createConstraints(5, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(lastNameField, constraints);

        // ID Number
        label = new JLabel("ID Number*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 2, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        idNumberField = new RoundedTextField(20, "eg..123456");
        constraints = GridBagHelper.createConstraints(1, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(idNumberField, constraints);

        // Age
        label = new JLabel("Age*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 3, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        ageField = new RoundedTextField(20, "eg..12");
        constraints = GridBagHelper.createConstraints(1, 3, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(ageField, constraints);

        // Class
        label = new JLabel("Class*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 3, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        classField = new RoundedTextField(20, "eg..Chicago");
        constraints = GridBagHelper.createConstraints(3, 3, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(classField, constraints);

        horizontalRule = new HorizontalRuleWithText("Contact Information");
        constraints = GridBagHelper.createConstraints(0, 4, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        constraints.gridwidth = 6;
        add(horizontalRule, constraints);

        // Phone1
        label = new JLabel("Phone1*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 5, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        phone1Field = new RoundedTextField(20, "eg..0712345678");
        constraints = GridBagHelper.createConstraints(1, 5, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone1Field, constraints);

        // Phone2
        label = new JLabel("Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 5, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        phone2Field = new RoundedTextField(20, "eg..0712345678");
        constraints = GridBagHelper.createConstraints(3, 5, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone2Field, constraints);

        // Email
        label = new JLabel("Email");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 6, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        emailField = new RoundedTextField(20, "eg..john@vilettech.mail.com");
        constraints = GridBagHelper.createConstraints(1, 6, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(emailField, constraints);

        // Guardian Phone1
        label = new JLabel("Guardian Phone1*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 7, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone1Field = new RoundedTextField(20, "eg..0788721657");
        constraints = GridBagHelper.createConstraints(1, 7, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone1Field, constraints);

        // Guardian Phone2
        label = new JLabel("Guardian Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 7, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone2Field = new RoundedTextField(20, "eg..0788721657");
        constraints = GridBagHelper.createConstraints(3, 7, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone2Field, constraints);

        // Guardian Email
        label = new JLabel("Guardian Email*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 9, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, 0, 1, 10, 10);
        add(label, constraints);

        guardianEmailField = new RoundedTextField(20, "eg..guardian@vilettech.mail.com");
        constraints = GridBagHelper.createConstraints(1, 9, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, 1, 1, 10, 10);
        add(guardianEmailField, constraints);

        lastPanel = new GradientPanel();
        lastPanel.setLayout(new GridBagLayout());
        constraints = GridBagHelper.createConstraints(0, 10, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 0, 100, 100);
        constraints.gridwidth = 6;
        constraints.gridheight = 5;
        add(lastPanel, constraints);

        //Add a button to the last panel
        RoundedButton registerButton = new RoundedButton("Register", 150, 40);
        registerButton.addActionListener(e -> validateAndShowConfirmationDialog());
        constraints = GridBagHelper.createConstraints(0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        lastPanel.add(registerButton, constraints);

        RoundedButton clearButton = new RoundedButton("Clear", 150, 40);
        clearButton.addActionListener(e -> clearFields());
        clearButton.setBackground(new Color(255, 255, 255));
        clearButton.setForeground(new Color(0, 0, 0));
        constraints = GridBagHelper.createConstraints(1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        lastPanel.add(clearButton, constraints);
    }

    private void setLabelFont(JLabel label) {
        label.setFont(new Font("Grauda", Font.BOLD, 16));
    }

    private void setLabelFont(JLabel label, int size) {
        label.setFont(new Font("Grauda", Font.BOLD, size));
    }

    private void clearFields() {
        firstNameField.setText("eg..John");
        middleNameField.setText("eg..Doe");
        lastNameField.setText("eg..Smith");
        idNumberField.setText("eg..123456");
        ageField.setText("eg..12");
        classField.setText("eg..Chicago");
        phone1Field.setText("eg..0712345678");
        phone2Field.setText("eg..0712345678");
        emailField.setText("eg..john@vilettech.mail.com");
        guardianPhone1Field.setText("eg..0788721657");
        guardianPhone2Field.setText("eg..0788721657");
        guardianEmailField.setText("eg..guardian@vilettech.mail.com");
    }

    private void validateAndShowConfirmationDialog() {
        if (Objects.equals(getFirstName(), "eg..John")
                || Objects.equals(getLastName(), "eg..Smith")
                || Objects.equals(getIdNumber(), "eg..123456")
                || Objects.equals(getAge(), "eg..12")
                || Objects.equals(getClassField(), "eg..Chicago")
                || Objects.equals(getPhone1(), "eg..0712345678")
                || Objects.equals(getGuardianPhone1(), "eg..0788721657")
                || Objects.equals(getGuardianEmail(), "eg..guardian@vilettech.mail.com")) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields marked with *.", "Incomplete Details", JOptionPane.WARNING_MESSAGE);
        } else {
            showConfirmationDialog();
        }
    } //todo handle the confirmation dialog to set not * field values to null if not given by the user
    private void showConfirmationDialog() {
        String message = String.format(
                "First Name: %s\nMiddle Name: %s\nLast Name: %s\nID Number: %s\nAge: %s\nClass: %s\nPhone1: %s\nPhone2: %s\nEmail: %s\nGuardian Phone1: %s\nGuardian Phone2: %s\nGuardian Email: %s",
                getFirstName(), getMiddleName(), getLastName(), getIdNumber(), getAge(), getClassField(), getPhone1(), getPhone2(), getEmail(), getGuardianPhone1(), getGuardianPhone2(), getGuardianEmail()
        );

        int option = JOptionPane.showConfirmDialog(this, message, "Confirm Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            registerStudent();
            clearFields();
            //todo add a successful dialog box
        }
    }

    private void registerStudent() {
        Student student = new Student();
        student.setFirstName(getFirstName());
        student.setMiddleName(getMiddleName());
        student.setLastName(getLastName());
        student.setIdNumber(getIdNumber());
        student.setAge(Integer.parseInt(getAge()));
        student.setClassId(new ClassDAO().getClassIdByName(getClassField()));
        student.setPhone1(getPhone1());
        student.setPhone2(getPhone2());
        student.setEmail(getEmail());
        student.setGuardianPhone1(getGuardianPhone1());
        student.setGuardianPhone2(getGuardianPhone2());
        student.setGuardianEmail(getGuardianEmail());

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);
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

