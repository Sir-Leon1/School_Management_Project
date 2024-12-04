package org.zidioschool.userInterface;

import org.zidioschool.model.Model;
import org.zidioschool.userInterface.customComponents.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUI extends JFrame {
    private static MainUI mainUI;
    private JPanel mainPanel;
    private LoginPanel loginPanel;
    private JPanel btnPanel;
    private JPanel tabPanel;
    private ViewList viewList;
    private NewStudentPanel registrationPanel;
    private UpdatePanel updatePanel;
    private AboutPanel reportPanel;

    private RoundedButton registerBtn;
    private RoundedButton updateBtn;
    private RoundedButton viewListBtn;
    private RoundedButton aboutBtn;

    public MainUI() {
        setTitle("Zidio School manager");

        setSize(700, 500);
        setLocationRelativeTo(null);
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout());

        loginPanel = new LoginPanel();
        mainPanel.add(loginPanel, BorderLayout.CENTER);

        btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnPanel.setBackground(Color.DARK_GRAY);
        registerBtn = new RoundedButton("+ New Student", 200, 60);
        updateBtn = new RoundedButton("Update", 200, 60);
        viewListBtn = new RoundedButton("View List", 200, 60);
        aboutBtn = new RoundedButton("Downloads", 200, 60);

        btnPanel.add(viewListBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(registerBtn);
        btnPanel.add(aboutBtn);

        tabPanel = new JPanel(new CardLayout());
        tabPanel.setBackground(Color.DARK_GRAY);

        registrationPanel = new NewStudentPanel();
        updatePanel = new UpdatePanel();
        viewList = new ViewList();
        reportPanel = new AboutPanel();

        tabPanel.add(viewList, "ViewListPanel");
        tabPanel.add(registrationPanel, "RegistrationPanel");
        tabPanel.add(updatePanel, "UpdatePanel");
        tabPanel.add(reportPanel, "ReportPanel");

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("RegistrationPanel");
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("UpdatePanel");
            }
        });

        viewListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("ViewListPanel");
            }
        });

        aboutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel("ReportPanel");
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeApp();
            }
        });

        setVisible(true);
    }

    public static synchronized MainUI getInstance() {
        if (mainUI == null) {
            mainUI = new MainUI();
        }
        return mainUI;
    }

    public void switchPanel(String panelName) {
        CardLayout cl = (CardLayout) tabPanel.getLayout();
        cl.show(tabPanel, panelName);
    }
    public ViewList getViewList() {
        return viewList;
    }

    public UpdatePanel getUpdatePanel() {
        return updatePanel;
    }

    public void showMainUI() {
        mainPanel.remove(loginPanel);
        mainUI.setSize(1500, 950);
        mainUI.setLocationRelativeTo(null);
        mainPanel.add(tabPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.NORTH);
        mainPanel.revalidate(); // Refresh the UI
        mainPanel.repaint(); // Refresh the UI
        add(btnPanel, BorderLayout.NORTH);
    }

    private void closeApp() {
        Model.getInstance().getDatabaseDriver().closeConnection();
        System.exit(0);
    }
}
