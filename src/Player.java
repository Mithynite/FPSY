import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
public class Player extends JPanel{
    private BufferedImage playerLeft, playerRight;
    private BufferedImage lastPlayerView;
    private Inputs movement = new Inputs();
    private int posiotionX = 200;
    private int posiotionY = 200;
    private int sizeX = 50;
    private int sizeY = 70;
    private int speed = 1;
    Window window = new Window();
    public int getSpeed() {
        return speed;
    }
    public Player() throws IOException {
        this.setBounds(0,0, window.getWidth(), window.getHeight());
        addKeyListener(movement);
        playerLeft = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Pictures/CharacterLeft.png")));
        playerRight = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("Pictures/CharacterRight.png")));
        lastPlayerView = playerLeft;
    }
    public void paintComponent(Graphics graphics){
        posiotionX += movement.getHorizontalMovement();
        posiotionY += movement.getVertiqalMovement();
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        if(movement.isRight()){
            graphics2D.drawImage(lastPlayerView, posiotionX, posiotionY, sizeX, sizeY, null);
            lastPlayerView = playerRight;
        }
        else if(movement.isLeft()){
            graphics2D.drawImage(lastPlayerView, posiotionX, posiotionY, sizeX, sizeY,null);
            lastPlayerView = playerLeft;
        }else graphics2D.drawImage(lastPlayerView, posiotionX, posiotionY, sizeX, sizeY,null);
        repaint();
    }
}

