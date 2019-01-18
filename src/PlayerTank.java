import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
public class PlayerTank extends Entity {
    private int speed = 2; //how fast moves
    //TODO: change delay, just testing phase

    private static final int DELAY = 10;
    private int delay = DELAY; //slows down rate of fire
    private int THIRTYSEC = 100;


    public static final int HEALTH = 30;
    public int health = HEALTH;

    private boolean healthUpgradeApplied = false;
    private boolean rapidUpgradeApplied = false;

    public boolean usedKit = false;
    public boolean usedRapid = false;
    public boolean usedDouble = false;
    public boolean usedMobility = false;

    public boolean pause = false;
    public int width = 30;
    public int height = 30;

    private int i = 0;

    public int r = 0;
    public int b = 0;
    public int m = 0;

    private final static Image playertankimg;
    static {
        try {
            playertankimg = ImageIO.read(Upgradesmenu.class.getResourceAsStream("playertankimage.bmp"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public PlayerTank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics2D g2d) {
        //base
        g2d.setColor(new Color(17, 75, 11));
        g2d.fillRect((int) x , (int) y,  30, 30);
/*g2d.drawImage(playertankimg,(int)x,(int)y,25,25,null);*/


        g2d.setColor(Color.green);
        g2d.fillOval((int) x, (int) y, 5, 5);

        g2d.setColor(Color.lightGray);
        g2d.fillRect(750 - HEALTH * 5, 625, HEALTH * 5, 25);

        if (health > 0) {
            g2d.setColor(Color.red);
            g2d.fillRect(750 - health * 5, 625, health * 5, 25);
        }

        Font txt = new Font("Monospaced", Font.BOLD, 15);

        if (Upgradesmenu.medkit) {
            String word;
            if (!usedKit) {
                g2d.setColor(Color.red);
                word = "Press 1 For MedKit";
            }else {
                g2d.setColor(Color.lightGray);
                word = "MedKit Used";
            }
            g2d.fillRect(150, 617, 250, 8);
            g2d.setColor(Color.green);
            g2d.setFont(txt);
            g2d.drawString(word, 150, 625);
        }

        if (m > THIRTYSEC || Upgradesmenu.mobility) {
            String word;
            if (!usedMobility) {
                g2d.setColor(Color.red);
                word = "Press 2 For Mobility";
            }else {
                g2d.setColor(Color.lightGray);
                word = "Mobility Used";
            }
            g2d.fillRect(150, 627, 250, 8);
            g2d.setColor(Color.green);
            g2d.setFont(txt);
            g2d.drawString(word, 150, 635);
        }

        if (b > THIRTYSEC || Upgradesmenu.doublebarrel) {
            String word;
            if (!usedDouble) {
                g2d.setColor(Color.red);
                word = "Press 3 For Double Barrel";
            }else {
                g2d.setColor(Color.lightGray);
                word = "Double Barrel Used";
            }
            g2d.fillRect(150, 637, 250, 8);
            g2d.setColor(Color.green);
            g2d.setFont(txt);
            g2d.drawString(word, 150, 645);
        }

        if (r > THIRTYSEC || Upgradesmenu.rapidfire) {
            String word;
            if (!usedRapid) {
                g2d.setColor(Color.red);
                word = "Press 4 For Rapid Fire";
            }else {
                g2d.setColor(Color.lightGray);
                word = "Rapid Fire Used";
            }
            g2d.fillRect(150, 647, 250, 8);
            g2d.setColor(Color.green);
            g2d.setFont(txt);
            g2d.drawString(word, 150, 655);
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
            health += 15;
            usedKit = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_2 && Upgradesmenu.mobility && !usedMobility) {
            usedMobility = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_3 && Upgradesmenu.doublebarrel && !usedDouble) {
            usedDouble = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_4 && Upgradesmenu.rapidfire && !usedRapid) {
            usedRapid = true;
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
        if (m > THIRTYSEC || !usedMobility) {
            this.x += this.vx;
            this.y += this.vy;
        }

        if (usedRapid) {
            r++;
            this.delay += 2;
        }
        if (r > THIRTYSEC || !usedRapid) {
            this.delay++;
        }

        if (usedDouble) {
            b++;
        }
        if (b > THIRTYSEC || !usedDouble) {
            usedDouble = false;
        }


        if (Upgradesmenu.armor && !healthUpgradeApplied) {
            this.health += 15;
            healthUpgradeApplied = true;
        }


        if (x < 0) x = 0;
        if (x + width > levelWidth - 15) x = levelWidth - width - 15;
        if (y < 0) y = 0;
        if (y + height > levelHeight - 85) y = levelHeight - 85 - height;

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
        if (delay > DELAY) {
            this.addParticleToLevel.accept(new Bullet(this.x + 15, this.y + 15, e.getX(), e.getY(), true));
            if (usedDouble)
                this.addParticleToLevel.accept(new Bullet(this.x + 15, this.y + 15, e.getX() + 15, e.getY(), true));
            this.delay = 0;
        }
    }
}
