package org.zidioschool.userInterface;

import javax.swing.*;
import java.awt.*;

public class StudentsView extends JFrame {
    private JPanel contentPane;
    private JButton registerButton;
    private JButton updateButton;
    private JButton viewButton;
    private JButton generateReportButton;

    public StudentsView() {
        setTitle("Zidio School manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 1000);
        setContentPane(contentPane);
        pack();

        JButton registerButton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                super.paintComponent(g2);
                g2.dispose();
            }
        };

        contentPane.add(registerButton);

        //Set the frame location to the center of the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }


}
