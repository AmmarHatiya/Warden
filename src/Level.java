import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public abstract class Level extends AppPanel implements MouseListener, KeyListener, MouseMotionListener {
    private StartMenu startmenu = new StartMenu();
    List<Entity> entities = Collections.synchronizedList(new CopyOnWriteArrayList<>());
    List<Particle> particles = Collections.synchronizedList(new CopyOnWriteArrayList<>());
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    private static final int TANK = 1;
    private static final int TRUCK = 2;
    private static final int PLANE = 3;
    private static final int TURRET = 4;
    private static final int TOWER = 5;

    public static class Level1 extends Level {
        public Level1() {
            super(Arrays.asList(new Entity[] {
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
            }), Arrays.asList(new Particle[] {

            }));
        }
    }

    public Level(List<Entity> entitiesToAdd, List<Particle> particlesToAdd) {
        entities.add(new PlayerTank(600, 600));
        entities.addAll(entitiesToAdd);
        particles.addAll(particlesToAdd);
        for (Entity e : entities)
            e.addParticleToLevel = particle -> {
                particle.removeSelf = this.particles::remove;
                particles.add(particle);
            };
        for (Entity e : entities) {
            e.removeSelf = this.entities::remove;
            e.removeParticleFromLevel = this.particles::remove;
        }
        for (Particle p : particles) p.removeSelf = this.particles::remove;
        setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    public void tick() {
        // copy the list so it doesn't crash if the list is modified
        for (Entity a: entities) for (Entity b: entities) a.check(b);
        for (Entity a: entities) for (Particle b: particles) a.check(b);
        for (Particle p : particles) p.tick(WIDTH, HEIGHT);
        for (Entity e : entities) e.tick(WIDTH, HEIGHT);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Entity e : entities) e.paint(g2d);
        for (Particle p : particles) p.paint(g2d);
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
            Thread.sleep(1000 / 60); //Pauses for a moment
            //Thread.sleep(1000); //Pauses for a moment
        }
    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {
        for (Entity e: entities) e.mousePressed(mouseEvent);
    }

    public void mouseReleased(MouseEvent mouseEvent) {

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

    public void mouseDragged(MouseEvent mouseEvent) {
        for (Entity e: entities) e.mouseDragged(mouseEvent);
    }

    public void mouseMoved(MouseEvent mouseEvent) {

    }
}

