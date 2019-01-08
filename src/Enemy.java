import java.awt.*;
public class Enemy extends Entity {

    private static final int TANK = 1;
    private static final int TRUCKS = 2;
    private static final int PLANES = 3;
    private static final int TURRETS = 4;
    private static final int TOWER = 5;

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
        g2d.fillRect((int)x-15, (int)y-15 , 30, 30);

        g2d.setColor(Color.green);
        g2d.fillOval((int)x, (int)y , 5, 5);
    }

    public void tick(int levelWidth, int levelHeight) {


        //vertical
        int random = (int)(Math.random() * 100 + 1);

        if (type == 4 || type == 5) {
            if (random > 70) {
                shoot();
            }
        }
        //stationary
        if (type == 1 || type == 2) {
            if (random > 85) {
                this.vy = speed;
            }
            else if (random > 70){
                this.vy = -speed;
            }
            else if (random > 15){

            }
            else
                shoot();
        }

        //horizontal
        random = (int)(Math.random() * 100 + 1);
        if (type == 1 || type == 3) {
            if (random > 85) {
                this.vx = speed;
            }
            else if (random > 70){
                this.vx = -speed;
            }
            else if (random > 15){

            }
            else
                shoot();
        }

        this.x = x+vx;
        this.y = y+vy;

    }

    public void shoot(){
        int r1 = (int)(Math.random() * 1000 - 100);
        int r2 = (int)(Math.random() * 1000 - 100);
        this.addParticleToLevel.accept(new Bullet(this.x, this.y, r1, r2));
    }

    public void check(Entity p) {

    }

    public void check(Particle p) {

    }

}
