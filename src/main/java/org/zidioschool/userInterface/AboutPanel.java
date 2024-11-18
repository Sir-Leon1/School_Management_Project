package org.zidioschool.userInterface;

import org.zidioschool.userInterface.customComponents.DropDownBox;
import org.zidioschool.userInterface.customComponents.GradientPanel;
import org.zidioschool.userInterface.customComponents.RoundedButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class AboutPanel extends JPanel {
    private JLabel label;
    private RoundedButton downloadBtn, downloadBtn2, downloadBtn3;
    private DropDownBox dropDownBox;
    private GradientPanel lastPanel;

    public AboutPanel() {
        Border outer = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border inner = BorderFactory.createTitledBorder("About");
        setBorder(new CompoundBorder(outer, inner));
        setBackground(Color.WHITE);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        label = new JLabel("Download class info");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 1,
                GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(label, constraints);

        downloadBtn = new RoundedButton("Download", 125, 25);
        constraints = GridBagHelper.createConstraints(2, 1,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(downloadBtn, constraints);

        //TODO: Convert options to a list of classes avaialable in the database
        String[] options = {"Math", "Science", "History", "Art"};
        dropDownBox = new DropDownBox<>(options);
        constraints = GridBagHelper.createConstraints(1, 1,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(dropDownBox, constraints);

        label = new JLabel("Download School info");
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 2,
                GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE,
                1, 1, 10, 10);
        add(label, constraints);

        downloadBtn2 = new RoundedButton("Download", 125, 25);
        constraints = GridBagHelper.createConstraints(2, 2,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(downloadBtn2, constraints);

        lastPanel = new GradientPanel();
        lastPanel.setLayout(new GridBagLayout());
        lastPanel.setForeground(Color.WHITE);
        constraints = UpdatePanel.GridBagHelper.createConstraints(0, 11, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 0, 10, 10);
        constraints.gridwidth = 3;
        add(lastPanel, constraints);

        label = new JLabel("About App: Zidio School Manager");
        setLabelFont(label, 18);
        constraints = GridBagHelper.createConstraints(0, 2,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                0, 0, 10, 10);
        constraints.gridwidth = 3;
        lastPanel.add(label, constraints);

        label = new JLabel("Developer: Gunnah Leon");
        setLabelFont(label, 18);
        constraints = GridBagHelper.createConstraints(0, 3,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("Contact: sir-Leon1@gmail.com");
        setLabelFont(label, 18);
        constraints = GridBagHelper.createConstraints(0, 4,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("License: MIT");
        setLabelFont(label, 18);
        constraints = GridBagHelper.createConstraints(0, 5,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("Version: 1.0");
        setLabelFont(label, 18);
        constraints = GridBagHelper.createConstraints(0, 6,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("Copyright (c) 2016 Zidio School");
        setLabelFont(label, 18);
        constraints = GridBagHelper.createConstraints(0, 7,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("Generate application report below");
        setLabelFont(label, 18);
        constraints = GridBagHelper.createConstraints(1, 3,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 10, 10);
        lastPanel.add(label, constraints);

        downloadBtn3 = new RoundedButton("Download", 125, 25);
        downloadBtn3.setBackground(new Color(255, 255, 255));
        downloadBtn3.setForeground(new Color(0, 0, 0));
        constraints = GridBagHelper.createConstraints(1, 4,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 10, 10);
        lastPanel.add(downloadBtn3, constraints);

    }

    private void setLabelFont(JLabel label) {
        label.setFont(new Font("Grauda", Font.BOLD, 16));
    }

    private void setLabelFont(JLabel label, int size) {
        label.setFont(new Font("Grauda", Font.BOLD, size));
        label.setForeground(new Color(255, 255, 255));
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
        // Set up the Swing UI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("ReportPanel Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1500, 850);

            // Create an instance of ReportPanel
            AboutPanel reportPanel = new AboutPanel();

            // Add the ReportPanel to the frame
            frame.add(reportPanel, BorderLayout.CENTER);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}
