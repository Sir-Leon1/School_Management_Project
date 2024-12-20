package org.zidioschool.userInterface.customComponents.panels;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private final int cornerRadius;
    private final Color borderColor;
    private final Color backgroundColor;
    private final int borderThickness;

    public RoundedPanel(int cornerRadius, Color borderColor, Color backgroundColor, int borderThickness) {
        this.cornerRadius = cornerRadius;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
        this.borderThickness = borderThickness;
        setOpaque(false); // Allows rounded edges by making the panel background transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Enable anti-aliasing for smoother edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw filled rounded rectangle for the background
        g2.setColor(backgroundColor);
        g2.fillRoundRect(
                borderThickness / 2,
                borderThickness / 2,
                getWidth() - borderThickness,
                getHeight() - borderThickness,
                cornerRadius,
                cornerRadius
        );

        // Draw rounded rectangle border
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderThickness));
        g2.drawRoundRect(
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
