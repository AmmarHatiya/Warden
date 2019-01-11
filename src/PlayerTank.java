import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PlayerTank extends Entity {
    private int speed = 2; //how fast moves
    private static final int DELAY = 5;
    private int delay = DELAY; //slows down rate of fire
    private static final int HEALTH =30;
    public int health = HEALTH;

    public int width = 30;
    public int height = 30;


    public PlayerTank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics2D g2d) {
        //base
        g2d.setColor(Color.lightGray);
        g2d.fillRect((int) x , (int) y,  30, 30);

        g2d.setColor(Color.green);
        g2d.fillOval((int) x, (int) y, 5, 5);

        g2d.setColor(Color.lightGray);
        g2d.fillRect(500, 500-HEALTH*5, 25, HEALTH*5);

        if (health>0){
            g2d.setColor(Color.pink);
            g2d.fillRect(500, 500-health*5, 25, health*5);
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
    }

    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
            this.vx = 0;
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S)
            this.vy = 0;
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            this.health = HEALTH;
    }

    public void tick(int levelWidth, int levelHeight) {
        super.tick(levelWidth, levelHeight);
        if (x < 0) x = 0;
        if (x + width > levelWidth) x = levelWidth - width;
        if (y < 0) y = 0;
        if (y + height > levelHeight) y = levelHeight - height;
        this.delay++;
    }

    //TODO:need health to come down
    public void check(Entity p) {
        if (x>p.x && x+width < p.x + width && y<p.y && y+height>p.y + height){
            /*this.x = x - vx;
            this.y = y - vy;*/
            health--;
        }
    }

    public void check(Particle p) {
        if (p instanceof Bullet){
            Bullet b = (Bullet) p;
            if (!b.isPlayer && x<b.x && x+width > b.x && y<b.y && y+height>b.y){
                this.removeParticleFromLevel.accept(p);
                health--;
            }
        }
        if (health<=0){

        }
    }

    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        this.mouseDragged(e);
    }

    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (delay>50) {
            this.addParticleToLevel.accept(new Bullet(this.x + 15, this.y + 15, e.getX(), e.getY(), true));
            this.delay=0;
        }
    }
}
