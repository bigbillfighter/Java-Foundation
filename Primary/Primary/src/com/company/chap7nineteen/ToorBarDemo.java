package com.company.chap7nineteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToorBarDemo extends JFrame {
    protected JTextArea textArea;
    protected String newLine= "\n";

    public ToorBarDemo(){
        super("ToolBarDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JToolBar toolBar = new JToolBar();
        textArea = new JTextArea(5, 30);
        addButtons(toolBar);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(400, 100));
        contentPane.add(toolBar, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        setContentPane(contentPane);
    }

    protected void addButtons(JToolBar toolBar){
        JButton button = null;

        button = new JButton(new ImageIcon("./doc/images/left.gif"));
        button.setToolTipText("This is the left button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayResult("Action for first button");
            }
        });
        toolBar.add(button);

        button = new JButton(new ImageIcon("./doc/images/middle.gif"));
        button.setToolTipText("This is the middle button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayResult("Action for second button");
            }
        });
        toolBar.add(button);

        button = new JButton(new ImageIcon("./doc/images/right.gif"));
        button.setToolTipText("This is the right button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayResult("Action for third button");
            }
        });
        toolBar.add(button);
    }

    protected void displayResult(String actionDescription){
        textArea.append(actionDescription+newLine);
    }

    public static void main(String[] args) {
        ToorBarDemo frame = new ToorBarDemo();
        frame.pack();
        frame.setVisible(true);
    }
}
