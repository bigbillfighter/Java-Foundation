package com.company.chap7three;

import javax.swing.*;
import java.awt.*;

public class ComponentTester {
    public static void main(String[] args) {
        // 是否设置一些基础的装饰
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Swing Frame");
        Container container = frame.getContentPane();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        panel.setLayout(new GridLayout(2, 1));
        JLabel label = new JLabel("Label", SwingConstants.CENTER);
        JButton button = new JButton("Button");
        panel.add(label); panel.add(button);
        container.add(panel);
        frame.setSize(200, 100);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
