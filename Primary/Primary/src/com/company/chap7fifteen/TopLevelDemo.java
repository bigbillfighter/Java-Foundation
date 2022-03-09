package com.company.chap7fifteen;


import javax.swing.*;
import java.awt.*;

public class TopLevelDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel yellowLabel = new JLabel("");
        yellowLabel.setOpaque(true); // 设置为不透明
        yellowLabel.setBackground(Color.yellow);
        yellowLabel.setPreferredSize(new Dimension(200, 180));

        JMenuBar cyanMenuBar = new JMenuBar();
        cyanMenuBar.setOpaque(true);
        cyanMenuBar.setBackground(Color.cyan);
        cyanMenuBar.setPreferredSize(new Dimension(200, 20));

        frame.setJMenuBar(cyanMenuBar);
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
