import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayerTank extends Entity {
    private int speed = 2; //how fast moves
    //TODO: change delay, just testing phase
    private int d = 10;
    //private static final int DELAY = d;
    private int delay = d; //slows down rate of fire
    public static final int HEALTH = 30;
    public int health = HEALTH;

    private boolean healthUpgradeApplied = false;
    private boolean rapidUpgradeApplied = false;

    private boolean usedKit = false;
    private boolean usedRapid = false;
    private boolean usedDouble = false;
    private boolean usedMobility = false;

    public boolean pause = false;
    public int width = 30;
    public int height = 30;

    private int i = 0;

    private int r = 0;
    private int b = 0;
    private int m = 0;


    public PlayerTank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics2D g2d) {
        //base
        g2d.setColor(Color.lightGray);
        g2d.fillRect((int) x, (int) y, 30, 30);

        g2d.setColor(Color.green);
        g2d.fillOval((int) x, (int) y, 5, 5);

        g2d.setColor(Color.lightGray);
        g2d.fillRect(700 - HEALTH * 5, 625, HEALTH * 5, 25);

        if (health > 0) {
            g2d.setColor(Color.red);
            g2d.fillRect(700 - health * 5, 625, health * 5, 25);
        }

        if (Upgradesmenu.mobility) {
            this.x += this.vx * 2;
            this.y += this.vy * 2;
        } else {
            this.x += this.vx;
            this.y += this.vy;
        }


    }

    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        if (e.getKeyCode() == KeyEvent.VK_A)
            this.vx = -speed;
        if (e.getKeyCode() == KeyEvent.VK_D)
            this.vx = +speed;
        if (e.getKeyCode() == KeyEvent.VK_W)
            this.vy = -speed;
        if (e.getKeyCode() == KeyEvent.VK_S)
            this.vy = +speed;

        if (e.getKeyCode() == KeyEvent.VK_1 && Upgradesmenu.medkit && !usedKit) {
            health+=15;
            usedKit=true;
        }

        if (e.getKeyCode() == KeyEvent.VK_2 && Upgradesmenu.mobility && !usedMobility) {
            usedMobility=true;
        }

        if (e.getKeyCode() == KeyEvent.VK_3 && Upgradesmenu.doublebarrel && !usedDouble) {
            usedMobility=true;
        }

        if (e.getKeyCode() == KeyEvent.VK_4 && Upgradesmenu.rapidfire && !usedRapid) {
            usedMobility=true;
        }


    }

    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
            this.vx = 0;
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S)
            this.vy = 0;

        //make pause
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            this.pause = true;
    }

    public void tick(int levelWidth, int levelHeight) {
        // Note: not calling super, as we want custom speeds.

        //to pause
        if (pause) {
            i++;
        }
        if (i > 1) {
            i = 0;
            pause = false;
        }

        if (usedMobility) {
            m++;
            this.x += this.vx * 2;
            this.y += this.vy * 2;
        }
        if (m > 100 || !usedMobility) {
            this.x += this.vx;
            this.y += this.vy;
        }


        if (Upgradesmenu.armor && !healthUpgradeApplied) {
            this.health += 15;
            healthUpgradeApplied = true;
        }


        if (Upgradesmenu.rapidfire && !rapidUpgradeApplied) {
            this.d = this.d - 5;
            rapidUpgradeApplied = true;
        }

        if (x < 0) x = 0;
        if (x + width > levelWidth - 15) x = levelWidth - width - 15;
        if (y < 0) y = 0;
        if (y + height > levelHeight - 85) y = levelHeight - 85 - height;
        this.delay++;
    }

    public void check(Entity p) {
        if (x < p.x + p.width && x + width > p.x && y < p.y + p.height && y + height > p.y) {
            health--;
        }
    }

    public void check(Particle p) {
        if (p instanceof Bullet) {
            Bullet b = (Bullet) p;
            if (!b.isPlayer && x < b.x + b.width && x + width > b.x && y < b.y + b.width && y + height > b.y) {
                this.removeParticleFromLevel.accept(p);
                health--;
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        this.mouseDragged(e);
    }

    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (delay > d) {
            this.addParticleToLevel.accept(new Bullet(this.x + 15, this.y + 15, e.getX(), e.getY(), true));
            if (Upgradesmenu.doublebarrel)
                this.addParticleToLevel.accept(new Bullet(this.x + 15, this.y + 15, e.getX() + 15, e.getY(), true));
            this.delay = 0;
        }
    }
}
