import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    private int width = 1920;
    private int height = 1080;
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    public Window() throws HeadlessException{}
    public Window(Player gamePanel) throws HeadlessException {
        initialize(gamePanel);
        /*ImageIcon icon = new ImageIcon(""); TODO
        frame.setIconImage(icon.getImage());*/
    }
    public void initialize(Player gamePanel) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(width, height);
        this.setTitle("Game");
        this.setResizable(false);
        this.add(gamePanel);
        //this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
