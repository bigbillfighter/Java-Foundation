package com.company.chap7sixteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOptionPaneDemo extends JFrame implements ActionListener {
    public JOptionPaneDemo(){
        super("simple dialog");
        Container c = getContentPane();
        JButton button = new JButton("exit");
        button.addActionListener(this);
        c.setLayout(new FlowLayout());
        c.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int select = JOptionPane.showConfirmDialog(this, "Are you sure to exit?",
                        "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if(select==JOptionPane.OK_OPTION) System.exit(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JOptionPaneDemo();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setVisible(true);
    }
}
