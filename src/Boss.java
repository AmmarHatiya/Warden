import java.awt.*;

public class Boss extends Entity {

    private static final int BOSSTURRET = 1;
    private static final int BOSSSHIP = 2;
    private static final int BOSSTANK = 3;
    private static final int BOSSCOPTER = 4;

    public int width;
    public int height;

    private int type;
    private int health;
    private int speed;


    public Boss(int type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.speed = 2;

        if (type == BOSSTURRET) {
            width = 50;
            height = 50;
            health = 25;
        } else if (type == BOSSSHIP) {
            health = 100;
            width = 80;
            height = 30;
        } else if (type == BOSSTANK) {
            width = 50;
            height = 50;
            health = 50;
        } else if (type == BOSSCOPTER) {
            width = 40;
            height = 30;
            health = 75;
        }
    }

    public void paint(Graphics2D g2d) {
        //base
        g2d.setColor(Color.black);
        g2d.fillRect((int) x, (int) y, width, height);

        g2d.setColor(Color.green);
        g2d.fillOval((int) x, (int) y, 5, 5);
    }

    public void tick(int levelWidth, int levelHeight) {
        //vertical
        int random = (int) (Math.random() * 100 + 1);
        if (type == BOSSTURRET) {
            if (random > 10) {
            } else {
                shoot();
            }
        } else if (type == BOSSTANK) {

        } else if (type == BOSSSHIP) {
            if (random > 10) {
            } else {
                shoot();
            }

        } else if (type == BOSSCOPTER) {

        }


        this.x = x + vx;
        this.y = y + vy;

    }


    public void shoot() {
        int r1 = (int) (Math.random() * 1000 - 100);
        int r2 = (int) (Math.random() * 1000 - 100);
        this.addParticleToLevel.accept(new Bullet(this.x + 15, this.y + 15, r1, r2, false));
    }

    public void check(Entity p) {
        if (x < p.x && x + width > p.x && y < p.y && y + height > p.y) {
            this.x = x - vx;
            this.y = y - vy;
        }
    }

    public void check(Particle p) {
        if (p instanceof Bullet) {
            Bullet b = (Bullet) p;
            if (b.isPlayer && x < b.x && x + width > b.x && y < b.y && y + height > b.y) {
                this.addToScore.accept(5);
                this.removeParticleFromLevel.accept(p);
                this.removeSelf.accept(this);
            }
        }
    }

}
