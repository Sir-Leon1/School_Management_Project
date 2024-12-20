package org.zidioschool.userInterface;

import org.zidioschool.services.Login;
import org.zidioschool.userInterface.customComponents.*;
import org.zidioschool.userInterface.customComponents.panels.GradientPanel;
import org.zidioschool.userInterface.customComponents.panels.RoundedPanel;
import org.zidioschool.userInterface.customComponents.panels.helpers.GridBagHelper;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends GradientPanel {
    public GridBagHelper GridBagHelper;
    private RoundedPanel infoPanel;
    private RoundedTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private Login loginLogic;
    private GridBagConstraints gbc;

    public LoginPanel() {

        setLayout(new GridBagLayout());
        loginLogic = new Login();
        gbc = new GridBagConstraints();

        infoPanel = new RoundedPanel(20, Color.GRAY, Color.WHITE, 2);
        infoPanel.setLayout(new GridBagLayout());
        gbc = GridBagHelper.createConstraints(0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        add(infoPanel, gbc);

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Zidio School");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 19));
        gbc = GridBagHelper.createConstraints(0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        infoPanel.add(welcomeLabel, gbc);

        // Username label
        JLabel usernameLabel = new JLabel("Email:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc = GridBagHelper.createConstraints(0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        add(usernameLabel, gbc);

        // Username field
        usernameField = new RoundedTextField(20, "email");
        usernameField.setForeground(Color.WHITE);
        gbc = GridBagHelper.createConstraints(0, 2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        add(usernameField, gbc);

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc = GridBagHelper.createConstraints(0, 3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        add(passwordLabel, gbc);

        // Password field
        passwordField = new RoundedPasswordField(20);
        passwordField.setText("Password");
        gbc = GridBagHelper.createConstraints(0, 4, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        add(passwordField, gbc);

        // Login button
        loginButton = new RoundedButton("Login", 150, 40);
        loginButton.addActionListener(e -> authenticateUser());
        gbc = GridBagHelper.createConstraints(0, 5, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        add(loginButton, gbc);

        // Register button
        registerButton = new RoundedButton("Register", 150, 40);
        registerButton.addActionListener(e -> {
            MainUI.getInstance().showSignUpUI();
        });
        gbc = GridBagHelper.createConstraints(0, 6, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10);
        add(registerButton, gbc);
    }

    private void authenticateUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (true/*loginLogic.authenticate(username, password)*/) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            MainUI.getInstance().showMainUI();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.add(new LoginPanel());
        frame.setVisible(true);
    }
}