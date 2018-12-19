import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
/*
//https://stackoverflow.com/questions/44138641/2d-bullet-game-in-java
public abstract class Enemy extends Entity {
    private int x;
    private int y;
    private int speed = 9; //how fast moves
    private boolean shoot = false;


    public static final Color MOD_YELLOW = new Color(254, 255, 24, 251);

    public boolean isShoot() {
        return shoot;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = 100;
        this.h = 100;
    }

    public void paint(Graphics2D g2d) {
        //Smooth’s out the movement
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);



        //base
        g2d.setColor(Color.lightGray);
        g2d.fillRect(x-15, y-15 , 30, 30);

        g2d.setColor(Color.green);
        g2d.fillOval(x, y , 5, 5);
    }

    public void keyPressed(KeyEvent e) {
        //moving with wasd keys
        if (e.getKeyCode() == KeyEvent.VK_A)
            x = x- speed;
        if (e.getKeyCode() == KeyEvent.VK_D)
            x = x+ speed;
        if (e.getKeyCode() == KeyEvent.VK_W)
            y = y- speed;
        if (e.getKeyCode() == KeyEvent.VK_S)
            y = y+ speed;
    }
}*/
