import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// NOTE: BUTTON CLASSES FOR THIS MENU END WITH -lsm
public class Levelselectmenu extends JPanel {
private Grassbttnlsm gb = new Grassbttnlsm();
    private Mudbttnlsm mb = new Mudbttnlsm();
    private Icebttnlsm ib = new Icebttnlsm();
    private Citybttnlsm cb = new Citybttnlsm();
    public Levelselectmenu() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                // IF STATEMENTS FOR Grass BUTTON
                if ((mouseEvent.getX() >= gb.getX()) && (mouseEvent.getX()<=(gb.getX()+gb.getW())) && (mouseEvent.getY()>= gb.getY())&& (mouseEvent.getY()<=(gb.getY()+gb.getH()))){
                    System.out.println("I'm in the Grass button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+gb.getY());
                }



                // IF STATEMENTS FOR mud BUTTON
                if ((mouseEvent.getX() >= mb.getX()) && (mouseEvent.getX()<=(mb.getX()+mb.getW())) && (mouseEvent.getY()>= mb.getY())&& (mouseEvent.getY()<=(mb.getY()+mb.getH()))){
                    System.out.println("I'm in the Mud button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+mb.getY());
                }



                // IF STATEMENTS FOR ice GAME BUTTON
                if ((mouseEvent.getX() >= ib.getX()) && (mouseEvent.getX()<=(ib.getX()+ib.getW())) && (mouseEvent.getY()>= ib.getY())&& (mouseEvent.getY()<=(ib.getY()+ib.getH()))){
                    System.out.println("I'm in the Ice button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ib.getY());
                }
                // IF STATEMENTS FOR city BUTTON
                if ((mouseEvent.getX() >= cb.getX()) && (mouseEvent.getX()<=(cb.getX()+cb.getW())) && (mouseEvent.getY()>= cb.getY())&& (mouseEvent.getY()<=(cb.getY()+cb.getH()))){
                    System.out.println("I'm in the City button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+cb.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                // Go to corresponding menu
                // IF STATEMENTS FOR Grass BUTTON
                if ((mouseEvent.getX() >= gb.getX()) && (mouseEvent.getX()<=(gb.getX()+gb.getW())) && (mouseEvent.getY()>= gb.getY())&& (mouseEvent.getY()<=(gb.getY()+gb.getH()))){
                    System.out.println("I'm in the Grass button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+gb.getY());
                }



                // IF STATEMENTS FOR mud BUTTON
                if ((mouseEvent.getX() >= mb.getX()) && (mouseEvent.getX()<=(mb.getX()+mb.getW())) && (mouseEvent.getY()>= mb.getY())&& (mouseEvent.getY()<=(mb.getY()+mb.getH()))){
                    System.out.println("I'm in the Mud button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+mb.getY());
                }



                // IF STATEMENTS FOR ice GAME BUTTON
                if ((mouseEvent.getX() >= ib.getX()) && (mouseEvent.getX()<=(ib.getX()+ib.getW())) && (mouseEvent.getY()>= ib.getY())&& (mouseEvent.getY()<=(ib.getY()+ib.getH()))){
                    System.out.println("I'm in the Ice button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+ib.getY());
                }
                // IF STATEMENTS FOR city BUTTON
                if ((mouseEvent.getX() >= cb.getX()) && (mouseEvent.getX()<=(cb.getX()+cb.getW())) && (mouseEvent.getY()>= cb.getY())&& (mouseEvent.getY()<=(cb.getY()+cb.getH()))){
                    System.out.println("I'm in the City button");
                    System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+cb.getY());
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
        gb.paint(g2d);
        mb.paint(g2d);
        ib.paint(g2d);
        cb.paint(g2d);
    }


    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("Den of Tanks");
        Levelselectmenu p = new Levelselectmenu();

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