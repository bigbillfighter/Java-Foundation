package com.company.chap7ten;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ImplementMouseListener implements MouseListener {
    JFrame f;
    public ImplementMouseListener(){
        f = new JFrame();
        f.setSize(800, 450);
        f.setVisible(true);
        f.addMouseListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        f.setTitle("The coordinate of the clicked place is "+e.getX()+", "+e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public static void main(String[] args) {
        new ImplementMouseListener();
    }
}
