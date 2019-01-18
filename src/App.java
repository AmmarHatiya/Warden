import javax.swing.*;

public class App {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    private static JFrame f;
    private static AppPanel currentPanel;
    public final static Level level1 = new Level.Level1();
    public final static Level level2 = new Level.Level1();
    public final static Level level3 = new Level.Level1();
    public final static Level level4 = new Level.Level1();
    public final static Pause pauseScreen= new Pause();
    public final static EndScreen endScreen = new EndScreen();
    public final static RetryScreen retryScreen= new RetryScreen();
    public final static HowToPlayMenu howtoplayScreen= new HowToPlayMenu();
    public final static Upgradesmenu upgradesmenu= new Upgradesmenu();
    public final static StartMenu startMenu = new StartMenu();
    public final static LevelSelectMenu levelSelectMenu = new LevelSelectMenu();

    public static void setCurrentPanel(AppPanel p) {
        currentPanel = p;
        f.setContentPane(currentPanel);
        f.repaint();
        currentPanel.invalidate();
        currentPanel.revalidate();
        currentPanel.repaint();
        currentPanel.tick();
        currentPanel.grabFocus();
    }

    public static AppPanel getCurrentPanel() {
        return currentPanel;
    }

    public static void main(String[] args) {
        f = new JFrame("Den Of Tanks");
        setCurrentPanel(startMenu);
        f.setSize(WIDTH, HEIGHT);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if (currentPanel != null) {
                currentPanel.tick(); //Updates the coordinates
                currentPanel.repaint(); //Calls the paint method
                try {
                    Thread.sleep(1000 / 30);
                } catch (InterruptedException ex) {
                } //Pauses for a moment
            }
        }
    }
}
