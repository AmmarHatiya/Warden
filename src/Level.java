import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public abstract class Level extends AppPanel implements MouseListener, KeyListener, MouseMotionListener {

    List<Entity> entities = Collections.synchronizedList(new CopyOnWriteArrayList<>());
    List<Particle> particles = Collections.synchronizedList(new CopyOnWriteArrayList<>());
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    private static final int TANK = 1;
    private static final int TRUCK = 2;
    private static final int PLANE = 3;
    private static final int TURRET = 4;
    private static final int TOWER = 5;

    private static final int BOSSTURRET = 1;
    private static final int BOSSSHIP = 2;
    private static final int BOSSTANK = 3;
    private static final int BOSSCOPTER = 4;

    public int level;

    public static int points = 1100; //TODO: reduce before handing in
    private int currentWave = -1;

    private List<List<Entity>> waves = new CopyOnWriteArrayList<>();

    public static class Level1 extends Level {
        public Level1() {
            this.level = 1;
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 400, 200),
                    new Enemy(TURRET, 500, 200),
                    new Enemy(TOWER, 600, 200),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Boss(BOSSTURRET, 500, 100),
            }));
        }
    }

    public static class Level2 extends Level {
        public Level2() {
            this.level = 2;
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 400, 200),
                    new Enemy(TURRET, 500, 200),
                    new Enemy(TOWER, 600, 200),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Boss(BOSSSHIP, 500, 100),
            }));
        }
    }

    public static class Level3 extends Level {
        public Level3() {
            this.level = 3;
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 400, 200),
                    new Enemy(TURRET, 500, 200),
                    new Enemy(TOWER, 600, 200),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 400, 200),
                    new Enemy(TURRET, 500, 200),
                    new Enemy(TOWER, 600, 200),
            }));
        }
    }

    public static class Level4 extends Level {
        public Level4() {
            this.level = 4;
            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 400, 200),
                    new Enemy(TURRET, 500, 200),
                    new Enemy(TOWER, 600, 200),
            }));

            this.addWave(Arrays.asList(new Entity[]{
                    new Enemy(TANK, 100, 100),
                    new Enemy(TRUCK, 200, 100),
                    new Enemy(PLANE, 300, 100),
                    new Enemy(TURRET, 400, 100),
                    new Enemy(TOWER, 500, 100),
                    new Enemy(TANK, 200, 200),
                    new Enemy(TRUCK, 300, 200),
                    new Enemy(PLANE, 400, 200),
                    new Enemy(TURRET, 500, 200),
                    new Enemy(TOWER, 600, 200),
            }));
        }
    }

    public Level() {
        entities.add(new PlayerTank(500, 500));
        for (Entity e : entities) {
            e.addParticleToLevel = particle -> {
                particle.removeSelf = this.particles::remove;
                particles.add(particle);
            };
            e.removeSelf = this.entities::remove;
            e.removeParticleFromLevel = this.particles::remove;
            e.addToScore = this::addToScore;
        }
        for (Particle p : particles) p.removeSelf = this.particles::remove;
        setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void addWave(List<Entity> wave) {
        this.waves.add(wave);
    }

    public void tick() {
        // copy the list so it doesn't crash if the list is modified
        for (Entity a : entities) for (Entity b : entities) a.check(b);
        for (Entity a : entities) for (Particle b : particles) a.check(b);
        for (Particle p : particles) p.tick(WIDTH, HEIGHT);
        for (Entity e : entities) e.tick(WIDTH, HEIGHT);

        int enemyCount = 0;
        for (Entity p : entities) {
            if (p instanceof PlayerTank) if (((PlayerTank) p).health <= 0) {
                ((PlayerTank) p).health = PlayerTank.HEALTH;
                this.reset();
                App.retryScreen.retryView = this;
                App.setCurrentPanel(App.retryScreen);
            }
            if (p instanceof Enemy) enemyCount++;
        }

        if (enemyCount < 1) {
            currentWave++;
            for (Entity e : entities)
                if (e instanceof PlayerTank) {
                    ((PlayerTank) e).x = 500;
                    ((PlayerTank) e).y = 500;
                    ((PlayerTank) e).vx = 0;
                    ((PlayerTank) e).vy = 0;
                }
            if (currentWave >= this.waves.size()) {
                this.reset();
                if (App.getCurrentPanel() instanceof Level1) {
                    App.setCurrentPanel(App.level2);
                    System.out.println("level 1 -> 2");
                } else if (App.getCurrentPanel() instanceof Level2) {
                    App.setCurrentPanel(App.level3);
                    System.out.println("level 2 -> 3");
                } else if (App.getCurrentPanel() instanceof Level3) {
                    App.setCurrentPanel(App.level4);
                    System.out.println("level 3 -> 4");
                } else
                    App.setCurrentPanel(App.startMenu);
                return;
            }
            this.entities.addAll(this.waves.get(this.currentWave));
            for (Entity e : entities) {
                e.addParticleToLevel = particle -> {
                    particle.removeSelf = this.particles::remove;
                    particles.add(particle);
                };
                e.removeSelf = this.entities::remove;
                e.removeParticleFromLevel = this.particles::remove;
                e.addToScore = this::addToScore;
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g); //Clears the panel, for a fresh start
        Graphics2D g2d = (Graphics2D) g;

        Font txt = new Font("Monospaced", Font.BOLD, 13);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, HEIGHT - 85, WIDTH, 50);
        g2d.setColor(Color.green);
        g2d.setFont(txt);
        g2d.drawString("Points:" + points, 10, HEIGHT - 45);
        g2d.drawString("Level:" + level + " Wave: " + (currentWave + 1), 150, HEIGHT - 45);
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
            Thread.sleep(1000 / 30); //Pauses for a moment
        }
    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void mousePressed(MouseEvent mouseEvent) {
        for (Entity e : entities) e.mousePressed(mouseEvent);
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
        for (Entity e : entities) e.keyPressed(keyEvent);
    }

    public void keyReleased(KeyEvent keyEvent) {
        for (Entity e : entities) e.keyReleased(keyEvent);
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        for (Entity e : entities) e.mouseDragged(mouseEvent);
    }

    public void mouseMoved(MouseEvent mouseEvent) {
    }

    public void addToScore(int n) {
        points += n;
    }

    public void reset() {
        for (Entity e : entities) if (e instanceof PlayerTank) ((PlayerTank) e).health = PlayerTank.HEALTH;
        for (Entity e : entities) if (e instanceof Enemy) entities.remove(e);
        particles.removeIf(v -> true);
        this.currentWave = -1;
    }
}

