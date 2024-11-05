package org.zidioschool.userInterface.customComponents;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int arcWidth = 30;
        int arcHeight = 30;

        // Create a gradient from dark blue to dark green
        GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 255, 255, 255), 0, height, new Color(255, 255, 255));
        g2d.setPaint(gradient);
        g2d.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gradient Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new GradientPanel());
        frame.setVisible(true);
    }
}