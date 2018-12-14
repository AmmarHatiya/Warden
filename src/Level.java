import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Level extends JPanel {
    private Tank tank = new Tank(100, 100);
    private ArrayList<Bullet> playerB;

    public Level() {
        playerB = new ArrayList<Bullet>(0);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent)  {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Bullet b = new Bullet(tank.getX(),tank.getY(),e.getX(),e.getY());
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
        for (Bullet b : playerB)b.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;

        tank.paint(g2d);
        for (Bullet b : playerB)b.paint(g2d);
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("CityScape");
        Level jp = new Level();
        frame.add(jp);
        frame.setSize(1000, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            jp.move(); //Updates the coordinates
            jp.repaint(); //Calls the paint method
            Thread.sleep(1); //Pauses for a moment
        }
    }

}

