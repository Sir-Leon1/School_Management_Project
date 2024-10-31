package org.zidioschool.userInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchBar extends JTextField {
    private boolean isClicked = false;

    public SearchBar(int columns) {
        super(columns);

        // Set placeholder text
        setText("Search...");
        setForeground(Color.GRAY);

        // Add padding and remove default border
        setBorder(new EmptyBorder(20, 40, 20, 40)); // padding around text

        // Set margin to add spacing between text and border
        setMargin(new Insets(10, 40, 10, 10));

        // Set preferred size
        setPreferredSize(new Dimension(800, 40));

        // Add a focus listener to handle placeholder text
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                isClicked = true;
                if (getText().equals("Search...")) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                isClicked = false;
                if (getText().isEmpty()) {
                    setText("Search...");
                    setForeground(Color.GRAY);
                }
            }
        });

        // Add a mouse listener to handle hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (getText().equals("Search...")) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isClicked && getText().isEmpty()) {
                    setText("Search...");
                    setForeground(Color.GRAY);
                }
            }
        });

        // Set rounded border
        setBorder(new RoundedCornerBorder());
    }

    // Custom border for rounded corners
    private static class RoundedCornerBorder extends MatteBorder {
        public RoundedCornerBorder() {
            super(1, 1, 1, 1, Color.LIGHT_GRAY);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawRoundRect(x, y, width - 1, height - 1, 15, 15); // Rounded rectangle
        }
    }

}