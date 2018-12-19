import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Startmenu extends JPanel {
    private Tank tank = new Tank(100, 100);
private Newgamebttn ngb = new Newgamebttn();
private Continuegamebttn cgb= new Continuegamebttn();
private Upgradesbttn ub= new Upgradesbttn();
private Levelselectbttn lsb = new Levelselectbttn();
    public Startmenu() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                // IF STATEMENTS FOR NEW GAME BUTTON
                if ((mouseEvent.getX() >= ngb.getX()) && (mouseEvent.getX()<=(ngb.getX()+ngb.getW())) && (mouseEvent.getY()>= ngb.getY())&& (mouseEvent.getY()<=(ngb.getY()+ngb.getH()))){
                    System.out.println("I'm in the New Game button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ngb.getY());
                }



                // IF STATEMENTS FOR CONTINUE GAME BUTTON
                if ((mouseEvent.getX() >= cgb.getX()) && (mouseEvent.getX()<=(cgb.getX()+cgb.getW())) && (mouseEvent.getY()>= cgb.getY())&& (mouseEvent.getY()<=(cgb.getY()+cgb.getH()))){
                    System.out.println("I'm in the Continue Game button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+cgb.getY());
                }



                // IF STATEMENTS FOR UPGRADES GAME BUTTON
                if ((mouseEvent.getX() >= ub.getX()) && (mouseEvent.getX()<=(ub.getX()+ub.getW())) && (mouseEvent.getY()>= ub.getY())&& (mouseEvent.getY()<=(ub.getY()+ub.getH()))){
                    System.out.println("I'm in the Upgrades button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ub.getY());
                }
                // IF STATEMENTS FOR LEVEL SELECT BUTTON
                if ((mouseEvent.getX() >= lsb.getX()) && (mouseEvent.getX()<=(lsb.getX()+lsb.getW())) && (mouseEvent.getY()>= lsb.getY())&& (mouseEvent.getY()<=(lsb.getY()+lsb.getH()))){
                    System.out.println("I'm in the Level Select button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+lsb.getY());

                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                // Go to corresponding menu
                // IF STATEMENTS FOR NEW GAME BUTTON
                if ((mouseEvent.getX() >= ngb.getX()) && (mouseEvent.getX()<=(ngb.getX()+ngb.getW())) && (mouseEvent.getY()>= ngb.getY())&& (mouseEvent.getY()<=(ngb.getY()+ngb.getH()))){
                    System.out.println("I'm in the New Game button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ngb.getY());
                }



                // IF STATEMENTS FOR CONTINUE GAME BUTTON
                if ((mouseEvent.getX() >= cgb.getX()) && (mouseEvent.getX()<=(cgb.getX()+cgb.getW())) && (mouseEvent.getY()>= cgb.getY())&& (mouseEvent.getY()<=(cgb.getY()+cgb.getH()))){
                    System.out.println("I'm in the Continue Game button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+cgb.getY());
                }



                // IF STATEMENTS FOR UPGRADES GAME BUTTON
                if ((mouseEvent.getX() >= ub.getX()) && (mouseEvent.getX()<=(ub.getX()+ub.getW())) && (mouseEvent.getY()>= ub.getY())&& (mouseEvent.getY()<=(ub.getY()+ub.getH()))){
                    System.out.println("I'm in the Upgrades button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ub.getY());
                }
// IF STATEMENTS FOR LEVEL SELECT BUTTON
                if ((mouseEvent.getX() >= lsb.getX()) && (mouseEvent.getX()<=(lsb.getX()+lsb.getW())) && (mouseEvent.getY()>= lsb.getY())&& (mouseEvent.getY()<=(lsb.getY()+lsb.getH()))){
                    System.out.println("I'm in the Level Select button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+lsb.getY());
                }



            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                // Go to corresponding menu
                /*if (mouseY == ){

                }*/
                /*if (mouseX == ){

                }*/

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
        ngb.paint(g2d);
        cgb.paint(g2d);
        ub.paint(g2d);
lsb.paint(g2d);
    }


    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("CityScape");
        Startmenu p = new Startmenu();

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