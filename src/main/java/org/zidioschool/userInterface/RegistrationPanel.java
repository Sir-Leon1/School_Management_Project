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
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class RegistrationPanel extends JPanel {
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

    String firstNameExample = "eg..John";
    String middleNameExample = "eg..Doe";
    String lastNameExample = "eg..Smith";
    String idNumberExample = "eg..123456";
    String ageExample = "eg..12";
    String classExample = "eg..Chicago";
    String phone1Example = "eg..0712345678";
    String phone2Example = "eg..0712345678";
    String emailExample = "eg..john@vilettech.mail.com";
    String guardianPhone1Example = "eg..0788721657";
    String guardianPhone2Example = "eg..0788721657";
    String guardianEmailExample = "eg..guardian@vilettech.mail.com";

    public RegistrationPanel() {
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

        firstNameField = new RoundedTextField(20, firstNameExample);
        constraints = GridBagHelper.createConstraints(1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(firstNameField, constraints);

        // Middle Name
        label = new JLabel("Middle Name");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        middleNameField = new RoundedTextField(20, middleNameExample);
        constraints = GridBagHelper.createConstraints(3, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(middleNameField, constraints);

        // Last Name
        label = new JLabel("Last Name*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(4, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        lastNameField = new RoundedTextField(20, lastNameExample);
        constraints = GridBagHelper.createConstraints(5, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(lastNameField, constraints);

        // ID Number
        label = new JLabel("ID Number*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 2, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        idNumberField = new RoundedTextField(20, idNumberExample);
        constraints = GridBagHelper.createConstraints(1, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(idNumberField, constraints);

        // Age
        label = new JLabel("Age*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 3, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        ageField = new RoundedTextField(20, ageExample);
        constraints = GridBagHelper.createConstraints(1, 3, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(ageField, constraints);

        // Class
        label = new JLabel("Class*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 3, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        classField = new RoundedTextField(20, classExample);
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

        phone1Field = new RoundedTextField(20, phone1Example);
        constraints = GridBagHelper.createConstraints(1, 5, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone1Field, constraints);

        // Phone2
        label = new JLabel("Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 5, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        phone2Field = new RoundedTextField(20, phone2Example);
        constraints = GridBagHelper.createConstraints(3, 5, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone2Field, constraints);

        // Email
        label = new JLabel("Email");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 6, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        emailField = new RoundedTextField(20, emailExample);
        constraints = GridBagHelper.createConstraints(1, 6, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(emailField, constraints);

        // Guardian Phone1
        label = new JLabel("Guardian Phone1*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 7, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone1Field = new RoundedTextField(20, guardianPhone1Example);
        constraints = GridBagHelper.createConstraints(1, 7, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone1Field, constraints);

        // Guardian Phone2
        label = new JLabel("Guardian Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 7, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone2Field = new RoundedTextField(20, guardianPhone2Example);
        constraints = GridBagHelper.createConstraints(3, 7, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone2Field, constraints);

        // Guardian Email
        label = new JLabel("Guardian Email*");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 9, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, 0, 1, 10, 10);
        add(label, constraints);

        guardianEmailField = new RoundedTextField(20, guardianEmailExample);
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
        firstNameField.setText(firstNameExample);
        middleNameField.setText(middleNameExample);
        lastNameField.setText(lastNameExample);
        idNumberField.setText(idNumberExample);
        ageField.setText(ageExample);
        classField.setText(classExample);
        phone1Field.setText(phone1Example);
        phone2Field.setText(phone2Example);
        emailField.setText(emailExample);
        guardianPhone1Field.setText(guardianPhone1Example);
        guardianPhone2Field.setText(guardianPhone2Example);
        guardianEmailField.setText(guardianEmailExample);
    }

    private void validateAndShowConfirmationDialog() {
        if (Objects.equals(firstNameField.getText(), firstNameExample)
                || Objects.equals(lastNameField.getText(), lastNameExample)
                || Objects.equals(idNumberField.getText(), idNumberExample)
                || Objects.equals(ageField.getText(), ageExample)
                || Objects.equals(classField.getText(), classExample)
                || Objects.equals(phone1Field.getText(), phone1Example)
                || Objects.equals(guardianPhone1Field.getText(), guardianPhone1Example)
                || Objects.equals(guardianEmailField.getText(), guardianEmailExample)) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields marked with *.", "Incomplete Details", JOptionPane.WARNING_MESSAGE);
        } else {

            if (Objects.equals(middleNameField.getText(), middleNameExample)) {
                middleNameField.setText("");
            }
            if (Objects.equals(phone2Field.getText(), phone2Example)) {
                phone2Field.setText("");
            }
            if (Objects.equals(emailField.getText(), emailExample)) {
                emailField.setText("");
            }
            if (Objects.equals(guardianPhone2Field.getText(), guardianPhone2Example)) {
                guardianPhone2Field.setText("");
            }

            showConfirmationDialog();
        }
    } //todo handle the confirmation dialog to set not * field values to null if not given by the user

    private void showConfirmationDialog() {
        String message = String.format(
                "First Name: %s\nMiddle Name: %s\nLast Name: %s\nID Number: %s\nAge: %s\nClass: %s\nPhone1: %s\nPhone2: %s\nEmail: %s\nGuardian Phone1: %s\nGuardian Phone2: %s\nGuardian Email: %s",
                firstNameField.getText(), middleNameField.getText(), lastNameField.getText(), idNumberField.getText(), ageField.getText(), classField.getText(), phone1Field.getText(), phone2Field.getText(), emailField.getText(), guardianPhone1Field.getText(), guardianPhone2Field.getText(), guardianEmailField.getText()
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
        student.setFirstName(firstNameField.getText());
        student.setMiddleName(middleNameField.getText());
        student.setLastName(lastNameField.getText());
        student.setIdNumber(idNumberField.getText());
        student.setAge(Integer.parseInt(ageField.getText()));
        student.setClassId(new ClassDAO().getClassIdByName(classField.getText()));
        student.setPhone1(phone1Field.getText());
        student.setPhone2(phone2Field.getText());
        student.setEmail(emailField.getText());
        student.setGuardianPhone1(guardianPhone1Field.getText());
        student.setGuardianPhone2(guardianPhone2Field.getText());
        student.setGuardianEmail(guardianEmailField.getText());

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);
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

