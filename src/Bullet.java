import java.awt.*;

//https://stackoverflow.com/questions/44138641/2d-bullet-game-in-java


public class Bullet extends Particle {
    public Bullet(double x, double y, double xM, double yM) {
        this.x = x;
        this.y = y;
        this.speed = 2;

        this.vy = speed * Math.sin(getAngle(xM, yM));
        this.vx = speed * Math.cos(getAngle(xM, yM));

    }

    public double getAngle(double xM, double yM) {
        double angle = Math.toDegrees(Math.atan2(yM - y, xM - x));

        if (angle < 0) {
            angle += 360;
        }
        return Math.toRadians(angle);
    }

    public void tick(int levelWidth, int levelHeight) {
        super.tick(levelWidth, levelHeight);
        this.speed *= 0.999;
        if (x > levelWidth-15 || x < 5 || y > levelHeight-15||y < 5) {
            this.removeSelf.accept(this);
        }
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.yellow);
        g2d.fillRect((int)Math.round(this.x), (int)Math.round(this.y), 8, 8);
    }

    public void check(Entity p) {

    }

    public void check(Particle p) {

    }
}