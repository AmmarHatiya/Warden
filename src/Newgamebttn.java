
import java.awt.*;

public class Newgamebttn {
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

    public Newgamebttn(/*int x, int y, int w, int h*/) {
        this.x = 30;
        this.y = 175;
        this.w = 125;
        this.h = 50;

    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GREEN);
        // TEXT ON BUTTON
        g2d.drawString("New Game",60,205);
//Draw First Button (New Game)
        g2d.drawRect(x, y, w, h);
    }

}
