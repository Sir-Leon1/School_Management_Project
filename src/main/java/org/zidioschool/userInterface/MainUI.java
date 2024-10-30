package org.zidioschool.userInterface;

import javax.swing.*;
import java.awt.*;

public class MainUI {
    public static JFrame frame;

    public static void ShowApp () {
        frame = new JFrame("Zidio School Manager");

        //Set default close operation so app exits when you close the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);
    }
}
