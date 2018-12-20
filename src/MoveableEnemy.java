import java.awt.*;
public class MoveableEnemy extends Entity {
    private int speed; //how fast moves
    private boolean shoot = false;


    public MoveableEnemy(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void paint(Graphics2D g2d) {
        //base
        g2d.setColor(Color.lightGray);
        g2d.fillRect((int)x-15, (int)y-15 , 30, 30);

        g2d.setColor(Color.green);
        g2d.fillOval((int)x, (int)y , 5, 5);
    }

    public void tick(int levelWidth, int levelHeight) {
        super.tick(levelWidth, levelHeight);
        if (x > levelWidth-15 || x < 5 || y > levelHeight-15||y < 5) {
            this.removeSelf.accept(this);
        }
    }

    public void check(Entity p) {

    }

    public void check(Particle p) {

    }

}
