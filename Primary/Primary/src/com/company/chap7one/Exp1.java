package com.company.chap7one;

import javax.swing.*;
import java.awt.*;

class GraphicsTester extends JFrame {
    public GraphicsTester(){
        super("演示字体、颜色、绘图"); // 窗口名称
        setVisible(true); // 显示窗口
        setSize(480, 250);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("SanSerif", Font.BOLD, 12));
        g.setColor(Color.blue);
        g.drawString("Hello, this is a sentence of SanSerif", 20, 50);

        g.setFont(new Font("Serif", Font.ITALIC, 14));
        g.setColor(new Color(255, 0, 0));
        g.drawString("And this is Serif", 250, 50);
        g.drawLine(20, 60, 460, 60);

        g.setColor(Color.green);
        g.drawRect(20, 70, 100, 50);
        g.fillRect(130, 70, 100, 50);

        g.setColor(Color.yellow);
        g.drawRoundRect(240, 70, 100, 50, 25, 25);
        g.fillRoundRect(350, 70, 100, 50, 25, 25);

        g.setColor(Color.cyan);
        g.draw3DRect(20, 130, 100, 50, true); // 凸起效果
        g.fill3DRect(130, 130, 100, 50, false); // 凹陷效果

        g.setColor(Color.pink);
        g.drawOval(240, 130, 100, 50);
        g.fillOval(350, 130, 100 ,50);

        g.setColor(new Color(0, 120, 120));
        g.drawArc(20, 190, 100, 50, 0, 90);
        g.fillArc(130, 190, 100, 50, 0, 90);

        g.setColor(Color.black);
        int[] xValues = {250, 280, 290, 300, 330, 310, 320, 290, 260, 270};
        int[] yValues = {210, 210, 190, 210, 210, 220, 230, 220, 230, 220};
        g.drawPolygon(xValues, yValues, 10);//绘制空心多边形

        int[] xValuesSecond = {360, 390, 400, 410, 440, 420, 430, 400, 370, 380};
        g.fillPolygon(xValuesSecond, yValues, 10); // 绘制实心多边形
    }
}


public class Exp1 {
    public static void main(String[] args) {
        GraphicsTester app = new GraphicsTester();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

