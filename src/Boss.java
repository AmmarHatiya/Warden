import javax.imageio.ImageIO;
import java.awt.*;

public class Boss extends Entity {

    private static final int BOSSTURRET = 1;
    private static final int BOSSTANK = 2;
    private static final int BOSSSHIP = 3;
    private static final int BOSSCOPTER = 4;
    // WHEN SHIP GOES LEFT OR RIGHT, THE PICTURE CHANGES
    private static final int BOSSHIPRIGHT = 9;
    private static final int BOSSSHIPLEFT = 8;
    private int bossshipdirection = 9;
    private static final int BOSSPLANERIGHT = 6;
    private static final int BOSSPLANELEFT = 7;
    private int bossplanedirection = 6;
    public int width;
    public int height;
    public int h;

    private int type;
    private int health;
    private int speed;
    private final static Image bossplanerightimg;

    static {
        try {
            bossplanerightimg = ImageIO.read(Upgradesmenu.class.getResourceAsStream("bossplaneright.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private final static Image bossplaneleftimg;

    static {
        try {
            bossplaneleftimg = ImageIO.read(Upgradesmenu.class.getResourceAsStream("bossplaneleft.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private final static Image bossshipleftimg;

    static {
        try {
            bossshipleftimg = ImageIO.read(Upgradesmenu.class.getResourceAsStream("bossshipleft.png"));
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
            h = health = 25;
        } else if (type == BOSSSHIP) {
            h = health = 100;
            width = 80;
            height = 30;
        } else if (type == BOSSTANK) {
            width = 50;
            height = 50;
            h = health = 50;
        } else if (type == BOSSCOPTER) {
            width = 40;
            height = 30;
            h = health = 75;
        }
    }

    public void check(Entity p) {
        if (x < p.x && x + width > p.x && y < p.y && y + height > p.y) {
            this.x = x - vx;
            this.y = y - vy;
        }
    }

    public void shoot() {
        int r1 = (int) (Math.random() * 1000 - 100);
        int r2 = (int) (Math.random() * 1000 - 100);
        this.addParticleToLevel.accept(new Bullet(this.x + 15, this.y + 15, r1, r2, false));
    }

    public void check(Particle p) {
        if (p instanceof Bullet) {
            Bullet b = (Bullet) p;
            if (b.isPlayer && x < b.x && x + width > b.x && y < b.y && y + height > b.y) {
                if (health > 0) {
                    health--;
                    this.removeParticleFromLevel.accept(p);
                } else if (health <= 0) {
                    this.addToScore.accept(h);
                    this.removeParticleFromLevel.accept(p);
                    this.removeSelf.accept(this);
                }

            }
        }
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.lightGray);
        g2d.fillRect(500 - h * 5, 5, h * 5, 25);

        if (health > 0) {
            g2d.setColor(Color.red);
            g2d.fillRect(500 - health * 5, 5, health * 5, 25);
        }
        Font txt = new Font("Monospaced", Font.BOLD + Font.ITALIC, 16);
        g2d.setColor(Color.WHITE);
        g2d.setFont(txt);
        g2d.drawString("Boss Health", 500, 25);
        //base
        g2d.setColor(Color.black);
        if (type == BOSSTURRET) {
            g2d.drawImage(bossturretimg, (int) x, (int) y, 80, 95, null);
        } else if (type == BOSSTANK) {
            g2d.drawImage(bosstankimg, (int) x, (int) y, 80, 95, null);
        } else if (type == BOSSSHIP && bossshipdirection == BOSSSHIPLEFT) {
            g2d.drawImage(bossshipleftimg, (int) x, (int) y, 65, 50, null);
        } else if (type == BOSSSHIP && bossshipdirection == BOSSHIPRIGHT) {
            g2d.drawImage(bossshiprightimg, (int) x, (int) y, 65, 50, null);
        } else if (type == BOSSCOPTER && bossplanedirection == BOSSPLANERIGHT) {
            g2d.drawImage(bossplanerightimg, (int) x, (int) y, 65, 50, null);
        } else if (type == BOSSCOPTER && bossplanedirection == BOSSPLANELEFT) {
            g2d.drawImage(bossplaneleftimg, (int) x, (int) y, 65, 50, null);
        }
    }

        public void tick ( int levelWidth, int levelHeight){
            //vertical
            // TURRET
            int random = (int) (Math.random() * 100 + 1);
            if (type == BOSSTURRET) {
                if (random > 30) {
                } else {
                    shoot();
                }
            }// TANK vertical
            else if (type == BOSSTANK) {
                if (random > 95) {
                    this.vy = speed;
                    shoot();
                } else if (random > 90) {
                    this.vy = -speed;
                    shoot();
                } else
                    shoot();
            }
            // TANK HORIZONTAL
            if (type == BOSSTANK) {
                if (random > 90) {
                    this.vx = speed;
                } else if (random > 80) {
                    this.vx = -speed;
                } else if (random > 2) {

                } else
                    shoot();
            }
// SHIP MOVEMENT (HORIZONTAL)
            if (type == BOSSSHIP) {
                if (random > 95) {
                    bossshipdirection = BOSSHIPRIGHT;
                    this.vx = speed;
                } else if (random > 90) {
                    bossshipdirection = BOSSSHIPLEFT;
                    this.vx = -speed;
                } else if (random > 2) {

                } else
                    shoot();
            }
            // HELICOPTER MOVEMENT
            else if (type == BOSSCOPTER) {
                if (random > 95) {
                    bossplanedirection = BOSSPLANERIGHT;
                    this.vx = speed;
                } else if (random > 90) {
                    bossplanedirection = BOSSPLANELEFT;
                    this.vx = -speed ;
                } else if (random > 20) {
                } else
                    shoot();
            }


            super.tick(levelWidth, levelHeight);
            if (x > levelWidth - width || x < 5)
                vx *= -speed;
            if (y > levelHeight - 85 - height || y < 5)
                vy *= -speed;


            this.x = x + vx;
            this.y = y + vy;

        }


    }

