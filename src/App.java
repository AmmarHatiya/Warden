import javax.swing.*;

public class App {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    private static JFrame f;
    private static AppPanel currentPanel;
    public final static RetryScreen retryScreen= new RetryScreen();
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
    }

    public static void main(String[] args) {
        f = new JFrame();

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
