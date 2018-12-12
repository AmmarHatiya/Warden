import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Level extends JPanel {
    private Tank tank = new Tank(100, 100);

    public Level() {


        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent)  {
                //tank.mouseClicked(mouseEvent);

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                tank.mousePressed(mouseEvent);
                            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                tank.mouseReleased(mouseEvent);
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

    private void move() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;

        tank.paint(g2d);
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

