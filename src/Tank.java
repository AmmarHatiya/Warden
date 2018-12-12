import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Tank {
    private int xa; //Horizontal speed
    private int ya; //Vertical speed
    private int x;
    private int y;
    private int acl = 4;
    private boolean shoot = false;


    public static final Color MOD_YELLOW = new Color(245, 255, 43, 176);

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isShoot() {
        return shoot;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics2D g2d) {
        //Smooth’s out the movement
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (shoot == true) {
            g2d.setColor(MOD_YELLOW);
            g2d.fillRect(x , y, 7, 975 - y);
        }


        //base
        g2d.setColor(Color.lightGray);
        g2d.fillRect(x-15, y-15 , 30, 30);

        g2d.setColor(Color.green);
        g2d.fillOval(x, y , 3, 3);
    }

    public void mouseClicked(MouseEvent e) {
        this.xa = 0;
        this.ya = 0;
        if (shoot == true) {
        shoot = false;
        } else {
            shoot = true;
        }
    }

    public void mousePressed(MouseEvent e) {
        this.xa = 0;
        this.ya = 0;
        shoot = true;
    }

    public void mouseReleased(MouseEvent e) {
        this.xa = 0;
        this.ya = 0;
        shoot = false;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A)
            x = x-acl;
        if (e.getKeyCode() == KeyEvent.VK_D)
            x = x+acl;
        if (e.getKeyCode() == KeyEvent.VK_W)
            y = y-acl;
        if (e.getKeyCode() == KeyEvent.VK_S)
            y = y+acl;
        x = x + xa; //Adjust the x and y coordinates
        y = y + ya; //by the appropriate speeds
    }
}
