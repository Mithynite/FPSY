package AnimationSettings;
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
    public Animation(int speed, int frames, String address) {
        this.speed = speed;
        this.frames = frames;
        this.address = address;
        this.tick = 0;
        this.currentFrameIndex = 0;
    }
    public void create(int unnecessaryWidthAdd){
        animationStore = new BufferedImage[frames];
        for(int a = 0; a < animationStore.length; a++){
            try{
                System.out.println(address);
                animationStore[a] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(address))).getSubimage(a*48,0,28+unnecessaryWidthAdd,48);
           }catch(NullPointerException | IOException x){
                throw new RuntimeException("Jeden z obrázků je nejspíš null.");
            }
        }
    }
    public void create(){
        create(0);
    }
    public void updateIt() {
        tick++;
        if(speed <= tick){
            tick = 0;
            currentFrameIndex++;
            if(animationStore.length <= currentFrameIndex)
                currentFrameIndex = 0;
        }
    }
}