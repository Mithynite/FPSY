
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player implements SharedMethods{
    private final String idleAnimationAddress = "Pictures/Idle_Walk/Woodcutter_idle.png";
    private final String walkAnimationAddress = "Pictures/Idle_Walk/Woodcutter_walk.png";
    private final GamePanel gamePanel = new GamePanel();
    AnimationPlayer idle = new AnimationPlayer(25, 4, idleAnimationAddress, 0);
    AnimationPlayer walk = new AnimationPlayer(10, 6, walkAnimationAddress, 0);
    private int posiotionX = 800;
    private int posiotionY = 200;
    private int speed = 3;
    private int sizeX = 100;
    private int sizeY = 120;
    private boolean moving;
    private boolean right, left, up, down;
    private boolean windowActivation;

    public void setWindowActivation(boolean windowActivation) {
        this.windowActivation = windowActivation;
    }

    public boolean isWindowActivation() {
        return windowActivation;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    public void setPosiotionX(int sp) {
        this.posiotionX += sp;
    }
    public void setPosiotionY(int sp) {
        this.posiotionY += sp;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public void setUp(boolean up) {
        this.up = up;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
    public void moveThePlayer(){ //TODO vypadá to hrozně, ale funguje, fixni to pls
        stopEveryMove();
            moving = false;
            if (left && !right) {
                setPosiotionX(-speed);
                moving = true;
            }
            if (!left && right) {
                setPosiotionX(speed);
                moving = true;
            }
            if (up && !down) {
                setPosiotionY(-speed);
                moving = true;
            }
            if (!up && down) {
                setPosiotionY(speed);
                moving = true;

        }
    }
    private void stopEveryMove(){
        if(!windowActivation){
            left = false;
            right = false;
            up = false;
            down = false;
        }
    }
    public BufferedImage changeView() {
       moveThePlayer();
        BufferedImage lastPlayerView;
            if(moving){
            lastPlayerView = walk.invoke();
            if (right) {
                sizeX = Math.abs(sizeX);
            }
             else if (left && sizeX > 0)
                sizeX = -sizeX;
        }else lastPlayerView = idle.invoke();
        return lastPlayerView;
    }
    public void render(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(changeView(), posiotionX, posiotionY, sizeX, sizeY, null);
    }
    @Override
    public void update() {

    }
}
