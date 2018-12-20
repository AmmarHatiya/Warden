import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

// NOTE: BUTTON CLASSES FOR THIS MENU END WITH -lsm
public class Upgradesmenu extends JPanel {
    private BufferedImage image;


    private int grasstankx[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int grasstanky[] = {50 + 60, 50 + 82, 50 + 82, 50 + 60};
    private int mudtankx[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int mudtanky[] = {350 + 60, 350 + 82, 350 + 82, 350 + 60};
    private int icetankx[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int icetanky[] = {200 + 60, 200 + 82, 200 + 82, 200 + 60};
    private int citytankx[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int citytanky[] = {500 + 60, 500 + 82, 500 + 82, 500 + 60};
    private Buttons doublebarrelbttn = new Buttons(30, 250, 70, 80);
    private Buttons armorbttn = new Buttons(30, 150, 70, 80);
    private Buttons mobilitybttn = new Buttons(30, 50, 70, 80);
    private Buttons penetrationbttn = new Buttons(30, 350, 70, 80);
    private Buttons rapidbttn = new Buttons(30, 450, 70, 80);
    private Buttons healthbttn = new Buttons(30, 550, 70, 80);


    public Upgradesmenu() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                // IF STATEMENTS FOR double barrel BUTTON
                if ((mouseEvent.getX() >= doublebarrelbttn.getX()) && (mouseEvent.getX() <= (doublebarrelbttn.getX() + doublebarrelbttn.getW())) && (mouseEvent.getY() >= doublebarrelbttn.getY()) && (mouseEvent.getY() <= (doublebarrelbttn.getY() + doublebarrelbttn.getH()))) {
                    System.out.println("I'm in the double barrel upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + doublebarrelbttn.getY());
                }


                // IF STATEMENTS FOR armor BUTTON
                if ((mouseEvent.getX() >= armorbttn.getX()) && (mouseEvent.getX() <= (armorbttn.getX() + armorbttn.getW())) && (mouseEvent.getY() >= armorbttn.getY()) && (mouseEvent.getY() <= (armorbttn.getY() + armorbttn.getH()))) {
                    System.out.println("I'm in the armor upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + armorbttn.getY());
                }


                // IF STATEMENTS FOR mobility GAME BUTTON
                if ((mouseEvent.getX() >= mobilitybttn.getX()) && (mouseEvent.getX() <= (mobilitybttn.getX() + mobilitybttn.getW())) && (mouseEvent.getY() >= mobilitybttn.getY()) && (mouseEvent.getY() <= (mobilitybttn.getY() + mobilitybttn.getH()))) {
                    System.out.println("I'm in the mobility upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + mobilitybttn.getY());
                }
                // IF STATEMENTS FOR penetration BUTTON
                if ((mouseEvent.getX() >= penetrationbttn.getX()) && (mouseEvent.getX() <= (penetrationbttn.getX() + penetrationbttn.getW())) && (mouseEvent.getY() >= penetrationbttn.getY()) && (mouseEvent.getY() <= (penetrationbttn.getY() + penetrationbttn.getH()))) {
                    System.out.println("I'm in the penetration upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + penetrationbttn.getY());
                }
                // IF STATEMENTS FOR RAPID FIRE BUTTON
                if ((mouseEvent.getX() >= rapidbttn.getX()) && (mouseEvent.getX() <= (rapidbttn.getX() + rapidbttn.getW())) && (mouseEvent.getY() >= rapidbttn.getY()) && (mouseEvent.getY() <= (rapidbttn.getY() + rapidbttn.getH()))) {
                    System.out.println("I'm in the rapid fire upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + rapidbttn.getY());
                }
                // IF STATEMENTS FOR HEALTH UPGRADES
                if ((mouseEvent.getX() >= healthbttn.getX()) && (mouseEvent.getX() <= (healthbttn.getX() + healthbttn.getW())) && (mouseEvent.getY() >= healthbttn.getY()) && (mouseEvent.getY() <= (healthbttn.getY() + healthbttn.getH()))) {
                    System.out.println("I'm in the health upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + healthbttn.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

                // IF STATEMENTS FOR double barrel BUTTON
                if ((mouseEvent.getX() >= doublebarrelbttn.getX()) && (mouseEvent.getX() <= (doublebarrelbttn.getX() + doublebarrelbttn.getW())) && (mouseEvent.getY() >= doublebarrelbttn.getY()) && (mouseEvent.getY() <= (doublebarrelbttn.getY() + doublebarrelbttn.getH()))) {
                    System.out.println("I'm in the double barrel upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + doublebarrelbttn.getY());
                }


                // IF STATEMENTS FOR armor BUTTON
                if ((mouseEvent.getX() >= armorbttn.getX()) && (mouseEvent.getX() <= (armorbttn.getX() + armorbttn.getW())) && (mouseEvent.getY() >= armorbttn.getY()) && (mouseEvent.getY() <= (armorbttn.getY() + armorbttn.getH()))) {
                    System.out.println("I'm in the armor upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + armorbttn.getY());
                }


                // IF STATEMENTS FOR mobility GAME BUTTON
                if ((mouseEvent.getX() >= mobilitybttn.getX()) && (mouseEvent.getX() <= (mobilitybttn.getX() + mobilitybttn.getW())) && (mouseEvent.getY() >= mobilitybttn.getY()) && (mouseEvent.getY() <= (mobilitybttn.getY() + mobilitybttn.getH()))) {
                    System.out.println("I'm in the mobility upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + mobilitybttn.getY());
                }
                // IF STATEMENTS FOR penetration BUTTON
                if ((mouseEvent.getX() >= penetrationbttn.getX()) && (mouseEvent.getX() <= (penetrationbttn.getX() + penetrationbttn.getW())) && (mouseEvent.getY() >= penetrationbttn.getY()) && (mouseEvent.getY() <= (penetrationbttn.getY() + penetrationbttn.getH()))) {
                    System.out.println("I'm in the penetration upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + penetrationbttn.getY());
                }
                // IF STATEMENTS FOR RAPID FIRE BUTTON
                if ((mouseEvent.getX() >= rapidbttn.getX()) && (mouseEvent.getX() <= (rapidbttn.getX() + rapidbttn.getW())) && (mouseEvent.getY() >= rapidbttn.getY()) && (mouseEvent.getY() <= (rapidbttn.getY() + rapidbttn.getH()))) {
                    System.out.println("I'm in the rapid fire upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + rapidbttn.getY());
                }
                // IF STATEMENTS FOR HEALTH UPGRADES
                if ((mouseEvent.getX() >= healthbttn.getX()) && (mouseEvent.getX() <= (healthbttn.getX() + healthbttn.getW())) && (mouseEvent.getY() >= healthbttn.getY()) && (mouseEvent.getY() <= (healthbttn.getY() + healthbttn.getH()))) {
                    System.out.println("I'm in the health upgrade button");
                    System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + healthbttn.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                // Go to corresponding menu

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        setFocusable(true);
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 2300, 2000);
        g2d.setColor(Color.GREEN);
        armorbttn.paint(g2d);
        mobilitybttn.paint(g2d);
        doublebarrelbttn.paint(g2d);
        penetrationbttn.paint(g2d);
        healthbttn.paint(g2d);
        rapidbttn.paint(g2d);
        g2d.setColor(new Color(128, 203, 255));
        g2d.fillRect(armorbttn.buttonx, armorbttn.buttony, armorbttn.buttonw, armorbttn.buttonh);
        try {
            image = ImageIO.read(new File("C:\\Users\\s300045442\\IdeaProjects\\Warden2\\res"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }



    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("Den of Tanks");
        Upgradesmenu p = new Upgradesmenu();

        frame.add(p);
        //Add our JPanel to the frame
        frame.setSize(1000, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Draw stuff
        while (true) {
            p.repaint();
            Thread.sleep(10);
        }

    }

}