import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Level extends JPanel {
    private Tank tank = new Tank(100, 100);
    private Barrel barrel;
    private ArrayList<Bullet> playerB;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    public Level() {
        playerB = new ArrayList<Bullet>(0);
        barrel = new Barrel(tank.getX(), tank.getY(),1,1);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Bullet b = new Bullet(tank.getX(), tank.getY(), e.getX(), e.getY());
                playerB.add(b);
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                tank.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    //moving each non player element
    private void move() {
        for (Bullet b : playerB) b.move();
    }

    private void remove() {
        ArrayList<Bullet> toRemove = new ArrayList<Bullet>(0);
        if (!playerB.isEmpty()) {
            for (Bullet b : playerB) {
                if (b.getX() > WIDTH-5 || b.getX() < 5 || b.getY() > HEIGHT-5|| b.getY() < 5) {
                    toRemove.add(b);
                }
            }
            playerB.removeAll(toRemove);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;


        tank.paint(g2d);
        for (Bullet b : playerB) b.paint(g2d);
        barrel.paint(g2d);
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("CityScape");
        Level jp = new Level();
        frame.add(jp);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            jp.move(); //Updates the coordinates
            jp.repaint(); //Calls the paint method
            jp.remove();
            Thread.sleep(1); //Pauses for a moment
        }
    }

}

