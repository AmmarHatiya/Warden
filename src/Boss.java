import javax.imageio.ImageIO;
import java.awt.*;

public class Boss extends Entity {

    private static final int BOSSTURRET = 1;
    private static final int BOSSSHIP = 2;
    private static final int BOSSTANK = 3;
    private static final int BOSSCOPTER = 4;
    // WHEN SHIP GOES LEFT OR RIGHT, THE PICTURE CHANGES
    private static final int BOSSHIPRIGHT = 9;
    private static final int BOSSSHIPLEFT = 8;
    private int bossshipdirection = 9;
    public int width;
    public int height;

    private int type;
    private int health;
    private int speed;
    private final static Image bossheliimg;
    static {
        try {
            bossheliimg= ImageIO.read(Upgradesmenu.class.getResourceAsStream(""));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private final static Image bossshipleftimg;
    static {
        try {
            bossshipleftimg= ImageIO.read(Upgradesmenu.class.getResourceAsStream("bossshipleft.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private final static Image bossshiprightimg;
    static {
        try {
            bossshiprightimg = ImageIO.read(Upgradesmenu.class.getResourceAsStream("bossshipright.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private final static Image bossturretimg;

    static {
        try {
            bossturretimg = ImageIO.read(Upgradesmenu.class.getResourceAsStream("bossturret.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private final static Image bosstankimg;

    static {
        try {
            bosstankimg = ImageIO.read(Upgradesmenu.class.getResourceAsStream("bosstank.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

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
        if (type == BOSSTURRET) {
            g2d.drawImage(bossturretimg, (int) x, (int) y, 80, 95, null);
        } else if (type == BOSSTANK) {
            g2d.drawImage(bosstankimg, (int) x, (int) y, 80, 95, null);
        } else if (type == BOSSSHIP && bossshipdirection == BOSSSHIPLEFT){
                g2d.drawImage(bossshipleftimg,(int)x,(int)y,65,50,null);
            }
            else if (type == BOSSSHIP && bossshipdirection == BOSSHIPRIGHT){
                g2d.drawImage(bossshiprightimg,(int)x,(int)y,65,50,null);
            }
            else if (type == BOSSCOPTER){
                g2d.drawImage(bossheliimg,(int)x,(int) y,65,65,null);
        }
        g2d.fillRect((int) x, (int) y, width, height);

        g2d.setColor(Color.green);
        g2d.fillOval((int) x, (int) y, 5, 5);
    }

    public void tick(int levelWidth, int levelHeight) {
        //vertical
        // TURRET
        int random = (int) (Math.random() * 100 + 1);
        if (type == BOSSTURRET) {
            if (random > 10) {
            } else {
                shoot();
            }
        } else if (type == BOSSTANK) {
            // TANK vertical
            if (type == BOSSTANK) {
                if (random > 95) {
                    this.vy = speed;
                } else if (random > 90) {
                    this.vy = -speed;
                } else if (random > 2) {

                } else
                    shoot();
            }
            // TANK HORIZONTAL
            random = (int) (Math.random() * 100 + 1);
            if (type == 1) {
                if (random > 95) {
                    this.vx = speed;
                } else if (random > 90) {
                    this.vx = -speed;
                } else if (random > 2) {

                } else
                    shoot();
            }

// SHIP MOVEMENT (HORIZONTAL)
        } else if (type == BOSSSHIP) {
            if (random > 95) {
                this.vx = speed;
                bossshipdirection = BOSSHIPRIGHT;
            } else if (random > 90) {
                bossshipdirection = BOSSSHIPLEFT;
                this.vx = -speed;
            } else if (random > 2) {

            } else
                shoot();
            // HELICOPTER MOVEMENT
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
