package org.zidioschool.userInterface.customComponents.panels.helpers;

import java.awt.*;

public class GridBagHelper {
    public static GridBagConstraints createConstraints(int gridx, int gridy) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;

        return constraints;
    }

    // Overload method to have custom weight or anchor if needed
    public static GridBagConstraints createConstraints(int gridx, int gridy, int anchor, int fill, double weightx, double weighty, int ipadx, int ipady) {
        GridBagConstraints constraints = createConstraints(gridx, gridy);
        constraints.anchor = anchor;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.ipadx = ipadx;
        constraints.ipady = ipady;
        constraints.fill = fill;

        return constraints;
    }
}
