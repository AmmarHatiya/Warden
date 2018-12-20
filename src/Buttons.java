import java.awt.*;

public class Buttons {
    public int buttonx;
    public int buttony;
    public int buttonw;
    public int buttonh;

    public Buttons(int buttonx, int buttony, int buttonw,int buttonh){
        this.buttonh= buttonh;
        this.buttonw=buttonw;
        this.buttonx=buttonx;
        this.buttony=buttony;

    }
    public int getX() {
        return buttonx;
    }

    public int getY() {
        return buttony;
    }

    public int getW() {
        return buttonw;
    }

    public int getH() {
        return buttonh;
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw Button
        g2d.setColor(Color.GREEN);
        g2d.drawRect(buttonx, buttony, buttonw, buttonh);
    }




}