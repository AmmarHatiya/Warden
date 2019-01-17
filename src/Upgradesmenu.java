import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;


// NOTE: BUTTON CLASSES FOR THIS MENU END WITH -lsm
public class Upgradesmenu extends AppPanel implements MouseListener {


    private Buttons doublebarrelbttn = new Buttons(30, 250, 70, 80);
    private Buttons armorbttn = new Buttons(30, 150, 70, 80);
    private Buttons mobilitybttn = new Buttons(30, 50, 70, 80);
    private Buttons rapidbttn = new Buttons(30, 450, 70, 80);
    private Buttons medkitbttn = new Buttons(30, 350, 70, 80);
    private Buttons backbttn = new Buttons(820, 550, 125, 50);
    public static boolean mobility = false;
    public static boolean rapidfire = false;
    public static boolean armor = false;
    public static boolean medkit = false;
    public static boolean doublebarrel = false;

    // BRING SCORE TO THE UPGRADES PAGE
    public Upgradesmenu() {
        addMouseListener(this);
        setFocusable(true);
    }

    public void tick() {
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("Monospaced", Font.BOLD, 20);
        Font title = new Font("Monospaced", Font.BOLD, 32);
        g2d.setFont(font);
        //Draw Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 2300, 2000);
        g2d.setColor(Color.GREEN);
        armorbttn.filled = armor;
        armorbttn.paint(g2d);
        mobilitybttn.filled= mobility;
        mobilitybttn.paint(g2d);
        doublebarrelbttn.filled = doublebarrel;
        doublebarrelbttn.paint(g2d);
        medkitbttn.filled = medkit;
        medkitbttn.paint(g2d);
        rapidbttn.filled = rapidfire;
        rapidbttn.paint(g2d);
        backbttn.paint(g2d);
        g2d.drawString("Back", backbttn.buttonx + 45, backbttn.buttony + 27);
        g2d.setColor(new Color(128, 203, 255));
        g2d.setColor(Color.GREEN);
        g2d.drawString("Armor: Permanent Health Boost by 15 hp", armorbttn.buttonx + 100, armorbttn.buttony + (armorbttn.buttonh / 2));
        g2d.drawString("Mobility: Move Faster", mobilitybttn.buttonx + 100, mobilitybttn.buttony + (mobilitybttn.buttonh / 2));
        g2d.drawString("Double Barrel Ability: Have two Barrels for 30 seconds", doublebarrelbttn.buttonx + 100, doublebarrelbttn.buttony + (doublebarrelbttn.buttonh / 2));
        g2d.drawString("Med Kit: First aid kit that gives you 15 hp" +
                "", medkitbttn.buttonx + 100, medkitbttn.buttony + (medkitbttn.buttonh / 2));
        g2d.drawString("Rapid Fire Ability: Fire Rapidly for 30 seconds", rapidbttn.buttonx + 100, rapidbttn.buttony + (rapidbttn.buttonh / 2));
        g2d.drawString("Score: " + Level.points, 820, 50);
        //TITLE DRAW
        g2d.setColor(Color.GREEN);
        g2d.setFont(title);
        g2d.drawString("Upgrades", 390, 30);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
       /* // IF STATEMENTS FOR double barrel BUTTON
        if ((mouseEvent.getX() >= doublebarrelbttn.getX()) && (mouseEvent.getX() <= (doublebarrelbttn.getX() + doublebarrelbttn.getW())) && (mouseEvent.getY() >= doublebarrelbttn.getY()) && (mouseEvent.getY() <= (doublebarrelbttn.getY() + doublebarrelbttn.getH()))) {
        }


        // IF STATEMENTS FOR armor BUTTON
        if ((mouseEvent.getX() >= armorbttn.getX()) && (mouseEvent.getX() <= (armorbttn.getX() + armorbttn.getW())) && (mouseEvent.getY() >= armorbttn.getY()) && (mouseEvent.getY() <= (armorbttn.getY() + armorbttn.getH()))) {
        }


        // IF STATEMENTS FOR mobility GAME BUTTON
        if ((mouseEvent.getX() >= mobilitybttn.getX()) && (mouseEvent.getX() <= (mobilitybttn.getX() + mobilitybttn.getW())) && (mouseEvent.getY() >= mobilitybttn.getY()) && (mouseEvent.getY() <= (mobilitybttn.getY() + mobilitybttn.getH()))) {
        }
        // IF STATEMENTS FOR RAPID FIRE BUTTON
        if ((mouseEvent.getX() >= rapidbttn.getX()) && (mouseEvent.getX() <= (rapidbttn.getX() + rapidbttn.getW())) && (mouseEvent.getY() >= rapidbttn.getY()) && (mouseEvent.getY() <= (rapidbttn.getY() + rapidbttn.getH()))) {
        }
        // IF STATEMENTS FOR HEALTH UPGRADES
        if ((mouseEvent.getX() >= medkitbttn.getX()) && (mouseEvent.getX() <= (medkitbttn.getX() + medkitbttn.getW())) && (mouseEvent.getY() >= medkitbttn.getY()) && (mouseEvent.getY() <= (medkitbttn.getY() + medkitbttn.getH()))) {
        }*/
    }

