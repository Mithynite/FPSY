import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int posiotionX = 200;
    private int posiotionY = 200;
    private int sizeX = 50;
    private int sizeY = 70;

    public GamePanel() {

    }
    private void initialize(){
        Dimension size = new Dimension(1920, 1080);
        setMinimumSize(size);
        setMinimumSize(size);
        setPreferredSize(size);

    }
}
