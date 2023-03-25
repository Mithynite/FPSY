import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Window extends JFrame {
    private int width = 840;
    private int height = 840;
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
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
