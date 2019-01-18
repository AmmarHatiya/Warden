import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public abstract class Entity {
    public double x, y, vx, vy;
    public int width,height;
    public Consumer<Particle> addParticleToLevel = e -> {
        System.out.println("addParticleToLevel not set, ignoring");
    };
    public Consumer<Particle> removeParticleFromLevel = e -> {
        System.out.println("removeParticleFromLevel not set, ignoring");
    };
    public Consumer<Entity> removeSelf = e -> {
        System.out.println("removeSelf not set, ignoring");
    };
    public Consumer<Integer> addToScore = e -> {
        System.out.println("addToScore not set, ignoring");
    };
    public abstract void paint(Graphics2D g);
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void tick(int levelWidth, int levelHeight) {
        this.x += this.vx;
        this.y += this.vy;
    }
    public abstract void check(Entity e);
    public abstract void check(Particle p);
}
