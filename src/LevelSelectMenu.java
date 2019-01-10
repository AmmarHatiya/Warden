import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// NOTE: BUTTON CLASSES FOR THIS MENU END WITH -lsm
public class LevelSelectMenu extends AppPanel implements MouseListener {
    private int grasstankx[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int grasstanky[] = {50+60, 50 + 82, 50 + 82, 50+60};
    private int mudtankx[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int mudtanky[] = {350+60, 350 + 82, 350 + 82, 350+60};
    private int icetankx[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int icetanky[] = {200+60, 200 + 82, 200 + 82, 200+60};
    private int citytankx[] = {30 + 25, 30 + 5, 30 + 60, 30 + 45};
    private int citytanky[] = {500+60, 500 + 82, 500 + 82, 500+60};
    private Buttons mudbttn= new Buttons(30,350,150,125);
    private Buttons icebttn= new Buttons(30,200,150,125);
    private Buttons grassbttn= new Buttons(30,50,150,125);
    private Buttons citybttn= new Buttons(30,500,150,125);

    public LevelSelectMenu() {
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
        g2d.setColor(Color.GREEN);
       mudbttn.paint(g2d);
        icebttn.paint(g2d);
        grassbttn.paint(g2d);
        citybttn.paint(g2d);
        //DRAW BACKGROUND OF GRASS BUTTON
        g2d.setColor(new Color(128, 203, 255));
        g2d.fillRect(grassbttn.buttonx,grassbttn.buttony,grassbttn.buttonw,grassbttn.buttonh);
        g2d.setColor(new Color(73, 197, 112));
        g2d.fillRect(grassbttn.buttonx,grassbttn.buttony+75,grassbttn.buttonw,grassbttn.buttonh-75);
        g2d.setColor(Color.GREEN);
        g2d.drawRect(grassbttn.buttonx-1,grassbttn.buttony-1,grassbttn.buttonw,grassbttn.buttonh);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillRect(grassbttn.buttonx+ 20, grassbttn.buttony + 55, grassbttn.buttonw - 100, grassbttn.buttonh - 120);
        g2d.fillRect(grassbttn.buttonx + 20, grassbttn.buttony + 50, grassbttn.buttonw - 120, grassbttn.buttonh- 110);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(grassbttn.buttonx+8,grassbttn.buttony+75,50,15);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillPolygon(grasstankx, grasstanky, 4);
        //DRAW BACKGROUND OF MUD BUTTON
        g2d.setColor(new Color(128, 203, 255));
        g2d.fillRect(mudbttn.buttonx,mudbttn.buttony,mudbttn.buttonw,mudbttn.buttonh);
        g2d.setColor(new Color(197, 119, 51));
        g2d.fillRect(mudbttn.buttonx,mudbttn.buttony+75,mudbttn.buttonw,mudbttn.buttonh-75);
        g2d.setColor(Color.GREEN);
        g2d.drawRect(mudbttn.buttonx-1,mudbttn.buttony-1,mudbttn.buttonw,mudbttn.buttonh);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillRect(mudbttn.buttonx + 20, mudbttn.buttony + 55, mudbttn.buttonw - 100, mudbttn.buttonh - 120);
        g2d.fillRect(mudbttn.buttonx + 20, mudbttn.buttony + 50, mudbttn.buttonw - 120, mudbttn.buttonh - 110);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(mudbttn.buttonx+8,mudbttn.buttony+75,50,15);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillPolygon(mudtankx, mudtanky, 4);
//DRAW ICE BUTTON
        g2d.setColor(new Color(128, 203, 255));
        g2d.fillRect(icebttn.buttonx, icebttn.buttony, icebttn.buttonw, icebttn.buttonh);
        g2d.setColor(new Color(255, 255, 255, 254));
        g2d.fillRect(icebttn.buttonx, icebttn.buttony + 75, icebttn.buttonw, icebttn.buttonh - 75);
        g2d.setColor(Color.GREEN);
        g2d.drawRect(icebttn.buttonx - 1, icebttn.buttony - 1, icebttn.buttonw, icebttn.buttonh);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillRect(icebttn.buttonx + 20, icebttn.buttony + 55, icebttn.buttonw - 100, icebttn.buttonh - 120);
        g2d.fillRect(icebttn.buttonx + 20, icebttn.buttony + 50, icebttn.buttonw - 120, icebttn.buttonh - 110);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(icebttn.buttonx+8,icebttn.buttony+75,50,15);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillPolygon(icetankx, icetanky, 4);
        //DRAW CITY BUTTON
        g2d.setColor(new Color(128, 203, 255));
        g2d.fillRect(citybttn.buttonx,citybttn.buttony,citybttn.buttonw,citybttn.buttonh);
        //DRAW BUILDINGS
        g2d.setColor(new Color(152, 176, 195, 251));
        g2d.fillRect(citybttn.buttonx+1,citybttn.buttony+25,citybttn.buttonw-130,citybttn.buttonh-50);
        g2d.fillRect(citybttn.buttonx+25,citybttn.buttony+15,citybttn.buttonw-105,citybttn.buttonh-50);
        g2d.fillRect(citybttn.buttonx+80,citybttn.buttony+10,citybttn.buttonw-120,citybttn.buttonh-50);
        g2d.fillRect(citybttn.buttonx+115,citybttn.buttony+20,citybttn.buttonw-115,citybttn.buttonh-50);
        //WINDOWS
       /* g2d.setColor(new Color(0, 0, 0, 251));
        // building 1 lines
        g2d.drawLine(citybttn.buttonx+1,citybttn.buttony+35,citybttn.buttonw-100,citybttn.buttony+35);
        g2d.drawLine(citybttn.buttonx+1,citybttn.buttony+45,citybttn.buttonw-100,citybttn.buttony+45);
        g2d.drawLine(citybttn.buttonx+1,citybttn.buttony+55,citybttn.buttonw-100,citybttn.buttony+55);
        g2d.drawLine(citybttn.buttonx+1,citybttn.buttony+65,citybttn.buttonw-100,citybttn.buttony+65);

        g2d.setColor(new Color(0, 0, 0, 251));
        g2d.drawLine(citybttn.buttonx+5,citybttn.buttony+74,citybttn.buttonx+5,citybttn.buttony+25);
        g2d.drawLine(citybttn.buttonx+15,citybttn.buttony+74,citybttn.buttonx+15,citybttn.buttony+25);
        // building 2 lines
        g2d.setColor(new Color(0, 0, 0, 251));
        g2d.drawLine(citybttn.buttonx+25,citybttn.buttony+35,citybttn.buttonw-51,citybttn.buttony+35);
        g2d.drawLine(citybttn.buttonx+25,citybttn.buttony+45,citybttn.buttonw-51,citybttn.buttony+45);
        g2d.drawLine(citybttn.buttonx+25,citybttn.buttony+55,citybttn.buttonw-52,citybttn.buttony+55);
        g2d.drawLine(citybttn.buttonx+25,citybttn.buttony+65,citybttn.buttonw-51,citybttn.buttony+65);
        g2d.drawLine(citybttn.buttonx+25,citybttn.buttony+25,citybttn.buttonw-51,citybttn.buttony+25);


       *//* g2d.drawLine(citybttn.buttonx+30,citybttn.buttony+74,citybttn.buttonx+30,citybttn.buttony+15);
        g2d.drawLine(citybttn.buttonx+45,citybttn.buttony+74,citybttn.buttonx+45,citybttn.buttony+15);
        g2d.drawLine(citybttn.buttonx+55,citybttn.buttony+74,citybttn.buttonx+55,citybttn.buttony+15);
        g2d.drawLine(citybttn.buttonx+65,citybttn.buttony+74,citybttn.buttonx+65,citybttn.buttony+15);*//*
        // building 3 lines
        g2d.drawLine(citybttn.buttonx+80,citybttn.buttony+35,citybttn.buttonw-11,citybttn.buttony+35);
        g2d.drawLine(citybttn.buttonx+80,citybttn.buttony+25,citybttn.buttonw-11,citybttn.buttony+25);
        g2d.drawLine(citybttn.buttonx+80,citybttn.buttony+45,citybttn.buttonw-11,citybttn.buttony+45);
        g2d.drawLine(citybttn.buttonx+80,citybttn.buttony+55,citybttn.buttonw-11,citybttn.buttony+55);
        g2d.drawLine(citybttn.buttonx+80,citybttn.buttony+65,citybttn.buttonw-11,citybttn.buttony+65);
        g2d.drawLine(citybttn.buttonx+80,citybttn.buttony+15,citybttn.buttonw-11,citybttn.buttony+15);
        // building 4 lines
        g2d.drawLine(citybttn.buttonx+115,citybttn.buttony+25,citybttn.buttonw+30,citybttn.buttony+25);
        g2d.drawLine(citybttn.buttonx+115,citybttn.buttony+35,citybttn.buttonw+30,citybttn.buttony+35);
        g2d.drawLine(citybttn.buttonx+115,citybttn.buttony+45,citybttn.buttonw+30,citybttn.buttony+45);
        g2d.drawLine(citybttn.buttonx+115,citybttn.buttony+55,citybttn.buttonw+30,citybttn.buttony+55);
        g2d.drawLine(citybttn.buttonx+115,citybttn.buttony+65,citybttn.buttonw+30,citybttn.buttony+65);*/
        //ROAD
        g2d.setColor(new Color(130, 130, 130, 251));
        g2d.fillRect(citybttn.buttonx,citybttn.buttony+75,citybttn.buttonw,citybttn.buttonh-75);
        g2d.setColor(Color.GREEN);
        g2d.drawRect(citybttn.buttonx-1,citybttn.buttony-1,citybttn.buttonw,citybttn.buttonh+1);
        //  ROAD LINES
        g2d.setColor(new Color(249, 234, 90, 251));
        g2d.drawLine(citybttn.buttonx+1,citybttn.buttony+95,citybttn.buttonx+30,citybttn.buttony+95);
        g2d.drawLine(citybttn.buttonx+55,citybttn.buttony+95,citybttn.buttonx+86,citybttn.buttony+95);
        g2d.drawLine(citybttn.buttonx+109,citybttn.buttony+95,citybttn.buttonx+140,citybttn.buttony+95);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillRect(citybttn.buttonx + 20, citybttn.buttony + 55, citybttn.buttonw - 100, citybttn.buttonh - 120);
        g2d.fillRect(citybttn.buttonx + 20, citybttn.buttony + 50, citybttn.buttonw - 120, citybttn.buttonh - 110);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(citybttn.buttonx+8,citybttn.buttony+75,50,15);
        g2d.setColor(new Color(50, 89, 47, 254));
        g2d.fillPolygon(citytankx, citytanky, 4);
    }

    public void tick() {

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        // IF STATEMENTS FOR Grass BUTTON
        if ((mouseEvent.getX() >= grassbttn.getX()) && (mouseEvent.getX()<=(grassbttn.getX()+grassbttn.getW())) && (mouseEvent.getY()>= grassbttn.getY())&& (mouseEvent.getY()<=(grassbttn.getY()+grassbttn.getH()))){
            System.out.println("I'm in the Grass button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+grassbttn.getY());
            App.setCurrentPanel(App.level1);
        }

        // IF STATEMENTS FOR mud BUTTON
        if ((mouseEvent.getX() >= mudbttn.getX()) && (mouseEvent.getX()<=(mudbttn.getX()+mudbttn.getW())) && (mouseEvent.getY()>= mudbttn.getY())&& (mouseEvent.getY()<=(mudbttn.getY()+mudbttn.getH()))){
            System.out.println("I'm in the Mud button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+mudbttn.getY());
        }

        // IF STATEMENTS FOR ice GAME BUTTON
        if ((mouseEvent.getX() >= icebttn.getX()) && (mouseEvent.getX()<=(icebttn.getX()+icebttn.getW())) && (mouseEvent.getY()>= icebttn.getY())&& (mouseEvent.getY()<=(icebttn.getY()+icebttn.getH()))){
            System.out.println("I'm in the Ice button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+icebttn.getY());
        }
        // IF STATEMENTS FOR city BUTTON
        if ((mouseEvent.getX() >= citybttn.getX()) && (mouseEvent.getX()<=(citybttn.getX()+citybttn.getW())) && (mouseEvent.getY()>= citybttn.getY())&& (mouseEvent.getY()<=(citybttn.getY()+citybttn.getH()))){
            System.out.println("I'm in the City button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+citybttn.getY());
        }
    }

    public void mousePressed(MouseEvent mouseEvent) {
        // Go to corresponding menu
        // IF STATEMENTS FOR Grass BUTTON
        if ((mouseEvent.getX() >= grassbttn.getX()) && (mouseEvent.getX()<=(grassbttn.getX()+grassbttn.getW())) && (mouseEvent.getY()>= grassbttn.getY())&& (mouseEvent.getY()<=(grassbttn.getY()+grassbttn.getH()))){
            System.out.println("I'm in the Grass button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+grassbttn.getY());
        }

        // IF STATEMENTS FOR mud BUTTON
        if ((mouseEvent.getX() >= mudbttn.getX()) && (mouseEvent.getX()<=(mudbttn.getX()+mudbttn.getW())) && (mouseEvent.getY()>= mudbttn.getY())&& (mouseEvent.getY()<=(mudbttn.getY()+mudbttn.getH()))){
            System.out.println("I'm in the Mud button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+mudbttn.getY());
        }

        // IF STATEMENTS FOR ice GAME BUTTON
        if ((mouseEvent.getX() >= icebttn.getX()) && (mouseEvent.getX()<=(icebttn.getX()+icebttn.getW())) && (mouseEvent.getY()>= icebttn.getY())&& (mouseEvent.getY()<=(icebttn.getY()+icebttn.getH()))){
            System.out.println("I'm in the Ice button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+icebttn.getY());
        }
        // IF STATEMENTS FOR city BUTTON
        if ((mouseEvent.getX() >= citybttn.getX()) && (mouseEvent.getX()<=(citybttn.getX()+citybttn.getW())) && (mouseEvent.getY()>= citybttn.getY())&& (mouseEvent.getY()<=(citybttn.getY()+citybttn.getH()))){
            System.out.println("I'm in the City button");
            System.out.println("Mouse y is:"+mouseEvent.getY()+" Button Y is:"+citybttn.getY());
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