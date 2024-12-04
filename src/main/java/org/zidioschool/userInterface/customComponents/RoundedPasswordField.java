package org.zidioschool.userInterface.customComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class RoundedPasswordField extends JPasswordField {
    public RoundedPasswordField(int columns) {
        super(columns);
        setBorder(BorderFactory.createCompoundBorder(
                new RoundedCornerBorder(),
                new EmptyBorder(0, 10, 0, 10)
        ));
        setFont(new Font("Grauda", Font.PLAIN, 16));
        setForeground(Color.WHITE);
        setOpaque(false);
    }

    private static class RoundedCornerBorder extends MatteBorder {
        public RoundedCornerBorder() {
            super(1, 1, 1, 1, Color.LIGHT_GRAY);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawRoundRect(x, y, width - 1, height - 1, 15, 15);
        }
    }
}