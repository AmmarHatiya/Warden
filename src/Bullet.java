import java.awt.*;

//https://stackoverflow.com/questions/44138641/2d-bullet-game-in-java


public class Bullet {
    int  xM, yM;
    private static final double speed = 1.5;//has to be greater than 1
    double x, y, dirX, dirY;

    public Bullet(int x, int y, int xM, int yM) {
        this.x = x;
        this.y = y;
        this.xM = xM;
        this.yM = yM;

        dirX = speed * Math.cos(getAngle());
        dirY = speed * Math.sin(getAngle());

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
        x += dirX;
        y += dirY;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.yellow);
        g2d.fillRect((int)Math.round(this.x), (int)Math.round(this.y), 8, 8);
    }
}