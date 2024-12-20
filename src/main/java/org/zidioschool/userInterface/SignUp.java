package org.zidioschool.userInterface;

import org.zidioschool.services.Registration;
import org.zidioschool.userInterface.customComponents.*;
import org.zidioschool.userInterface.customComponents.panels.GradientPanel;
import org.zidioschool.userInterface.customComponents.panels.RoundedPanel;
import org.zidioschool.userInterface.customComponents.panels.helpers.GridBagHelper;

import javax.swing.*;
import java.awt.*;

public class SignUp extends GradientPanel {
    private RoundedPanel infoPanel;
    private RoundedTextField usernameField;
    private RoundedTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton loginBtn;
    private Registration registrationLogic;
    private GridBagConstraints gbc;
    private GridBagHelper gbh;

    public SignUp() {

        setLayout(new GridBagLayout());
        registrationLogic = new Registration();
        gbc = new GridBagConstraints();

        infoPanel = new RoundedPanel(20, Color.GRAY, Color.WHITE, 2);
        infoPanel.setLayout(new GridBagLayout());
        gbc = gbh.createConstraints(0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        add(infoPanel, gbc);

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Zidio School");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 19));
        gbc = gbh.createConstraints(0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        infoPanel.add(welcomeLabel, gbc);

        // Username label
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel, gbh.createConstraints(0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0));

        // Username field
        usernameField = new RoundedTextField(20, "username");
        usernameField.setForeground(Color.WHITE);
        add(usernameField, gbh.createConstraints(0, 2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Email label
        JLabel emailLabel = new JLabel("Email:");
        add(emailLabel, gbh.createConstraints(0, 3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0));

        // Email field
        emailField = new RoundedTextField(20, "email");
        add(emailField, gbh.createConstraints(0, 4, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel, gbh.createConstraints(0, 5, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0));

        // Password field
        passwordField = new RoundedPasswordField(20);
        passwordField.setText("Password");
        add(passwordField, gbh.createConstraints(0, 6, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Confirm Password label
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        add(confirmPasswordLabel, gbh.createConstraints(0, 7, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 0, 0));

        // Confirm Password field
        confirmPasswordField = new RoundedPasswordField(20);
        confirmPasswordField.setText("Confirm Password");
        add(confirmPasswordField, gbh.createConstraints(0, 8, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Register button
        registerButton = new RoundedButton("Register", 150, 40);
        registerButton.addActionListener(e -> registerUser());
        add(registerButton, gbh.createConstraints(0, 9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Back to login button
        loginBtn = new RoundedButton("Back To Login", 150, 40);
        loginBtn.addActionListener(e -> {
            MainUI.getInstance().showLoginUI();
        });
        add(loginBtn, gbh.createConstraints(0, 10, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new SignUp());
        frame.setVisible(true);
    }
}