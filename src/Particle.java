import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;

public abstract class Particle {
    public Consumer<Particle> removeSelf = e -> {
        System.out.println("removeSelf not set, ignoring");
    };
    public double x, y, speed = 1, vx, vy;
    public boolean isPlayer = false;
    public abstract void paint(Graphics2D g);

    public void tick(int levelWidth, int levelHeight) {
        this.x += this.vx*speed;
        this.y += this.vy*speed;
    }
}
