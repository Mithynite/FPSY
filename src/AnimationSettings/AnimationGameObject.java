package AnimationSettings;
import java.awt.image.BufferedImage;

public class AnimationGameObject extends Animation {
    public AnimationGameObject(int speed, int frames, String address) {
        super(speed, frames, address);
        create();
    }
    public AnimationGameObject(int speed, int frames, String address, int unnecessaryWidthAdd) {
        super(speed, frames, address);
        create(unnecessaryWidthAdd);
    }
    public boolean animationIsFinished(){
        return currentFrameIndex == frames-1;
    }
    public void resetAnimationIndex(){
        currentFrameIndex = 0;
    }
    public BufferedImage invoke(){
        updateIt();
        return animationStore[currentFrameIndex];
    }
}
