package com.company.chap7twenty;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Progress implements ChangeListener {
    JLabel label;
    JProgressBar pb;
    public Progress(){
        int value = 0;
        JFrame f = new JFrame("JProgressBar Presentation");
        Container contentPane = f.getContentPane();
        label = new JLabel("", JLabel.CENTER);
        label.setToolTipText("Display progress information");
        pb = new JProgressBar();
        pb.setOrientation(JProgressBar.HORIZONTAL); // 进度条为水平方向
        pb.setMinimum(0);
        pb.setMaximum(100);
        pb.setValue(value);
        pb.setStringPainted(true);
        pb.addChangeListener(this);
        pb.setToolTipText("Progress bar");
        contentPane.add(pb, BorderLayout.CENTER);
        contentPane.add(label, BorderLayout.SOUTH);

        f.setSize(400, 60);
        f.setVisible(true);

        for(int i=1;i<=5e8; i++){
            if(i%5e6==0){
                pb.setValue(++value);
            }
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int value = pb.getValue();
        label.setText("Completed: "+value+"%");
    }

    public static void main(String[] args) {
        new Progress();
    }
}
