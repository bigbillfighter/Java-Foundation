package com.company.chap7eleven;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExtendMouseAdapter extends MouseAdapter {
    JFrame f;
    public ExtendMouseAdapter(){
        f = new JFrame();
        f.setSize(800, 450);
        f.setVisible(true);
        f.addMouseListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        f.setTitle("The coordinate of the clicked place is "+e.getX()+", "+e.getY());
    }

    public static void main(String[] args) {
        new ExtendMouseAdapter();
    }
}
