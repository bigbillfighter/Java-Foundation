package com.company.chap7twelve;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserInnerClass {
    JFrame f;
    public UserInnerClass(){
        f = new JFrame();
        f.setSize(800, 450);
        f.setVisible(true);
        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                f.setTitle("The coordinate of the clicked place is "+e.getX()+", "+e.getY());
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UserInnerClass();
    }
}
