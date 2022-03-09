package com.company.chap7fourteen;

import javax.swing.*;
import java.awt.*;

public class FrameDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame("FrameDemo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(175, 100)); // 设置文本区域大小
        f.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}
