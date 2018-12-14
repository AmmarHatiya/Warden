import java.awt.*;

//https://stackoverflow.com/questions/44138641/2d-bullet-game-in-java


public class Bullet
{
    int x,y, xM, yM;
    private static final double speed = 2;
    double dirX, dirY;

    public Bullet(int x, int y, int xM, int yM)
    {
        this.x=x;
        this.y=y;
        this.xM = xM;
        this.yM = yM;

        dirX = speed*Math.cos(getAngle());
        dirY = speed*Math.sin(getAngle());
    }

    public double getAngle()
    {
        double angle = (double) Math.toDegrees(Math.atan2(yM-y, xM - x));

        if(angle < 0){
            angle += 360;
        }
        return Math.toRadians(angle);
    }

    public void move()
    {
        x+=dirX;
        y+=dirY;
    }

    public void paint (Graphics2D g2d)
    {
        g2d.setColor(Color.yellow);
        g2d.fillRect(Math.round(this.x),Math.round(this.y),8,8);
    }
}