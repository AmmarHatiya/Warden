
import java.awt.*;

public class Icebttnlsm {
    private int x;
    private int y;
    private int w;
    private int h;
    private int xtank[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int ytank[] = {200+60, 200 + 82, 200 + 82, 200+60};
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

    public Icebttnlsm() {
        this.x = 30;
        this.y = 200;
        this.w = 150;
        this.h = 125;

    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GREEN);
        // TEXT ON BUTTON
        /*g2d.drawString("Ice",60,y);*/
//Draw First Button (Ice)
        g2d.setColor(new Color(128, 203, 255));
        g2d.fillRect(x, y, w, h);
        g2d.setColor(new Color(255, 255, 255, 254));
        g2d.fillRect(x, y + 75, w, h - 75);
        g2d.setColor(Color.GREEN);
        g2d.drawRect(x - 1, y - 1, w, h);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillRect(x + 20, y + 55, w - 100, h - 120);
        g2d.fillRect(x + 20, y + 50, w - 120, h - 110);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x+8,y+75,50,15);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillPolygon(xtank, ytank, 4);

    }

}
