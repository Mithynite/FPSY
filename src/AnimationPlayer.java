import java.awt.image.BufferedImage;
public class AnimationPlayer extends Animation{
    public AnimationPlayer(int speed, int frames, String address, int tick) {
        super(speed, frames, address, tick);
        create();
    }
    public BufferedImage invoke(){
        update();
            return animationStore[currentFrameIndex];
    }
}
