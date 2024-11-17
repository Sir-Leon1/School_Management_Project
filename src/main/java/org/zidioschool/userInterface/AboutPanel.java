package org.zidioschool.userInterface;

import org.zidioschool.userInterface.customComponents.DropDownBox;
import org.zidioschool.userInterface.customComponents.RoundedButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class AboutPanel extends JPanel {
    private JLabel label;
    private RoundedButton downloadBtn, downloadBtn2;
    private DropDownBox dropDownBox;

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
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
                1, 0, 10, 10);
        add(label, constraints);

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
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
                1, 1, 10, 10);
        add(label, constraints);

//        setLayout(new BorderLayout());
//        label = new JLabel("Download Class info");
//        add(label, BorderLayout.NORTH);
    }

    private void setLabelFont(JLabel label) {
        label.setFont(new Font("Grauda", Font.BOLD, 16));
    }

    private void setLabelFont(JLabel label, int size) {
        label.setFont(new Font("Grauda", Font.BOLD, size));
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
