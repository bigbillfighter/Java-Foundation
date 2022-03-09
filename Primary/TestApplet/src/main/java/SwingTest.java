import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest extends JApplet {
    @Override
    public void init() {
        super.init();
        Container contentPane = getContentPane(); // 定义内容面板
        contentPane.setLayout(new GridLayout(2, 1));
        JButton button = new JButton("Click me");
        final JLabel label = new JLabel();
        contentPane.add(button); contentPane.add(label);
        // 在按钮上添加时间监听器
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 设置对话框
                String information = JOptionPane.showInputDialog("Please input a string");
                // 将对话框中的内容显示到标签上
                label.setText(information);
            }
        });
    }
}

