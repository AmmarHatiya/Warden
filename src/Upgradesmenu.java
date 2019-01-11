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
public class Upgradesmenu extends AppPanel implements MouseListener {
    /*private final static Image backImage;

    static {
        try {
            backImage = ImageIO.read(Upgradesmenu.class.getResourceAsStream("back.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }*/


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
    private Buttons backbttn= new Buttons(820,50,125,50);

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
        backbttn.paint(g2d);
        g2d.drawString("Back", backbttn.buttonx+35, backbttn.buttony+15);
        g2d.setColor(new Color(128, 203, 255));
        g2d.fillRect(armorbttn.buttonx, armorbttn.buttony, armorbttn.buttonw, armorbttn.buttonh);
        g2d.drawString("Armor", armorbttn.buttonx+30, armorbttn.buttony+armorbttn.buttonh+15);
        g2d.drawString("Mobility", mobilitybttn.buttonx+32, mobilitybttn.buttony+mobilitybttn.buttonh+15);
        g2d.drawString("Double Barrel Ability", doublebarrelbttn.buttonx+35, doublebarrelbttn.buttony+doublebarrelbttn.buttonh+15);
        g2d.drawString("Armor Penetration", penetrationbttn.buttonx+30, penetrationbttn.buttony+penetrationbttn.buttonh+15);
        g2d.drawString("Health Upgrade", healthbttn.buttonx+30, healthbttn.buttony+healthbttn.buttonh+15);
        g2d.drawString("Rapid Fire Ability", rapidbttn.buttonx+32, rapidbttn.buttony+rapidbttn.buttonh+15);

        /*g2d.drawImage(backImage, 0, 0, this);*/
    }
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
        // IF STATEMENTS FOR BACK BUTTON
        if ((mouseEvent.getX() >= backbttn.getX()) && (mouseEvent.getX()<=(backbttn.getX()+backbttn.getW())) && (mouseEvent.getY()>= backbttn.getY())&& (mouseEvent.getY()<=(backbttn.getY()+backbttn.getH()))){
            System.out.println("I'm in the Mud button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+backbttn.getY());
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