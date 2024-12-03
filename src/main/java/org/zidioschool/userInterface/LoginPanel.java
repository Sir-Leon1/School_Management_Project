package org.zidioschool.userInterface;

import org.zidioschool.services.Login;
import org.zidioschool.userInterface.customComponents.RoundedButton;
import org.zidioschool.userInterface.customComponents.RoundedPanel;
import org.zidioschool.userInterface.customComponents.RoundedPasswordField;
import org.zidioschool.userInterface.customComponents.RoundedTextField;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends RoundedPanel {
    private RoundedTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private Login loginLogic;

    public LoginPanel() {
        super(20, Color.GRAY, Color.WHITE, 2);
        setLayout(new GridBagLayout());
        loginLogic = new Login();

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Zidio School");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel, GridBagHelper.createConstraints(0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Username label
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel, GridBagHelper.createConstraints(0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Username field
        usernameField = new RoundedTextField(20, "username");
        add(usernameField, GridBagHelper.createConstraints(0, 2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Password label
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel, GridBagHelper.createConstraints(0, 3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Password field
        passwordField = new RoundedPasswordField(20);
        passwordField.setText("Password");
        add(passwordField, GridBagHelper.createConstraints(0, 4, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Login button
        loginButton = new RoundedButton("Login", 150, 40);
        loginButton.addActionListener(e -> authenticateUser());
        add(loginButton, GridBagHelper.createConstraints(0, 5, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));

        // Register button
        registerButton = new RoundedButton("Register", 150, 40);
        registerButton.addActionListener(e -> {
            JFrame frame = new JFrame("Registration Panel");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);
            frame.add(new RegistrationPanel());
            frame.setVisible(true);
        });
        add(registerButton, GridBagHelper.createConstraints(0, 6, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 0, 10, 10));
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.add(new LoginPanel());
        frame.setVisible(true);
    }
}