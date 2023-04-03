import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements  SharedMethods {
    private Game game;
    private Window window;
    private Inputs movement = new Inputs(this);

    public Game getGame() {
        return game;
    }
    public GamePanel(Game game) {
        window = new Window(this);
        initialize();
        this.game = game;
        addKeyListener(movement);
    }
    public GamePanel() {

    }
    private void initialize() {
        this.setBounds(0, 0, window.getWidth(), window.getHeight());
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        try {
            game.render(graphics);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update() {

    }
}