package org.zidioschool.userInterface.customComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DropDownBox<T> extends JComboBox<T> {

    public DropDownBox(T[] items) {
        super(items);
        setRenderer(new DropdownRenderer<>());
        setUI(new DropdownUI());

        // Additional customization
        setBackground(Color.WHITE);
        setForeground(Color.DARK_GRAY);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }

    // Custom Renderer for list items
    private static class DropdownRenderer<T> extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Customizing the label
            label.setBorder(new EmptyBorder(5, 10, 5, 10)); // Padding
            label.setFont(new Font("SansSerif", Font.PLAIN, 14));
            label.setOpaque(true);

            if (isSelected) {
                label.setBackground(new Color(0x3498db)); // Light blue for selection
                label.setForeground(Color.WHITE);
            } else {
                label.setBackground(Color.WHITE);
                label.setForeground(Color.DARK_GRAY);
            }
            return label;
        }
    }

    // Custom UI for the dropdown box
    private static class DropdownUI extends javax.swing.plaf.basic.BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            JButton button = new JButton();
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setBackground(Color.WHITE);
            button.setIcon(new DownArrowIcon());
            return button;
        }

        // Draw a simple arrow icon
        private static class DownArrowIcon implements Icon {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.DARK_GRAY);
                int[] xPoints = {x, x + getIconWidth() / 2, x + getIconWidth()};
                int[] yPoints = {y, y + getIconHeight(), y};
                g2.fillPolygon(xPoints, yPoints, 3);
                g2.dispose();
            }

            @Override
            public int getIconWidth() {
                return 10;
            }

            @Override
            public int getIconHeight() {
                return 5;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Modern Dropdown Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new FlowLayout());

            // Create a ModernDropdown
            String[] options = {"Math", "Science", "History", "Art"};
            DropDownBox<String> modernDropdown = new DropDownBox<>(options);

            // Add the dropdown to the frame
            frame.add(new JLabel("Select a class:"));
            frame.add(modernDropdown);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}
