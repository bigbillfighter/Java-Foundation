import java.awt.*;
import javax.swing.*;

public class Test extends JApplet {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(new GradientPaint(0, 0, Color.red, 180, 35, Color.yellow));
        g2d.drawString("This is a Java Applet!", 25, 25);
    }
}
