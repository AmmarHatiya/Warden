import java.awt.*;

public class Barrel {

    int  xM, yM;
    double x, y, dirX, dirY;

    public Barrel(int x, int y, int xM, int yM) {
        this.x = x;
        this.y = y;
        this.xM = xM;
        this.yM = yM;

        dirX = Math.cos(getAngle());
        dirY = Math.sin(getAngle());
    }

    public double getAngle() {
        double angle = Math.toDegrees(Math.atan2(yM - y, xM - x));

        if (angle < 0) {
            angle += 360;
        }
        return Math.toRadians(angle);
    }

    public double getX() {
        return x;
    }

    public double getY() { return y; }

    public void move() {

    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.rotate(getAngle());
        g2d.fillRect((int)Math.round(this.x), (int)Math.round(this.y), 20, 70);
    }
}
