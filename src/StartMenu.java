import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class StartMenu extends AppPanel implements MouseListener {
    private final static Image tankimage;

    static {
        try {
            tankimage = ImageIO.read(Upgradesmenu.class.getResourceAsStream("tankimage.bmp"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
private Buttons ngamebttn = new Buttons(30,250,175,50);
    private Buttons lselectbttn = new Buttons(30,450,175,50);
    private Buttons upgradesbttn = new Buttons(30,550,175,50);
    private Buttons continuegamebttn = new Buttons(30,350,175,50);
    private Buttons howtoplaybttn = new Buttons(30,150,175,50);
    public StartMenu() {
        addMouseListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Monospaced", Font.BOLD, 18);
        g2d.setFont(font);
        Font title = new Font("Monospaced", Font.BOLD+Font.ITALIC, 55);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw Background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 2300, 2000);
        /*ngb.paint(g2d);
        cgb.paint(g2d);
        ub.paint(g2d);
lsb.paint(g2d);*/
        //Draw button
        g2d.setColor(Color.GREEN);
        ngamebttn.paint(g2d);
        upgradesbttn.paint(g2d);
        continuegamebttn.paint(g2d);
        lselectbttn.paint(g2d);
        howtoplaybttn.paint(g2d);
        g2d.drawString("How To Play", howtoplaybttn.buttonx+27, howtoplaybttn.buttony+27);
        g2d.drawString("New Game", ngamebttn.buttonx+45, ngamebttn.buttony+27);
        g2d.drawString("Continue Game", continuegamebttn.buttonx+15, continuegamebttn.buttony+27);
        g2d.drawString("Level Select", lselectbttn.buttonx+25, lselectbttn.buttony+27);
        g2d.drawString("Upgrades", upgradesbttn.buttonx+40, upgradesbttn.buttony+27);
        g2d.setFont(title);
        g2d.setColor(Color.GRAY);
        g2d.drawString("DEN OF TANKS",400+2,100+1);
        g2d.setColor(Color.GREEN);
        g2d.drawString("DEN OF TANKS",400,100);


        g2d.drawImage(tankimage, 400, 250, this);
    }

    public void tick() {
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        // Go to corresponding menu
        // IF STATEMENTS FOR NEW GAME BUTTON
        if ((mouseEvent.getX() >= ngamebttn.getX()) && (mouseEvent.getX()<=(ngamebttn.getX()+ngamebttn.getW())) && (mouseEvent.getY()>= ngamebttn.getY())&& (mouseEvent.getY()<=(ngamebttn.getY()+ngamebttn.getH()))){
            App.setCurrentPanel(App.level1);
        }

        // IF STATEMENTS FOR CONTINUE GAME BUTTON
        if ((mouseEvent.getX() >= continuegamebttn.getX()) && (mouseEvent.getX()<=(continuegamebttn.getX()+continuegamebttn.getW())) && (mouseEvent.getY()>= continuegamebttn.getY())&& (mouseEvent.getY()<=(continuegamebttn.getY()+continuegamebttn.getH()))){
        }

        // IF STATEMENTS FOR UPGRADES GAME BUTTON
        if ((mouseEvent.getX() >= upgradesbttn.getX()) && (mouseEvent.getX()<=(upgradesbttn.getX()+upgradesbttn.getW())) && (mouseEvent.getY()>= upgradesbttn.getY())&& (mouseEvent.getY()<=(upgradesbttn.getY()+upgradesbttn.getH()))){
            App.setCurrentPanel(App.upgradesmenu);
        }

        // IF STATEMENTS FOR LEVEL SELECT BUTTON
        if ((mouseEvent.getX() >= lselectbttn.getX()) && (mouseEvent.getX()<=(lselectbttn.getX()+lselectbttn.getW())) && (mouseEvent.getY()>= lselectbttn.getY())&& (mouseEvent.getY()<=(lselectbttn.getY()+lselectbttn.getH()))){
            App.setCurrentPanel(App.levelSelectMenu);
        }
        // IF STATEMENTS FOR HOWTOPLAY BUTTON
        if ((mouseEvent.getX() >= howtoplaybttn.getX()) && (mouseEvent.getX()<=(howtoplaybttn.getX()+howtoplaybttn.getW())) && (mouseEvent.getY()>= howtoplaybttn.getY())&& (mouseEvent.getY()<=(howtoplaybttn.getY()+howtoplaybttn.getH()))){
            App.setCurrentPanel(App.howtoplayScreen);
        }
    }

    public void mousePressed(MouseEvent mouseEvent) {
        // Go to corresponding menu
        // IF STATEMENTS FOR NEW GAME BUTTON
        if ((mouseEvent.getX() >= ngamebttn.getX()) && (mouseEvent.getX()<=(ngamebttn.getX()+ngamebttn.getW())) && (mouseEvent.getY()>= ngamebttn.getY())&& (mouseEvent.getY()<=(ngamebttn.getY()+ngamebttn.getH()))){
            App.setCurrentPanel(App.level1);
        }

        // IF STATEMENTS FOR CONTINUE GAME BUTTON
        if ((mouseEvent.getX() >= continuegamebttn.getX()) && (mouseEvent.getX()<=(continuegamebttn.getX()+continuegamebttn.getW())) && (mouseEvent.getY()>= continuegamebttn.getY())&& (mouseEvent.getY()<=(continuegamebttn.getY()+continuegamebttn.getH()))){
        }

        // IF STATEMENTS FOR UPGRADES GAME BUTTON
        if ((mouseEvent.getX() >= upgradesbttn.getX()) && (mouseEvent.getX()<=(upgradesbttn.getX()+upgradesbttn.getW())) && (mouseEvent.getY()>= upgradesbttn.getY())&& (mouseEvent.getY()<=(upgradesbttn.getY()+upgradesbttn.getH()))){
            App.setCurrentPanel(App.upgradesmenu);
        }

        // IF STATEMENTS FOR LEVEL SELECT BUTTON
        if ((mouseEvent.getX() >= lselectbttn.getX()) && (mouseEvent.getX()<=(lselectbttn.getX()+lselectbttn.getW())) && (mouseEvent.getY()>= lselectbttn.getY())&& (mouseEvent.getY()<=(lselectbttn.getY()+lselectbttn.getH()))){
            App.setCurrentPanel(App.levelSelectMenu);
        }
        // IF STATEMENTS FOR HOWTOPLAY BUTTON
        if ((mouseEvent.getX() >= howtoplaybttn.getX()) && (mouseEvent.getX()<=(howtoplaybttn.getX()+howtoplaybttn.getW())) && (mouseEvent.getY()>= howtoplaybttn.getY())&& (mouseEvent.getY()<=(howtoplaybttn.getY()+howtoplaybttn.getH()))){
            App.setCurrentPanel(App.howtoplayScreen);
        }
    }
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }
}