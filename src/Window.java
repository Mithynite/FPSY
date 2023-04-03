import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Window extends JFrame {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = 1000   ;//(int) screenSize.getWidth();
    private int height = 800;//(int) screenSize.getHeight();
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    public Window(GamePanel gamePanel) throws HeadlessException {
        initialize(gamePanel);
        /*ImageIcon icon = new ImageIcon(""); TODO
        frame.setIconImage(icon.getImage());*/
    }

    public Window() throws HeadlessException {
    }
    public void initialize(GamePanel gP) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(width, height);
        this.setTitle("Game");
        this.setResizable(true);
        this.add(gP);
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                gP.getGame().focusGained();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                gP.getGame().focusLost();
            }
        });
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        }

    }
