import javax.swing.*;
import java.awt.*;

public class Continuegamebttn {
    private int x;
    private int y;
    private int w;
    private int h;

    // Below: Methods that return the variable positions
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public Continuegamebttn() {
        this.x = 30;
        this.y = 275;
        this.w = 125;
        this.h = 50;

    }
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


            g2d.setColor(Color.GREEN);
            // TEXT ON BUTTON
            g2d.drawString("Continue Game",50,305);
//Draw Second Button (Continue Story)
            g2d.drawRect(x, y, w, h);
        }

    }
