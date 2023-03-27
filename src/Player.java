import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.Objects;
public class Player extends JPanel implements SharedMethods{
    private final String idleAnimationAddress = "NewPictures/Old_man_idle.png";
    private final String walkAnimationAddress = "NewPictures/Old_man_walk.png";
    private BufferedImage idle, walk;
    private BufferedImage[] animationStoreIdle;
    private BufferedImage[] animationStoreWalk;
    private BufferedImage lastPlayerView;
    private Inputs movement = new Inputs();
    private int posiotionX = 200;
    private int posiotionY = 200;
    private int sizeX = 500;
    private int sizeY = 70;
    private int speed = 3;
    Window window = new Window();

    public int getSpeed() {
        return speed;
    }

    public Player() throws IOException {
        this.setBounds(0, 0, window.getWidth(), window.getHeight());
        addKeyListener(movement);
        importImages();
        animationsLoad();
        //lastPlayerView = playerLeft;
    }
    public void importImages() throws IOException {
        idle = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(idleAnimationAddress)));
        walk = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(walkAnimationAddress)));
    }
    public void animationsLoad() throws IOException {
        animationStoreIdle = new BufferedImage[4];
        animationStoreWalk = new BufferedImage[6];

       for(int a = 0; a < animationStoreIdle.length; a++)
            animationStoreIdle[a] = idle.getSubimage(a*48, 0, 24, 48); //h48 w192

        /*for(int b = 0; b < animationStoreWalk.length; b++)
            animationStoreWalk[b] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(walkAnimationAddress)));*/
    }

    public void paintComponent(Graphics graphics) {
        posiotionX += movement.getHorizontalMovement();
        posiotionY += movement.getVertiqalMovement();
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(animationStoreIdle[0], posiotionX, posiotionY, sizeX, sizeY, null);
    }
    public BufferedImage updateAnimation() {
        if(movement.getHorizontalMovement() != 0 || movement.getVertiqalMovement() != 0)
            for(int a = 0; a < animationStoreWalk.length; a++)
                return animationStoreWalk[a];
        else
            for(int b = 0; b < animationStoreIdle.length; b++)
                return animationStoreIdle[b];
        return null;

        /*if (movement.isRight()) lastPlayerView = playerRight;
        else if (movement.isLeft()) lastPlayerView = playerLeft;
        return lastPlayerView;*/
    }
    @Override
    public void update() {

    }
}
