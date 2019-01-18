import java.awt.*;

public class Enemy extends Entity {

    private static final int TANK = 1;
    private static final int TRUCKS = 2;
    private static final int PLANES = 3;
    private static final int TURRETS = 4;
    private static final int TOWER = 5;

    public int width = 30;
    public int height = 30;

    private int type;
    private int health;
    private boolean shoot = false;
    private int speed;


    public Enemy(int type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.speed = 2;
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

        if (type == 4 || type == 5) {
            if (random > 2) {

            }
            else{
                shoot();
            }
        }
        //stationary
        if (type == 1 || type == 2) {
            if (random > 95) {
                this.vy = speed;
            } else if (random > 90) {
                this.vy = -speed;
            } else if (random > 2) {

            } else
                shoot();
        }

        //horizontal
        random = (int) (Math.random() * 100 + 1);
        if (type == 1 || type == 3) {
            if (random > 95) {
                this.vx = speed;
            } else if (random > 90) {
                this.vx = -speed;
            } else if (random > 2) {

            } else
                shoot();
        }


        super.tick(levelWidth, levelHeight);
        if (x > levelWidth - width || x < 5)
            vx *= -speed;
        if (y > levelHeight - 85-height || y < 5)
            vy *= -speed;


        this.x = x + vx;
        this.y = y + vy;

    }


    public void shoot() {
        int r1 = (int) (Math.random() * 1000 - 100);
        int r2 = (int) (Math.random() * 1000 - 100);
        this.addParticleToLevel.accept(new Bullet(this.x+15, this.y+15, r1, r2, false));
    }

    public void check(Entity p) {
        if (x<p.x+p.width && x+width > p.x && y<p.y +p.height && y+height>p.y){
            this.x = x - vx;
            this.y = y - vy;
        }
    }

    public void check(Particle p) {
        if (p instanceof Bullet){
            Bullet b = (Bullet) p;
            if (b.isPlayer && x < b.x+b.width && x + width > b.x && y < b.y+b.width && y + height > b.y){
                this.addToScore.accept(5);
                this.removeParticleFromLevel.accept(p);
                this.removeSelf.accept(this);
            }
        }
    }

}
