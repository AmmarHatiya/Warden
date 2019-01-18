import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Pause extends AppPanel implements MouseListener {

    private Buttons mainmenu = new Buttons(250,350,125,50);
    private Buttons resumeBttn = new Buttons(600,350,125,50);
    public AppPanel resumeView = App.startMenu;

    public Pause() {
        addMouseListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Font button = new Font("Monospaced", Font.BOLD, 14);
        Font word = new Font("Monospaced", Font.BOLD, 35);
        g.setFont(button);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 2300, 2000);
        //Draw button
        g2d.setColor(Color.GREEN);
        mainmenu.paint(g2d);
        resumeBttn.paint(g2d);
        g2d.drawString("Resume", resumeBttn.buttonx+23, resumeBttn.buttony+27);
        g2d.drawString("Main Menu", mainmenu.buttonx+25, mainmenu.buttony+27);
        g.setFont(word);
        g2d.drawString("Game Paused", 400, 250);
    }

    public void tick() {
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        // Go to corresponding menu

        // IF STATEMENTS FOR NEW GAME BUTTON
        if ((mouseEvent.getX() >= mainmenu.getX()) && (mouseEvent.getX()<=(mainmenu.getX()+ mainmenu.getW())) && (mouseEvent.getY()>= mainmenu.getY())&& (mouseEvent.getY()<=(mainmenu.getY()+ mainmenu.getH()))){
            //App.resumeView.reset();
            App.setCurrentPanel(App.startMenu);
        }
        // IF STATEMENTS FOR Retry BUTTON
        if ((mouseEvent.getX() >= resumeBttn.getX()) && (mouseEvent.getX()<=(resumeBttn.getX()+ resumeBttn.getW())) && (mouseEvent.getY()>= resumeBttn.getY())&& (mouseEvent.getY()<=(resumeBttn.getY()+ resumeBttn.getH()))){
            if (this.resumeView != null) App.setCurrentPanel(this.resumeView);
        }
    }

    public void mousePressed(MouseEvent mouseEvent) {
        // Go to corresponding menu

        // IF STATEMENTS FOR NEW GAME BUTTON
        if ((mouseEvent.getX() >= mainmenu.getX()) && (mouseEvent.getX()<=(mainmenu.getX()+ mainmenu.getW())) && (mouseEvent.getY()>= mainmenu.getY())&& (mouseEvent.getY()<=(mainmenu.getY()+ mainmenu.getH()))){
            App.setCurrentPanel(App.startMenu);
        }
        // IF STATEMENTS FOR Retry BUTTON
        if ((mouseEvent.getX() >= resumeBttn.getX()) && (mouseEvent.getX()<=(resumeBttn.getX()+ resumeBttn.getW())) && (mouseEvent.getY()>= resumeBttn.getY())&& (mouseEvent.getY()<=(resumeBttn.getY()+ resumeBttn.getH()))){
            if (this.resumeView != null) App.setCurrentPanel(this.resumeView);
        }

    }
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }
}
