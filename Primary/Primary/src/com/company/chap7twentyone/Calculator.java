package com.company.chap7twentyone;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Calculator implements ActionListener, ItemListener {
    static JFrame f = null;
    JComboBox combo;
    ButtonGroup bg;
    JSpinner s1;
    JLabel L3;
    JRadioButton r1, r2, r3, r4;
    int op = 0;

    public Calculator(){
        f = new JFrame("The display of second class Atomic components");
        Container contentPane = f.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 4));
        // 设置边框
        p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue, 2),
                "choose calculation type", TitledBorder.CENTER, TitledBorder.TOP));

        // 单选按钮
        r1 = new JRadioButton(" + ");
        r2 = new JRadioButton(" - ");
        r3 = new JRadioButton(" x ");
        r4 = new JRadioButton(" ÷ ");
        p1.add(r1); p1.add(r2); p1.add(r3); p1.add(r4);

        // 按钮组，保证每次只能选择一个
        bg = new ButtonGroup();
        bg.add(r1); bg.add(r2); bg.add(r3); bg.add(r4);

        r1.addItemListener(this);
        r2.addItemListener(this);
        r3.addItemListener(this);
        r4.addItemListener(this);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 2));
        p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue, 2),
                "choose or input number", TitledBorder.CENTER, TitledBorder.TOP));
        JLabel L1 = new JLabel("第一个操作数：");
        JLabel L2 = new JLabel("第二个操作数：");

        // 创建下拉列表
        String[] data1 = {"0", "10", "20", "30", "40",
                "50", "60", "70", "80", "90", "100"};
        combo = new JComboBox(data1);
        combo.setEditable(true);
        ComboBoxEditor editor = combo.getEditor();
        combo.configureEditor(editor, "Please choose or input number");

        SpinnerModel sM1 = new SpinnerNumberModel(50, 0, 100, 1);
        s1 = new JSpinner(sM1);

        p2.add(L1); p2.add(combo); p2.add(L2); p2.add(s1);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 2));
        JButton button1 = new JButton("Calculate");
        L3 = new JLabel("", SwingConstants.CENTER);
        p3.add(button1); p3.add(L3);
        button1.addActionListener(this);

        contentPane.add(p1, BorderLayout.NORTH);
        contentPane.add(p2, BorderLayout.CENTER);
        contentPane.add(p3, BorderLayout.SOUTH);

        // 设置回车默认按钮
        f.getRootPane().setDefaultButton(button1);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==r1) op=1;
        if(e.getSource()==r2) op=2;
        if(e.getSource()==r3) op=3;
        if(e.getSource()==r4) op=4;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(combo.getSelectedItem().toString());
        double b = Double.parseDouble(s1.getValue().toString());
        double c;
        switch (op){
            case 1:
                c = a+b;
                L3.setText(""+c);
                break;
            case 2:
                c = a-b;
                L3.setText(""+c);
                break;
            case 3:
                c = a*b;
                L3.setText(""+c);
                break;
            case 4:
                c = a/b;
                L3.setText(""+c);
                break;
            default:
                L3.setText("Please select operator");
        }
    }

    public static void main(String[] args) {
        new Calculator();
        new PassWord(f);
    }
}

class PassWord implements ActionListener{
    JTextField user;
    JPasswordField passwordField;
    JButton b1, b2;
    Container dialogPane;
    JDialog d;
    JFrame f;

    public PassWord(JFrame f){
        d = new JDialog();
        d.setTitle("Please input user name and password");
        dialogPane = d.getContentPane();
        dialogPane.setLayout(new GridLayout(3,2));
        dialogPane.add(new JLabel("username", SwingConstants.CENTER));

        user = new JTextField();
        dialogPane.add(user);
        dialogPane.add(new JLabel("password", SwingConstants.CENTER));

        passwordField = new JPasswordField();
        dialogPane.add(passwordField);
        b1 = new JButton("confirm");
        b2 = new JButton("exit");
        dialogPane.add(b1); dialogPane.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        d.setBounds(200, 150, 400, 130);
        d.getRootPane().setDefaultButton(b1);
        d.setVisible(true);
        this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("confirm")) {
            String name = user.getText();
            String passWord = new String(passwordField.getPassword());
            System.out.println(passWord);
            if ((name.equals("test")) && (passWord.equals("1234"))) {
                d.dispose();
                f.setVisible(true);
                return;
            } else {
                JOptionPane.showMessageDialog(d, "Wrong username or password",
                        "Please reenter", JOptionPane.WARNING_MESSAGE);
                user.setText("");
                passwordField.setToolTipText("");
            }
        }
        if(cmd.equals("exit")) System.exit(0);
    }

}
