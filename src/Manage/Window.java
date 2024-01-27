package Manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Window extends JFrame {
    private static int width = 1920;
    private static int height = 1080;
    public static int getWindowWidth(){
        return width;
    }
    public static int getWindowHeight() {
        return height;
    }
    public Window(GamePanel gamePanel) throws HeadlessException {
        initialize(gamePanel);
        /*ImageIcon icon = new ImageIcon(Constants.getTopLeftCornerLogo_Address());TODO
        this.setIconImage(icon.getImage());*/
    }
    public void initialize(GamePanel gP) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(width, height);
        this.setTitle("Ultimate Lumberjack");
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