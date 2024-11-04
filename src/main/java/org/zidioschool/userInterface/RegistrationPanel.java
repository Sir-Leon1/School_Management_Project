package org.zidioschool.userInterface;

import org.zidioschool.userInterface.customComponents.GradientPanel;
import org.zidioschool.userInterface.customComponents.RoundedButton;
import org.zidioschool.userInterface.customComponents.RoundedTextField;
import org.zidioschool.userInterface.customComponents.HorizontalRuleWithText;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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

        label = new JLabel("First Name");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        firstNameField = new RoundedTextField(20, "First Name");
        constraints = GridBagHelper.createConstraints(1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(firstNameField, constraints);

        // Middle Name
        label = new JLabel("Middle Name");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        middleNameField = new RoundedTextField(20, "Middle Name");
        constraints = GridBagHelper.createConstraints(3, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(middleNameField, constraints);

        // Last Name
        label = new JLabel("Last Name");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(4, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        lastNameField = new RoundedTextField(20, "Last Name");
        constraints = GridBagHelper.createConstraints(5, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(lastNameField, constraints);

        // ID Number
        label = new JLabel("ID Number");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 2, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        idNumberField = new RoundedTextField(20, "ID Number");
        constraints = GridBagHelper.createConstraints(1, 2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(idNumberField, constraints);

        // Age
        label = new JLabel("Age");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 3, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        ageField = new RoundedTextField(20, "Age");
        constraints = GridBagHelper.createConstraints(1, 3, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(ageField, constraints);

        // Class
        label = new JLabel("Class");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 3, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        classField = new RoundedTextField(20, "Class");
        constraints = GridBagHelper.createConstraints(3, 3, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(classField, constraints);

        horizontalRule = new HorizontalRuleWithText("Contact Information");
        constraints = GridBagHelper.createConstraints(0, 4, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        constraints.gridwidth = 6;
        add(horizontalRule, constraints);

        // Phone1
        label = new JLabel("Phone1");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 5, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        phone1Field = new RoundedTextField(20, "Phone1");
        constraints = GridBagHelper.createConstraints(1, 5, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone1Field, constraints);

        // Phone2
        label = new JLabel("Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 5, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        phone2Field = new RoundedTextField(20, "Phone2");
        constraints = GridBagHelper.createConstraints(3, 5, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(phone2Field, constraints);

        // Email
        label = new JLabel("Email");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 6, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        emailField = new RoundedTextField(20, "Email");
        constraints = GridBagHelper.createConstraints(1, 6, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(emailField, constraints);

        // Guardian Phone1
        label = new JLabel("Guardian Phone1");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 7, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone1Field = new RoundedTextField(20, "Guardian Phone1");
        constraints = GridBagHelper.createConstraints(1, 7, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone1Field, constraints);

        // Guardian Phone2
        label = new JLabel("Guardian Phone2");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(2, 7, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianPhone2Field = new RoundedTextField(20, "Guardian Phone2");
        constraints = GridBagHelper.createConstraints(3, 7, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianPhone2Field, constraints);

        // Guardian Email
        label = new JLabel("Guardian Email");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 9, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 10, 10);
        add(label, constraints);

        guardianEmailField = new RoundedTextField(20, "Guardian Email");
        constraints = GridBagHelper.createConstraints(1, 9, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, 0, 10, 10);
        add(guardianEmailField, constraints);

        lastPanel = new GradientPanel();
        lastPanel.setLayout(new GridBagLayout());
        constraints = GridBagHelper.createConstraints(0, 10, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 0, 100, 100);
        constraints.gridwidth = 6;
        constraints.gridheight = 5;
        add(lastPanel, constraints);

        //Add a button to the last panel
        RoundedButton registerButton = new RoundedButton("Register", 150, 40);
        constraints = GridBagHelper.createConstraints(0, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        lastPanel.add(registerButton, constraints);

        RoundedButton clearButton = new RoundedButton("Clear", 150, 40);
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

    public class GridBagHelper {
        public static GridBagConstraints createConstraints (int gridx, int gridy) {
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

