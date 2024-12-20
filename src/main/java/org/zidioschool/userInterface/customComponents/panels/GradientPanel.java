package org.zidioschool.userInterface.customComponents.panels;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {


    public GradientPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int arcWidth = 20;
        int arcHeight = 20;

        GradientPaint gradient = new GradientPaint(0, 0, new Color(87, 91, 198, 255), 0, height, new Color(92, 139, 231));
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