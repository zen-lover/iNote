package ceit;

import ceit.gui.CFrame;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        CFrame frame = new CFrame("iNote");
        frame.setVisible(true);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
