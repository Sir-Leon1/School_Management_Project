package org.zidioschool.userInterface.customComponents;

import javax.swing.*;
import java.awt.*;

public class HorizontalRuleWithText extends JPanel {
    public HorizontalRuleWithText(String text) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Left separator
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JSeparator(), gbc);

        // Text label
        JLabel label = new JLabel(text){{
            setFont(new Font("Grauda", Font.BOLD, 18));
        }};
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.insets = new Insets(0, 10, 0, 10); // Add some padding around the text
        add(label, gbc);

        // Right separator
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        add(new JSeparator(), gbc);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Horizontal Rule with Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setLayout(new BorderLayout());
        frame.add(new HorizontalRuleWithText("Text in the middle"), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}