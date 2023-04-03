import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Inputs implements KeyListener{
    private GamePanel gamePanel;
    public Inputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
            gamePanel.getGame().getPlayer().setMoving(true);
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> gamePanel.getGame().getPlayer().setUp(true);
                case KeyEvent.VK_A -> gamePanel.getGame().getPlayer().setLeft(true);
                case KeyEvent.VK_S -> gamePanel.getGame().getPlayer().setDown(true);
                case KeyEvent.VK_D -> gamePanel.getGame().getPlayer().setRight(true);
            }
    }
    @Override
    public void keyReleased(KeyEvent e) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_W -> gamePanel.getGame().getPlayer().setUp(false);
                case KeyEvent.VK_A -> gamePanel.getGame().getPlayer().setLeft(false);
                case KeyEvent.VK_S -> gamePanel.getGame().getPlayer().setDown(false);
                case KeyEvent.VK_D -> gamePanel.getGame().getPlayer().setRight(false);

            }
            gamePanel.getGame().getPlayer().setMoving(false);

    }
}