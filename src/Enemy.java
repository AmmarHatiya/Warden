import javax.imageio.ImageIO;
import java.awt.*;

public class Enemy extends Entity {

    private static final int TANK = 1;
    private static final int TRUCKS = 2;
    private static final int PLANES = 3;
    private static final int TURRETS = 4;
    private static final int TOWER = 5;
// PLANE MOVE RIGHT OR LEFT
    private static final int PLANELEFT = 9;
    private static final int PLANERIGHT = 8;
    private int planedirection = 9;
    public int width = 25;
    public int height = 32;

    private int type;
    private int health;
    private boolean shoot = false;
    private int speed;
    private final static Image enemyplaneleft;
    static {
        try {
            enemyplaneleft= ImageIO.read(Upgradesmenu.class.getResourceAsStream("enemyplaneleft.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private final static Image enemyplaneright;
    static {
        try {
            enemyplaneright= ImageIO.read(Upgradesmenu.class.getResourceAsStream("enemyplaneright.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private final static Image enemytowerimg;
    static {
        try {
            enemytowerimg= ImageIO.read(Upgradesmenu.class.getResourceAsStream("enemytower.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private final static Image enemyturretimg;
    static {
        try {
            enemyturretimg= ImageIO.read(Upgradesmenu.class.getResourceAsStream("enemyturret.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private final static Image enemytankimg;
    static {
        try {
            enemytankimg= ImageIO.read(Upgradesmenu.class.getResourceAsStream("enemytank.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private final static Image enemytruckimg;
    static {
        try {
            enemytruckimg= ImageIO.read(Upgradesmenu.class.getResourceAsStream("enemytruck.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public Enemy(int type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.speed = 2;
    }


    public void paint(Graphics2D g2d) {
        //base
        g2d.setColor(Color.black);
        if (type == TANK) {
            g2d.drawImage(enemytankimg, (int) x, (int) y, width, height, null);
        }
        else if (type == TRUCKS){
            g2d.drawImage(enemytruckimg,(int)x,(int)y,25,33,null);
        }
        else if (type == TURRETS ){
            g2d.drawImage(enemyturretimg,(int)x,(int)y,45,60,null);
        }
        else if (type == TOWER ){
            g2d.drawImage(enemytowerimg,(int)x,(int)y,55,75,null);
        }
        else if (type == PLANES && planedirection == PLANELEFT){
            g2d.drawImage(enemyplaneleft,(int)x,(int)y,65,50,null);
        }
        else if (type == PLANES && planedirection == PLANERIGHT){
            g2d.drawImage(enemyplaneright,(int)x,(int)y,65,50,null);
        }
        else {
            g2d.fillRect((int) x, (int) y, width, height);
        }
    }

    public void tick(int levelWidth, int levelHeight) {

        //stationary
        int random = (int) (Math.random() * 100 + 1);

        if (type == 4 || type == 5) {
            if (random > 2) {

            }
            else{
                shoot();
            }

        }
        //vertical
        // TANK AND TRUCK MOVEMENT VERTICAL
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
        // TANK MOVEMENT HORIZONTAL
        random = (int) (Math.random() * 100 + 1);
        if (type == 1 ) {
            if (random > 95) {
                this.vx = speed;
            } else if (random > 90) {
                this.vx = -speed;
            } else if (random > 2) {

            } else
                shoot();
        }
        // PLANE MOVEMENT HORIZONTAL
        random = (int) (Math.random() * 100 + 1);
        if (type == 3) {
            if (random > 95) {
                planedirection = PLANERIGHT;
                this.vx = speed;
            } else if (random > 90) {
                planedirection = PLANELEFT;
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
