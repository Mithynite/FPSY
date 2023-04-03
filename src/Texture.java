import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Texture {
    private BufferedImage[] img;
    private TextureType type;
    private boolean collision;
    private String address;
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    public Texture(TextureType type, boolean collision, String address, int height, int width) {
        this.type = type;
        this.collision = collision;
        this.address = address;
        this.height = height;
        this.width = width;
    }
    public BufferedImage getTexture() throws IOException {
        BufferedImage tmp = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(address)));
        return tmp;
    }
}
