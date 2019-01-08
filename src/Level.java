import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


public abstract class Level extends AppPanel implements MouseListener, KeyListener {
    private StartMenu startmenu = new StartMenu();
    List<Entity> entities = Collections.synchronizedList(new LinkedList<>());
    List<Particle> particles = Collections.synchronizedList(new LinkedList<>());
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    public static class Level1 extends Level {
        public Level1() {
            super(Arrays.asList(new Entity[] {
                    new Enemy(1, 500, 500)
            }), Arrays.asList(new Particle[] {

            }));
        }
    }

    public Level(List<Entity> entitiesToAdd, List<Particle> particlesToAdd) {
        entities.add(new PlayerTank(100, 100));
        entities.addAll(entitiesToAdd);
        particles.addAll(particlesToAdd);
        for (Entity e : entities)
            e.addParticleToLevel = particle -> {
                particle.removeSelf = p -> this.particles.remove(p);
                particles.add(particle);
            };
        for (Entity e : entities) {
            e.removeSelf = entity -> this.entities.remove(entity);
            e.removeParticleFromLevel = particle -> this.particles.remove(particle);
        }
        for (Particle p : particles) p.removeSelf = particle -> this.particles.remove(particle);
        setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
    }


    public void tick() {
        // copy the list so it doesn't crash if the list is modified
        for (Particle p : new ArrayList<>(particles)) p.tick(WIDTH, HEIGHT);
        for (Entity e : new ArrayList<>(entities)) e.tick(WIDTH, HEIGHT);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Entity e : new ArrayList<>(entities)) e.paint(g2d);
        for (Particle p : new ArrayList<>(particles)) p.paint(g2d);
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Den of Tanks");
        Level jp = new Level1();
        frame.setContentPane(jp);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            jp.tick(); //Updates the coordinates
            jp.repaint(); //Calls the paint method
            Thread.sleep(1000 / 30); //Pauses for a moment
            //Thread.sleep(1000); //Pauses for a moment
        }
    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {
        for (Entity e: entities) e.mousePressed(mouseEvent);
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        for (Entity e: entities) e.mousePressed(mouseEvent);
    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        for (Entity e: entities) e.keyPressed(keyEvent);
    }

    public void keyReleased(KeyEvent keyEvent) {
        for (Entity e: entities) e.keyReleased(keyEvent);
    }
}

