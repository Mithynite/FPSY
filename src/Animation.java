import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
public class Animation{
    protected int speed;
    protected int frames;
    protected int currentFrameIndex;
    protected int tick;
    protected String address;
    protected BufferedImage[] animationStore;
    public Animation(int speed, int frames, String address, int tick) {
        this.speed = speed;
        this.frames = frames;
        this.address = address;
        this.tick = tick;
        this.currentFrameIndex = 0;
    }
    public void create() {
        animationStore = new BufferedImage[frames];
        for(int a = 0; a < animationStore.length; a++)
            try{
            animationStore[a] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(address))).getSubimage(a*48,0,28,48);// + a + ".png"
       }catch(NullPointerException | IOException x){
            throw new RuntimeException("Looks like the image could be null.");
        }
    }
    public void update() {
        tick++;
        if(speed <= tick){
            tick = 0;
            currentFrameIndex++;
            if(animationStore.length <= currentFrameIndex)
                currentFrameIndex = 0;
        }
    }
}
