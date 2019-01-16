import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HowToPlayMenu extends AppPanel implements MouseListener {

    private Buttons mainmenu = new Buttons(437, 550, 125, 50);


    public HowToPlayMenu() {
        addMouseListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Font button = new Font("Monospaced", Font.BOLD, 14);
        Font title = new Font("Century Gothic", Font.BOLD, 32);
        Font txt = new Font("Monospaced", Font.BOLD, 25);
        g2d.setFont(button);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 2300, 2000);
        //Draw button
        g2d.setColor(Color.GREEN);
        mainmenu.paint(g2d);
        /*nextbttn.paint(g2d);*/
        g2d.drawString("Main Menu", mainmenu.buttonx + 27, mainmenu.buttony + 27);
        // FIRST BOX
        g2d.setFont(txt);
        g2d.drawString("Press W to move ⇧", 29, 159);
        g2d.drawString("Press A to move ⇦", 29, 219);
        g2d.drawString("Press S to move ⇩", 29, 279);
        g2d.drawString("Press D to move ⇨", 29, 339);
        g2d.drawString("Move mouse to Aim", 29, 399);
        g2d.drawString("Left-Click mouse to shoot", 29, 459);
        g2d.drawRect(9, 125, 500, 375);
        g2d.drawRect(509, 125, 465, 375);
        // SECOND BOX
        g2d.drawString("Shoot and destroy all enemy", 526, 159);
        g2d.drawString("forces. Avoid enemy bullets.", 526, 219);
        g2d.drawString("Beat the boss at the end of", 526,279);
        g2d.drawString("every level. Good luck and", 526, 339);
        g2d.drawString("stay safe Sergeant!", 600, 399);
        g2d.setFont(title);
        g2d.drawString("HOW TO PLAY", 390, 30);
    }

    public void tick() {
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        // IF STATEMENTS FOR MAIN MENU BUTTON
        if ((mouseEvent.getX() >= mainmenu.getX()) && (mouseEvent.getX() <= (mainmenu.getX() + mainmenu.getW())) && (mouseEvent.getY() >= mainmenu.getY()) && (mouseEvent.getY() <= (mainmenu.getY() + mainmenu.getH()))) {


        }


    }

    public void mousePressed(MouseEvent mouseEvent) {
        // Go to corresponding menu
        // IF STATEMENTS FOR main menu BUTTON
        if ((mouseEvent.getX() >= mainmenu.getX()) && (mouseEvent.getX() <= (mainmenu.getX() + mainmenu.getW())) && (mouseEvent.getY() >= mainmenu.getY()) && (mouseEvent.getY() <= (mainmenu.getY() + mainmenu.getH()))) {
            App.setCurrentPanel(App.startMenu);
        }

    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }
}
