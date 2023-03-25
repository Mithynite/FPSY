import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
public class Player extends JPanel implements SharedMethods{
    private BufferedImage playerLeft, playerRight;
    private BufferedImage lastPlayerView;
    private Inputs movement = new Inputs();
    private int posiotionX = 200;
    private int posiotionY = 200;
    private int sizeX = 50;
    private int sizeY = 70;
    private int speed = 3;
    Window window = new Window();

    public int getSpeed() {
        return speed;
    }

    public Player() throws IOException {
        this.setBounds(0, 0, window.getWidth(), window.getHeight());
        addKeyListener(movement);
        animations();
        lastPlayerView = playerLeft;
    }
    public void animations() throws IOException {
        playerLeft = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Pictures/CharacterLeft.png")));
        playerRight = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Pictures/CharacterRight.png")));
    }
    public void paintComponent(Graphics graphics) {
        posiotionX += movement.getHorizontalMovement();
        posiotionY += movement.getVertiqalMovement();
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(updateAnimation(), posiotionX, posiotionY, sizeX, sizeY, null);
    }
    public BufferedImage updateAnimation() {
        if (movement.isRight()) lastPlayerView = playerRight;
        else if (movement.isLeft()) lastPlayerView = playerLeft;
        return lastPlayerView;
    }
    @Override
    public void update() {

    }
}