    public void mousePressed(MouseEvent mouseEvent) {

        // IF STATEMENTS FOR double barrel BUTTON
        if ((mouseEvent.getX() >= doublebarrelbttn.getX()) && (mouseEvent.getX() <= (doublebarrelbttn.getX() + doublebarrelbttn.getW())) && (mouseEvent.getY() >= doublebarrelbttn.getY()) && (mouseEvent.getY() <= (doublebarrelbttn.getY() + doublebarrelbttn.getH()))) {

            if (Level.points >= 500 && !doublebarrel) {
                doublebarrel = true;
                Level.points = Level.points - 500;
            }
        }


        // IF STATEMENTS FOR armor BUTTON
        if ((mouseEvent.getX() >= armorbttn.getX()) && (mouseEvent.getX() <= (armorbttn.getX() + armorbttn.getW())) && (mouseEvent.getY() >= armorbttn.getY()) && (mouseEvent.getY() <= (armorbttn.getY() + armorbttn.getH()))) {
            if (Level.points >= 500 && !armor) {
                armor = true;
                Level.points = Level.points - 500;
            }
        }


        // IF STATEMENTS FOR mobility GAME BUTTON
        if ((mouseEvent.getX() >= mobilitybttn.getX()) && (mouseEvent.getX() <= (mobilitybttn.getX() + mobilitybttn.getW())) && (mouseEvent.getY() >= mobilitybttn.getY()) && (mouseEvent.getY() <= (mobilitybttn.getY() + mobilitybttn.getH()))) {
            if (Level.points >= 500 && !mobility) {
                mobility = true;
                Level.points = Level.points - 500;
            }
        }

        // IF STATEMENTS FOR RAPID FIRE BUTTON
        if ((mouseEvent.getX() >= rapidbttn.getX()) && (mouseEvent.getX() <= (rapidbttn.getX() + rapidbttn.getW())) && (mouseEvent.getY() >= rapidbttn.getY()) && (mouseEvent.getY() <= (rapidbttn.getY() + rapidbttn.getH()))) {
            if (Level.points >= 500 && !rapidfire) {
                Level.points = Level.points - 500;
                rapidfire = true;
            }
        }
        // IF STATEMENTS FOR HEALTH UPGRADES
        if ((mouseEvent.getX() >= medkitbttn.getX()) && (mouseEvent.getX() <= (medkitbttn.getX() + medkitbttn.getW())) && (mouseEvent.getY() >= medkitbttn.getY()) && (mouseEvent.getY() <= (medkitbttn.getY() + medkitbttn.getH()))) {
            if (Level.points >= 500 && !medkit) {
                medkit = true;
                Level.points = Level.points - 500;
            }

        }
        // IF STATEMENTS FOR BACK BUTTON
        if ((mouseEvent.getX() >= backbttn.getX()) && (mouseEvent.getX() <= (backbttn.getX() + backbttn.getW())) && (mouseEvent.getY() >= backbttn.getY()) && (mouseEvent.getY() <= (backbttn.getY() + backbttn.getH()))) {
            App.setCurrentPanel(App.startMenu);

        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        // Go to corresponding menu

    }


    public void mouseEntered(MouseEvent mouseEvent) {
    }


    public void mouseExited(MouseEvent mouseEvent) {

    }


}