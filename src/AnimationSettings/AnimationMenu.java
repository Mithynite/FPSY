package AnimationSettings;
import java.awt.*;
import java.awt.image.BufferedImage;
public class AnimationMenu extends Animation {
    private int coorX, coorY, sizeX, sizeY;
    public AnimationMenu(int speed, int frames, String address, int coorX, int coorY, int sizeX, int sizeY) {
        super(speed, frames, address);
        this.coorX = coorX;
        this.coorY = coorY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        create(0);
    }
    public BufferedImage invoke(){
        updateIt();
        return animationStore[currentFrameIndex];
    }
    public void render(Graphics graphics){
        graphics.drawImage(invoke(), coorX, coorY, sizeX, sizeY, null);
    }
}
