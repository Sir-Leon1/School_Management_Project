package org.zidioschool.userInterface;
import javax.swing.*;

import java.awt.*;

public class RoundedButton extends JButton{
    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new Dimension(200, 60));
        setBackground(new Color(70, 130, 180));
        setForeground(Color.WHITE);
        setFont(new Font("Grauda", Font.BOLD, 16));
    }



    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g2);
        g2.dispose();
    }
}
