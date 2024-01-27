package TexturesAndImages;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Texture {
    private TextureType type;
    private String address;
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    public Texture(TextureType type, String address, int width, int height) {
        this.type = type;
        this.address = address;
        this.height = height;
        this.width = width;
    }
    public Texture(String address, int width, int height) {
        this.address = address;
        this.height = height;
        this.width = width;
    }
    public BufferedImage getTexture(){
        BufferedImage tmp;
        try {
            tmp = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(address)));
        } catch (IOException e) {
            throw new RuntimeException("Nějaká textura je null.");
        }
        return tmp;
    }
}
