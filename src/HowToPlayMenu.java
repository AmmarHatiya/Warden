import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HowToPlayMenu extends AppPanel implements MouseListener {

    private Buttons mainmenu = new Buttons(425, 550, 125, 50);
    private Buttons nextbttn = new Buttons(425, 550, 125, 50);


    public HowToPlayMenu() {
        addMouseListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Font button = new Font("Monospaced", Font.BOLD, 14);
        Font title = new Font("Century Gothic", Font.BOLD, 30);
        Font txt = new Font("Monospaced", Font.BOLD, 25);
        g.setFont(button);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 2300, 2000);
        //Draw button
        g2d.setColor(Color.GREEN);
        mainmenu.paint(g2d);
        /*nextbttn.paint(g2d);*//*
        g2d.drawString("Next", nextbttn.buttonx+25, nextbttn.buttony+27);*/
        g2d.drawString("Main Menu", mainmenu.buttonx + 25, mainmenu.buttony + 27);
        g2d.setFont(txt);
g2d.drawString("Press W to move ⇧",200,150);
        g2d.drawString("Press A to move ⇦",200,170);
        g2d.drawString("Press S to move ⇩",200,190);
        g2d.drawString("Press D to move ⇨",200,210);
        g2d.drawString("Move mouse to Aim",200,210);
        g2d.drawString("Right-Click mouse button to shoot",200,210);
        g2d.setFont(title);
        g2d.drawString("HOW TO PLAY", 390, 40);


    }

    public void tick() {
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        // IF STATEMENTS FOR NEW GAME BUTTON
        if ((mouseEvent.getX() >= mainmenu.getX()) && (mouseEvent.getX() <= (mainmenu.getX() + mainmenu.getW())) && (mouseEvent.getY() >= mainmenu.getY()) && (mouseEvent.getY() <= (mainmenu.getY() + mainmenu.getH()))) {
            System.out.println("I'm in the Main Menu button");
            System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + mainmenu.getY());

        }
        // IF STATEMENTS FOR retry BUTTON
        if ((mouseEvent.getX() >= nextbttn.getX()) && (mouseEvent.getX() <= (nextbttn.getX() + nextbttn.getW())) && (mouseEvent.getY() >= nextbttn.getY()) && (mouseEvent.getY() <= (nextbttn.getY() + nextbttn.getH()))) {
            System.out.println("NEXT");
            System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + nextbttn.getY());
            /*App.setCurrentPanel(App.);*/
        }


    }

    public void mousePressed(MouseEvent mouseEvent) {
        // Go to corresponding menu
        // IF STATEMENTS FOR NEW GAME BUTTON
        if ((mouseEvent.getX() >= mainmenu.getX()) && (mouseEvent.getX() <= (mainmenu.getX() + mainmenu.getW())) && (mouseEvent.getY() >= mainmenu.getY()) && (mouseEvent.getY() <= (mainmenu.getY() + mainmenu.getH()))) {
            System.out.println("I'm in the Main Menu button");
            System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + mainmenu.getY());
            App.setCurrentPanel(App.startMenu);
        }
        // IF STATEMENTS FOR LEVEL SELECT BUTTON
        if ((mouseEvent.getX() >= nextbttn.getX()) && (mouseEvent.getX() <= (nextbttn.getX() + nextbttn.getW())) && (mouseEvent.getY() >= nextbttn.getY()) && (mouseEvent.getY() <= (nextbttn.getY() + nextbttn.getH()))) {
            System.out.println("NEXT");
            System.out.println("Mouse y is:" + mouseEvent.getY() + " Button Y is:" + nextbttn.getY());
            /*    lsb.paint();*/
        }

    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }
}
