package org.zidioschool.userInterface.customComponents;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    private final int cornerRadius = 20;
    private final Color borderColor = Color.GRAY;
    private final int borderThickness = 3;
    private final Color gradientStartColor = new Color(87, 91, 198, 255);
    private final Color gradientEndColor = new Color(92, 139, 231);

    public GradientPanel() {
        setOpaque(false); // Allows rounded edges by making the panel background transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Enable anti-aliasing for smoother edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw gradient background
        GradientPaint gradient = new GradientPaint(0, 0, gradientStartColor, 0, getHeight(), gradientEndColor);
        g2.setPaint(gradient);
        g2.fillRoundRect(
                borderThickness / 2,
                borderThickness / 2,
                getWidth() - borderThickness,
                getHeight() - borderThickness,
                cornerRadius,
                cornerRadius
        );

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 100); // Default size, can be customized
    }
}