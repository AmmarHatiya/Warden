import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RetryScreen extends AppPanel implements MouseListener {

        private Buttons mainmenu = new Buttons(30,175,125,50);
        private Buttons retrybttn = new Buttons(30,375,125,50);

        public RetryScreen() {
            addMouseListener(this);
            setFocusable(true);
        }

        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draw Background
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, 2300, 2000);
            //Draw button
            g2d.setColor(Color.GREEN);
            mainmenu.paint(g2d);
            retrybttn.paint(g2d);
        }

        public void tick() {
        }

        public void mouseClicked(MouseEvent mouseEvent) {
            // IF STATEMENTS FOR NEW GAME BUTTON
            if ((mouseEvent.getX() >= mainmenu.getX()) && (mouseEvent.getX()<=(mainmenu.getX()+ mainmenu.getW())) && (mouseEvent.getY()>= mainmenu.getY())&& (mouseEvent.getY()<=(mainmenu.getY()+ mainmenu.getH()))){
                System.out.println("I'm in the Main Menu button");
                System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ mainmenu.getY());
                App.setCurrentPanel(App.startMenu);
            }
            // IF STATEMENTS FOR retry BUTTON
            if ((mouseEvent.getX() >= retrybttn.getX()) && (mouseEvent.getX()<=(retrybttn.getX()+ retrybttn.getW())) && (mouseEvent.getY()>= retrybttn.getY())&& (mouseEvent.getY()<=(retrybttn.getY()+ retrybttn.getH()))){
                System.out.println("I'm in the Retry button");
                System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ retrybttn.getY());
                /*App.setCurrentPanel(App.);*/
            }


        }

        public void mousePressed(MouseEvent mouseEvent) {
            // Go to corresponding menu
            // IF STATEMENTS FOR NEW GAME BUTTON
            if ((mouseEvent.getX() >= mainmenu.getX()) && (mouseEvent.getX()<=(mainmenu.getX()+ mainmenu.getW())) && (mouseEvent.getY()>= mainmenu.getY())&& (mouseEvent.getY()<=(mainmenu.getY()+ mainmenu.getH()))){
                System.out.println("I'm in the New Game button");
                System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ mainmenu.getY());
            }
            // IF STATEMENTS FOR LEVEL SELECT BUTTON
            if ((mouseEvent.getX() >= retrybttn.getX()) && (mouseEvent.getX()<=(retrybttn.getX()+ retrybttn.getW())) && (mouseEvent.getY()>= retrybttn.getY())&& (mouseEvent.getY()<=(retrybttn.getY()+ retrybttn.getH()))){
                System.out.println("I'm in the Level Select button");
                System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ retrybttn.getY());
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
