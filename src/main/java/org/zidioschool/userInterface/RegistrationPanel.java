package org.zidioschool.userInterface;

import org.zidioschool.services.Registration;
import org.zidioschool.userInterface.customComponents.RoundedButton;
import org.zidioschool.userInterface.customComponents.RoundedPanel;
import org.zidioschool.userInterface.customComponents.RoundedPasswordField;
import org.zidioschool.userInterface.customComponents.RoundedTextField;

import javax.swing.*;
import java.awt.*;

public class RegistrationPanel extends RoundedPanel {
    private RoundedTextField usernameField;
    private RoundedTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private Registration registrationLogic;

    public RegistrationPanel() {
        super(20, Color.GRAY, Color.WHITE, 2);
        setLayout(new GridBagLayout());
        registrationLogic = new Registration();

        // Welcome label
        JLabel welcomeLabel = new JLabel("Register at Zidio School");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel, GridBagHelper.createConstraints(0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Username label
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel, GridBagHelper.createConstraints(0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0));

        // Username field
        usernameField = new RoundedTextField(20, "username");
        add(usernameField, GridBagHelper.createConstraints(0, 2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Email label
        JLabel emailLabel = new JLabel("Email:");
        add(emailLabel, GridBagHelper.createConstraints(0, 3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0));

        // Email field
        emailField = new RoundedTextField(20, "email");
        add(emailField, GridBagHelper.createConstraints(0, 4, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel, GridBagHelper.createConstraints(0, 5, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0));

        // Password field
        passwordField = new RoundedPasswordField(20);
        passwordField.setText("Password");
        add(passwordField, GridBagHelper.createConstraints(0, 6, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Confirm Password label
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        add(confirmPasswordLabel, GridBagHelper.createConstraints(0, 7, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0));

        // Confirm Password field
        confirmPasswordField = new RoundedPasswordField(20);
        confirmPasswordField.setText("Confirm Password");
        add(confirmPasswordField, GridBagHelper.createConstraints(0, 8, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Register button
        registerButton = new RoundedButton("Register", 150, 40);
        registerButton.addActionListener(e -> registerUser());
        add(registerButton, GridBagHelper.createConstraints(0, 9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));
    }

    private void registerUser() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        int teacherId = 1; // Example teacher ID, replace with actual logic

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (registrationLogic.register(email, password, teacherId)) {
            JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "User already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

        // Overload method to have custom weight or anchor if needed
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new RegistrationPanel());
        frame.setVisible(true);
    }
}