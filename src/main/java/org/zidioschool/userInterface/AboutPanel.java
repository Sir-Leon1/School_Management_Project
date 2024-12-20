package org.zidioschool.userInterface;

import org.zidioschool.model.ClassDAO;
import org.zidioschool.model.modelClasses.Clss;
import org.zidioschool.services.pdfGenerator.PdfReportGenerator;
import org.zidioschool.userInterface.customComponents.DropDownBox;
import org.zidioschool.userInterface.customComponents.panels.GradientPanel;
import org.zidioschool.userInterface.customComponents.RoundedButton;
import org.zidioschool.userInterface.customComponents.panels.helpers.GridBagHelper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.io.File;
import java.util.List;
import javax.swing.border.TitledBorder;

public class AboutPanel extends JPanel {
    private JLabel label;
    private RoundedButton downloadBtn, downloadBtn2, downloadBtn3;
    private DropDownBox dropDownBox;
    private GradientPanel lastPanel;
    private GridBagHelper GridBagHelper;

    public AboutPanel() {
        Border outer = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border inner = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "About");
        ((TitledBorder) inner).setTitleColor(Color.WHITE);
        setBorder(new CompoundBorder(outer, inner));
        setBackground(Color.DARK_GRAY);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        label = new JLabel("Download class info");
        label.setForeground(Color.WHITE);
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 1,
                GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(label, constraints);

        downloadBtn = new RoundedButton("Download", 125, 25);
        downloadBtn.addActionListener(e -> {
            downloadClassPdf();
        });
        constraints = GridBagHelper.createConstraints(2, 1,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(downloadBtn, constraints);

        List<Clss> options = new ClassDAO().getAllClasses();
        String[] classNames = options.stream()
                .map(Clss::getClassName)
                .toArray(String[]::new);
        dropDownBox = new DropDownBox<>(classNames);
        constraints = GridBagHelper.createConstraints(1, 1,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(dropDownBox, constraints);

        label = new JLabel("Download School Register");
        label.setForeground(Color.WHITE);
        setLabelFont(label);
        constraints = GridBagHelper.createConstraints(0, 2,
                GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE,
                1, 1, 10, 10);
        add(label, constraints);

        downloadBtn2 = new RoundedButton("Download", 125, 25);
        downloadBtn2.addActionListener(e -> {
            downloadSchlRegister();
        });
        constraints = GridBagHelper.createConstraints(2, 2,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(downloadBtn2, constraints);

        lastPanel = new GradientPanel();
        lastPanel.setLayout(new GridBagLayout());
        lastPanel.setForeground(Color.WHITE);
        constraints = GridBagHelper.createConstraints(0, 11,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                0, 0, 10, 10);
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
        setLabelFont(label, 15);
        constraints = GridBagHelper.createConstraints(0, 3,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("Contact: sir-Leon1@gmail.com");
        setLabelFont(label, 15);
        constraints = GridBagHelper.createConstraints(0, 4,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("License: MIT");
        setLabelFont(label, 15);
        constraints = GridBagHelper.createConstraints(0, 5,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("Version: 1.0");
        setLabelFont(label, 15);
        constraints = GridBagHelper.createConstraints(0, 6,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("Copyright (c) 2016 Zidio School");
        setLabelFont(label, 15);
        constraints = GridBagHelper.createConstraints(0, 7,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 0, 0);
        lastPanel.add(label, constraints);

        label = new JLabel("Generate application report below");
        setLabelFont(label, 15);
        constraints = GridBagHelper.createConstraints(1, 3,
                GridBagConstraints.NORTH, GridBagConstraints.NONE,
                1, 0, 10, 10);
        lastPanel.add(label, constraints);

        downloadBtn3 = new RoundedButton("Download", 125, 25);
        downloadBtn3.setBackground(new Color(255, 255, 255));
        downloadBtn3.setForeground(new Color(0, 0, 0));
        downloadBtn3.addActionListener(e -> {
            downloadAppReport();
        });
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

    private void downloadClassPdf() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Output Path");

        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                PdfReportGenerator.generateStudentsByClass(String.valueOf(dropDownBox.getSelectedItem()),
                        selectedFile.getAbsolutePath());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void downloadSchlRegister() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Output Path");

        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                PdfReportGenerator.generateAllStudentsReport(selectedFile.getAbsolutePath());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void downloadAppReport() {
        // TODO Generates a pdf from the main README.md of this repository on github

    }


    public static void main(String[] args) {
        // Set up the Swing UI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("ReportPanel Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1500, 850);

            AboutPanel reportPanel = new AboutPanel();

            // Add the ReportPanel to the frame
            frame.add(reportPanel, BorderLayout.CENTER);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}
